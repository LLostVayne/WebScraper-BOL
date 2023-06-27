import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JList;

public class View {

	public void showProducts(ArrayList<String> products) {
		
		JFrame productsFrame = new JFrame("Simple GUI Webscraper for bol.com");
		JList list = new JList(products.toArray());
		productsFrame.add(list);
		
		productsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		productsFrame.setSize(800,800);
		productsFrame.setLocationRelativeTo(null);
		productsFrame.setVisible(true);
		
	}

}
