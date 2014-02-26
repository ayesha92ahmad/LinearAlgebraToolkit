package viewController;

import javax.swing.*; 
import java.awt.*;

public class MainPanel extends JPanel {
	JLabel l1= new JLabel("Welcome");
	
	MainPanel(){
		this.add(l1);
	}
	MainPanel(JLabel l){
		this.add(l1);
	}
	MainPanel(JPanel p){
		this.add(p);
	}	
	

}
