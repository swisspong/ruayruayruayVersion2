package commponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;

import com.mysql.cj.x.protobuf.MysqlxResultset.ColumnMetaDataOrBuilder;

import constants.ColorConstants;

public class ComboBoxStyle extends JPanel {
	JComboBox comboBox;
	public ComboBoxStyle(String name, List<String> arr,int width) {

//		String ar[] = {"test",""};
		JLabel lbName = new JLabel(name);
		lbName.setFont(new java.awt.Font("Berlin Sans FB", 0, 15));
		lbName.setForeground(Color.white);

		comboBox = new JComboBox();
//		comboBox.setModel(new DefaultComboBoxModel(ar));
		
		comboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected void installDefaults() {
				super.installDefaults();
			}

		});

		comboBox.setUI(new BasicComboBoxUI() {
			@Override
			public void configureArrowButton() {
				super.configureArrowButton();
				arrowButton.setBackground(null);
				arrowButton.setForeground(Color.white);
				arrowButton.setBorder(BorderFactory.createEmptyBorder());
			}

			@Override
			protected ListCellRenderer<Object> createRenderer() {
				return new PersonalCellRenderer();
			}
		});
		comboBox.setBorder(BorderFactory.createEmptyBorder());
		comboBox.setPreferredSize(new Dimension(width, 20));
		comboBox.setBackground(null);
		comboBox.setForeground(Color.white);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setFont(new java.awt.Font("sanserfi", 0, 15));
		comboBox.setFocusable(UIManager.getBoolean("ComboBox.focusable"));
		JSeparator sr = new JSeparator();
		sr.setPreferredSize(new Dimension(width, 2));
		sr.setBackground(Color.white);

		setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		setPreferredSize(new Dimension(width, 47));
		setBackground(null);

		add(lbName);
		add(comboBox);
		add(sr);

	}

	public class PersonalCellRenderer extends BasicComboBoxRenderer {

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			if (isSelected) {
				setForeground(UIManager.getColor("ComboBox[item].selectionForeground"));
			} else {
				setForeground(Color.white);
			}
			setBackground(isSelected || cellHasFocus ? Color.white : ColorConstants.PRIMARY);
			return this;
		}

	}

	public void setData(List<String> arr) {
		comboBox.setModel(new DefaultComboBoxModel(arr.toArray()));
	}
	public String getText() {
		
		return comboBox.getSelectedItem().toString();
	}
	public void setSelect(String str) {
		comboBox.setSelectedItem(str);
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	
}
