package org.jarzarr.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jarzarr.ui.pages.CreatePage;
import org.jarzarr.ui.pages.HomePage;
import org.jarzarr.ui.pages.SummaryPage;
import org.jarzarr.ui.pages.ViewPage;

public class Display implements Runnable {
	
	public static final String DISPLAY_NAME = "Budgeter";
	public static final Dimension DISPLAY_SIZE = new Dimension(1000, 700);
	public static final Color DISPLAY_COLOR = new Color(50, 50, 50);
	
	private CardLayout layout;
	private final int layoutGap = 20;
	
	private static JPanel contentPanel;

	@Override
	public void run() {
		JFrame frame = new JFrame(DISPLAY_NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(DISPLAY_SIZE);
		frame.setLocationRelativeTo(null);
		contentPanel = (JPanel) frame.getContentPane();
		contentPanel.setBackground(DISPLAY_COLOR);
		addComponents();
		frame.setVisible(true);
	}
	
	private void addComponents() {
		layout = new CardLayout(layoutGap, layoutGap);
		contentPanel.setLayout(layout);
		
		contentPanel.add(new HomePage(), HomePage.NAME);
		contentPanel.add(new CreatePage(), CreatePage.NAME);
		contentPanel.add(new ViewPage(), ViewPage.NAME);
		contentPanel.add(new SummaryPage(), SummaryPage.NAME);
	}
	
	public static void showPage(String pageName) {
		((CardLayout) contentPanel.getLayout()).show(contentPanel, pageName);
	}

}
