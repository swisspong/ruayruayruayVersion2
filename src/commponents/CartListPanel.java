package commponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import constants.ColorConstants;
import constants.InvoiceConstants;

public class CartListPanel extends PanelRounded{
	DefaultListModel dlm;
	ButtonRounded btnRemove;
	ButtonRounded btnClear;
	JList<String> list;
	public CartListPanel() {
		int width;
		int height;
		setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		setBackground(ColorConstants.PRIMARY);
		
		JLabel pageName = new JLabel("Cart");
		pageName.setFont(new Font("sanserif", Font.PLAIN, 18));
		pageName.setForeground(Color.white);
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		
		setPreferredSize(new Dimension(150,220));
		width = getPreferredSize().width;
		height =getPreferredSize().height;
		setBounds(930-width-80,350,width,height);
		
		list = new JList<String>();
		dlm = new DefaultListModel();
	
		list.setModel(dlm);
		list.setBounds(100,500,100,100);
		list.setBackground(ColorConstants.PRIMARY);
		list.setForeground(Color.white);
		JScrollPane sp = new JScrollPane(list);
		

		sp.setPreferredSize(new Dimension(100,100));
		sp.setBorder(BorderFactory.createEmptyBorder());
		sp.setVerticalScrollBar(new ScrollBarCustom());
		sp.setBackground(ColorConstants.PRIMARY);
		add(pageName);
		add(sp);
		btnRemove=new ButtonRounded("remove");
		add(btnRemove);
		btnClear=new ButtonRounded("clear");
		add(btnClear);
	}
	public JList getList() {
		return list;
	}
	public DefaultListModel getDlm() {
		return dlm;
	}
	public ButtonRounded getBtnRemove() {
		return btnRemove;
	}
	public ButtonRounded getBtnClear() {
		return btnClear;
	}
}
