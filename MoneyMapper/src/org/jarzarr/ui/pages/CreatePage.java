package org.jarzarr.ui.pages;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreatePage extends Page {
	
	public static final String NAME = "CreatePage";

	public CreatePage() {
		super("Create Ticket");
	}

	@Override
	protected JPanel layoutComponents() {
		JPanel container = new JPanel();
		container.setBackground(SECONDARY_COLOR);
		container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JPanel topContainer = new JPanel();
		JPanel bottomContainer = new JPanel();
		
		topContainer.setLayout(new BoxLayout(topContainer, BoxLayout.X_AXIS));
		topContainer.setBorder(BorderFactory.createRaisedBevelBorder());
		
		layoutTopContainer(topContainer);
		layoutBottomContainer(bottomContainer);
		
		
		container.add(topContainer);
		container.add(bottomContainer);
		
		
		return container;
	}
	
	private void layoutTopContainer(JPanel container) {
		JPanel descPanel = new JPanel();
		JPanel typePanel = new JPanel();
		
		descPanel.setLayout(new BoxLayout(descPanel, BoxLayout.Y_AXIS));
		
	}

	private void layoutBottomContainer(JPanel container) {
		
	}
}
