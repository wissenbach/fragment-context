package eu.interedition.fragmentContext.text.urifragident;

import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.io.IOUtils;

import eu.interedition.fragmentContext.text.urifragident.parser.URIFragmentIdentifierPlainTextLexer;
import eu.interedition.fragmentContext.text.urifragident.parser.URIFragmentIdentifierPlainTextParser;

public class TextFragmentIdentifierFactory {

	public TextFragmentIdentifierFactory() {
		
	}
	
	public TextFragmentIdentifier createTextFragmentIdentifier(String fragmentIdentifier) throws RecognitionException {
		if ((fragmentIdentifier == null) || (fragmentIdentifier.isEmpty())) {
			return new FulltextFragmentIdentifier();
		}
		ANTLRInputStream is;
		try {
			is = new ANTLRInputStream(IOUtils.toInputStream(fragmentIdentifier));
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		URIFragmentIdentifierPlainTextLexer lexer = new URIFragmentIdentifierPlainTextLexer(is);
		CommonTokenStream ts = new CommonTokenStream(lexer);
		URIFragmentIdentifierPlainTextParser parser = new URIFragmentIdentifierPlainTextParser(ts);
		parser.start();
		return  parser.getTextFragmentIdentifier();

	}
}
