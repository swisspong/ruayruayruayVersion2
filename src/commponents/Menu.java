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
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel{
	
	public Menu() {
		setOpaque(false);
		setLayout(new FlowLayout(0,0,0));
		JLabel head = new JLabel("RuayRuayRuay");
		head.setPreferredSize(new Dimension(230,100));
		head.setHorizontalAlignment(SwingConstants.CENTER);
		
		head.setFont(new Font("sanserif", Font.BOLD, 20));
		head.setForeground(Color.white);
		head.setIcon(new ImageIcon(getClass().getResource("/shop.png")));
		JLabel blank =new JLabel();
		blank.setPreferredSize(new Dimension(10,200));
		 
		add(head);
		add(blank);
		MenuItem menu1 = new MenuItem();
		add(menu1);
		add(new MenuItem("test",null));
		
		
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gd = new GradientPaint(0, 0, Color.decode("#FF0099"), 0,getHeight(),Color.decode("#493240"));
		g2.setPaint(gd);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
		g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
		super.paintComponent(g2);
	}
	
}
