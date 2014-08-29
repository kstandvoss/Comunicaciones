package model.drawables;
import model.Face;
import model.Vertex;
public class Curve extends DrawableObject {
boolean[] bits;
int frequency;
int harmonic;
int bps;
// private double cn;
public Curve(boolean[] bits, int frequency, int harmonic, int bps) {
super();
this.bits = bits;
this.frequency = frequency;
this.bps = bps;
this.harmonic = harmonic;
}
public void create() {
faces.clear();
Face line;
double[] next = new double[harmonic];
double[] last = new double[harmonic];
double[] an = new double[harmonic];
double[] bn = new double[harmonic];
double[] dc = new double[harmonic];
for (int k = 0; k < harmonic; k++) {
//System.out.println(k);
an[k] = 0;
bn[k] = 0;
dc[k] = 0;
for (int i = 0; i < bits.length; i++) {
if (bits[i]) {
an[k] += ((Math.cos(2 * Math.PI * (i + 1) * (k + 1)
/ bits.length)
/ Math.PI / (k + 1)) - (Math.cos(2 * Math.PI * (i)
* (k + 1) / bits.length)
/ Math.PI / (k + 1)));
bn[k] += ((Math.sin(2 * Math.PI * (i + 1) * (k + 1)
/ bits.length)
/ Math.PI / (k + 1)) - (Math.sin(2 * Math.PI * (i)
* (k + 1) / bits.length)
/ Math.PI / (k + 1)));
dc[k]++;
}
}
dc[k] /= bits.length;
// cn=Math.sqrt(Math.pow(an, 2)+Math.pow(bn,2));
//System.out.println("an:" + an[k]);
//System.out.println("bn: " + bn[k]);
//System.out.println("dc: " + dc[k]);
last[k] = dc[k] + an[k]
* Math.sin(2 * Math.PI * (k + 1) / bits.length * 0) + bn[k]
* Math.cos(2 * Math.PI * (k + 1) / bits.length * 0);
}
boolean firstRun = true;
double firstSum = 0;
for (double i = 0.01; i < bits.length; i += 0.01) {
for (int k = 0; k < harmonic; k++) {
next[k] = last[k] = dc[k] + an[k]
* Math.sin(2 * Math.PI * (k + 1) / bits.length * i)
+ bn[k]
* Math.cos(2 * Math.PI * (k + 1) / bits.length * i);
line = new Face(new Vertex(i -harmonic/2 - 0.01, last[k], -k + harmonic
- 6, 1), new Vertex(i -harmonic/2 , next[k], -k + harmonic - 6,
1));
faces.add(line);
}
double sum1 = 0, sum2 = 0;
for (int k = 0; k < harmonic; k++) {
sum1 += last[k];
sum2 += next[k];
}
if (firstRun) {
firstSum = sum1;
boolean anyPositive = false;
for(boolean b : bits){
if(b) anyPositive = true;
}
if(anyPositive) firstSum -= 1;
firstRun = false;
}
line = new Face(new Vertex(i - 0.01 - harmonic/2, sum1 - firstSum ,
-6, 1), new Vertex(i - harmonic/2, sum2 - firstSum ,
-6 , 1));
line.setRed(true);
faces.add(line);
for (int k = 0; k < harmonic; k++)
last[k] = next[k];
}
/*
* Basis line später fixen
*/
/**
* line = new Face(new Vertex(-5, 0, 0, 1), new Vertex(bits.length - 5,
* 0, 0, 1)); faces.add(line);
*/
}
public boolean[] getBits() {
return bits;
}
public void setBits(boolean[] bits) {
this.bits = bits;
}
public double getFrequency() {
return frequency;
}
public void setFrequency(int frequency) {
this.frequency = frequency;
}
public int getHarmonic() {
return harmonic;
}
public void setHarmonic(int harmonic) {
this.harmonic = harmonic;
}
public int getBps() {
return bps;
}
public void setBps(int bps) {
this.bps = bps;
}
}