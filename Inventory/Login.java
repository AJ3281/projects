import java.awt.EventQueue;


import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textField;
	private JButton btnNewButton;
	private JPasswordField passwordField;
	private JLabel lblBD;

	/**
	 **************************************************************************************************************
	 * Constructor
	 **************************************************************************************************************
	 */	
	public Login() {
		
		initialize();
		connection = DBHandler.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 739, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(234, 260, 107, 50);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(234, 313, 100, 50);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(362, 275, 107, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 **************************************************************************************************************
		 * Login Button
		 **************************************************************************************************************
		 */	
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				
				try {
					String query = "select * from Signin where username = ? and password = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						
						
						count = count +1;
						
					}
					
					if (count == 1) {
						
						//JOptionPane.showMessageDialog(null, "Username and password is correct");
						frame.dispose();
						EmployeeInfo ei = new EmployeeInfo();
						ei.setVisible(true);
					}
					
					
					else {
						
						JOptionPane.showMessageDialog(null, "Username and password is not correct");
						
					}
					
				rs.close();
				pst.close();
					
				} catch(Exception d) {
					
					JOptionPane.showMessageDialog(null, d);
					
					
				}
				
				finally{
					
					try {
						
					} catch (Exception d){
						
						JOptionPane.showMessageDialog(null, d);
					}
				}
				
			}
		});
		btnNewButton.setBounds(257, 386, 200, 50);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(362, 328, 105, 20);
		frame.getContentPane().add(passwordField);
		
		lblBD = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/BD.png")).getImage();
		lblBD.setIcon(new ImageIcon(img));
		lblBD.setBounds(227, 107, 268, 88);
		frame.getContentPane().add(lblBD);
	}
}
