package edu.cmu.cs214.hw9.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FacelookInitGUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacelookInitGUI frame = new FacelookInitGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FacelookInitGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.getContentPane().add(new LoginPanel(this));
	}
	/*
	 * Use this method to swap between panels! Example in LoginPanel.java
	 */
	public void replace(JPanel j){
		this.getContentPane().removeAll();
		this.getContentPane().add(j);
		validate();
	}
}
