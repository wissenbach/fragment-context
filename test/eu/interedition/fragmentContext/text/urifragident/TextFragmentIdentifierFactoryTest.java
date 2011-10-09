package eu.interedition.fragmentContext.text.urifragident;
import junit.framework.Assert;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifierFactory;

public class TextFragmentIdentifierFactoryTest {


	@Test
	public void test() throws RecognitionException {
		Assert.assertTrue(
				new TextFragmentIdentifierFactory().createTextFragmentIdentifier(
						"char=10,20;length=9876,UTF-8").toString().equals(
								"RANGE[10,20] LENGTH[9876] MD5[null] MIMECHARSET[UTF-8]"));
	}

}
