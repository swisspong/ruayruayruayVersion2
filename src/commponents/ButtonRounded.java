package commponents;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ButtonRounded extends JButton{
	public ButtonRounded() {
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBackground(Color.decode("#966bca"));
		setForeground(Color.black);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(new EmptyBorder(5,10,5,10));

	}
	@Override
	protected void paintComponent(Graphics grphcs) {
		int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, height, height);
  
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
	}
}
