package pages;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.Main;
import commponents.PanelRounded;
import daos.GoodDAO;

import models.Good;

public class AdminPage implements ActionListener {
	JTextField tfTitle;
	JTextField tfPrice;
	JTextField tfStock;
	JTextField tfDesc;

	public AdminPage(Main main) {
		PanelRounded adminPage = new PanelRounded();
		int width;
		int height;

		JLabel pageName = new JLabel("Admin Good");
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		pageName.setBounds(20, 50, width, height);
		adminPage.setLayout(null);
		adminPage.add(pageName);

		JLabel lbTitle = new JLabel("Name");
		width = lbTitle.getPreferredSize().width;
		height = lbTitle.getPreferredSize().height;
		lbTitle.setBounds(20, 75, width, height);

		tfTitle = new JTextField(30);
		width = tfTitle.getPreferredSize().width;
		height = tfTitle.getPreferredSize().height;
		tfTitle.setBounds(100, 75, width, height);
		adminPage.add(tfTitle);
		adminPage.add(lbTitle);

		JLabel lbPrice = new JLabel("Price");
		width = lbPrice.getPreferredSize().width;
		height = lbPrice.getPreferredSize().height;
		lbPrice.setBounds(20, 100, width, height);

		tfPrice = new JTextField(30);
		width = tfPrice.getPreferredSize().width;
		height = tfPrice.getPreferredSize().height;
		tfPrice.setBounds(100, 100, width, height);
		adminPage.add(tfPrice);
		adminPage.add(lbPrice);

		JLabel lbDesc = new JLabel("Description");
		width = lbDesc.getPreferredSize().width;
		height = lbDesc.getPreferredSize().height;
		lbDesc.setBounds(20, 125, width, height);

		tfDesc = new JTextField(30);
		width = tfDesc.getPreferredSize().width;
		height = tfDesc.getPreferredSize().height;
		tfDesc.setBounds(100, 125, width, height);
		adminPage.add(tfDesc);
		adminPage.add(lbDesc);

		JLabel lbStock = new JLabel("Stock");
		width = lbStock.getPreferredSize().width;
		height = lbStock.getPreferredSize().height;
		lbStock.setBounds(20, 150, width, height);

		tfStock = new JTextField(30);
		width = tfStock.getPreferredSize().width;
		height = tfStock.getPreferredSize().height;
		tfStock.setBounds(100, 150, width, height);
		adminPage.add(tfStock);
		adminPage.add(lbStock);

		JButton btAdd = new JButton("Add");
		width = btAdd.getPreferredSize().width;
		height = btAdd.getPreferredSize().height;
		btAdd.setBounds(20, 175, width, height);
		adminPage.add(btAdd);
		btAdd.addActionListener(this);

		JButton btDelete = new JButton("Delete");
		width = btDelete.getPreferredSize().width;
		height = btDelete.getPreferredSize().height;
		btDelete.setBounds(100, 175, width, height);
		adminPage.add(btDelete);

		JButton btUpdate = new JButton("Update");
		width = btUpdate.getPreferredSize().width;
		height = btUpdate.getPreferredSize().height;
		btUpdate.setBounds(180, 175, width, height);
		adminPage.add(btUpdate);
		
		GoodDAO dao = new GoodDAO();
		Vector<Good> products = dao.viewGoods();

		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Desc");
		model.addColumn("Price");
		model.addColumn("Quantity");
		
		Iterator it = products.iterator();
		int i=0;
		while (it.hasNext()) {
			Good good = (Good) it.next();
			model.addRow(new Object[0]);
			model.setValueAt(good.getId(), i, 0);
			model.setValueAt(good.getName(), i, 1);
			model.setValueAt(good.getDescription(), i, 2);
			model.setValueAt(good.getPrice(), i, 3);
			model.setValueAt(good.getStock(), i, 4);
			i++;
		}

			
		table.setPreferredScrollableViewportSize(new Dimension (100,450));

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(200,250,450,100);
		adminPage.add(sp);
		main.mainPanel.add(adminPage, "adds");

	}

	public void actionPerformed(ActionEvent evt) {

		String command = evt.getActionCommand();
		if (command.equals("Add")) {

			String strTitle = tfTitle.getText();
			String strDesc = tfDesc.getText();
			String strPrice = tfPrice.getText();
			String strQuantity = tfStock.getText();

			try {
				double price = Double.parseDouble(strPrice);
				int quantity = Integer.parseInt(strQuantity);

				Good good = new Good(strTitle, strDesc, price, quantity);
				GoodDAO goodDAO = new GoodDAO();
				goodDAO.addGood(good);
//				ex9Main.addGood(ex9Good);
//				ex9Main.viewGoodList();

			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}

	}

}
