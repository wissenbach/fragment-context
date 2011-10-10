package eu.interedition.fragmentContext.ws;

import java.math.BigInteger;
import java.net.URI;

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
	public String createConstraint(String args) throws Exception {
		
		JSONObject jsonArgs = new JSONObject(args);
		ArgumentsParser argsParser = new ArgumentsParser(jsonArgs);
		URI targetURI = argsParser.getTargetURI();
		
		TextFragmentIdentifierFactory factory = new TextFragmentIdentifierFactory();
		TextFragmentIdentifier textFragmentIdentifier = 
				factory.createTextFragmentIdentifier(targetURI.getFragment());
		
		TextPrimary primary = argsParser.getPrimary();
		
		TextConstraint constraint = 
				new TextConstraint(
					textFragmentIdentifier.getCharacterStartPos(primary.getContent()),
					textFragmentIdentifier.getCharacterEndPos(primary.getContent()));

		TextContext context = 
				new TextContext(primary, constraint, HashType.MD5, 20);
				
		JSONObject jsonResult = new JSONObject();
		jsonResult.put(ArgumentsParser.Field.uri.name(), 
				jsonArgs.getString(ArgumentsParser.Field.uri.name()));
		
		JSONObject jsonConstraint = new JSONObject();
		jsonConstraint.put(
				ArgumentsParser.Field.checksum.name(), 
				new BigInteger(context.getCheckSum()).toString(16));
		jsonConstraint.put(
				ArgumentsParser.Field.position.name(), 
				textFragmentIdentifier.getTextScheme());
		
		JSONObject jsonContext = new JSONObject();
		jsonContext.put(
				ArgumentsParser.Field.before.name(), 
				context.getBeforeContext());
		jsonContext.put(
				ArgumentsParser.Field.after.name(), 
				context.getAfterContext());
		
		jsonConstraint.put(
				ArgumentsParser.Field.context.name(), 
				jsonContext.toString());
		
		jsonResult.put(
				ArgumentsParser.Field.constraint.name(), 
				jsonConstraint);
		
		System.out.println(jsonResult.toString());
		
		return jsonResult.toString();
	}
}
