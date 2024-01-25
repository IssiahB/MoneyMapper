package org.jarzarr.ui.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jarzarr.ui.Display;

public abstract class Page extends JPanel {
	
	protected Font customFont;
	protected final Color PRIMARY_COLOR = Display.DISPLAY_COLOR;
	protected final Color SECONDARY_COLOR = new Color(203, 209, 208);
	protected final Color HIGHLIGHT_COLOR = new Color(105, 9, 9);
	
	public Page(String title) {
		setLayout(new BorderLayout());
		JPanel titleContainer = layoutTitle(title);
		JPanel componentContainer = layoutComponents();
		
		add(titleContainer, BorderLayout.NORTH);
		add(componentContainer, BorderLayout.CENTER);
	}
	
	private JPanel layoutTitle(String title) {
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel titleLabel = new JLabel(title);
		
		// Layout
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.CENTER;
		
		// Label config
		customFont = loadCustomFont();
		titleLabel.setFont(customFont.deriveFont(Font.BOLD, 70));
		titleLabel.setForeground(SECONDARY_COLOR);
		
		// Panel config
		panel.add(titleLabel, gbc);
		panel.setBackground(PRIMARY_COLOR);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		return panel;
	}
	
	private Font loadCustomFont() {
		try {
			File fontFile = new File("res/Signika.ttf");
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			return customFont;
		} catch (IOException | FontFormatException e) {
			System.err.println("Could Not Load Fonts");
			e.printStackTrace();
		}
		
		return null;
	}
	
	protected JButton createButton(String text, ActionListener action) {
		Dimension size = new Dimension(180, 50);
		JButton btn = new JButton(text);
		
		// Configure Button
		btn.addActionListener(action);
		btn.setSize(size);
		btn.setPreferredSize(size);
		btn.setMaximumSize(size);
		btn.setMinimumSize(size);
		btn.setFont(customFont.deriveFont(Font.BOLD, 20));
		btn.setBackground(HIGHLIGHT_COLOR);
		btn.setForeground(Color.white);
		btn.setFocusPainted(false);
		
		UIManager.put("Button.select", HIGHLIGHT_COLOR.brighter());
		
		return btn;
	}
	
	protected abstract JPanel layoutComponents();
}
