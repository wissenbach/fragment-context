package eu.interedition.fragmentContext.ws;

import java.net.URI;

import org.json.JSONObject;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import eu.interedition.fragmentContext.Context.NoMatchFoundException;
import eu.interedition.fragmentContext.text.TextConstraint;
import eu.interedition.fragmentContext.text.TextContext;
import eu.interedition.fragmentContext.text.TextContext.HashType;
import eu.interedition.fragmentContext.text.TextPrimary;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifier;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifierFactory;

public class ConstraintMatcher extends ServerResource {

	@Post
	public String machtConstraint(String args) throws Exception {

		JSONObject jsonArgs = new JSONObject(args);
		ArgumentsParser argsParser = new ArgumentsParser(jsonArgs);
		URI targetURI = argsParser.getTargetURI();

		TextFragmentIdentifierFactory factory = new TextFragmentIdentifierFactory();
		
		TextFragmentIdentifier textFragmentIdentifier = 
				factory.createTextFragmentIdentifier(targetURI.getFragment());
		
		if (textFragmentIdentifier.getMd5HexValue() == null) {
			textFragmentIdentifier.setMd5HexValue(argsParser.getMd5HexValue());
		}
		
		TextPrimary primary = argsParser.getPrimary();
		
		TextConstraint constraint = 
				new TextConstraint(
					textFragmentIdentifier.getCharacterStartPos(primary.getContent()),
					textFragmentIdentifier.getCharacterEndPos(primary.getContent()));

		TextContext context = 
			new TextContext(
					constraint, textFragmentIdentifier.getMd5HexValueAsBytes(), 
					HashType.MD5, 
					argsParser.getBeforeContext(), 
					argsParser.getAfterContext() );
		
		
		
		if (!context.verify(primary)) {
			try {
				TextConstraint matchedConstraint = (TextConstraint)context.match(primary);
				TextContext matchedContext = new TextContext(primary, matchedConstraint, HashType.MD5, 20 );
				TextFragmentIdentifier matchedFragmentIdentifier = 
						factory.createTextFragmentIdentifier(
								"char=" + matchedConstraint.getStartPos() 
								+ "," + matchedConstraint.getEndPos());
				JSONResultFactory resultFactory = new JSONResultFactory();
				JSONObject result = resultFactory.createResult(
						jsonArgs, matchedContext, matchedFragmentIdentifier);
				
				return result.toString();
				
			}
			catch(NoMatchFoundException nme) {
				Response.getCurrent().setStatus(
						Status.CLIENT_ERROR_CONFLICT, "primary resource of the target has been modified");
				return jsonArgs.toString();
			}
		}
		
		return jsonArgs.toString();
	}
	
}
