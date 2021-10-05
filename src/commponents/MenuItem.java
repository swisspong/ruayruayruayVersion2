package commponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MenuItem extends JPanel{
	
	private JPanel pipe;
	private JLabel nameLabel;
	private String name;
	private String path;
	private Menu menu;
	public MenuItem(String name,String pathIcon,Menu menu) {
		this.name = name;
		path = pathIcon;
		this.menu =menu;
		init();
		action();
		selected();
	}
	private void init() {
		setOpaque(false);
		setLayout(null);
		setPreferredSize(new Dimension(270,60));
		setBackground(new Color(0,0,0,0));

		pipe = new JPanel();
		pipe.setBounds(0,0,5,60);
		pipe.setBackground(new Color(0,0,0,0));
		
		nameLabel = new JLabel(name != null? name:"Admin Goods");
		nameLabel.setFont(new Font("sanserif",Font.BOLD,16));
		nameLabel.setForeground(Color.white);
		nameLabel.setIcon(new ImageIcon(getClass().getResource(path !=null ? path:"/boxes.png")));
		nameLabel.setIconTextGap(15);
		nameLabel.setBounds(40,0,200,60);
		
		add(pipe);
		add(nameLabel);
	}
	private void hover() {
		setOpaque(true);//ทึบแสงไหม
		setBackground(new Color(1.0f,1.0f,1.0f,0.2f));
		pipe.setOpaque(true);
		pipe.setBackground(Color.white);
		SwingUtilities.updateComponentTreeUI(this);
	}
	public void exited() {
		setOpaque(false);
		pipe.setOpaque(false);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void selected() {
		if(menu.selected == name) {
			hover();
		}
	}
	
	private void action () {
		addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseEntered(MouseEvent e) {
				if(menu.selected != name) {
					hover();
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(menu.selected != name) {
					exited();
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(menu.selected != name) {
					menu.selected = name;
					for(MenuItem i:menu.menuItemArr) {
						if (i.name != menu.selected) {
							i.exited();
						}
					}
					if(menu.selected.equalsIgnoreCase("exit")) {
						 System.exit(0);
					}
				}
			}
		});
	}
	
}
