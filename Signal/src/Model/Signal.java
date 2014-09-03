package Model;

import java.util.Observable;

public class Signal extends Observable{

    private long channel;
    private long bps;
    private boolean[] bits; 
    private int harmonics;
    private double[] signal;
    private int interval;
    
    public Signal(){
	
    }


    public long getChannel() {
        return channel;
    }



    public void setChannel(long channel){
        if(channel <= 0){
            throw new IllegalArgumentException();
        }
	this.channel = channel;
    }



    public long getBps() {
        return bps;
    }



    public void setBps(long bps) {
	if(bps <= 0){
            throw new IllegalArgumentException();
        }
        this.bps = bps;
    }


    public void setInterval(int i){
	if(i <=0){
	    throw new IllegalArgumentException();
	}
	this.interval = i;
    }
    
    public int getInterval(){
	return interval;
    }
    public boolean[] getBits() {
        return bits;
    }



    public void setBits(boolean[] bits) {
	if(bits.length < 0){
            throw new IllegalArgumentException();
        }
        this.bits = bits;
        setChanged();
        notifyObservers();
    }



    public int getHarmonics() {
        return harmonics;
    }


    public void setHarmonics(int harmonics){
	if(harmonics <= 0){
            throw new IllegalArgumentException();
        }
	this.harmonics = harmonics;
    }


    public float get_T(){
	if(this.bits.length != 0 && this.bps != 0)
	    return (float) this.bits.length/this.bps;
	else 
	    throw new IllegalArgumentException();
    }
    
    public float getFrequency() throws IllegalArgumentException{
	float t = this.get_T();
	return 1/t;
    }
    
    public long getMaxHarmonics() throws IllegalArgumentException{
	if(channel != 0){
	    float f = this.getFrequency();
	    return (long) (channel/f);
	}
	else
	    throw new IllegalArgumentException();
    }
    
    public boolean checkHarmonics() throws IllegalArgumentException{
	long max = getMaxHarmonics();
	if(harmonics == 0)
	    throw new IllegalArgumentException();
	return max>=harmonics;
    }


    public void calculateSignal() {
	if(!this.checkHarmonics())
	    throw new IllegalArgumentException();
	

	double[] points = new double[(int)(this.interval/0.01)+1];
	
	float c = this.getIntegral('c',0);
	float[] a = new float[this.harmonics];
	float[] b = new float[this.harmonics];
	
	for(int j = 1; j<=this.harmonics;j++){
		b[j-1] = this.getIntegral('b',j);
		a[j-1] = this.getIntegral('a',j);
	}	
	
	int k=0;
	for(float i = 0; i<this.interval;i+=0.01){
	    float sumA = 0;
	    float sumB = 0;
	    for(int j = 1; j<=this.harmonics;j++){
		sumA += a[j-1] * Math.sin(2*Math.PI*j*i);
		sumB += b[j-1] * Math.cos(2*Math.PI*j*i);
	    }	
	    points[k++] = 1/2 * c + sumA + sumB;
	}
	
	this.setSignal(points);
    }


    private float getIntegral(char c,int n) {
	float integral = 0;
	int i = 0;
	switch(c){
	case 'c':
	    for(boolean b : this.getBits()){
		if(b) integral++;
	    };break;
	case 'b':
	    for(boolean b : this.getBits()){
		if(b){
		    integral += (-Math.sin(2*Math.PI*n*(i+1)/this.bits.length)
				/(2*Math.PI*this.getFrequency()*n)) 
				+ (Math.sin(2*Math.PI*n*i/this.bits.length)
				/(2*Math.PI*this.getFrequency()*n));
		    
		}
		i++;
	    };break;
	case 'a':
	    for(boolean b : this.getBits()){
		if(b){
		    integral += (-Math.cos(2*Math.PI*n*(i+1)/this.bits.length)
				/(2*Math.PI*this.getFrequency()*n))
				+ (Math.cos(2*Math.PI*n*i/this.bits.length)
				/(2*Math.PI*this.getFrequency()*n));
		}
		i++;
	    };break;
	}
	return 2/this.get_T() * integral;
    }


    public double[] getSignal() {
	return signal;
    }


    private void setSignal(double[] signal) {
	this.signal = signal;
    }



}
