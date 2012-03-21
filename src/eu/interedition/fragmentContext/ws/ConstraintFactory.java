package eu.interedition.fragmentContext.ws;

import java.net.URI;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import eu.interedition.fragmentContext.text.TextConstraint;
import eu.interedition.fragmentContext.text.TextContext;
import eu.interedition.fragmentContext.text.TextContext.HashType;
import eu.interedition.fragmentContext.text.TextPrimary;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifier;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifierFactory;
import eu.interedition.fragmentContext.ws.ArgumentsParser.State;


public class ConstraintFactory extends ServerResource{
	
	@Post
	public String createConstraint(String args) {
		StringBuilder jsonResult = new StringBuilder("[");
		String conc = "";
		try {
			JSONArray jsonArgs = new JSONArray(args);
			for (int i=0; i<jsonArgs.length(); i++) {
				JSONObject jsonArg = jsonArgs.getJSONObject(i);
				
				ArgumentsParser argsParser = new ArgumentsParser(jsonArg);
				URI targetURI = argsParser.getTargetURI();
				TextPrimary primary = argsParser.getPrimary();
				
				TextFragmentIdentifierFactory factory = new TextFragmentIdentifierFactory();
				TextFragmentIdentifier textFragmentIdentifier = 
						factory.createTextFragmentIdentifier(targetURI.getFragment());
				
				TextConstraint constraint = 
						new TextConstraint(
							textFragmentIdentifier.getCharacterStartPos(primary.getContent()),
							textFragmentIdentifier.getCharacterEndPos(primary.getContent()));
		
				TextContext context = 
						new TextContext(
								primary, constraint, HashType.MD5, 
								TextContext.DEFAULT_CONTEXTLENGTH);
						
				JSONResultFactory resultFactory = new JSONResultFactory();
				JSONObject curJsonResult = resultFactory.createResult(
						jsonArg, context, textFragmentIdentifier, State.success);
				
				Logger.getLogger(this.getClass().getName()).info(curJsonResult.toString());
				jsonResult.append(conc);
				jsonResult.append(curJsonResult);
				conc = ",";
			}
			jsonResult.append("]");
			return jsonResult.toString();
		}
		catch(Throwable t) {
			return ExceptionHandler.handle(t);
		}
	}
}
