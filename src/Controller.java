public class Controller {
	
	WebScraper scraper = new WebScraper();
	View view = new View();
	Model model = new Model();
	
	
	public Controller(String productName) {
		this.scrape(productName);
		this.viewProducts();
	}
	
	private void scrape(String productName) {
		model.setProducts(scraper.scrapeProduct(productName));
	}
	
	private void viewProducts() {
		view.showProducts(model.getProducts());
	}

}
