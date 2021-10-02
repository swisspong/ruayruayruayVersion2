package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;


import javax.swing.JFrame;

import commponents.Menu;
import commponents.PanelRounded;



public class Main {
	public JFrame frame;
	private Menu menu;
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
		frame.setBackground(new Color(0,0,0,0));
		
	}
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		PanelRounded panelRounded = new PanelRounded();
		panelRounded.setLayout(new BorderLayout());
		panelRounded.setBackground(Color.white);
		panelRounded.setBounds(0, 0, 1200, 700);
		
		menu = new Menu();
		menu.setPreferredSize(new Dimension(270,0));
		panelRounded.add(menu,BorderLayout.WEST);
		frame.add(panelRounded);
	}

}
