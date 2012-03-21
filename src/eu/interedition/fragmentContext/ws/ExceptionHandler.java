package eu.interedition.fragmentContext.ws;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

import org.restlet.Response;
import org.restlet.data.Status;

public class ExceptionHandler {

	public static String handle(Throwable t) {
		t.printStackTrace();
		try {
			throw t;
		}
		catch(FileNotFoundException fe) {
			Response.getCurrent().setStatus(Status.CLIENT_ERROR_NOT_FOUND, fe);
		}
		catch(UnknownHostException uhe) {
			Response.getCurrent().setStatus(Status.CLIENT_ERROR_NOT_FOUND, uhe);
		}
		catch(Throwable t2) {
			Response.getCurrent().setStatus(Status.SERVER_ERROR_INTERNAL, t2, "Sorry for that!");
		}
		return t.getClass().getName() + ": " + t.getMessage();
	}
}
