import java.io.File;

public class Driver {
	File driver = new File(System.getProperty("user.dir")+"/Driver").listFiles()[0];

	public File GetDriver() {
		return driver;
	}
	
}
