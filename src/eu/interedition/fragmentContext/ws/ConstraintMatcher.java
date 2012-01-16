package eu.interedition.fragmentContext.ws;

import java.net.URI;
import java.util.logging.Logger;

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
import eu.interedition.fragmentContext.text.urifragident.CharFragmentIdentifier;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifier;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifierFactory;

public class ConstraintMatcher extends ServerResource {

	@Post
	public String machtConstraint(String args) {
		try {
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
					
					TextContext matchedContext = 
							new TextContext(
									primary, matchedConstraint, HashType.MD5, 
									TextContext.DEFAULT_CONTEXTLENGTH );
					
					TextFragmentIdentifier matchedFragmentIdentifier = 
							factory.createTextFragmentIdentifier(
									CharFragmentIdentifier.SCHEME_NAME + "=" 
									+ matchedConstraint.getStartPos() 
									+ "," + matchedConstraint.getEndPos());
					
					JSONResultFactory resultFactory = new JSONResultFactory();
					JSONObject result = resultFactory.createResult(
							jsonArgs, matchedContext, matchedFragmentIdentifier);
					
					Logger.getLogger(this.getClass().getName()).info(result.toString());
					
					return result.toString();
					
				}
				catch(NoMatchFoundException nme) {
					String msg = "primary resource of the target has been modified";
					Logger.getLogger(this.getClass().getName()).info(msg);
					Response.getCurrent().setStatus(
							Status.CLIENT_ERROR_CONFLICT, 
							msg);
					return jsonArgs.toString();
				}
			}
			
			return jsonArgs.toString();
		}
		catch(Throwable t) {
			return ExceptionHandler.handle(t);
		}
	}
	
}
