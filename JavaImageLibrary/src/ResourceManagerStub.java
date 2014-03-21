import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;


public class ResourceManagerStub implements IResourceManager {

	@Override
	public BufferedImage load(String dest) throws MalformedURLException, IOException {
		return ImageIO.read(new File(dest));
	}
	
}
