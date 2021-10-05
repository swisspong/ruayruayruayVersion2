package commponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pages.CustomerPage;

public class TableStyle extends PanelRounded{
	private JTable table;
	DefaultTableModel model;
	CustomerPage page;
	public TableStyle(CustomerPage page) {
		this.page = page;
		table = new JTable();
		table.setFocusable(false);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setSelectionBackground(new Color(1.0f,1.0f,1.0f,0.2f));
		table.setSelectionForeground(Color.white);
		table.setForeground(Color.white);
		table.setFont(new Font("sanserif",Font.PLAIN,15));
		table.setBackground(Color.decode("#1E1E1E"));
		table.setShowVerticalLines(false);
		table.setRowHeight(35);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(Color.decode("#1E1E1E"));
		table.getTableHeader().setForeground(Color.white);
		table.setOpaque(true);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.decode("#1E1E1E"));
		table.setGridColor(Color.white);
		
		table.setFocusable(false);
		table.getTableHeader().setFont(new Font("sanserif",Font.BOLD,16));
		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		table.getTableHeader().setFocusable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		
		model = (DefaultTableModel) table.getModel();
		for(String i:page.arr) {
			model.addColumn(i);
		}
		
		
		table.setPreferredScrollableViewportSize(new Dimension (270,770));
		
		JScrollPane sp = new JScrollPane(table);

		sp.setBounds(0,15,770,270);
		sp.setBorder(BorderFactory.createEmptyBorder());
		sp.setVerticalScrollBar(new ScrollBarCustom());
		sp.setBackground(Color.decode("#1E1E1E"));
		
		setLayout(null);
		setBackground(Color.decode("#1E1E1E"));
		setBounds(80,350,770,300);
		add(sp);
		action();
	}
	public JTable getTable() {
		return table;
	}
	public DefaultTableModel getModel() {
		return model;
	}
	public void action() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				System.out.println(Integer.parseInt(model.getValueAt(index, 0).toString()));
				page.idGood = Integer.parseInt(model.getValueAt(index, 0).toString());
				int j=1;
				for(TextFieldStyle i:page.tfs) {
					i.setTxt(model.getValueAt(index, j).toString());
					j++;
				}
				
			}
		});
	}
}
