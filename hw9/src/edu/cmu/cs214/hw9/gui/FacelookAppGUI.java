package edu.cmu.cs214.hw9.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FacelookAppGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FacelookAppGUI(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 540);
		this.getContentPane().add(new NewsFeedPanel(username, this));
		setVisible(true);
	}
	
	/*
	 * Use this method to swap between panels!
	 */
	public void replace(JPanel j){
		this.getContentPane().removeAll();
		this.getContentPane().add(j);
		validate();
	}

}
