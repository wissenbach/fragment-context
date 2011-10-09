// $ANTLR 3.4 C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g 2011-10-09 12:06:24

package eu.interedition.fragmentContext.text.urifragident.parser;
import eu.interedition.fragmentContext.text.urifragident.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class URIFragmentIdentifierPlainTextParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALPHA", "CHAR_S", "DIGIT", "EQUAL", "HEXDIGIT", "INT", "LINE_S", "MD5VALUE", "MIMECHARSETCHARS", "','", "';'", "'length='", "'md5='"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int ALPHA=4;
    public static final int CHAR_S=5;
    public static final int DIGIT=6;
    public static final int EQUAL=7;
    public static final int HEXDIGIT=8;
    public static final int INT=9;
    public static final int LINE_S=10;
    public static final int MD5VALUE=11;
    public static final int MIMECHARSETCHARS=12;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public URIFragmentIdentifierPlainTextParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public URIFragmentIdentifierPlainTextParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return URIFragmentIdentifierPlainTextParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g"; }



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



    // $ANTLR start "start"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:79:1: start : textFragment EOF ;
    public final void start() throws RecognitionException {
        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:79:7: ( textFragment EOF )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:79:9: textFragment EOF
            {
            pushFollow(FOLLOW_textFragment_in_start67);
            textFragment();

            state._fsp--;


            match(input,EOF,FOLLOW_EOF_in_start69); 

            }

        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "start"



    // $ANTLR start "textFragment"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:83:1: textFragment : textScheme ( ';' integrityCheck )* ;
    public final void textFragment() throws RecognitionException {
        TextFragmentIdentifier textScheme1 =null;

        IntegrityCheckParams integrityCheck2 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:84:2: ( textScheme ( ';' integrityCheck )* )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:84:4: textScheme ( ';' integrityCheck )*
            {
            pushFollow(FOLLOW_textScheme_in_textFragment87);
            textScheme1=textScheme();

            state._fsp--;


            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:84:15: ( ';' integrityCheck )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:84:16: ';' integrityCheck
            	    {
            	    match(input,14,FOLLOW_14_in_textFragment90); 

            	    pushFollow(FOLLOW_integrityCheck_in_textFragment92);
            	    integrityCheck2=integrityCheck();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            			textfragmentIdentifier = textScheme1;
            			textfragmentIdentifier.setLength(integrityCheck2.length);
            			textfragmentIdentifier.setMd5HexValue(integrityCheck2.md5);
            			textfragmentIdentifier.setMimeCharset(integrityCheck2.mimeCharset);
            		

            }

        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "textFragment"



    // $ANTLR start "textScheme"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:94:1: textScheme returns [TextFragmentIdentifier textfragmentIdentifier] : ( lineScheme | charScheme );
    public final TextFragmentIdentifier textScheme() throws RecognitionException {
        TextFragmentIdentifier textfragmentIdentifier = null;


        TextFragmentIdentifier lineScheme3 =null;

        TextFragmentIdentifier charScheme4 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:95:2: ( lineScheme | charScheme )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==LINE_S) ) {
                alt2=1;
            }
            else if ( (LA2_0==CHAR_S) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:95:4: lineScheme
                    {
                    pushFollow(FOLLOW_lineScheme_in_textScheme121);
                    lineScheme3=lineScheme();

                    state._fsp--;



                    		 	textfragmentIdentifier = lineScheme3;
                    		 	

                    }
                    break;
                case 2 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:99:4: charScheme
                    {
                    pushFollow(FOLLOW_charScheme_in_textScheme131);
                    charScheme4=charScheme();

                    state._fsp--;



                    		 	textfragmentIdentifier = charScheme4;
                    		 	

                    }
                    break;

            }
        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return textfragmentIdentifier;
    }
    // $ANTLR end "textScheme"



    // $ANTLR start "charScheme"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:107:1: charScheme returns [TextFragmentIdentifier textfragmentIdentifier] : CHAR_S EQUAL ( position | range ) ;
    public final TextFragmentIdentifier charScheme() throws RecognitionException {
        TextFragmentIdentifier textfragmentIdentifier = null;


        URIFragmentIdentifierPlainTextParser.position_return position5 =null;

        Range range6 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:108:2: ( CHAR_S EQUAL ( position | range ) )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:108:4: CHAR_S EQUAL ( position | range )
            {
            match(input,CHAR_S,FOLLOW_CHAR_S_in_charScheme159); 

            match(input,EQUAL,FOLLOW_EQUAL_in_charScheme161); 

            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:109:3: ( position | range )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==INT) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==EOF||LA3_1==14) ) {
                    alt3=1;
                }
                else if ( (LA3_1==13) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:109:4: position
                    {
                    pushFollow(FOLLOW_position_in_charScheme167);
                    position5=position();

                    state._fsp--;



                    			textfragmentIdentifier = new CharFragmentIdentifier(new Range((position5!=null?input.toString(position5.start,position5.stop):null)));
                    			

                    }
                    break;
                case 2 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:113:5: range
                    {
                    pushFollow(FOLLOW_range_in_charScheme179);
                    range6=range();

                    state._fsp--;



                    			textfragmentIdentifier = new CharFragmentIdentifier(range6);
                    			

                    }
                    break;

            }


            }

        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return textfragmentIdentifier;
    }
    // $ANTLR end "charScheme"



    // $ANTLR start "lineScheme"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:122:1: lineScheme returns [TextFragmentIdentifier textfragmentIdentifier] : LINE_S EQUAL ( position | range ) ;
    public final TextFragmentIdentifier lineScheme() throws RecognitionException {
        TextFragmentIdentifier textfragmentIdentifier = null;


        URIFragmentIdentifierPlainTextParser.position_return position7 =null;

        Range range8 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:123:2: ( LINE_S EQUAL ( position | range ) )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:123:4: LINE_S EQUAL ( position | range )
            {
            match(input,LINE_S,FOLLOW_LINE_S_in_lineScheme216); 

            match(input,EQUAL,FOLLOW_EQUAL_in_lineScheme218); 

            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:124:3: ( position | range )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==INT) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==EOF||LA4_1==14) ) {
                    alt4=1;
                }
                else if ( (LA4_1==13) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA4_0==13) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:124:4: position
                    {
                    pushFollow(FOLLOW_position_in_lineScheme224);
                    position7=position();

                    state._fsp--;



                    			textfragmentIdentifier = new LineFragmentIdentifier(new Range((position7!=null?input.toString(position7.start,position7.stop):null)));
                    			

                    }
                    break;
                case 2 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:128:5: range
                    {
                    pushFollow(FOLLOW_range_in_lineScheme236);
                    range8=range();

                    state._fsp--;



                    			textfragmentIdentifier = new LineFragmentIdentifier(range8);
                    			

                    }
                    break;

            }


            }

        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return textfragmentIdentifier;
    }
    // $ANTLR end "lineScheme"



    // $ANTLR start "integrityCheck"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:137:1: integrityCheck returns [IntegrityCheckParams integrityCheckParams] : ( ( lengthScheme ( ',' mimeCharset )? ) | ( md5Scheme ( ',' mimeCharset )? ) );
    public final IntegrityCheckParams integrityCheck() throws RecognitionException {
        IntegrityCheckParams integrityCheckParams = null;


        Integer lengthScheme9 =null;

        URIFragmentIdentifierPlainTextParser.mimeCharset_return mimeCharset10 =null;

        String md5Scheme11 =null;

        URIFragmentIdentifierPlainTextParser.mimeCharset_return mimeCharset12 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:138:2: ( ( lengthScheme ( ',' mimeCharset )? ) | ( md5Scheme ( ',' mimeCharset )? ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            else if ( (LA7_0==16) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:138:4: ( lengthScheme ( ',' mimeCharset )? )
                    {
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:138:4: ( lengthScheme ( ',' mimeCharset )? )
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:138:5: lengthScheme ( ',' mimeCharset )?
                    {
                    pushFollow(FOLLOW_lengthScheme_in_integrityCheck273);
                    lengthScheme9=lengthScheme();

                    state._fsp--;


                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:138:19: ( ',' mimeCharset )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==13) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:138:20: ',' mimeCharset
                            {
                            match(input,13,FOLLOW_13_in_integrityCheck277); 

                            pushFollow(FOLLOW_mimeCharset_in_integrityCheck279);
                            mimeCharset10=mimeCharset();

                            state._fsp--;


                            }
                            break;

                    }


                    }



                    			integrityCheckParams = new IntegrityCheckParams(lengthScheme9, (mimeCharset10!=null?input.toString(mimeCharset10.start,mimeCharset10.stop):null));
                    			

                    }
                    break;
                case 2 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:142:5: ( md5Scheme ( ',' mimeCharset )? )
                    {
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:142:5: ( md5Scheme ( ',' mimeCharset )? )
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:142:6: md5Scheme ( ',' mimeCharset )?
                    {
                    pushFollow(FOLLOW_md5Scheme_in_integrityCheck295);
                    md5Scheme11=md5Scheme();

                    state._fsp--;


                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:142:16: ( ',' mimeCharset )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==13) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:142:17: ',' mimeCharset
                            {
                            match(input,13,FOLLOW_13_in_integrityCheck298); 

                            pushFollow(FOLLOW_mimeCharset_in_integrityCheck300);
                            mimeCharset12=mimeCharset();

                            state._fsp--;


                            }
                            break;

                    }


                    }



                    			integrityCheckParams = new IntegrityCheckParams(md5Scheme11, (mimeCharset12!=null?input.toString(mimeCharset12.start,mimeCharset12.stop):null));
                    			

                    }
                    break;

            }
        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return integrityCheckParams;
    }
    // $ANTLR end "integrityCheck"


    public static class position_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "position"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:149:1: position : INT ;
    public final URIFragmentIdentifierPlainTextParser.position_return position() throws RecognitionException {
        URIFragmentIdentifierPlainTextParser.position_return retval = new URIFragmentIdentifierPlainTextParser.position_return();
        retval.start = input.LT(1);


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:150:2: ( INT )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:150:4: INT
            {
            match(input,INT,FOLLOW_INT_in_position326); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "position"



    // $ANTLR start "range"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:154:1: range returns [Range range] : ( (position1= position ',' (position2= position )? ) | ( ',' position ) );
    public final Range range() throws RecognitionException {
        Range range = null;


        URIFragmentIdentifierPlainTextParser.position_return position1 =null;

        URIFragmentIdentifierPlainTextParser.position_return position2 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:155:2: ( (position1= position ',' (position2= position )? ) | ( ',' position ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==INT) ) {
                alt9=1;
            }
            else if ( (LA9_0==13) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:155:4: (position1= position ',' (position2= position )? )
                    {
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:155:4: (position1= position ',' (position2= position )? )
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:155:5: position1= position ',' (position2= position )?
                    {
                    pushFollow(FOLLOW_position_in_range352);
                    position1=position();

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_range354); 

                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:155:37: (position2= position )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==INT) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:155:37: position2= position
                            {
                            pushFollow(FOLLOW_position_in_range358);
                            position2=position();

                            state._fsp--;


                            }
                            break;

                    }


                    }



                    		range = new Range();
                    		range.setStartPos((position1!=null?input.toString(position1.start,position1.stop):null));
                    		range.setEndPos((position2!=null?input.toString(position2.start,position2.stop):null));
                    		

                    }
                    break;
                case 2 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:161:5: ( ',' position )
                    {
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:161:5: ( ',' position )
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:161:6: ',' position
                    {
                    match(input,13,FOLLOW_13_in_range372); 

                    pushFollow(FOLLOW_position_in_range374);
                    position();

                    state._fsp--;


                    }



                    		range = new Range();
                    		range.setEndPos((position1!=null?input.toString(position1.start,position1.stop):null));
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return range;
    }
    // $ANTLR end "range"



    // $ANTLR start "lengthScheme"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:170:1: lengthScheme returns [Integer length] : 'length=' INT ;
    public final Integer lengthScheme() throws RecognitionException {
        Integer length = null;


        Token INT13=null;

        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:171:2: ( 'length=' INT )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:171:4: 'length=' INT
            {
            match(input,15,FOLLOW_15_in_lengthScheme406); 

            INT13=(Token)match(input,INT,FOLLOW_INT_in_lengthScheme408); 


            			length = Integer.valueOf((INT13!=null?INT13.getText():null));
            		

            }

        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return length;
    }
    // $ANTLR end "lengthScheme"



    // $ANTLR start "md5Scheme"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:178:1: md5Scheme returns [String md5] : 'md5=' MD5VALUE ;
    public final String md5Scheme() throws RecognitionException {
        String md5 = null;


        Token MD5VALUE14=null;

        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:179:2: ( 'md5=' MD5VALUE )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:179:4: 'md5=' MD5VALUE
            {
            match(input,16,FOLLOW_16_in_md5Scheme434); 

            MD5VALUE14=(Token)match(input,MD5VALUE,FOLLOW_MD5VALUE_in_md5Scheme436); 


            			md5 = (MD5VALUE14!=null?MD5VALUE14.getText():null);
            		

            }

        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return md5;
    }
    // $ANTLR end "md5Scheme"


    public static class mimeCharset_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "mimeCharset"
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:186:1: mimeCharset : ( MIMECHARSETCHARS )+ ;
    public final URIFragmentIdentifierPlainTextParser.mimeCharset_return mimeCharset() throws RecognitionException {
        URIFragmentIdentifierPlainTextParser.mimeCharset_return retval = new URIFragmentIdentifierPlainTextParser.mimeCharset_return();
        retval.start = input.LT(1);


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:187:2: ( ( MIMECHARSETCHARS )+ )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:187:4: ( MIMECHARSETCHARS )+
            {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:187:4: ( MIMECHARSETCHARS )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==MIMECHARSETCHARS) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:187:4: MIMECHARSETCHARS
            	    {
            	    match(input,MIMECHARSETCHARS,FOLLOW_MIMECHARSETCHARS_in_mimeCharset460); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mimeCharset"

    // Delegated rules


 

    public static final BitSet FOLLOW_textFragment_in_start67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textScheme_in_textFragment87 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_textFragment90 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_integrityCheck_in_textFragment92 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_lineScheme_in_textScheme121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_charScheme_in_textScheme131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_S_in_charScheme159 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUAL_in_charScheme161 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_position_in_charScheme167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_charScheme179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_S_in_lineScheme216 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUAL_in_lineScheme218 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_position_in_lineScheme224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_lineScheme236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lengthScheme_in_integrityCheck273 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_integrityCheck277 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mimeCharset_in_integrityCheck279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_md5Scheme_in_integrityCheck295 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_integrityCheck298 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mimeCharset_in_integrityCheck300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_position326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_position_in_range352 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_range354 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_position_in_range358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_range372 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_position_in_range374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_lengthScheme406 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_lengthScheme408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_md5Scheme434 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_MD5VALUE_in_md5Scheme436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIMECHARSETCHARS_in_mimeCharset460 = new BitSet(new long[]{0x0000000000001002L});

}