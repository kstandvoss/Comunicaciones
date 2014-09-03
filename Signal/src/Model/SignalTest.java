package Model;

import javax.swing.JFrame;

import View.DataFrame;

public class SignalTest {

    public static void main(String[] args) {
   	JFrame frame = new JFrame("Signal");
   	Signal signal = new Signal();
   	DataFrame view = new DataFrame(signal);
   	frame.setContentPane(view);
   	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	frame.pack();
	frame.setLocationRelativeTo(null);
   	frame.setVisible(true);
       }
    
}
