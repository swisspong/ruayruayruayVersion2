package pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.Main;
import commponents.ButtonRounded;
import commponents.FormGroup;
import commponents.GroupButton;
import commponents.PanelRounded;
import commponents.PanelRoundedRight;
import commponents.ScrollBarCustom;
import commponents.TableStyle;
import commponents.TextFieldStyle;
import constants.AdminGoodConstants;
import constants.ColorConstants;
import constants.CustomerConstants;
import daos.CustomerDAO;
import daos.GoodDAO;
import models.Customer;
import models.Good;

public class CustomerPage extends PanelRoundedRight implements ActionListener {
	public JTextField userId;
	public ButtonRounded[] btns = { new ButtonRounded(CustomerConstants.ADD),
			new ButtonRounded(CustomerConstants.UPDATE), new ButtonRounded(CustomerConstants.DELETE), };
	public TextFieldStyle[] tfs = { new TextFieldStyle("Name", 270), new TextFieldStyle("Username", 270),
			new TextFieldStyle("Email", 270), new TextFieldStyle("Address", 270), new TextFieldStyle("Phone", 270),
			new TextFieldStyle("Password", 270),
	};
	public String arr[] = { "Id", "Name", "Username", "Email", "Address", "Phone", "Password" };
	public TableStyle tbPanel;

	private CustomerDAO customerDAO = new CustomerDAO();

	public CustomerPage() {
		int width;
		int height;
		JLabel pageName = new JLabel(CustomerConstants.PAGE_NAME);
		pageName.setFont(new Font("sanserif", Font.PLAIN, 18));
		pageName.setForeground(Color.white);
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		pageName.setBounds(80, 40, 100, 24);

		userId = new JTextField();
		userId.setBackground(null);
		userId.setBounds(0, 0, 0, 0);
		setLayout(null);
		setBackground(ColorConstants.BG);
		add(userId);
		add(pageName);

		add(new GroupButton(btns));
		for (ButtonRounded i : btns) {
			i.addActionListener(this);
		}
		add(new FormGroup(tfs, 10, 15));

		tbPanel = new TableStyle(arr, tfs, userId);
		fetchData();
		add(tbPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(CustomerConstants.ADD)) {
			String strName = tfs[0].getTxt();
			String strUsername = tfs[1].getTxt();
			String strEmail = tfs[2].getTxt();
			String strAddress = tfs[3].getTxt();
			String strPhone = tfs[4].getTxt();
			String strPassword = tfs[5].getTxt();
			Customer customer = new Customer(strName, strAddress, strPhone, strEmail, strUsername, strPassword);
			customerDAO.addCustomer(customer);
			for (TextFieldStyle i : tfs) {
				i.setTxt("");
			}
			fetchData();
		}else if(command.equals(CustomerConstants.UPDATE)) {
			String strName = tfs[0].getTxt();
			String strUsername = tfs[1].getTxt();
			String strEmail = tfs[2].getTxt();
			String strAddress = tfs[3].getTxt();
			String strPhone = tfs[4].getTxt();
			String strPassword = tfs[5].getTxt();
			String strId =userId.getText();
			try {
				int id = Integer.parseInt(strId);
				Customer customer = new Customer(id, strName, strAddress, strPhone, strEmail, strUsername, strPassword);
				customerDAO.editCustomer(customer);
				for(TextFieldStyle i :tfs) {
					i.setTxt("");
				}
				userId.setText("");
				fetchData();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}else if(command.equals(CustomerConstants.DELETE)) {
			int id = Integer.parseInt(userId.getText());
			customerDAO.deleteCustomer(id);
			for(TextFieldStyle i :tfs) {
				i.setTxt("");
			}
			userId.setText("");
			fetchData();
		}
	}

	public void fetchData() {
		((DefaultTableModel) tbPanel.getTable().getModel()).setRowCount(0);
		Vector<Customer> customers = customerDAO.viewCustomers();
		Iterator it = customers.iterator();
		int i = 0;
		while (it.hasNext()) {
			Customer customer = (Customer) it.next();
			tbPanel.getModel().addRow(new Object[0]);
			tbPanel.getModel().setValueAt(customer.getId(), i, 0);
			tbPanel.getModel().setValueAt(customer.getName(), i, 1);
			tbPanel.getModel().setValueAt(customer.getUsername(), i, 2);
			tbPanel.getModel().setValueAt(customer.getEmail(), i, 3);
			tbPanel.getModel().setValueAt(customer.getAddress(), i, 4);
			tbPanel.getModel().setValueAt(customer.getPhone(), i, 5);
			tbPanel.getModel().setValueAt(customer.getPassword(), i, 6);
			i++;
		}

	}

}
