package pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import commponents.ButtonRounded;
import commponents.ComboBoxStyle;
import commponents.FormGroup;
import commponents.GroupButton;
import commponents.PanelRoundedRight;
import commponents.TableStyle;
import commponents.TextFieldStyle;
import constants.ColorConstants;
import constants.SupplierAdminConstants;
import constants.SupplierGoodConstants;
import daos.GoodDAO;
import daos.SupplierDAO;
import daos.SupplierGoodDAO;
import models.Good;
import models.Supplier;
import models.SupplierGood;

public class SupplierGoodPage extends PanelRoundedRight implements ActionListener {
	public List<String> listSupComboBox = null;
	public List<String> listGoodComboBox = null;
	public TableStyle tbPanel;
	public Component[] test = { new ComboBoxStyle("Supplier", listSupComboBox, 540),
			new ComboBoxStyle("Good", listSupComboBox, 540), new TextFieldStyle("Price", 540)

	};
	public ButtonRounded[] btns = { new ButtonRounded(SupplierGoodConstants.ADD),
			new ButtonRounded(SupplierGoodConstants.UPDATE), new ButtonRounded(SupplierGoodConstants.DELETE) };
	private String arr[] = { "Id", "Id_Sup", "Id_Good", "Price" };
	private SupplierDAO supplierDAO = new SupplierDAO();
	private SupplierGoodDAO supplierGoodDAO = new SupplierGoodDAO();
	private GoodDAO goodDAO = new GoodDAO();
	public JTextField supGoodId;

	public SupplierGoodPage() {
		listSupComboBox = new ArrayList<String>();
		listGoodComboBox = new ArrayList<String>();
		int width;
		int height;
		JLabel pageName = new JLabel(SupplierGoodConstants.PAGE_NAME);
		pageName.setFont(new Font("sanserif", Font.PLAIN, 18));
		pageName.setForeground(Color.white);
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		pageName.setBounds(80, 40, 200, 24);

		supGoodId = new JTextField();
		supGoodId.setBackground(null);
		supGoodId.setBounds(0, 0, 0, 0);
		setLayout(null);
		setBackground(ColorConstants.BG);
		add(supGoodId);
		add(pageName);

		fetchSupplier();
		((ComboBoxStyle) test[0]).setData(listSupComboBox);

		((ComboBoxStyle) test[1]).setData(listGoodComboBox);

		add(new GroupButton(btns));
		for (ButtonRounded i : btns) {
			i.addActionListener(this);
		}

		setLayout(null);
		setBackground(ColorConstants.BG);
		add(new FormGroup(test));

		tbPanel = new TableStyle(arr, test, supGoodId);
		
		fetchData();
		add(tbPanel);
	}
	
	public void init() {
		listSupComboBox = new ArrayList<String>();
		listGoodComboBox = new ArrayList<String>();
		int width;
		int height;
		JLabel pageName = new JLabel(SupplierGoodConstants.PAGE_NAME);
		pageName.setFont(new Font("sanserif", Font.PLAIN, 18));
		pageName.setForeground(Color.white);
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		pageName.setBounds(80, 40, 200, 24);

		supGoodId = new JTextField();
		supGoodId.setBackground(null);
		supGoodId.setBounds(0, 0, 0, 0);
		setLayout(null);
		setBackground(ColorConstants.BG);
		add(supGoodId);
		add(pageName);

		fetchSupplier();
		((ComboBoxStyle) test[0]).setData(listSupComboBox);

		((ComboBoxStyle) test[1]).setData(listGoodComboBox);

		add(new GroupButton(btns));
	
		setLayout(null);
		setBackground(ColorConstants.BG);
		add(new FormGroup(test));

		tbPanel = new TableStyle(arr, test, supGoodId);
		
		fetchData();
		add(tbPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if (command.equals(SupplierGoodConstants.ADD)) {
			String strSupId = ((ComboBoxStyle) test[0]).getText().split(" ")[0];
			String strGoodId = ((ComboBoxStyle) test[1]).getText().split(" ")[0];
			String strPrice = ((TextFieldStyle) test[2]).getTxt();
			try {
				int supId = Integer.parseInt(strSupId);
				int goodId = Integer.parseInt(strGoodId);
				double price = Double.parseDouble(strPrice);

				SupplierGood supplierGood = new SupplierGood(supId, goodId, price);

				supplierGoodDAO.addSupGood(supplierGood);
				((TextFieldStyle) test[2]).setTxt("");
				fetchData();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		} else if (command.equals(SupplierGoodConstants.UPDATE)) {
			String strId = supGoodId.getText();
			String strSupId = ((ComboBoxStyle) test[0]).getText().split(" ")[0];
			String strGoodId = ((ComboBoxStyle) test[1]).getText().split(" ")[0];
			String strPrice = ((TextFieldStyle) test[2]).getTxt();
			try {
				int supId = Integer.parseInt(strSupId);
				int goodId = Integer.parseInt(strGoodId);
				double price = Double.parseDouble(strPrice);
				int id = Integer.parseInt(strId);
				SupplierGood supplierGood = new SupplierGood(id, supId, goodId, price);
				supplierGoodDAO.editSupGood(supplierGood);
				((TextFieldStyle) test[2]).setTxt("");
				supGoodId.setText("");
				fetchData();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		} else if (command.equals(SupplierGoodConstants.DELETE)) {
			try {
				int id = Integer.parseInt(supGoodId.getText());
				supplierGoodDAO.deleteSupGood(id);
				((TextFieldStyle) test[2]).setTxt("");
				supGoodId.setText("");
				fetchData();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void fetchSupplier() {
		Vector<Supplier> vecs = supplierDAO.viewSuppliers();
		Vector<Good> goods = goodDAO.viewGoods();
		for (Supplier i : vecs) {
			listSupComboBox.add(i.getId() + " " + i.getName());
		}
		for (Good i : goods) {
			listGoodComboBox.add(i.getId() + " " + i.getName());
		}
	}

	public void fetchData() {
		((DefaultTableModel) tbPanel.getTable().getModel()).setRowCount(0);
		Vector<SupplierGood> supGoods = supplierGoodDAO.viewSupGoodJoin();
		Iterator it = supGoods.iterator();
		int i = 0;
		while (it.hasNext()) {
			SupplierGood supGood = (SupplierGood) it.next();
			tbPanel.getModel().addRow(new Object[0]);
			tbPanel.getModel().setValueAt(supGood.getId(), i, 0);
			tbPanel.getModel().setValueAt(supGood.getId_supplier() + " " + supGood.getSupplier().getName(), i, 1);
			tbPanel.getModel().setValueAt(supGood.getId_good() + " " + supGood.getGood().getName(), i, 2);
			tbPanel.getModel().setValueAt(supGood.getPrice(), i, 3);
			i++;
		}

	}
}
