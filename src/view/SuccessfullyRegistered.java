
	package view;

	import java.awt.Container;

import javax.swing.JFrame;
	import javax.swing.JLabel;

	public class SuccessfullyRegistered extends JFrame {
		Container container;
		JLabel lTxt;
		
		public SuccessfullyRegistered() {
			 container = getContentPane();
			this.setTitle("Successfully Registered");
			this.setVisible(true);
			this.setBounds(0,0,200,200);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);//fixed size frame
		lTxt = new JLabel("Successfully Registered!......");
		lTxt.setBounds(0,0,100,70);
		container.add(lTxt);
		}

		
		

	}


