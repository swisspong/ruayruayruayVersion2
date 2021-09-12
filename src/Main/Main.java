package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;


import javax.swing.JFrame;



public class Main {
	public JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Main() {
		initialize();
	}
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
	}

}
