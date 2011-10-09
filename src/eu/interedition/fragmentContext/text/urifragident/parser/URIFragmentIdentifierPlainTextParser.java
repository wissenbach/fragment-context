// $ANTLR 3.4 C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g 2011-10-09 16:13:01

package eu.interedition.fragmentContext.text.urifragident.parser;
import eu.interedition.fragmentContext.text.urifragident.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class URIFragmentIdentifierPlainTextParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALPHA", "CHAR_S", "DIGIT", "EQUAL", "HEXDIGIT", "INT", "LINE_S", "MD5VALUE", "MIMECHARS", "','", "';'", "'length='", "'md5='"
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
    public static final int MIMECHARS=12;

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



    class IntegrityCheckParams {
    	String md5;
    	Integer length;
    	String mimeCharset;
    	public IntegrityCheckParams(Integer length, String mimeCharset) {
    		super();
    		this.length = length;
    		this.mimeCharset = mimeCharset;
    	}
    	public IntegrityCheckParams(String md5, String mimeCharset) {
    		super();
    		this.md5 = md5;
    		this.mimeCharset = mimeCharset;
    	}
    	
    }

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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:96:1: start : textFragment EOF ;
    public final void start() throws RecognitionException {
        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:96:7: ( textFragment EOF )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:96:9: textFragment EOF
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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:100:1: textFragment : textScheme ( ';' integrityCheck )* ;
    public final void textFragment() throws RecognitionException {
        TextFragmentIdentifier textScheme1 =null;

        IntegrityCheckParams integrityCheck2 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:101:2: ( textScheme ( ';' integrityCheck )* )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:101:4: textScheme ( ';' integrityCheck )*
            {
            pushFollow(FOLLOW_textScheme_in_textFragment87);
            textScheme1=textScheme();

            state._fsp--;


            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:101:15: ( ';' integrityCheck )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:101:16: ';' integrityCheck
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
            			if (integrityCheck2 != null) {
            				textfragmentIdentifier.setLength(integrityCheck2.length);
            				textfragmentIdentifier.setMd5HexValue(integrityCheck2.md5);
            				textfragmentIdentifier.setMimeCharset(integrityCheck2.mimeCharset);
            			}
            		

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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:113:1: textScheme returns [TextFragmentIdentifier textfragmentIdentifier] : ( lineScheme | charScheme );
    public final TextFragmentIdentifier textScheme() throws RecognitionException {
        TextFragmentIdentifier textfragmentIdentifier = null;


        TextFragmentIdentifier lineScheme3 =null;

        TextFragmentIdentifier charScheme4 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:114:2: ( lineScheme | charScheme )
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
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:114:4: lineScheme
                    {
                    pushFollow(FOLLOW_lineScheme_in_textScheme121);
                    lineScheme3=lineScheme();

                    state._fsp--;



                    		 	textfragmentIdentifier = lineScheme3;
                    		 	

                    }
                    break;
                case 2 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:118:4: charScheme
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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:126:1: charScheme returns [TextFragmentIdentifier textfragmentIdentifier] : CHAR_S EQUAL range ;
    public final TextFragmentIdentifier charScheme() throws RecognitionException {
        TextFragmentIdentifier textfragmentIdentifier = null;


        Range range5 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:127:2: ( CHAR_S EQUAL range )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:127:4: CHAR_S EQUAL range
            {
            match(input,CHAR_S,FOLLOW_CHAR_S_in_charScheme159); 

            match(input,EQUAL,FOLLOW_EQUAL_in_charScheme161); 

            pushFollow(FOLLOW_range_in_charScheme163);
            range5=range();

            state._fsp--;



            			textfragmentIdentifier = new CharFragmentIdentifier(range5);
            			

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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:134:1: lineScheme returns [TextFragmentIdentifier textfragmentIdentifier] : LINE_S EQUAL range ;
    public final TextFragmentIdentifier lineScheme() throws RecognitionException {
        TextFragmentIdentifier textfragmentIdentifier = null;


        Range range6 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:135:2: ( LINE_S EQUAL range )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:135:4: LINE_S EQUAL range
            {
            match(input,LINE_S,FOLLOW_LINE_S_in_lineScheme192); 

            match(input,EQUAL,FOLLOW_EQUAL_in_lineScheme194); 

            pushFollow(FOLLOW_range_in_lineScheme196);
            range6=range();

            state._fsp--;



            			textfragmentIdentifier = new LineFragmentIdentifier(range6);
            			

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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:142:1: integrityCheck returns [IntegrityCheckParams integrityCheckParams] : ( ( lengthScheme ( ',' mimeCharset )? ) | ( md5Scheme ( ',' mimeCharset )? ) );
    public final IntegrityCheckParams integrityCheck() throws RecognitionException {
        IntegrityCheckParams integrityCheckParams = null;


        Integer lengthScheme7 =null;

        URIFragmentIdentifierPlainTextParser.mimeCharset_return mimeCharset8 =null;

        String md5Scheme9 =null;

        URIFragmentIdentifierPlainTextParser.mimeCharset_return mimeCharset10 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:143:2: ( ( lengthScheme ( ',' mimeCharset )? ) | ( md5Scheme ( ',' mimeCharset )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:143:4: ( lengthScheme ( ',' mimeCharset )? )
                    {
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:143:4: ( lengthScheme ( ',' mimeCharset )? )
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:143:5: lengthScheme ( ',' mimeCharset )?
                    {
                    pushFollow(FOLLOW_lengthScheme_in_integrityCheck225);
                    lengthScheme7=lengthScheme();

                    state._fsp--;


                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:143:19: ( ',' mimeCharset )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==13) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:143:20: ',' mimeCharset
                            {
                            match(input,13,FOLLOW_13_in_integrityCheck229); 

                            pushFollow(FOLLOW_mimeCharset_in_integrityCheck231);
                            mimeCharset8=mimeCharset();

                            state._fsp--;


                            }
                            break;

                    }


                    }



                    			integrityCheckParams = new IntegrityCheckParams(lengthScheme7, (mimeCharset8!=null?input.toString(mimeCharset8.start,mimeCharset8.stop):null));
                    			

                    }
                    break;
                case 2 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:147:5: ( md5Scheme ( ',' mimeCharset )? )
                    {
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:147:5: ( md5Scheme ( ',' mimeCharset )? )
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:147:6: md5Scheme ( ',' mimeCharset )?
                    {
                    pushFollow(FOLLOW_md5Scheme_in_integrityCheck247);
                    md5Scheme9=md5Scheme();

                    state._fsp--;


                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:147:16: ( ',' mimeCharset )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==13) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:147:17: ',' mimeCharset
                            {
                            match(input,13,FOLLOW_13_in_integrityCheck250); 

                            pushFollow(FOLLOW_mimeCharset_in_integrityCheck252);
                            mimeCharset10=mimeCharset();

                            state._fsp--;


                            }
                            break;

                    }


                    }



                    			integrityCheckParams = new IntegrityCheckParams(md5Scheme9, (mimeCharset10!=null?input.toString(mimeCharset10.start,mimeCharset10.stop):null));
                    			

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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:154:1: position : INT ;
    public final URIFragmentIdentifierPlainTextParser.position_return position() throws RecognitionException {
        URIFragmentIdentifierPlainTextParser.position_return retval = new URIFragmentIdentifierPlainTextParser.position_return();
        retval.start = input.LT(1);


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:155:2: ( INT )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:155:4: INT
            {
            match(input,INT,FOLLOW_INT_in_position278); 

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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:159:1: range returns [Range range] : ( (position1= position (comma1= ',' | (comma2= ',' position2= position ) )? ) | ( ',' position ) );
    public final Range range() throws RecognitionException {
        Range range = null;


        Token comma1=null;
        Token comma2=null;
        URIFragmentIdentifierPlainTextParser.position_return position1 =null;

        URIFragmentIdentifierPlainTextParser.position_return position2 =null;


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:160:2: ( (position1= position (comma1= ',' | (comma2= ',' position2= position ) )? ) | ( ',' position ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==INT) ) {
                alt7=1;
            }
            else if ( (LA7_0==13) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:160:4: (position1= position (comma1= ',' | (comma2= ',' position2= position ) )? )
                    {
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:160:4: (position1= position (comma1= ',' | (comma2= ',' position2= position ) )? )
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:160:5: position1= position (comma1= ',' | (comma2= ',' position2= position ) )?
                    {
                    pushFollow(FOLLOW_position_in_range304);
                    position1=position();

                    state._fsp--;


                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:160:24: (comma1= ',' | (comma2= ',' position2= position ) )?
                    int alt6=3;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==13) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==EOF||LA6_1==14) ) {
                            alt6=1;
                        }
                        else if ( (LA6_1==INT) ) {
                            alt6=2;
                        }
                    }
                    switch (alt6) {
                        case 1 :
                            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:160:25: comma1= ','
                            {
                            comma1=(Token)match(input,13,FOLLOW_13_in_range309); 

                            }
                            break;
                        case 2 :
                            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:160:38: (comma2= ',' position2= position )
                            {
                            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:160:38: (comma2= ',' position2= position )
                            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:160:39: comma2= ',' position2= position
                            {
                            comma2=(Token)match(input,13,FOLLOW_13_in_range316); 

                            pushFollow(FOLLOW_position_in_range320);
                            position2=position();

                            state._fsp--;


                            }


                            }
                            break;

                    }


                    }



                    		range = new Range();
                    		range.setStartPos((position1!=null?input.toString(position1.start,position1.stop):null));
                    		if ((comma2!=null?comma2.getText():null) != null) {
                    			range.setEndPos((position2!=null?input.toString(position2.start,position2.stop):null));
                    		}
                    		else if ((comma1!=null?comma1.getText():null) == null) {
                    			range.setEndPos((position1!=null?input.toString(position1.start,position1.stop):null));	
                    		}
                    		

                    }
                    break;
                case 2 :
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:171:5: ( ',' position )
                    {
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:171:5: ( ',' position )
                    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:171:6: ',' position
                    {
                    match(input,13,FOLLOW_13_in_range335); 

                    pushFollow(FOLLOW_position_in_range337);
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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:180:1: lengthScheme returns [Integer length] : 'length=' INT ;
    public final Integer lengthScheme() throws RecognitionException {
        Integer length = null;


        Token INT11=null;

        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:181:2: ( 'length=' INT )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:181:4: 'length=' INT
            {
            match(input,15,FOLLOW_15_in_lengthScheme369); 

            INT11=(Token)match(input,INT,FOLLOW_INT_in_lengthScheme371); 


            			length = Integer.valueOf((INT11!=null?INT11.getText():null));
            		

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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:188:1: md5Scheme returns [String md5] : 'md5=' MD5VALUE ;
    public final String md5Scheme() throws RecognitionException {
        String md5 = null;


        Token MD5VALUE12=null;

        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:189:2: ( 'md5=' MD5VALUE )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:189:4: 'md5=' MD5VALUE
            {
            match(input,16,FOLLOW_16_in_md5Scheme397); 

            MD5VALUE12=(Token)match(input,MD5VALUE,FOLLOW_MD5VALUE_in_md5Scheme399); 


            			md5 = (MD5VALUE12!=null?MD5VALUE12.getText():null);
            		

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
    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:196:1: mimeCharset : ( MIMECHARS )+ ;
    public final URIFragmentIdentifierPlainTextParser.mimeCharset_return mimeCharset() throws RecognitionException {
        URIFragmentIdentifierPlainTextParser.mimeCharset_return retval = new URIFragmentIdentifierPlainTextParser.mimeCharset_return();
        retval.start = input.LT(1);


        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:197:2: ( ( MIMECHARS )+ )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:197:4: ( MIMECHARS )+
            {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:197:4: ( MIMECHARS )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==MIMECHARS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:197:4: MIMECHARS
            	    {
            	    match(input,MIMECHARS,FOLLOW_MIMECHARS_in_mimeCharset423); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
    public static final BitSet FOLLOW_range_in_charScheme163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_S_in_lineScheme192 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUAL_in_lineScheme194 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_range_in_lineScheme196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lengthScheme_in_integrityCheck225 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_integrityCheck229 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mimeCharset_in_integrityCheck231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_md5Scheme_in_integrityCheck247 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_integrityCheck250 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mimeCharset_in_integrityCheck252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_position278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_position_in_range304 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_range309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_range316 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_position_in_range320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_range335 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_position_in_range337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_lengthScheme369 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_lengthScheme371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_md5Scheme397 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_MD5VALUE_in_md5Scheme399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIMECHARS_in_mimeCharset423 = new BitSet(new long[]{0x0000000000001002L});

}