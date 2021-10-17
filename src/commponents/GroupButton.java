package commponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import constants.ColorConstants;

public class GroupButton extends PanelRounded{
	public GroupButton(ButtonRounded btns[]) {
		
		int width;
		int height;
		setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		setBackground(ColorConstants.PRIMARY);
		
		
		setPreferredSize(new Dimension(150,220));
		width = getPreferredSize().width;
		height =getPreferredSize().height;
		setBounds(930-width-80,100,width,height);
		

		for(ButtonRounded i:btns) {
			add(i);
		}
	}
	public GroupButton(Component btns[],int hgap,int vgap) {
		
		int width;
		int height;
		setLayout(new FlowLayout(FlowLayout.CENTER,hgap,vgap));
		setBackground(ColorConstants.PRIMARY);
		
		
		setPreferredSize(new Dimension(150,220));
		width = getPreferredSize().width;
		height =getPreferredSize().height;
		setBounds(930-width-80,100,width,height);
		
		
		for(Component i:btns) {
			add(i);
		}
	}
	public GroupButton(Component btns[],int hgap,int vgap,int y) {
		
		int width;
		int height;
		setLayout(new FlowLayout(FlowLayout.CENTER,hgap,vgap));
		setBackground(ColorConstants.PRIMARY);
		
		
		setPreferredSize(new Dimension(150,220));
		width = getPreferredSize().width;
		height =getPreferredSize().height;
		setBounds(930-width-80,y,width,height);
		
		
		for(Component i:btns) {
			add(i);
		}
	}
}
