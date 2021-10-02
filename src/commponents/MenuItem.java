package commponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuItem extends JPanel{
	
	private JPanel pipe;
	private JLabel nameLabel;
	private String name;
	private String path;
	
	public MenuItem(String name,String pathIcon) {
		this.name = name;
		path = pathIcon;
		init();
		
	}
	public MenuItem() {
		init();
	}
	
	
	private void init() {
		setLayout(null);
		setPreferredSize(new Dimension(270,60));
		setBackground(new Color(1.0f,1.0f,1.0f,0.2f));
		
		pipe = new JPanel();
		pipe.setBounds(0,0,5,60);
		pipe.setBackground(Color.white);
		
		nameLabel = new JLabel(name != null? name:"Admin Goods");
		nameLabel.setFont(new Font("sanserif",Font.BOLD,16));
		nameLabel.setForeground(Color.white);
		nameLabel.setIcon(new ImageIcon(getClass().getResource(path !=null ? path:"/boxes.png")));
		nameLabel.setIconTextGap(15);
		nameLabel.setBounds(40,0,200,60);
		
		add(pipe);
		add(nameLabel);
	}
	
	
	
}
