package eu.interedition.fragmentContext.ws;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class InfoProvider extends ServerResource {

	@Get
	public StringRepresentation getOacConstraintInfo() {

		InputStream is = 
				Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
		String info = "";
		try {
			info = IOUtils.toString(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StringRepresentation sr = new StringRepresentation(info, MediaType.TEXT_HTML);
		
		return sr;
		
	}
	
}
