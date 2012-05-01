package edu.cmu.cs214.hw9.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class RegisterPanel extends JPanel {
	private FacelookInitGUI container;
	/**
	 * Create the panel.
	 */
	public RegisterPanel(FacelookInitGUI j) {
		super();
		container = j;
		this.setBackground(Color.decode("#3b5998"));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new MigLayout("", "[grow]", "[][][][][][][][]"));
		
		JLabel lblFacelook = new JLabel("Facelook");
		lblFacelook.setForeground(Color.WHITE);
		lblFacelook.setFont(new Font("Lucida Fax", Font.BOLD, 36));
		this.add(lblFacelook, "cell 0 0");
		
		final JTextField txtUsername = new JTextField();
		txtUsername.setText("Name");
		txtUsername.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		txtUsername.setBackground(Color.decode("#3b5998"));
		txtUsername.setForeground(Color.WHITE);
		this.add(txtUsername, "cell 0 2,growx");
		txtUsername.setColumns(10);
		txtUsername.addFocusListener(new FocusListener() {

	        public void focusGained(FocusEvent e) {
	            if (txtUsername.getText().equals("Name")) {
	            	txtUsername.setText("");
	            }
	        }

	        public void focusLost(FocusEvent e) {
	            if ("".equalsIgnoreCase(txtUsername.getText().trim())) {
	            	txtUsername.setText("Name");
	            }
	        }});
		
		final JTextField txtEmail = new JTextField();
		txtEmail.setText("Email Address");
		txtEmail.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		txtEmail.setBackground(Color.decode("#3b5998"));
		txtEmail.setForeground(Color.WHITE);
		this.add(txtEmail, "cell 0 3,growx");
		txtEmail.setColumns(10);
		txtEmail.addFocusListener(new FocusListener() {

	        public void focusGained(FocusEvent e) {
	            if (txtEmail.getText().equals("Email Address")) {
	            	txtEmail.setText("");
	            }
	        }

	        public void focusLost(FocusEvent e) {
	            if ("".equalsIgnoreCase(txtEmail.getText().trim())) {
	            	txtEmail.setText("Email Address");
	            }
	        }});
		
		final JPasswordField txtPass1 = new JPasswordField("Enter Password");
		txtPass1.setEchoChar((char)0);
		txtPass1.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		txtPass1.setBackground(Color.decode("#3b5998"));
		txtPass1.setForeground(Color.WHITE);
		this.add(txtPass1, "cell 0 4,growx");
		txtPass1.setColumns(10);
		txtPass1.addFocusListener(new FocusListener() {

	        public void focusGained(FocusEvent e) {
	            txtPass1.setEchoChar('*');
	            if (txtPass1.getText().equals("Enter Password")) {
	            	txtPass1.setText("");
	            }
	        }

	        public void focusLost(FocusEvent e) {
	            if ("".equalsIgnoreCase(txtPass1.getText().trim())) {
	            	txtPass1.setEchoChar((char)0);
	            	txtPass1.setText("Enter Password");
	            }
	        }});
		
		final JPasswordField txtPass2 = new JPasswordField("Re-enter Password");
		txtPass2.setEchoChar((char)0);
		txtPass2.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		txtPass2.setBackground(Color.decode("#3b5998"));
		txtPass2.setForeground(Color.WHITE);
		this.add(txtPass2, "cell 0 5,growx");
		txtPass2.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		add(btnRegister, "cell 0 6");
		
		
		//==============================================//
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
                Comms.getInstance().register(txtUsername.getText(), txtEmail.getText(), txtPass1.getText());
                new FacelookAppGUI(txtUsername.getText());
			} });
		//==============================================//
		
		
		JButton btnBackToLogin = new JButton("Back to Login");
		add(btnBackToLogin, "cell 0 7");
		//Sends user back to login
		btnBackToLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				container.replace(new LoginPanel(container));
			} });
		txtPass2.addFocusListener(new FocusListener() {

	        public void focusGained(FocusEvent e) {
	            txtPass2.setEchoChar('*');
	            if (txtPass2.getText().equals("Re-enter Password")) {
	            	txtPass2.setText("");
	            }
	        }

	        public void focusLost(FocusEvent e) {
	            if ("".equalsIgnoreCase(txtPass2.getText().trim())) {
	            	txtPass2.setEchoChar((char)0);
	            	txtPass2.setText("Re-enter Password");
	            }
	        }});
	}

}
