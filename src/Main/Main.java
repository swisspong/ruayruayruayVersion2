package Main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import commponents.Menu;
import commponents.PanelRounded;
import pages.AdminPage;
import pages.CustomerPage;

public class Main{
	public JFrame frame;
	private Menu menu;
	public PanelRounded mainPanel;

	public static void main(String[] args) {
		
	    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
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
		init();
		frame.setBackground(new Color(0,0,0,0));
	}

	public void init() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		PanelRounded panelRounded = new PanelRounded();
		panelRounded.setLayout(new BorderLayout());
		panelRounded.setBackground(Color.white);
		panelRounded.setBounds(0, 0, 1200, 700);
		
		menu = new Menu();
		menu.setFrame(frame);
		menu.setPreferredSize(new Dimension(270,0));
		
		
	
	
		
		panelRounded.add(menu,BorderLayout.WEST);
		frame.add(panelRounded);
		mainPanel = new PanelRounded();

		mainPanel.setLayout(new CardLayout());
		
		
//		new AdminPage(this);
		new CustomerPage(this);
		
		

		panelRounded.add(mainPanel,BorderLayout.CENTER);

	}

}
