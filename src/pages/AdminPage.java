package pages;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.Main;
import commponents.ButtonRounded;
import commponents.FormGroup;
import commponents.GroupButton;
import commponents.Menu;
import commponents.PanelRounded;
import commponents.PanelRoundedRight;
import commponents.TableStyle;
import commponents.TextFieldStyle;
import constants.AdminGoodConstants;
import constants.ColorConstants;
import daos.GoodDAO;

import models.Good;

public class AdminPage extends PanelRoundedRight implements ActionListener{
	public TextFieldStyle[] tfs = {
			new TextFieldStyle("Name",440),
			new TextFieldStyle("Price",210),
			new TextFieldStyle("Stock",210),
			new TextFieldStyle("Description",440)
	};
	public ButtonRounded[] btns= {
		new ButtonRounded(AdminGoodConstants.ADD),
		new ButtonRounded(AdminGoodConstants.UPDATE),
		new ButtonRounded(AdminGoodConstants.DELETE),
	};
	public String arr[]= {
			"Id",
			"Name",
			"Price",
			"Stock",
			"Description"
		};
	public TableStyle tbPanel;
	public JTextField goodId;
	GoodDAO goodDAO = new GoodDAO();
	public AdminPage() {
		init();
		for(ButtonRounded i:btns) {
			i.addActionListener(this);
		}
	}
	
	public void init() {
		
		int width;
		int height;
		JLabel pageName = new JLabel(AdminGoodConstants.PAGE_NAME);
		pageName.setFont(new Font("sanserif",Font.PLAIN,18));
		pageName.setForeground(Color.white);
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		System.out.println(height);
		pageName.setBounds(80, 40, 100, 24);
		
		goodId = new JTextField();
		goodId.setBackground(null);
		goodId.setBounds(0,0,0,0);
		setLayout(null);
		setBackground(ColorConstants.BG);
		add(goodId);
		add(pageName);
		

		add(new GroupButton(btns));
//		for(ButtonRounded i:btns) {
//			i.addActionListener(this);
//		}

		add(new FormGroup(tfs));
		tbPanel = new TableStyle(arr,tfs,goodId);
		fetchData();
		add(tbPanel);
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		if (command.equals(AdminGoodConstants.ADD)) {
			String strName = tfs[0].getTxt();
			String strPrice = tfs[1].getTxt();
			String strStock = tfs[2].getTxt();
			String strDesc =  tfs[3].getTxt();
			try {
				double price = Double.parseDouble(strPrice);
				int stock = Integer.parseInt(strStock);
				
				Good good = new Good(strName, strDesc, price, stock);
				GoodDAO goodDAO = new GoodDAO();
				goodDAO.addGood(good);
				for(TextFieldStyle i :tfs) {
					i.setTxt("");
				}
				fetchData();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		else if(command.equals(AdminGoodConstants.UPDATE)) {
			String strName = tfs[0].getTxt();
			String strPrice = tfs[1].getTxt();
			String strStock = tfs[2].getTxt();
			String strDesc =  tfs[3].getTxt();
			String strId =goodId.getText();
			
			System.out.println("update");
			try {
				double price = Double.parseDouble(strPrice);
				int stock = Integer.parseInt(strStock);
				int id = Integer.parseInt(strId);
				Good good = new Good(id,strName, strDesc, price, stock);
				goodDAO.editGood(good);
				for(TextFieldStyle i :tfs) {
					i.setTxt("");
				}
				goodId.setText("");
			
				fetchData();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		else if(command.equals(AdminGoodConstants.DELETE)) {
			int id = Integer.parseInt(goodId.getText());
			goodDAO.deleteGood(id);
			for(TextFieldStyle i :tfs) {
				i.setTxt("");
			}
			goodId.setText("");
			fetchData();
		}
	}
	public void fetchData() {
		((DefaultTableModel)tbPanel.getTable().getModel()).setRowCount(0);
		Vector<Good> goods = goodDAO.viewGoods();
		Iterator it = goods.iterator();
		int i=0;
		while (it.hasNext()) {
			Good good = (Good) it.next();
			tbPanel.getModel().addRow(new Object[0]);
			tbPanel.getModel().setValueAt(good.getId(), i, 0);
			tbPanel.getModel().setValueAt(good.getName(), i, 1);
			tbPanel.getModel().setValueAt(good.getPrice(), i, 2);
			tbPanel.getModel().setValueAt(good.getStock(), i, 3);
			tbPanel.getModel().setValueAt(good.getDescription(), i, 4);
			i++;
		}
		
	}

	
}

