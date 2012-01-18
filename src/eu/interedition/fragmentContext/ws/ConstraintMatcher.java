package eu.interedition.fragmentContext.ws;

import java.net.URI;
import java.util.HashMap;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
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
import eu.interedition.fragmentContext.ws.ArgumentsParser.State;

public class ConstraintMatcher extends ServerResource {

	@Post
	public String machtConstraint(String args) {
		HashMap<String, TextPrimary> primariesCache = new HashMap<String, TextPrimary>();
		
		Logger.getLogger(this.getClass().getName()).info("ConstraintMatcher args:" + args);
		
		StringBuilder jsonResult = new StringBuilder("[");
		String conc = "";
		try {
			JSONArray jsonArgs = new JSONArray(args);
			for (int i=0; i<jsonArgs.length(); i++) {
				JSONObject jsonArg = jsonArgs.getJSONObject(i);
				ArgumentsParser argsParser = new ArgumentsParser(jsonArg);
				URI targetURI = argsParser.getTargetURI();
				
				TextFragmentIdentifierFactory factory = new TextFragmentIdentifierFactory();
				
				TextFragmentIdentifier textFragmentIdentifier = 
						factory.createTextFragmentIdentifier(targetURI.getFragment());
				
				if (textFragmentIdentifier.getMd5HexValue() == null) {
					textFragmentIdentifier.setMd5HexValue(argsParser.getMd5HexValue());
				}
				String textPrimaryKey = targetURI.getScheme()+targetURI.getSchemeSpecificPart();
				
				TextPrimary primary = primariesCache.get(textPrimaryKey);
				
				if (primary == null) {
					primary = argsParser.getPrimary();
					primariesCache.put(textPrimaryKey, primary);
					Logger.getLogger(this.getClass().getName()).info("caching " + targetURI);
				}
				else {
					Logger.getLogger(this.getClass().getName()).info(" using primary from cache: " + targetURI);
				}
				
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
						TextConstraint matchedConstraint = (TextConstraint)context.match(primary, constraint);
						
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
								jsonArg, matchedContext, matchedFragmentIdentifier, State.modified);
						
						Logger.getLogger(this.getClass().getName()).info(result.toString());
						
						jsonResult.append(conc);
						jsonResult.append(result);
					}
					catch(NoMatchFoundException nme) {
						String msg = "primary resource of the target has been modified";
						Logger.getLogger(this.getClass().getName()).info(msg);
//						Response.getCurrent().setStatus(
//								Status.CLIENT_ERROR_CONFLICT, 
//								msg);
						jsonArg.put(
							ArgumentsParser.Field.state.name(), ArgumentsParser.State.failure.name());
						jsonResult.append(conc);
						jsonResult.append(jsonArg.toString());
					}
				}
				else {
					jsonArg.put(ArgumentsParser.Field.state.name(), ArgumentsParser.State.success.name());
					jsonResult.append(conc);
					jsonResult.append(jsonArg.toString());
				}
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
