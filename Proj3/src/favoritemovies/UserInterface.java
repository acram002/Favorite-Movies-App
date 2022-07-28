package favoritemovies;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UserInterface implements ActionListener{

	
	JFrame frame = new JFrame();
	JButton bloop = new JButton("Text");
	
	UserInterface(){
		
		frame.setTitle("Favorite Movies");
		frame.setSize(400, 400);
		
		bloop.setBounds(540,40,120,30);
		bloop.setFocusable(false);
		bloop.addActionListener(this);
		
		frame.setLayout(null);
		frame.add(bloop);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000, 600));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == bloop) {
			//Do stuff
		}
	}
	
}
