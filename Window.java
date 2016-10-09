package IntList;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The window that appears when IntList is ran
 * @author Mark Szewczuk
 *
 */
public class Window {
	
//	private JFrame frame = new JFrame();
//	private JLabel enterName = new JLabel("Enter Name Here");
//	private JLabel checkLabel = new JLabel("Check Here");
//	private JPanel panel = new JPanel();
//	private JTextField textField = new JTextField(12);
//	private JButton button = new JButton("ADD");
//	private JTextField checkF = new JTextField(12);
//	private JButton check = new JButton("CHECK");
//	private JPanel inting = new JPanel();
//	private JLabel feed = new JLabel("INT");
//	private JFrame plsInt = new JFrame();
//	private JButton closeInt = new JButton("OK");
	private ListHandling lh = new ListHandling();
	private CheckWindow ch;
	private IntWindow iw;
	private JFrame plsInt = new JFrame();
	
	/**
	 * Nested class to clean up some JFrame windows 
	 * @author Mark Szewczuk
	 *
	 */
	private class CheckWindow {
		private JLabel enterName = new JLabel("Enter Name Here");
		private JLabel checkLabel = new JLabel("Check Here");
		private JPanel panel = new JPanel();
		private JTextField textField = new JTextField(12);
		private JButton button = new JButton("ADD");
		private JTextField checkField = new JTextField(12);
		private JButton check = new JButton("CHECK");
		private JFrame frame = new JFrame();
		
		public CheckWindow() {
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(enterName, BorderLayout.CENTER);
			frame.setSize(200, 200);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(enterName);
			panel.add(textField);
			panel.add(button);
			panel.add(checkLabel);
			panel.add(checkField);
			panel.add(check);
			enterName.setAlignmentX(Component.CENTER_ALIGNMENT);
			textField.setAlignmentX(Component.CENTER_ALIGNMENT);
			button.setAlignmentX(Component.CENTER_ALIGNMENT);
			checkLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			checkField.setAlignmentX(Component.CENTER_ALIGNMENT);
			check.setAlignmentX(Component.CENTER_ALIGNMENT);
			frame.add(panel);
			frame.setLocationRelativeTo(null);
			frame.setTitle("INT LIST");
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						lh.appendToEnd(textField.getText());
						textField.setText(null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			check.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(lh.check(checkField.getText())){
						plsInt.setVisible(true);
					}
					checkField.setText(null);
				}
			});
		}
		
		
	}
	
	/**
	 * Nested class to clean up some JFrame windows
	 * @author Mark Szewczuk
	 *
	 */
	private class IntWindow {
		private JPanel inting = new JPanel();
		private JLabel feed = new JLabel("INT");
		private JButton closeInt = new JButton("OK");

		public IntWindow() {
			plsInt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			plsInt.setSize(200, 200);
			plsInt.add(inting);
			inting.add(feed);
			inting.add(closeInt);
			plsInt.setLocationRelativeTo(null);
			feed.setFont(new Font(feed.getFont().getName(), Font.BOLD, 100));
			closeInt.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					plsInt.dispose();
				}
				
			});
		}
		
	}
	
	public Window() throws IOException{
		lh.onStart();
		ch = new CheckWindow();
		iw = new IntWindow();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().add(enterName, BorderLayout.CENTER);
//		frame.setSize(200, 200);
//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//		panel.add(enterName);
//		panel.add(textField);
//		panel.add(button);
//		panel.add(checkLabel);
//		panel.add(checkF);
//		panel.add(check);
//		enterName.setAlignmentX(Component.CENTER_ALIGNMENT);
//		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
//		button.setAlignmentX(Component.CENTER_ALIGNMENT);
//		checkLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		checkF.setAlignmentX(Component.CENTER_ALIGNMENT);
//		check.setAlignmentX(Component.CENTER_ALIGNMENT);
//		frame.add(panel);
//		frame.setLocationRelativeTo(null);
//		frame.setTitle("INT LIST");
//		
//		plsInt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
//		plsInt.setSize(200, 200);
//		plsInt.add(inting);
//		inting.add(feed);
//		inting.add(closeInt);
//		plsInt.setLocationRelativeTo(null);
//		feed.setFont(new Font(feed.getFont().getName(), Font.BOLD, 100));
//		
//		button.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				try {
//					lh.appendToEnd(textField.getText());
//					textField.setText(null);
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//		check.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				if(lh.check(checkF.getText())){
//					plsInt.setVisible(true);
//				}
//				checkF.setText(null);
//			}
//		});
//		closeInt.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				plsInt.dispose();
//			}
//			
//		});
	}
	
	
	
	
}



