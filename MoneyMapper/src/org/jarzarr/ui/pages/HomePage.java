package org.jarzarr.ui.pages;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.jarzarr.ui.Display;

public class HomePage extends Page {
	
	public static final String NAME = "HomePage";
	
	public HomePage() {
		super("Budgeter");
	}

	@Override
	protected JPanel layoutComponents() {
		JPanel container = new JPanel(new BorderLayout(10, 0));
		JPanel btnContainer = new JPanel();
		JPanel infoContainer = new JPanel();
		
		// Config main container
		container.setBackground(PRIMARY_COLOR);
		
		// Add secondary containers
		container.add(btnContainer, BorderLayout.WEST);
		container.add(infoContainer, BorderLayout.CENTER);
		
		// Config secondary layouts
			btnContainer.setLayout(new GridBagLayout());
			btnContainer.setBackground(SECONDARY_COLOR);
			// TODO set infoContainer layout
		
		// layout components for secondary containers
		layoutButtonContainer(btnContainer);
		layoutInfoContainer(infoContainer);
		
		return container;
	}
	
	private void layoutButtonContainer(JPanel container) {
		container.setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.CENTER;
		
		JPanel innerContainer = new JPanel();
		
		// Config inner container
		innerContainer.setLayout(new BoxLayout(innerContainer, BoxLayout.Y_AXIS));
		innerContainer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		innerContainer.setBackground(SECONDARY_COLOR);
		
		// Configure Buttons
		JButton createTicketBtn = createButton("Create Ticket", e -> {
			Display.showPage(CreatePage.NAME);
		});
		
		JButton viewTicketsBtn = createButton("View Tickets", e -> {
			Display.showPage(ViewPage.NAME);
		});
		
		JButton viewSummaryBtn = createButton("View Summary", e -> {
			Display.showPage(SummaryPage.NAME);
		});
		
		JButton exitBtn = createButton("Exit", e -> {
			System.exit(0);
		});
		
		JButton[] btns = {createTicketBtn, viewTicketsBtn, viewSummaryBtn, exitBtn};
		for (JButton btn: btns) {
			innerContainer.add(btn);
			innerContainer.add(Box.createVerticalStrut(40));
		}
		
		// Add components
		container.add(innerContainer, gbc);
	}
	
	private void layoutInfoContainer(JPanel container) {
		container.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
}
