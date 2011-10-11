package eu.interedition.fragmentContext.text.urifragident;
import junit.framework.Assert;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifierFactory;

public class TextFragmentIdentifierFactoryTest {


	@Test
	public void simpletest() throws RecognitionException {
		Assert.assertTrue(
				new TextFragmentIdentifierFactory().createTextFragmentIdentifier(
						"char=10,20;length=9876,UTF-8").toString().equals(
								"char=10,20;length=9876,UTF-8"));
	}
	
	@Test
	public void lineTest() throws RecognitionException {
		
		TextFragmentIdentifier ti = new TextFragmentIdentifierFactory().createTextFragmentIdentifier("line=2,3");
		Assert.assertTrue(ti.getCharacterStartPos("Line1\nLine2\nLine3") == 12);
		Assert.assertTrue(ti.getCharacterEndPos("Line1\nLine2\nLine3") == 17);
		
		ti = new TextFragmentIdentifierFactory().createTextFragmentIdentifier("line=2,");
		Assert.assertTrue(ti.getCharacterStartPos("Line1\nLine2\nLine3") == 12);
		Assert.assertTrue(ti.getCharacterEndPos("Line1\nLine2\nLine3") == 17);

		ti = new TextFragmentIdentifierFactory().createTextFragmentIdentifier("line=,2");
		Assert.assertTrue(ti.getCharacterStartPos("Line1\nLine2\nLine3") == 0);
		Assert.assertTrue(ti.getCharacterEndPos("Line1\nLine2\nLine3") == 17);
		
		ti = new TextFragmentIdentifierFactory().createTextFragmentIdentifier("line=1,3");
		Assert.assertTrue(ti.getCharacterStartPos("Line1\nLine2\nLine3") == 6);
		Assert.assertTrue(ti.getCharacterEndPos("Line1\nLine2\nLine3") == 17);
	}

}
