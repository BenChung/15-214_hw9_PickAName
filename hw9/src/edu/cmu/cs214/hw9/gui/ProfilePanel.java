package edu.cmu.cs214.hw9.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ProfilePanel extends JPanel {

	private FacelookAppGUI container;
	private JTextField textField;
	//Name is the name of the profile you are viewing, username is the user accessing it
	public ProfilePanel(final String name, final String username, FacelookAppGUI a) {
		super();
		container = a;
		this.setBackground(Color.decode("#3b5998"));
		this.setPreferredSize(new Dimension(770,539));
		setLayout(null);
		
		JLabel lblFacelook = new JLabel("Facelook");
		lblFacelook.setFont(new Font("Lucida Fax", Font.PLAIN, 32));
		lblFacelook.setForeground(Color.WHITE);
		lblFacelook.setBounds(12, 13, 199, 32);
		add(lblFacelook);
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(173, 17, 199, 32);
		nameLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 21));
		add(nameLabel);
		
		
		JLabel lblLatest = new JLabel("Latest Post");
		lblLatest.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblLatest.setForeground(Color.WHITE);
		lblLatest.setBounds(12, 87, 166, 40);
		add(lblLatest);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 147, 719, 379);
		add(panel);
		panel.setLayout(new GridLayout(5, 2, 5, 5));
		
		/*
		 * Fill this GridLayout with StatusPost buttons for the status/notifications
		 * It is ok to generate this at the beginning and only refresh when coming back to this page. 
		 * If there are less than 10 then leave the remainder of the grid blank. These don't need to link back to same page.
		 */
		
		
		if(!username.equals(name)){//Only show these when it is not your own profile
		JButton btnAddFriend = new JButton("Add/Remove Friend");
		btnAddFriend.setBounds(12, 49, 155, 25);
		add(btnAddFriend);
		
		
		//=====================================//
		btnAddFriend.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO FILL IN CODE TO ADD/REMOVE FRIEND
				
			}
			
		});
		//=====================================//

		
		
		JButton btnAddSubscription = new JButton("Add/Remove Subscription");
		btnAddSubscription.setBounds(183, 49, 199, 25);
		add(btnAddSubscription);
		
		
		//=====================================//
		btnAddSubscription.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO FILL IN CODE TO SUBSCRIBE TO USER
				
			}
			
		});
		}
		//=====================================//

		
		JButton btnNewsFeed = new JButton("News Feed");
		btnNewsFeed.setBounds(661, 49, 97, 25);
		add(btnNewsFeed);
		btnNewsFeed.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				container.replace(new NewsFeedPanel(username, container));
			}
			
		});
		
		
		if(username.equals(name)){
		textField = new JTextField("What's on your mind?");
		textField.setBounds(12, 60, 300, 32);
		add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener() {

	        public void focusGained(FocusEvent e) {
	            if (textField.getText().equals("What's on your mind?")) {
	            	textField.setText("");
	            }
	        }

	        public void focusLost(FocusEvent e) {
	            if ("".equalsIgnoreCase(textField.getText().trim())) {
	            	textField.setText("What's on your mind?");
	            }
	        }});
		
		JButton btnNewButton = new JButton("Post Status");
		btnNewButton.setBounds(312, 60, 97, 32);
		add(btnNewButton);
		
		
		//=====================================//
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO HANDLE POSTING OF STATUS
			}
			
		});
		//=====================================//

		
		
		JButton btnNewButton1 = new JButton("Post Notification");
		btnNewButton1.setBounds(409, 60, 140, 32);
		add(btnNewButton1);
		
		
		//=====================================//
		btnNewButton1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO HANDLE POSTING OF NOTIFICATION
			}
			
		});
		//=====================================//

		
		}
	}
}
