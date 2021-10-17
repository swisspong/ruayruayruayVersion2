package pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import commponents.ButtonRounded;
import commponents.CartListPanel;
import commponents.CartListSp;
import commponents.ComboBoxStyle;
import commponents.DateChooser;
import commponents.FormGroup;
import commponents.GroupButton;
import commponents.PanelRoundedRight;
import commponents.ScrollBarCustom;
import commponents.TableStyle;
import commponents.TextFieldStyle;
import constants.ColorConstants;
import constants.InvoiceConstants;
import constants.SupplierGoodConstants;
import daos.GoodDAO;
import daos.InvoiceDAO;
import daos.InvoiceDetailDAO;
import daos.SupplierDAO;
import daos.SupplierGoodDAO;
import models.CartItem;
import models.Good;
import models.Invoice;
import models.InvoiceDetail;
import models.Supplier;
import models.SupplierGood;

public class InvoicePage extends PanelRoundedRight implements ActionListener{
	public ButtonRounded[] btns = { new ButtonRounded(InvoiceConstants.ADD),new ButtonRounded(InvoiceConstants.ADD_CART),new ButtonRounded("Accept To Stock"),new ButtonRounded("Cancel")};
	public List<String> listSupComboBox = null;
	public List<String> listGoodComboBox=null;
	public Component[] test = { 
			new ComboBoxStyle("Supplier", listSupComboBox, 540),
			new ComboBoxStyle("Good", listSupComboBox, 540), 
			new TextFieldStyle("Quantity", 540),
		
	};
	private String arr[] = { "Id", "Id_Sup", "Date", "Total" };
	private String arr2[] = { "Id", "Id_Inv", "Status", "Id_Good","Amount","Qty" };
	List<CartItem> carts = new ArrayList<CartItem>();
	private SupplierDAO supplierDAO = new SupplierDAO();
	DefaultListModel dlm;
	CartListPanel crp;
	private GoodDAO goodDAO = new GoodDAO();
	private SupplierGoodDAO supGoodDAO = new SupplierGoodDAO();
	private Vector<Supplier> sups;
	Vector<SupplierGood> supGoods;
	public TableStyle tbPanel;
	public TableStyle tbPanel2;
	public JTextField invId;
	InvoiceDAO invoiceDAO = new InvoiceDAO();
	public InvoicePage() {
		listSupComboBox = new ArrayList<String>();
		listGoodComboBox=new ArrayList<String>();
		int width;
		int height;
		
		fetchSupplier();
		((ComboBoxStyle) test[0]).setData(listSupComboBox);

		((ComboBoxStyle) test[1]).setData(listGoodComboBox);
		
		JLabel pageName = new JLabel(InvoiceConstants.PAGE_NAME);
		pageName.setFont(new Font("sanserif", Font.PLAIN, 18));
		pageName.setForeground(Color.white);
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		pageName.setBounds(80, 40, 200, 24);
		
		
		add(pageName);
		invId = new JTextField();
		invId.setBackground(null);
		invId.setBounds(0, 0, 0, 0);
		setLayout(null);
		setBackground(ColorConstants.BG);
		add(invId);
		
		setLayout(null);
		setBackground(ColorConstants.BG);

		JList<String> list = new JList<String>();
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
		
		((ComboBoxStyle) test[0]).getComboBox().addActionListener(this);

		crp = new CartListPanel();
		crp.getBtnRemove().addActionListener(this);
		crp.getBtnClear().addActionListener(this);
		add(crp);
	
		add(new GroupButton(btns));
		add(new FormGroup(test));
		
		add(pageName);
		
		for (ButtonRounded i : btns) {
			i.addActionListener(this);
		}

		tbPanel2 = new TableStyle(arr2, test, invId,600,150,500);

		add(tbPanel2);
		tbPanel = new TableStyle(arr, test, invId,600,100,350);
		fetchData();
		tbPanel.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tbPanel.getTable().getSelectedRow();
				fetchDataTb2(Integer.parseInt(tbPanel.getTable().getModel().getValueAt(index, 0).toString()));
			}
		});
		add(tbPanel);
	}
	
	public void init() {
		this.removeAll();
		this.revalidate();
		this.repaint();
		listSupComboBox = new ArrayList<String>();
		listGoodComboBox=new ArrayList<String>();
		
		int width;
		int height;
		
		fetchSupplier();
		((ComboBoxStyle) test[0]).setData(listSupComboBox);

		((ComboBoxStyle) test[1]).setData(listGoodComboBox);
		
		JLabel pageName = new JLabel(InvoiceConstants.PAGE_NAME);
		pageName.setFont(new Font("sanserif", Font.PLAIN, 18));
		pageName.setForeground(Color.white);
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		pageName.setBounds(80, 40, 200, 24);
		
		
		add(pageName);
		invId = new JTextField();
		invId.setBackground(null);
		invId.setBounds(0, 0, 0, 0);
		setLayout(null);
		setBackground(ColorConstants.BG);
		add(invId);
		
		setLayout(null);
		setBackground(ColorConstants.BG);

		JList<String> list = new JList<String>();
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
		
		((ComboBoxStyle) test[0]).getComboBox().addActionListener(this);

		crp = new CartListPanel();
		crp.getBtnRemove().addActionListener(this);
		crp.getBtnClear().addActionListener(this);
		add(crp);
	
		add(new GroupButton(btns));
		add(new FormGroup(test));
		
		add(pageName);
		


		tbPanel2 = new TableStyle(arr2, test, invId,600,150,500);

		add(tbPanel2);
		tbPanel = new TableStyle(arr, test, invId,600,100,350);
		fetchData();
		tbPanel.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tbPanel.getTable().getSelectedRow();
				fetchDataTb2(Integer.parseInt(tbPanel.getTable().getModel().getValueAt(index, 0).toString()));
			}
		});
		add(tbPanel);
	}
	
	
	public void fetchSupplier() {
		sups = supplierDAO.viewSuppliers();
		listSupComboBox.clear();
		for (Supplier i : sups) {
			listSupComboBox.add(i.getId() + " " + i.getName());
		}
		supGoods =supGoodDAO.findBySupId(sups.get(0));
		
		listGoodComboBox.clear();
		for (SupplierGood i : supGoods) {
			listGoodComboBox.add(""+i.getId_good());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(InvoiceConstants.ADD_CART)) {
			((ComboBoxStyle) test[0]).getComboBox().setEnabled(false);
			String strGood = ((ComboBoxStyle) test[1]).getText();
			String strQty = ((TextFieldStyle) test[2]).getTxt();

			
			CartItem itemNew =new CartItem();
			itemNew.setId(Integer.parseInt(strGood));
			itemNew.setQuantity(Integer.parseInt(strQty));
			itemNew.setSubTotal(supGoods.get(((ComboBoxStyle) test[1]).getComboBox().getSelectedIndex()).getPrice() * itemNew.getQuantity());
			boolean found = false;

			for(CartItem i:carts) {
				if(i.getId() == itemNew.getId()) {
					i.setQuantity(i.getQuantity() + itemNew.getQuantity());
					i.setSubTotal(supGoods.get(((ComboBoxStyle) test[1]).getComboBox().getSelectedIndex()).getPrice() * i.getQuantity());
					found=true;

				}
			}
			if(found == false) {
				carts.add(itemNew);
			}

			crp.getDlm().clear();
			for(CartItem i:carts) {
				crp.getDlm().addElement("ID:"+i.getId()+" Qty:"+i.getQuantity()+" Price:"+i.getSubTotal());
			}

			
		}else if(command.equals("remove")) {		

			carts.remove(crp.getList().getSelectedIndex());
			crp.getDlm().clear();
			for(CartItem i:carts) {
				crp.getDlm().addElement("ID:"+i.getId()+" Qty:"+i.getQuantity()+" Price:"+i.getSubTotal());
			}
			if(carts.size() == 0) ((ComboBoxStyle) test[0]).getComboBox().setEnabled(true);
		}else if(command.equals("clear")) {

			crp.getDlm().clear();
			carts.clear();
			((ComboBoxStyle) test[0]).getComboBox().setEnabled(true);
		}else if(command.equals(InvoiceConstants.ADD)){
			
			InvoiceDetailDAO invdDAO =new InvoiceDetailDAO();
			Supplier sup = sups.get(((ComboBoxStyle) test[0]).getComboBox().getSelectedIndex());
			
		
			Invoice invoice = new Invoice(sup,0);
			try {
				invoice.setId(invoiceDAO.addInvoieAndGetKey(invoice));
				for(CartItem i:carts) {
					InvoiceDetail invD = new InvoiceDetail(invoice,0,(Good) i,i.getSubTotal(),i.getQuantity());
					invdDAO.addInvoiceDetail(invD);
				}
				invoice.setTotal(invdDAO.sumAmount(invoice.getId()));
				invoiceDAO.updateTotal(invoice);
				crp.getDlm().clear();
				carts.clear();
				((ComboBoxStyle) test[0]).getComboBox().setEnabled(true);
				fetchData();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}else if(command.equals("Accept To Stock")) {
			InvoiceDetailDAO invDDAO =new InvoiceDetailDAO();
			int index = tbPanel2.getTable().getSelectedRow();
			int index2 = tbPanel.getTable().getSelectedRow();
			System.out.println(Integer.parseInt(tbPanel2.getTable().getModel().getValueAt(index, 0).toString()));
			if(tbPanel2.getTable().getModel().getValueAt(index, 2).toString().equals("Pending")) {
				
				try {
					invDDAO.updateStatus(Integer.parseInt(tbPanel2.getTable().getModel().getValueAt(index, 0).toString()));
					Good good =goodDAO.findById(Integer.parseInt(tbPanel2.getTable().getModel().getValueAt(index, 3).toString()));
					good.setStock(good.getStock() + Integer.parseInt(tbPanel2.getTable().getModel().getValueAt(index, 5).toString()));
					goodDAO.updateStock(good);
					fetchDataTb2(Integer.parseInt(tbPanel.getTable().getModel().getValueAt(index2, 0).toString()));
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		}else if(command.equals("Cancel")) {
			InvoiceDetailDAO invDDAO =new InvoiceDetailDAO();
			int index = tbPanel2.getTable().getSelectedRow();
			int index2 = tbPanel.getTable().getSelectedRow();
			if(tbPanel2.getTable().getModel().getValueAt(index, 2).toString().equals("Pending")) {
				
				try {
					invDDAO.updateStatus(Integer.parseInt(tbPanel2.getTable().getModel().getValueAt(index, 0).toString()));
					fetchDataTb2(Integer.parseInt(tbPanel.getTable().getModel().getValueAt(index2, 0).toString()));
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		}else if(e.getSource() == ((ComboBoxStyle) test[0]).getComboBox()) {
			System.out.println(((ComboBoxStyle) test[0]).getComboBox().getSelectedIndex());
			supGoods =supGoodDAO.findBySupId(sups.get(((ComboBoxStyle) test[0]).getComboBox().getSelectedIndex()));
			listGoodComboBox.clear();
			for (SupplierGood i : supGoods) {
				listGoodComboBox.add(""+i.getId_good());
			}
			((ComboBoxStyle) test[1]).setData(listGoodComboBox);
		}
		
	}
	public void fetchData() {
		((DefaultTableModel) tbPanel.getTable().getModel()).setRowCount(0);
		Vector<Invoice> invoices = invoiceDAO.viewInvoices();
		Iterator it = invoices.iterator();
		int i = 0;
		while (it.hasNext()) {
			Invoice invoice = (Invoice) it.next();
			tbPanel.getModel().addRow(new Object[0]);
			tbPanel.getModel().setValueAt(invoice.getId(), i, 0);
			tbPanel.getModel().setValueAt(invoice.getSupplier().getId(), i, 1);
			tbPanel.getModel().setValueAt(invoice.getDate(), i, 2);
			tbPanel.getModel().setValueAt(invoice.getTotal(), i, 3);
			i++;
		}

	}
	public void fetchDataTb2(int invoiceId) {
		InvoiceDetailDAO invDDAO =new InvoiceDetailDAO();
		((DefaultTableModel) tbPanel2.getTable().getModel()).setRowCount(0);
		Vector<InvoiceDetail> invDs = invDDAO.viewInvoiceDetailById(invoiceId);
		Iterator it = invDs.iterator();
		int i = 0;
		while (it.hasNext()) {
			InvoiceDetail invD = (InvoiceDetail) it.next();
			tbPanel2.getModel().addRow(new Object[0]);
			tbPanel2.getModel().setValueAt(invD.getId(), i, 0);
			tbPanel2.getModel().setValueAt(invD.getInvoice().getId(), i, 1);
			tbPanel2.getModel().setValueAt(invD.getStatus() == 0?"Pending":"Good In Stock", i, 2);
			tbPanel2.getModel().setValueAt(invD.getGood().getId(), i, 3);
			tbPanel2.getModel().setValueAt(invD.getAmount(), i, 4);
			tbPanel2.getModel().setValueAt(invD.getQuantity(), i, 5);
			i++;
		}
		
	}
}
