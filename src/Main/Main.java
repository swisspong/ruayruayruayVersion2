package Main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import commponents.Menu;
import commponents.PanelRounded;
import constants.ColorConstants;
import pages.AdminPage;
import pages.CustomerPage;

public class Main{
	public JFrame frame;
	private Menu menu;
	public PanelRounded mainPanel;
	
	public static void main(String[] args) {
//		UIManager.put("ComboBox.background",new javax.swing.plaf.ColorUIResource(Color.RED));
//		  UIManager.put("ComboBox.background", new ColorUIResource(ColorConstants.PRIMARY));
//		  UIManager.put("ComboBox.selectionBackground", new ColorUIResource(ColorConstants.PRIMARY));
//		  UIManager.put("ComboBox[item].selectionForeground", new ColorUIResource(Color.black));
//		  UIManager.put("ComboBox.selectedInDropDownBackground", new ColorUIResource(Color.white));
//	        UIManager.put("ComboBox.selectionForeground", new ColorUIResource(Color.blue));
//	        UIManager.put("JTextField.background", new ColorUIResource(Color.yellow));
	    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            	System.out.println(info.getName());
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
		
		
	
	
		
		frame.add(panelRounded);
		mainPanel = new PanelRounded();

		mainPanel.setLayout(new CardLayout());
		menu = new Menu(this);

		
		menu.setPreferredSize(new Dimension(270,0));
		panelRounded.add(menu,BorderLayout.WEST);
			
		panelRounded.add(mainPanel,BorderLayout.CENTER);

	}

}
