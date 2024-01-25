package org.jarzarr;

import javax.swing.SwingUtilities;

import org.jarzarr.ui.Display;

public class Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Display());
	}
}
