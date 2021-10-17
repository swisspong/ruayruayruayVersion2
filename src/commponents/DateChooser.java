package commponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.plaf.PanelUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import constants.ColorConstants;

public class DateChooser extends JPanel{
	JDateChooser dateChooser;
	public DateChooser(String name,int width) {
		
		setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		setPreferredSize(new Dimension(width, 47));
		setBackground(null);
		
		JLabel lbName = new JLabel(name);
		lbName.setFont(new java.awt.Font("Berlin Sans FB", 0, 15));
		lbName.setForeground(Color.white);
		dateChooser = new JDateChooser();
		
		dateChooser.getDateEditor().getUiComponent().setBackground(ColorConstants.PRIMARY);
		dateChooser.getDateEditor().getUiComponent().setBorder(BorderFactory.createEmptyBorder());
		dateChooser.getDateEditor().getUiComponent().setForeground(Color.white);
//		dateChooser.setLocale(new Locale("th", "TH"));
		dateChooser.setDate(dateChooser.getDate());
		JTextFieldDateEditor txtFld = (JTextFieldDateEditor) dateChooser.getDateEditor();
		txtFld.setEditable(false);
		txtFld.setFont(new java.awt.Font("sanserfi", 0, 15));
        txtFld.addPropertyChangeListener("foreground", event -> {
            if (Color.BLACK.equals(event.getNewValue())) {
                txtFld.setForeground(Color.WHITE);
            }
        });
		
		dateChooser.setPreferredSize(new Dimension(width, 20));
		
		dateChooser.getCalendarButton().setBackground(ColorConstants.PRIMARY);
		
		JSeparator sr = new JSeparator();
		sr.setPreferredSize(new Dimension(width, 2));
		sr.setBackground(Color.white);
		
		
		add(lbName);
		add(dateChooser);
		add(sr);
	}
}
