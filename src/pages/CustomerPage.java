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
import commponents.PanelRounded;
import commponents.PanelRoundedRight;
import commponents.ScrollBarCustom;
import commponents.TableStyle;
import commponents.TextFieldStyle;
import daos.GoodDAO;
import models.Good;

public class CustomerPage implements ActionListener {
	private JTable table;
	private GoodDAO goodDAO = new GoodDAO();
	private DefaultTableModel model;
	public TextFieldStyle[] tfs = {
			new TextFieldStyle("Name",440),
			new TextFieldStyle("Price",210),
			new TextFieldStyle("Stock",210),
			new TextFieldStyle("Description",440)
	};
	public String arr[]= {
			"Id",
			"Name",
			"Price",
			"Stock",
			"Description"
		};
	public int idGood;
	private TableStyle panel1;
	public CustomerPage(Main main) {
		PanelRoundedRight customerPage = new PanelRoundedRight();
		int width;
		int height;
		JLabel pageName = new JLabel("Admin Good");
		pageName.setFont(new Font("sanserif",Font.PLAIN,18));
		pageName.setForeground(Color.white);
		width = pageName.getPreferredSize().width;
		height = pageName.getPreferredSize().height;
		pageName.setBounds(80, 40, 100, height);
		customerPage.setLayout(null);
		customerPage.setBackground(Color.decode("#121212"));

		customerPage.add(pageName);
		
		PanelRounded container = new PanelRounded();

		container.setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
		container.setBackground(Color.decode("#1E1E1E"));

		container.setPreferredSize(new Dimension(150,220));
		width = container.getPreferredSize().width;
		height = container.getPreferredSize().height;
		container.setBounds(930-width-80,100,width,height);
		
		ButtonRounded btn = new ButtonRounded();
		btn.setText("Add Customer");
		btn.addActionListener(this);
		ButtonRounded btn1 = new ButtonRounded();
		btn1.setText("Update Customer");
		btn1.addActionListener(this);
		ButtonRounded btn2 = new ButtonRounded();
		btn2.setText("Delete Customer");
		btn2.addActionListener(this);
		container.add(btn);
		container.add(btn1);
		container.add(btn2);
		customerPage.add(container);
		
		PanelRounded panel = new PanelRounded();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,15));
		panel.setBackground(Color.decode("#1E1E1E"));
		panel.setBounds(80,100,600,220);
		
		for(TextFieldStyle i:tfs) {
			panel.add(i);
		}
		customerPage.add(panel);
		
		//------------- table -------------
		
//		table = new JTable();
//		table.setFocusable(false);
//		table.setIntercellSpacing(new Dimension(0,0));
//		table.setSelectionBackground(new Color(1.0f,1.0f,1.0f,0.2f));
//		table.setSelectionForeground(Color.white);
//		table.setForeground(Color.white);
//		table.setFont(new Font("sanserif",Font.PLAIN,15));
//		table.setBackground(Color.decode("#1E1E1E"));
//		table.setShowVerticalLines(false);
//		table.setRowHeight(35);
//		table.getTableHeader().setOpaque(false);
//		table.getTableHeader().setBackground(Color.decode("#1E1E1E"));
//		table.getTableHeader().setForeground(Color.white);
//		table.setOpaque(true);
//		table.setFillsViewportHeight(true);
//		table.setBackground(Color.decode("#1E1E1E"));
//		table.setGridColor(Color.white);
//		
//		table.setFocusable(false);
//		table.getTableHeader().setFont(new Font("sanserif",Font.BOLD,16));
//		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
//		table.getTableHeader().setFocusable(false);
//		table.getTableHeader().setReorderingAllowed(false);
//		table.getTableHeader().setResizingAllowed(false);
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int index = table.getSelectedRow();
//				idGood = Integer.parseInt(model.getValueAt(index, 0).toString());
//				tfs[0].setTxt(model.getValueAt(index, 1).toString());
//				tfs[1].setTxt(model.getValueAt(index, 3).toString());
//				tfs[2].setTxt(model.getValueAt(index, 4).toString());
//				tfs[3].setTxt(model.getValueAt(index, 2).toString());
//				
//			}
//		});
//		
//		model = (DefaultTableModel) table.getModel();
//		model.addColumn("Id");
//		model.addColumn("Name");
//		model.addColumn("Description");
//		model.addColumn("Price");
//		model.addColumn("Quantity");
//
//		
//		fetchData();
//		
//		
//		
//		table.setPreferredScrollableViewportSize(new Dimension (270,770));
		
	
	
//		JScrollPane sp = new JScrollPane(table);
//		
//		sp.setBounds(0,15,770,270);
//		sp.setBorder(BorderFactory.createEmptyBorder());
//		sp.setVerticalScrollBar(new ScrollBarCustom());
//		sp.setBackground(Color.decode("#1E1E1E"));
//		
//		PanelRounded panel1 = new PanelRounded();
//		panel1.setLayout(null);
//		panel1.setBackground(Color.decode("#1E1E1E"));
//		panel1.setBounds(80,350,770,300);
//		panel1.add(sp);

		panel1 = new TableStyle(this);
		fetchData();
		customerPage.add(panel1);
		
		
		main.mainPanel.add(customerPage,"test");
	}
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		if (command.equals("Add Customer")) {
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
		else if(command.equals("Update Customer")) {
			String strName = tfs[0].getTxt();
			String strPrice = tfs[1].getTxt();
			String strStock = tfs[2].getTxt();
			String strDesc =  tfs[3].getTxt();
			
			try {
				double price = Double.parseDouble(strPrice);
				int stock = Integer.parseInt(strStock);
				Good good = new Good(idGood,strName, strDesc, price, stock);
				goodDAO.editGood(good);
				for(TextFieldStyle i :tfs) {
					i.setTxt("");
				}
				idGood=0;
			
				fetchData();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		else if(command.equals("Delete Customer")) {
			
			goodDAO.deleteGood(idGood);
			for(TextFieldStyle i :tfs) {
				i.setTxt("");
			}
			fetchData();
		}
	}
	public void fetchData() {
		((DefaultTableModel)panel1.getTable().getModel()).setRowCount(0);
		Vector<Good> goods = goodDAO.viewGoods();
		Iterator it = goods.iterator();
		int i=0;
		while (it.hasNext()) {
			Good good = (Good) it.next();
			panel1.getModel().addRow(new Object[0]);
			panel1.getModel().setValueAt(good.getId(), i, 0);
			panel1.getModel().setValueAt(good.getName(), i, 1);
			panel1.getModel().setValueAt(good.getPrice(), i, 2);
			panel1.getModel().setValueAt(good.getStock(), i, 3);
			panel1.getModel().setValueAt(good.getDescription(), i, 4);
			i++;
		}
		
	}
}
