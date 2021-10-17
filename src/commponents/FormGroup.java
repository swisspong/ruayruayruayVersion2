package commponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import constants.ColorConstants;

public class FormGroup extends PanelRounded {
	private int hGap =20;
	private int vGap =15;
	private TextFieldStyle tfs[];
	private ComboBoxStyle comboBox;
	private Component fields[];
	public FormGroup(TextFieldStyle[] tfs) {
		this.tfs = tfs;
		init();
	}
	public FormGroup(TextFieldStyle tfs[],int hGap,int vGap) {
		this.tfs=tfs;
		this.hGap = hGap;
		this.vGap = vGap;
		init();
	}
	public FormGroup(Component[] fields) {
		this.fields = fields;
		
		initObj();
	}
	public FormGroup(Component[] fields,int hGap,int vGap) {
		this.fields = fields;
		this.hGap = hGap;
		this.vGap = vGap;
		initObj();
	}
	public void init() {
		setLayout(new FlowLayout(FlowLayout.CENTER, hGap, vGap));
		setBackground(ColorConstants.PRIMARY);
		setBounds(80, 100, 600, 220);
		for (TextFieldStyle i : tfs) {
			add(i);
		}
		
	}
	public void initObj() {
		setLayout(new FlowLayout(FlowLayout.CENTER, hGap, vGap));
		setBackground(ColorConstants.PRIMARY);
		setBounds(80, 100, 600, 220);
		for (Component i : fields) {
			
			add(i);
		}
		
	}

}
