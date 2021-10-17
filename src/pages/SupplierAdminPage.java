package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import commponents.ButtonRounded;
import commponents.FormGroup;
import commponents.GroupButton;
import commponents.PanelRoundedRight;
import commponents.TableStyle;
import commponents.TextFieldStyle;
import constants.ColorConstants;
import constants.SupplierAdminConstants;
import daos.SupplierDAO;
import models.Customer;
import models.Supplier;

public class SupplierAdminPage extends PanelRoundedRight implements ActionListener {
	public JTextField supId;
	public ButtonRounded[] btns = { new ButtonRounded(SupplierAdminConstants.ADD),
			new ButtonRounded(SupplierAdminConstants.UPDATE), new ButtonRounded(SupplierAdminConstants.DELETE) };
	public TextFieldStyle[] tfs = { new TextFieldStyle("Name", 540), new TextFieldStyle("Address", 540),
			new TextFieldStyle("Email", 265), new TextFieldStyle("Phone", 265) };
	public String arr[] = { "Id", "Name", "Address", "Email", "Phone" };
	private TableStyle tbPanel;
	private SupplierDAO supplierDAO = new SupplierDAO();
	public SupplierAdminPage() {
		
		int width;
		int height;
		JLabel pageName = new JLabel(SupplierAdminConstants.PAGE_NAME);
		pageName.setFont(new Font("sanserif", Font.PLAIN, 18));
		pageName.setForeground(Color.white);
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		pageName.setBounds(80, 40, 200, 24);

		supId = new JTextField();
		supId.setBackground(null);
		supId.setBounds(0, 0, 0, 0);
		setLayout(null);
		setBackground(ColorConstants.BG);
		add(supId);
		add(pageName);

		add(new GroupButton(btns));
		for (ButtonRounded i : btns) {
			i.addActionListener(this);
		}
		add(new FormGroup(tfs, 10, 15));

		tbPanel = new TableStyle(arr, tfs, supId);
		fetchData();
		add(tbPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(SupplierAdminConstants.ADD)) {
			String strName = tfs[0].getTxt();
			String strAddress = tfs[1].getTxt();
			String strEmail = tfs[2].getTxt();
			String strPhone = tfs[3].getTxt();
			Supplier supplier = new Supplier(strName, strAddress, strPhone, strEmail);
			supplierDAO.addSupplier(supplier);
			for (TextFieldStyle i : tfs) {
				i.setTxt("");
			}
			fetchData();
		} else if (command.equals(SupplierAdminConstants.UPDATE)) {
			String strName = tfs[0].getTxt();
			String strAddress = tfs[1].getTxt();
			String strEmail = tfs[2].getTxt();
			String strPhone = tfs[3].getTxt();
			String strId =supId.getText();
			try {
				int id = Integer.parseInt(strId);
				Supplier supplier = new Supplier(id, strName, strAddress, strPhone, strEmail);
				supplierDAO.editSupplier(supplier);
				for(TextFieldStyle i :tfs) {
					i.setTxt("");
				}
				supId.setText("");
				fetchData();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		} else if (command.equals(SupplierAdminConstants.DELETE)) {
			int id = Integer.parseInt(supId.getText());
			supplierDAO.deleteSupplier(id);
			for(TextFieldStyle i :tfs) {
				i.setTxt("");
			}
			supId.setText("");
			fetchData();
		}

	}
	public void fetchData() {
		((DefaultTableModel) tbPanel.getTable().getModel()).setRowCount(0);
		Vector<Supplier> suppliers = supplierDAO.viewSuppliers();
		Iterator it = suppliers.iterator();
		int i = 0;
		while (it.hasNext()) {
			Supplier supplier = (Supplier) it.next();
			tbPanel.getModel().addRow(new Object[0]);
			tbPanel.getModel().setValueAt(supplier.getId(), i, 0);
			tbPanel.getModel().setValueAt(supplier.getName(), i, 1);
			tbPanel.getModel().setValueAt(supplier.getAddress(), i, 2);
			tbPanel.getModel().setValueAt(supplier.getEmail(), i, 3);
			tbPanel.getModel().setValueAt(supplier.getPhone(), i, 4);
			
			i++;
		}

	}

}
