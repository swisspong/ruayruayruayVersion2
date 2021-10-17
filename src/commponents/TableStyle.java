package commponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.w3c.dom.Text;

import constants.ColorConstants;
import pages.CustomerPage;

public class TableStyle extends PanelRounded {
	private JTable table;
	public DefaultTableModel model;
	public Menu menu;
	public JTextField goodId;
	private TextFieldStyle tfs[];
	private String arr[];
	public Component coms[];
	private int width=770;
	private int height=270;
	private int hgap=80;
	private int vgap=350;
//	CustomerPage page;
	public TableStyle(String arr[],Component coms[],JTextField goodId) {
		this.coms = coms;
		this.goodId = goodId;
		table = new JTable();
		table.setFocusable(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setSelectionBackground(new Color(1.0f, 1.0f, 1.0f, 0.2f));
		table.setSelectionForeground(Color.white);
		table.setForeground(Color.white);
		table.setFont(new Font("sanserif", Font.PLAIN, 15));
		table.setBackground(ColorConstants.PRIMARY);
		table.setShowVerticalLines(false);
		table.setRowHeight(35);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(ColorConstants.PRIMARY);
		table.getTableHeader().setForeground(Color.white);
		table.setOpaque(true);
		table.setFillsViewportHeight(true);
		table.setBackground(ColorConstants.PRIMARY);
		table.setGridColor(Color.white);

		table.setFocusable(false);
		table.getTableHeader().setFont(new Font("sanserif", Font.BOLD, 16));
		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		table.getTableHeader().setFocusable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		model = (DefaultTableModel) table.getModel();
		for (String i : arr) {
			model.addColumn(i);
		}
//		table.setPreferredScrollableViewportSize(new Dimension(270, 600));
//		table.setPreferredScrollableViewportSize(new Dimension(270, 770));
		table.setPreferredScrollableViewportSize(new Dimension(270, width));

		JScrollPane sp = new JScrollPane(table);

//		sp.setBounds(0, 15, 770, 270);
		sp.setBounds(0, 15, width, 270);
//		sp.setBounds(0, 15, 600, 270);
		sp.setBorder(BorderFactory.createEmptyBorder());
		sp.setVerticalScrollBar(new ScrollBarCustom());
		sp.setBackground(ColorConstants.PRIMARY);

		setLayout(null);
		setBackground(ColorConstants.PRIMARY);
//		setBounds(80, 350, 600, 300);
//		setBounds(80, 350, 770, 300);
		setBounds(80, 350, width, 300);
		add(sp);
		action();
	}
	public TableStyle(String arr[],Component coms[],JTextField goodId,int width,int height,int vgap) {
		this.coms = coms;
		this.goodId = goodId;
		table = new JTable();
		table.setFocusable(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setSelectionBackground(new Color(1.0f, 1.0f, 1.0f, 0.2f));
		table.setSelectionForeground(Color.white);
		table.setForeground(Color.white);
		table.setFont(new Font("sanserif", Font.PLAIN, 15));
		table.setBackground(ColorConstants.PRIMARY);
		table.setShowVerticalLines(false);
		table.setRowHeight(35);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(ColorConstants.PRIMARY);
		table.getTableHeader().setForeground(Color.white);
		table.setOpaque(true);
		table.setFillsViewportHeight(true);
		table.setBackground(ColorConstants.PRIMARY);
		table.setGridColor(Color.white);
		
		table.setFocusable(false);
		table.getTableHeader().setFont(new Font("sanserif", Font.BOLD, 16));
		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		table.getTableHeader().setFocusable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		model = (DefaultTableModel) table.getModel();
		for (String i : arr) {
			model.addColumn(i);
		}
//		table.setPreferredScrollableViewportSize(new Dimension(270, 600));
//		table.setPreferredScrollableViewportSize(new Dimension(270, 770));
		table.setPreferredScrollableViewportSize(new Dimension(height, width));
		
		JScrollPane sp = new JScrollPane(table);
		
//		sp.setBounds(0, 15, 770, 270);
		sp.setBounds(0, 15, width, height);
//		sp.setBounds(0, 15, 600, 270);
		sp.setBorder(BorderFactory.createEmptyBorder());
		sp.setVerticalScrollBar(new ScrollBarCustom());
		sp.setBackground(ColorConstants.PRIMARY);
		
		setLayout(null);
		setBackground(ColorConstants.PRIMARY);
//		setBounds(80, 350, 600, 300);
//		setBounds(80, 350, 770, 300);
		setBounds(hgap, vgap, width, height+30);
		add(sp);
//		action();
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public TableStyle(String arr[], TextFieldStyle tfs[], JTextField goodId) {
		this.arr = arr;
		this.tfs = tfs;
		this.goodId = goodId;

		table = new JTable();
		table.setFocusable(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setSelectionBackground(new Color(1.0f, 1.0f, 1.0f, 0.2f));
		table.setSelectionForeground(Color.white);
		table.setForeground(Color.white);
		table.setFont(new Font("sanserif", Font.PLAIN, 15));
		table.setBackground(ColorConstants.PRIMARY);
		table.setShowVerticalLines(false);
		table.setRowHeight(35);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(ColorConstants.PRIMARY);
		table.getTableHeader().setForeground(Color.white);
		table.setOpaque(true);
		table.setFillsViewportHeight(true);
		table.setBackground(ColorConstants.PRIMARY);
		table.setGridColor(Color.white);

		table.setFocusable(false);
		table.getTableHeader().setFont(new Font("sanserif", Font.BOLD, 16));
		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		table.getTableHeader().setFocusable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		model = (DefaultTableModel) table.getModel();
		for (String i : arr) {
			model.addColumn(i);
		}

		table.setPreferredScrollableViewportSize(new Dimension(270, 770));

		JScrollPane sp = new JScrollPane(table);

		sp.setBounds(0, 15, 770, 270);
		sp.setBorder(BorderFactory.createEmptyBorder());
		sp.setVerticalScrollBar(new ScrollBarCustom());
		sp.setBackground(ColorConstants.PRIMARY);

		setLayout(null);
		setBackground(ColorConstants.PRIMARY);
		setBounds(80, 350, 770, 300);
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
				if(coms != null) {
					int index = table.getSelectedRow();
					goodId.setText(model.getValueAt(index, 0).toString());
					int j = 1;
					for (Component i : coms) {
						if(i instanceof ComboBoxStyle) {
							((ComboBoxStyle) i).setSelect(model.getValueAt(index, j).toString());
						}else {
							((TextFieldStyle) i).setTxt(model.getValueAt(index, j).toString());
							
						}
						j++;
					}
				}else {
					
					int index = table.getSelectedRow();
					goodId.setText(model.getValueAt(index, 0).toString());
					int j = 1;
					for (TextFieldStyle i : tfs) {
						i.setTxt(model.getValueAt(index, j).toString());
						j++;
					}
				}

			}
		});
	}
}

class JComponentTableCellRenderer implements TableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return (JComponent) value;
	}
}
