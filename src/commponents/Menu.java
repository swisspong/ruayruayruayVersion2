package commponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Main.Main;
import constants.AdminGoodConstants;
import constants.CustomerConstants;
import constants.InvoiceConstants;
import constants.SupplierAdminConstants;
import constants.SupplierGoodConstants;
import pages.AdminPage;
import pages.CustomerPage;
import pages.InvoicePage;
import pages.SupplierAdminPage;
import pages.SupplierGoodPage;

public class Menu extends JPanel{
	private int mousePressX;
	private int mousePressY;
	public Main mainSwing;
	public String selected = "Admin Good";
	public MenuItem menuItemArr[] = {
			new MenuItem("Admin Good","/boxes.png",this),
			new MenuItem("Supplier Admin","/supplier.png",this),
			new MenuItem("Supplier Good","/inventory.png",this),
			new MenuItem("Customer","/customer.png",this),
			new MenuItem("Invoice","/invoice.png",this),
			new MenuItem("Exit","/logout.png",this),
	};
	public PanelRounded pCard;
	public Menu(Main mainSwing) {
		this.mainSwing = mainSwing;
		setOpaque(false);
		setLayout(new FlowLayout(0,0,0));
		JLabel head = new JLabel("RuayRuayRuay");
		head.setPreferredSize(new Dimension(230,100));
		head.setHorizontalAlignment(SwingConstants.CENTER);
		
		head.setFont(new Font("sanserif", Font.BOLD, 20));
		head.setForeground(Color.white);
		head.setIcon(new ImageIcon(getClass().getResource("/shop.png")));
		head.setIconTextGap(20);
		JLabel blank =new JLabel();
		blank.setPreferredSize(new Dimension(10,200));
		
		add(head);
		add(blank);
			
		for(MenuItem i:menuItemArr) {
			add(i);
		}
		
		
		mainSwing.mainPanel.add(new AdminPage(),AdminGoodConstants.PAGE_NAME);
		mainSwing.mainPanel.add(new CustomerPage(),CustomerConstants.PAGE_NAME);
		mainSwing.mainPanel.add(new SupplierAdminPage(),SupplierAdminConstants.PAGE_NAME);
		mainSwing.mainPanel.add(new SupplierGoodPage(),SupplierGoodConstants.PAGE_NAME);
		mainSwing.mainPanel.add(new InvoicePage(),InvoiceConstants.PAGE_NAME);
		pCard = mainSwing.mainPanel; 
		
		reactUX();
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.decode("#1F1F1F"));
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
		g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
		super.paintComponent(g2);
	}
	private void reactUX () {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePressX=e.getX();
				mousePressY=e.getY();	
			}
		});
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				mainSwing.frame.setLocation(e.getXOnScreen()-mousePressX, e.getYOnScreen()-mousePressY);
			}
		});
		
	}


}
