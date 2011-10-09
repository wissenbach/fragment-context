grammar URIFragmentIdentifierPlainText;


//************************************************
// package definition for generated code
//************************************************

@lexer::header {
package eu.interedition.fragmentContext.text.urifragident.parser;
}

@parser::header {
package eu.interedition.fragmentContext.text.urifragident.parser;
import eu.interedition.fragmentContext.text.urifragident.*;
}

//************************************************
// plain code generation for the lexer
//************************************************

@lexer::members {

/**
* overrides the default error handling. enables immediate failure
*/
public void reportError(RecognitionException e) {
	throw new RuntimeException(e);
}

}


//************************************************
// plain code generation for the parser
//************************************************

@parser::members {

private TextFragmentIdentifier textfragmentIdentifier = null;

public TextFragmentIdentifier getTextFragmentIdentifier() {
	return textfragmentIdentifier;
}


/**
* overrides the default error handling. enables immediate failure
*/
protected void mismatch(IntStream input, int ttype, BitSet follow)
	throws RecognitionException {
	throw new MismatchedTokenException(ttype,input);
}

/**
* overrides the default error handling. enables immediate failure
*/
public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
	throws RecognitionException {
	throw e;
}

/**
* overrides the default error handling. enables immediate failure
*/
protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
	throws RecognitionException
{
	throw new MismatchedTokenException(ttype,input);
}
}

@rulecatch {
catch (RecognitionException e) {
	throw e;
}
}


start :	textFragment EOF
	;
	catch[RecognitionException e] {throw e;}
	
textFragment
	:	textScheme (';' integrityCheck)*
		{
			textfragmentIdentifier = $textScheme.textfragmentIdentifier;
			textfragmentIdentifier.setLength($integrityCheck.integrityCheckParams.length);
			textfragmentIdentifier.setMd5HexValue($integrityCheck.integrityCheckParams.md5);
			textfragmentIdentifier.setMimeCharset($integrityCheck.integrityCheckParams.mimeCharset);
		}
	;	
	catch[RecognitionException e] {throw e;}
	
textScheme returns [TextFragmentIdentifier textfragmentIdentifier]
	:	lineScheme
			{
		 	$textfragmentIdentifier = $lineScheme.textfragmentIdentifier;
		 	}
	| charScheme
			{
		 	$textfragmentIdentifier = $charScheme.textfragmentIdentifier;
		 	}

	;
	catch[RecognitionException e] {throw e;}
	
charScheme returns [TextFragmentIdentifier textfragmentIdentifier]
	:	CHAR_S EQUAL 
		(position 
			{
			$textfragmentIdentifier = new CharFragmentIdentifier(new Range($position.text));
			}
		| range
			{
			$textfragmentIdentifier = new CharFragmentIdentifier($range.range);
			}
		
		) 
	;
	catch[RecognitionException e] {throw e;}
			
lineScheme returns [TextFragmentIdentifier textfragmentIdentifier]
	:	LINE_S EQUAL 
		(position 
			{
			$textfragmentIdentifier = new LineFragmentIdentifier(new Range($position.text));
			}
		| range
			{
			$textfragmentIdentifier = new LineFragmentIdentifier($range.range);
			}
		
		) 
	;	
	catch[RecognitionException e] {throw e;}
	
integrityCheck returns [IntegrityCheckParams integrityCheckParams]
	:	(lengthScheme  (',' mimeCharset)?) 
			{
			$integrityCheckParams = new IntegrityCheckParams($lengthScheme.length, $mimeCharset.text);
			}
		| (md5Scheme (',' mimeCharset)?)
			{
			$integrityCheckParams = new IntegrityCheckParams($md5Scheme.md5, $mimeCharset.text);
			}
	;
	catch[RecognitionException e] {throw e;}

position 
	:	INT
	;
	catch[RecognitionException e] {throw e;}
	
range 	returns [Range range]
	:	(position1=position ',' position2=position?) 
		{
		$range = new Range();
		$range.setStartPos($position1.text);
		$range.setEndPos($position2.text);
		}
		| (',' position) 
		{
		$range = new Range();
		$range.setEndPos($position1.text);
		}
		
	;
	catch[RecognitionException e] {throw e;}
	
lengthScheme returns [Integer length] 
	:	'length=' INT
		{
			$length = Integer.valueOf($INT.text);
		}
	;
	catch[RecognitionException e] {throw e;}
	
md5Scheme returns [String md5]
	:	'md5=' MD5VALUE
		{
			$md5 = $MD5VALUE.text;
		}
	;	
	catch[RecognitionException e] {throw e;}
	
mimeCharset 
	:	MIMECHARSETCHARS+
	;
	catch[RecognitionException e] {throw e;}

MIMECHARSETCHARS 
	:	ALPHA | DIGIT | '!' | '#' | '$' | '%' | '&' | '\'' | '+' | '-' | '^' | '_' | '`' | '{' | '}' | '~'
	;

INT	:	DIGIT+
	;
	
MD5VALUE 
	:	HEXDIGIT+
	;

fragment HEXDIGIT 
	:	 DIGIT | 'a' .. 'f' | 'A' .. 'F'
	;

fragment ALPHA 	:	'A'..'Z'
	;

fragment DIGIT	:	'0'..'9'
	;	
	
CHAR_S 	:	'char'
	;
	
LINE_S 	:	'line'
	;
	
EQUAL 	:	'='
	;
