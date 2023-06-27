import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;  

public class SearchForm {
	
	public void makeInputGUI() {
		JFrame inputFrame = new JFrame("Simple GUI Webscraper for bol.com");
		JLabel label = new JLabel("Enter product");
		JTextField text = new JTextField(10);
		JButton button = new JButton("Search");
		Font font = new Font(Font.DIALOG, Font.PLAIN,25);

		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputFrame.setSize(600,100);
		inputFrame.setLocationRelativeTo(null);
		inputFrame.setLayout(new FlowLayout());

		label.setFont(font);
		text.setFont(font);
		button.setFont(font);

		inputFrame.add(label);
		inputFrame.add(text);
		inputFrame.add(button);

		inputFrame.setVisible(true);

		button.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (!text.getText().replaceAll("\\s+","").equals("")) {
					new Controller(text.getText());
					inputFrame.dispose();
				}
			}  
		}); 
	}
	
}
