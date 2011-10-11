package eu.interedition.fragmentContext.ws;

import java.net.URI;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import eu.interedition.fragmentContext.text.TextConstraint;
import eu.interedition.fragmentContext.text.TextContext;
import eu.interedition.fragmentContext.text.TextContext.HashType;
import eu.interedition.fragmentContext.text.TextPrimary;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifier;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifierFactory;


public class ConstraintFactory extends ServerResource{
	
	@Post
	public String createConstraint(String args) {
		try {
			JSONObject jsonArgs = new JSONObject(args);
			ArgumentsParser argsParser = new ArgumentsParser(jsonArgs);
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
			JSONObject jsonResult = resultFactory.createResult(
					jsonArgs, context, textFragmentIdentifier);
			
			Logger.getLogger(this.getClass().getName()).info(jsonResult.toString());

			return jsonResult.toString();
		}
		catch(Throwable t) {
			return ExceptionHandler.handle(t);
		}
	}
}
