package View;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.SignalController;
import Model.Signal;

public class DataFrame extends JPanel implements Observer {

    private static final long serialVersionUID = 3861112842144318523L;
    private Signal model;
    private JLabel channelLabel;
    private JLabel bpsLabel;
    private JLabel harmonicsLabel;
    private JLabel bitsLabel;
    private JLabel intervalLabel;
    private JTextField interval;
    private JTextField channel;
    private JTextField bps;
    private JTextField harmonics;
    private JTextField bits;
    private JButton generate;
    
    public DataFrame(Signal model){
	this.model = model;
	this.model.addObserver(this);
	
	this.channelLabel = new JLabel("Bandwidth in Hz: ");
	this.channel = new JTextField("0");
	this.channel.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {
	        channel.setText("");
	    }

	    public void focusLost(FocusEvent e) {
	        // nothing
	    }
	});
	
	this.bpsLabel = new JLabel("Bps: ");
	this.bps = new JTextField("0");
	this.bps.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {
	        bps.setText("");
	    }

	    public void focusLost(FocusEvent e) {
	        // nothing
	    }
	});
	
	this.harmonicsLabel = new JLabel("Number of Harmonics: ");
	this.harmonics = new JTextField("0");
	this.harmonics.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {
	        harmonics.setText("");
	    }

	    public void focusLost(FocusEvent e) {
	        // nothing
	    }
	});
	
	this.bitsLabel = new JLabel("Bit signal: ");
	this.bits = new JTextField("0");
	this.bits.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {
	        bits.setText("");
	    }

	    public void focusLost(FocusEvent e) {
	        // nothing
	    }
	});
	
	this.intervalLabel = new JLabel("Interval in sec: ");
	this.interval = new JTextField("10");
	this.interval.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {
	        interval.setText("");
	    }

	    public void focusLost(FocusEvent e) {
	        // nothing
	    }
	});
	
	this.generate = new JButton("Graph");
	this.generate.addMouseListener(new SignalController(this.model,this));
	
	this.setLayout(new GridLayout(6,1));
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(1,2));
	panel.add(this.channelLabel);
	panel.add(this.channel);
	this.add(panel);
	panel = new JPanel();
	panel.setLayout(new GridLayout(1,2));
	panel.add(this.bpsLabel);
	panel.add(this.bps);
	this.add(panel);
	panel = new JPanel();
	panel.setLayout(new GridLayout(1,2));
	panel.add(this.harmonicsLabel);
	panel.add(this.harmonics);
	this.add(panel);
	panel = new JPanel();
	panel.setLayout(new GridLayout(1,2));
	panel.add(this.bitsLabel);
	panel.add(this.bits);
	this.add(panel);
	panel = new JPanel();
	panel.setLayout(new GridLayout(1,2));
	panel.add(this.intervalLabel);
	panel.add(this.interval);
	this.add(panel);
	this.add(this.generate);
    }
    
    public JTextField getChannel(){
	return this.channel;
    }
    
    public JTextField getBps(){
	return this.bps;
    }
    
    public JTextField getHarmonics(){
	return this.harmonics;
    }
    
    public JTextField getBits(){
	return this.bits;
    }
    
    public JTextField getInterval(){
	return this.interval;
    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
		System.out.println("Channel: " + this.model.getChannel());
		System.out.println("Bps: " + this.model.getBps());
		System.out.println("Harmonics: " + this.model.getHarmonics());
    }

}
