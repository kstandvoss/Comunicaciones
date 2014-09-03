package Controller;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Signal;
import View.DataFrame;
import View.GraphFrame;

public class SignalController implements MouseListener, Observer {

    private Signal model;
    private DataFrame view;
    
    public SignalController(Signal model, DataFrame view){
	this.model = model;
	this.view = view;
	
	model.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
	
	if(e.getButton()==MouseEvent.BUTTON1){
	    
	    try{
	    	char[] charbits = this.view.getBits().getText().toCharArray();
		boolean[] bits = new boolean[charbits.length];
		int k = charbits.length-1;
		for(int i = 0;i<charbits.length;i++){
		    if(charbits[i]-'0' == 1)
			bits[k] = true;
 		    if(charbits[i]-'0' != 1 && charbits[i]-'0' != 0)
			throw new IllegalArgumentException();
 		    k--;
		}
		
		this.model.setBits(bits);
		this.model.setBps(Long.parseLong(this.view.getBps().getText()));
		this.model.setChannel(Long.parseLong(this.view.getChannel().getText()));
		this.model.setHarmonics(Integer.parseInt(this.view.getHarmonics().getText()));
		this.model.setInterval(Integer.parseInt(this.view.getInterval().getText()));
		this.model.calculateSignal(); //FEHLER!
		double[] points = model.getSignal();
		GraphFrame graph = new GraphFrame();
		graph.addLine(0, 0, 0,points[0]);
		for(int i = 0; i<points.length-1;i++){
		    graph.addLine((double) i+1, points[i]*20, (double)(i+2), points[i+1]*20);
		}
		JDialog frame = new JDialog();
		frame.setPreferredSize(new Dimension(400,300));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setContentPane(graph);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	    }catch(IllegalArgumentException e1){
		JOptionPane.showMessageDialog(this.view, "Invalid/Missing Parameters", "Ok", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
    }

    @Override
    public void mouseEntered(MouseEvent e) {
	
    }

    @Override
    public void mouseExited(MouseEvent e) {
	
    }

    @Override
    public void mousePressed(MouseEvent e) {
	
    }

    @Override
    public void mouseReleased(MouseEvent e) {
	
    }

}
