package favoritemovies;

import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.List;

import javax.swing.JOptionPane;

public class ErrorMessage {

	public void errorMessage(String message, String titleBar) {
		// displays error message in window if no item selected and
		// remove button pressed
		Component nul = null;
		JOptionPane.showMessageDialog(nul, message, titleBar, JOptionPane.INFORMATION_MESSAGE);

	}

}
