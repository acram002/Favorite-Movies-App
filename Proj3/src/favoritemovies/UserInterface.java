package favoritemovies;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import javax.swing.*;

public class UserInterface implements ActionListener {

	// GUI components
	JFrame frame = new JFrame();
	JButton addButt = new JButton("Add");
	JButton removeButt = new JButton("Remove");
	JButton loadButt = new JButton("Load");
	JButton saveButt = new JButton("Save");

	private Add add = new Add();
	private ErrorMessage error = new ErrorMessage();
	private MovieList list = new MovieList();
	private DefaultListModel model = new DefaultListModel();// !!!!

	JTextField input = new JTextField(50);
	JPanel panel = new JPanel();
	JList movieList = new JList(model);
	JTextArea instruct = new JTextArea();

	UserInterface() {

		// setting up GUI components
		input.setBounds(200, 275, 180, 30);

		addButt.setBounds(125, 325, 150, 80);
		addButt.setFocusable(false);
		addButt.addActionListener(this);

		removeButt.setBounds(325, 325, 150, 80);
		removeButt.setFocusable(false);
		removeButt.addActionListener(this);

		loadButt.setBounds(125, 425, 150, 80);
		loadButt.setFocusable(false);
		loadButt.addActionListener(this);

		saveButt.setBounds(325, 425, 150, 80);
		saveButt.setFocusable(false);
		saveButt.addActionListener(this);

		frame.setTitle("Favorite Movies");
		frame.setLayout(null);
		frame.add(addButt);
		frame.add(removeButt);
		frame.add(loadButt);
		frame.add(saveButt);
		frame.add(input);

		movieList.setLayoutOrientation(JList.VERTICAL);
		movieList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);// allows for item selection in list

		panel.setBounds(150, 25, 275, 200);
		panel.add(new JScrollPane(movieList));

		instruct.setBounds(100, 175, 400, 85);
		instruct.setText(
				"Enter movie into text box and press Add to add to list\nSelect item and hold shift to multi-select items\nPress Remove to remove selected items from list\nSave will save list of movies to movies.txt\nLoad will load previously saved list");
		instruct.setEditable(false);

		frame.add(instruct);// adds instruction text box
		frame.add(panel);// adds panel with movie list

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 600));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		// operations for when each button is pressed
		if (e.getSource() == addButt) {
			// adds the item from the text field to the list
			String newFav = input.getText();
			add.AddMovie((newFav.trim()).toLowerCase());
			model.addElement((newFav.trim()).toLowerCase());

		} else if (e.getSource() == removeButt) {
			// removes the selected items from the list
			// pops up error window if no item selected
			List selected = movieList.getSelectedValuesList();
			if (movieList.isSelectionEmpty()) {
				error.errorMessage("Please select an item to delete!", "ERROR");

			} else {
				for (int i = 0; i < selected.size(); i++) {
					model.removeElement(selected.get(i));
				}
			}
		} else if (e.getSource() == loadButt) {
			// reads from movies.txt file to load last saved list of movies
			// changes current list to last saved list
			model.removeAllElements();
			try (BufferedReader read = new BufferedReader(new FileReader("movies.txt"))) {
				String line = read.readLine();
				while (line != null) {
					model.addElement(line);
					line = read.readLine();
				}
			} catch (FileNotFoundException exce) {

			} catch (IOException excep) {

			}
		} else if (e.getSource() == saveButt) {
			// saves current list of items to movies.txt by writing to file
			// will create file if no movies.txt file, otherwise will overwrite current file
			try (BufferedWriter write = new BufferedWriter(new FileWriter(new File("movies.txt")))) {

				for (int i = 0; i < movieList.getModel().getSize(); i++) {

					String movie = movieList.getModel().getElementAt(i).toString();
					write.write(movie + "\n");

				}
			} catch (IOException exc) {

			}

		}
	}
}
