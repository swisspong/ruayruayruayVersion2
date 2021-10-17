package commponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import constants.ColorConstants;

public class TextFieldStyle extends JPanel {
	
	private JLabel lbName;
	private JTextField tf;
	private JSeparator sr;
	
	public TextFieldStyle(String name,int width){
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setPreferredSize(new Dimension(width,47));
		setBackground(null);
		lbName = new JLabel(name);
		lbName.setFont(new java.awt.Font("Berlin Sans FB", 0, 15));
		lbName.setForeground(Color.white);
		
		tf = new JTextField();
		
		tf.setBackground(ColorConstants.PRIMARY);
		tf.setForeground(new java.awt.Color(255, 255, 255));
		tf.setPreferredSize(new Dimension(width,20));
		tf.setBorder(null);
		tf.setCaretColor(Color.white);
		tf.setFont(new java.awt.Font("sanserfi", 0, 15));
		
		sr = new JSeparator();
		sr.setPreferredSize(new Dimension(width,2));
		sr.setBackground(Color.white);
		
		add(lbName);
		add(tf);
		add(sr);
		
	}
	public String getTxt() {
		return tf.getText();
	}
	public void setTxt(String text) {
		tf.setText(text);
	}
	
}
