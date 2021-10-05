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

public class Menu extends JPanel{
	private JFrame frame;
	private int mousePressX;
	private int mousePressY;
	public String selected = "Admin Good";
	public MenuItem menuItemArr[] = {
			new MenuItem("Admin Good","/boxes.png",this),
			new MenuItem("Supplier Admin","/supplier.png",this),
			new MenuItem("Supplier Good","/inventory.png",this),
			new MenuItem("Customer","/customer.png",this),
			new MenuItem("Invoice","/invoice.png",this),
			new MenuItem("Exit","/logout.png",this),
	};
	
	public Menu() {
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
	
		reactUX();
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		GradientPaint gd = new GradientPaint(0, 0, Color.decode("#000000"), 0,getHeight(),Color.decode("#333333"));
//		g2.setPaint(gd);
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
				frame.setLocation(e.getXOnScreen()-mousePressX, e.getYOnScreen()-mousePressY);
			}
		});
		
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
