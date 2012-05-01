package edu.cmu.cs214.hw9.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FriendListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private FacelookAppGUI container;
	public FriendListPanel(final String name, FacelookAppGUI a) {
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
		
		JLabel lblPendingRequests = new JLabel("Pending Requests");
		lblPendingRequests.setForeground(Color.WHITE);
		lblPendingRequests.setFont(new Font("Lucida Fax", Font.PLAIN, 18));
		lblPendingRequests.setBounds(12, 58, 199, 32);
		add(lblPendingRequests);
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(22, 103, 380, 91);
		add(scrollPane1);
		JPanel panel = new JPanel();
		scrollPane1.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 5));
		
		
		/*
		 * Fill this grid with buttons that link to profile pages of people who requested you as a friend i.e.
		 * JButton link = new JButton("Patrick Woody");
		 * link.addActionListener(new ActionListener(){ ... });
		 * panel.add(link);
		 */
		
		
		
		JLabel lblFriends = new JLabel("Friends");
		lblFriends.setForeground(Color.WHITE);
		lblFriends.setFont(new Font("Lucida Fax", Font.PLAIN, 18));
		lblFriends.setBounds(12, 209, 199, 32);
		add(lblFriends);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 242, 380, 284);
		add(scrollPane);
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 5));
		
		
		/*
		 * Fill this grid with buttons that link to profile pages i.e.
		 * JButton link = new JButton("Patrick Woody");
		 * link.addActionListener(new ActionListener(){ ... });
		 * panel_1.add(link);
		 */
		
		
		
		JButton btnNewsFeed = new JButton("News Feed");
		btnNewsFeed.setBounds(661, 49, 97, 25);
		add(btnNewsFeed);
		btnNewsFeed.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				container.replace(new NewsFeedPanel(name, container));
			}
			
		});
	}
}
