package favoritemovies;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class UserInterface implements ActionListener{

	JFrame frame = new JFrame();
	JButton addButt = new JButton("Add");
	JButton removeButt = new JButton("Remove");
	JButton loadButt = new JButton("Load");
	JButton saveButt = new JButton("Save");
	
	private Add add = new Add();
	private Load load = new Load();
	private ErrorMessage error = new ErrorMessage();
	private Save save = new Save();
	private MovieList list = new MovieList();
	
	private DefaultListModel model = new DefaultListModel();//!!!!
	
	private String[] boop = new String[] {"hello"};
	
	JTextField input = new JTextField(50);
	
	JPanel panel = new JPanel();
	
	JList movieList = new JList( model );
	
	JTextArea instruct = new JTextArea();
	
	UserInterface(){
		
		//model.addElement( "bloop" );
		
		frame.setTitle("Favorite Movies");
			
		input.setBounds(200,250,180,30);
		
		addButt.setBounds(125,325,150,80);
		addButt.setFocusable(false);
		addButt.addActionListener(this);
		
		removeButt.setBounds(325,325,150,80);
		removeButt.setFocusable(false);
		removeButt.addActionListener(this);
		
		loadButt.setBounds(125,425,150,80);
		loadButt.setFocusable(false);
		loadButt.addActionListener(this);
		
		saveButt.setBounds(325,425,150,80);
		saveButt.setFocusable(false);
		saveButt.addActionListener(this);
		
		frame.setLayout(null);
		frame.add(addButt);
		frame.add(removeButt);
		frame.add(loadButt);
		frame.add(saveButt);
		frame.add(input);
		
		movieList.setLayoutOrientation(JList.VERTICAL);
		movieList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		panel.setBounds(175,25,250,200);
		panel.add(new JScrollPane(movieList));
		
		instruct.setBounds(150, 175, 300, 50);
		instruct.setText("Enter movie into text box and press Add to add to list\nSelect item and hold shift to multi-select items\nPress Remove to remove items from list\nMORE INSTRUCTIONS");
		instruct.setLineWrap(true);
		
		frame.add(instruct);
		frame.add(panel);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 600));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addButt) {
			String newFav = input.getText();
			add.AddMovie((newFav.trim()).toLowerCase());
			model.addElement( (newFav.trim()).toLowerCase());
			System.out.println(list.getList());
		
		}
		else if(e.getSource() == removeButt) {
			List selected = movieList.getSelectedValuesList();
			if (movieList.isSelectionEmpty()) {
				System.out.println("Please select an item to delete!");
				//JLabel error = new JLabel("Please select an item to delete!");
				//error.setBounds(175,190,200,100);
				//frame.add(error);
				
				error.errorMessage("Please select an item to delete!", "ERROR");
				
			}
			else {
			for (int i = 0; i< selected.size(); i++) {
			model.removeElement(selected.get(i));
			}
			}
		}
		else if(e.getSource() == loadButt) {
			
		}
		else if(e.getSource() == saveButt) {
	
		}
}
}

//reference https://www.geeksforgeeks.org/java-swing-jlist-with-examples/
