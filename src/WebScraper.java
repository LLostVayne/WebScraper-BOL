import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
	
	final private String CURRENCY_SYMBOL = "\u20AC";
	final private String SEARCH_URL_TEMPLATE = "https://www.bol.com/nl/nl/s/?searchtext=";
	final private Driver driver = new Driver();
	final private FirefoxOptions options = new FirefoxOptions();
	final private FirefoxDriver webdriver;
	private ArrayList<String> products = new ArrayList<String>();

	public WebScraper() {
		options.addArguments("--headless");
		System.setProperty("webdriver.firefox.driver", driver.GetDriver().toString());
		webdriver = new FirefoxDriver(options);
	}

	public ArrayList<String> scrapeProduct(String productName) {
		
		webdriver.get(SEARCH_URL_TEMPLATE + productName);

		WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(10));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("js-first-screen-accept-all-button")));
        acceptButton.click();
        

		List<WebElement> productItems = webdriver.findElements(By.className("product-item__content"));

		String price; 
		for (WebElement item : productItems) {
			String creator = item.findElement(By.className("product-creator")).getText();
			String title = item.findElement(By.className("product-title--inline")).getText();

			try {
				price = item.findElement(By.className("promo-price")).getText().replace("\n", ",").replace("-", "") + CURRENCY_SYMBOL;
			} catch (Exception e) {
				price = "Niet leeverbaar";
			}

			products.add(creator + " | " + title + " | " + price);
		}

		webdriver.quit();
		return products;
	}
}
