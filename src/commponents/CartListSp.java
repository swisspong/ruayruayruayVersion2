package commponents;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import constants.ColorConstants;

public class CartListSp extends JScrollPane{
	DefaultListModel dlm;
	JList<String> list;
	public CartListSp() {
		
		dlm = new DefaultListModel();
		list = new JList<String>();
		list.setModel(dlm);
//		list.setBounds(100,500,100,100);
		list.setPreferredSize(new Dimension(100,100));
		list.setBackground(Color.pink);

		
		setPreferredSize(new Dimension(100,100));
		setBorder(BorderFactory.createEmptyBorder());
		setVerticalScrollBar(new ScrollBarCustom());
		setBackground(ColorConstants.PRIMARY);
	
		add(list);
		
	}
}
