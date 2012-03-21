package eu.interedition.fragmentContext.text.urifragident;
import junit.framework.Assert;

import org.antlr.runtime.RecognitionException;
import org.json.JSONObject;
import org.junit.Test;

import eu.interedition.fragmentContext.text.TextPrimary;
import eu.interedition.fragmentContext.ws.ArgumentsParser;

public class TextFragmentIdentifierFactoryTest {


	@Test
	public void simpletest() throws RecognitionException {
		Assert.assertTrue(
				new TextFragmentIdentifierFactory().createTextFragmentIdentifier(
						"char=10,20;length=9876,UTF-8").toString().equals(
								"char=10,20;length=9876,UTF-8"));
	}
	
	@Test
	public void lineTest() throws Exception {
		TextFragmentIdentifierFactory factory = new TextFragmentIdentifierFactory();
		TextFragmentIdentifier ti = factory.createTextFragmentIdentifier("line=2,3");
		Assert.assertTrue(ti.getCharacterStartPos("Line1\nLine2\nLine3") == 12);
		Assert.assertTrue(ti.getCharacterEndPos("Line1\nLine2\nLine3") == 17);
		
		ti = factory.createTextFragmentIdentifier("line=2,");
		Assert.assertTrue(ti.getCharacterStartPos("Line1\nLine2\nLine3") == 12);
		Assert.assertTrue(ti.getCharacterEndPos("Line1\nLine2\nLine3") == 17);

		ti = factory.createTextFragmentIdentifier("line=,2");
		Assert.assertTrue(ti.getCharacterStartPos("Line1\nLine2\nLine3") == 0);
		Assert.assertTrue(ti.getCharacterEndPos("Line1\nLine2\nLine3") == 17);
		
		ti = factory.createTextFragmentIdentifier("line=1,3");
		Assert.assertTrue(ti.getCharacterStartPos("Line1\nLine2\nLine3") == 6);
		Assert.assertTrue(ti.getCharacterEndPos("Line1\nLine2\nLine3") == 17);
		
		JSONObject args = 
				new JSONObject(
						"{ \"uri\" : \"http://www.gutenberg.org/cache/epub/11/pg11.txt#line=51,57\", " +
						"\"constraint\" : { \"position\" : \"line=51,57\" }}");
		
		ArgumentsParser argumentsParser = new ArgumentsParser(args);
		argumentsParser.getTargetURI();
		TextPrimary primary = argumentsParser.getPrimary();
		System.out.println("*"+primary.getContent().substring(756, 761)+"*");
		ti = factory.createTextFragmentIdentifier("line=51,57");
		
		System.out.println(ti.getCharacterStartPos(primary.getContent()));
		System.out.println(ti.getCharacterEndPos(primary.getContent()));
		System.out.println("*"+primary.getContent().substring(ti.getCharacterStartPos(primary.getContent()), ti.getCharacterEndPos(primary.getContent()))+"*");
	}

}
