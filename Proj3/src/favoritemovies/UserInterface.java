package favoritemovies;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class UserInterface implements ActionListener{

	JFrame frame = new JFrame();
	JButton addButt = new JButton("Add");
	JButton removeButt = new JButton("Remove");
	JButton loadButt = new JButton("Load");
	JButton saveButt = new JButton("Save");
	
	JTextField input = new JTextField(50);
	
	UserInterface(){
		
		frame.setTitle("Favorite Movies");
		frame.setSize(400, 400);
		
		input.setBounds(220,260,180,30);
		
		addButt.setBounds(130,50,150,80);
		addButt.setFocusable(false);
		addButt.addActionListener(this);
		
		removeButt.setBounds(330,50,150,80);
		removeButt.setFocusable(false);
		removeButt.addActionListener(this);
		
		loadButt.setBounds(130,150,150,80);
		loadButt.setFocusable(false);
		loadButt.addActionListener(this);
		
		saveButt.setBounds(330,150,150,80);
		saveButt.setFocusable(false);
		saveButt.addActionListener(this);
		
		frame.setLayout(null);
		frame.add(addButt);
		frame.add(removeButt);
		frame.add(loadButt);
		frame.add(saveButt);
		frame.add(input);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 600));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addButt) {
			//Do stuff
		
		}
		else if(e.getSource() == removeButt) {
			
		}
		else if(e.getSource() == loadButt) {
			
		}
		else if(e.getSource() == saveButt) {
	
		}
}
}
