import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;


public interface IResourceManager {
	BufferedImage load(String dest) throws MalformedURLException, IOException; 
}
