package view;

import java.awt.Container;

import javax.swing.JFrame;

public class EmpHomeFrame extends JFrame{
    Container container;
	public EmpHomeFrame() {
		container = getContentPane();
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		  
		this.setTitle("EMP HOME");
		this.setVisible(true);
		this.setBounds(10,10,600,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//fixed size frame
		
}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		}
	
	public void addComponentsToContainer() {
	}

	public void callDispose() {
		this.dispose();
	}
}
