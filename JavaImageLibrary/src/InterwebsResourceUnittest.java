import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class InterwebsResourceUnittest {

	@Test(expected=IOException.class)
	public void testStaticGet__BadURL__ThrowIOException() throws IOException {
		String junkUrl = "http://i.imgur.com/NicllDXz.jpg";
		InterwebsResource resource = InterwebsResource.get(junkUrl);
	}
	
	@Test
	public void testStaticGet__localStubURL__returnsInterwebsImage() throws IOException {
		InterwebsResource.setManager(new ResourceManagerStub());
		String localFile = "images\\bioshock.jpg";
		InterwebsResource resource = InterwebsResource.get(localFile);
		assertEquals(resource.getClass(), InterwebsResource.class);
	}
	
	

}
