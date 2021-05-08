package project1;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Project1:Going Down");
        frame.setSize(400, 400);    //makes the mouse location correct
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Downpanel d = new Downpanel();
        frame.setContentPane(d);
        d.requestFocus();
        frame.setVisible(true);
	}

}