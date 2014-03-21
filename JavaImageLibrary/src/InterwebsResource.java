import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;


public class InterwebsResource {
	private BufferedImage image = null;
	private static IResourceManager resourceManager = new ResourceManager();
	
	private InterwebsResource(BufferedImage image) {
		this.image = image;
	}
	
	public static InterwebsResource get(String dest) throws IOException {
		BufferedImage image = null;
		image = resourceManager.load(dest);
		if (image == null)
			throw new IOException("Image could not be downloaded!");
		return new InterwebsResource(image);
	}
	
	public Image toImage() {
		byte[] pixels = ((DataBufferByte) this.image.getRaster().getDataBuffer()).getData();
		Mat m = new Mat();
		m.put(0, 0, pixels);
		return Image.fromMat(m);
	}
	
	protected static void setManager(IResourceManager manager) {
		resourceManager = manager;
	}
}
