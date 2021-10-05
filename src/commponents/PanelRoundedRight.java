package commponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelRoundedRight extends JPanel {
	public PanelRoundedRight() {
		setOpaque(false);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth(), getHeight(),20, 20);
		g2.fillRect(0-20, 0, getWidth(), getHeight());
		super.paintComponent(g2);
	}
}
