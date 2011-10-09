// $ANTLR 3.4 C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g 2011-10-09 12:06:24

package eu.interedition.fragmentContext.text.urifragident.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class URIFragmentIdentifierPlainTextLexer extends Lexer {
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


    /**
    * overrides the default error handling. enables immediate failure
    */
    public void reportError(RecognitionException e) {
    	throw new RuntimeException(e);
    }



    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public URIFragmentIdentifierPlainTextLexer() {} 
    public URIFragmentIdentifierPlainTextLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public URIFragmentIdentifierPlainTextLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:16:7: ( ',' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:16:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:17:7: ( ';' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:17:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:18:7: ( 'length=' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:18:9: 'length='
            {
            match("length="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:19:7: ( 'md5=' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:19:9: 'md5='
            {
            match("md5="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "MIMECHARSETCHARS"
    public final void mMIMECHARSETCHARS() throws RecognitionException {
        try {
            int _type = MIMECHARSETCHARS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:192:2: ( ALPHA | DIGIT | '!' | '#' | '$' | '%' | '&' | '\\'' | '+' | '-' | '^' | '_' | '`' | '{' | '}' | '~' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:
            {
            if ( input.LA(1)=='!'||(input.LA(1) >= '#' && input.LA(1) <= '\'')||input.LA(1)=='+'||input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= '^' && input.LA(1) <= '`')||input.LA(1)=='{'||(input.LA(1) >= '}' && input.LA(1) <= '~') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MIMECHARSETCHARS"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:195:5: ( ( DIGIT )+ )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:195:7: ( DIGIT )+
            {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:195:7: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "MD5VALUE"
    public final void mMD5VALUE() throws RecognitionException {
        try {
            int _type = MD5VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:199:2: ( ( HEXDIGIT )+ )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:199:4: ( HEXDIGIT )+
            {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:199:4: ( HEXDIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'F')||(LA2_0 >= 'a' && LA2_0 <= 'f')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MD5VALUE"

    // $ANTLR start "HEXDIGIT"
    public final void mHEXDIGIT() throws RecognitionException {
        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:203:2: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEXDIGIT"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:206:17: ( 'A' .. 'Z' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:209:16: ( '0' .. '9' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "CHAR_S"
    public final void mCHAR_S() throws RecognitionException {
        try {
            int _type = CHAR_S;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:212:9: ( 'char' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:212:11: 'char'
            {
            match("char"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR_S"

    // $ANTLR start "LINE_S"
    public final void mLINE_S() throws RecognitionException {
        try {
            int _type = LINE_S;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:215:9: ( 'line' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:215:11: 'line'
            {
            match("line"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_S"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:218:8: ( '=' )
            // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:218:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    public void mTokens() throws RecognitionException {
        // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:8: ( T__13 | T__14 | T__15 | T__16 | MIMECHARSETCHARS | INT | MD5VALUE | CHAR_S | LINE_S | EQUAL )
        int alt3=10;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:10: T__13
                {
                mT__13(); 


                }
                break;
            case 2 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:16: T__14
                {
                mT__14(); 


                }
                break;
            case 3 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:22: T__15
                {
                mT__15(); 


                }
                break;
            case 4 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:28: T__16
                {
                mT__16(); 


                }
                break;
            case 5 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:34: MIMECHARSETCHARS
                {
                mMIMECHARSETCHARS(); 


                }
                break;
            case 6 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:51: INT
                {
                mINT(); 


                }
                break;
            case 7 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:55: MD5VALUE
                {
                mMD5VALUE(); 


                }
                break;
            case 8 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:64: CHAR_S
                {
                mCHAR_S(); 


                }
                break;
            case 9 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:71: LINE_S
                {
                mLINE_S(); 


                }
                break;
            case 10 :
                // C:\\data\\eclipse_workspace\\fragment-context\\grammars\\urifragidentplaintext\\URIFragmentIdentifierPlainText.g:1:78: EQUAL
                {
                mEQUAL(); 


                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\5\uffff\2\7\1\uffff\1\11\4\uffff\1\17\2\uffff";
    static final String DFA3_eofS =
        "\20\uffff";
    static final String DFA3_minS =
        "\1\41\2\uffff\1\145\1\uffff\2\60\1\uffff\1\150\4\uffff\1\60\2\uffff";
    static final String DFA3_maxS =
        "\1\176\2\uffff\1\151\1\uffff\2\146\1\uffff\1\150\4\uffff\1\146\2"+
        "\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\2\uffff\1\5\1\uffff\1\7\1\12\1\3\1"+
        "\11\1\uffff\1\10\1\6";
    static final String DFA3_specialS =
        "\20\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\7\1\uffff\5\7\3\uffff\1\7\1\1\1\7\2\uffff\12\5\1\uffff\1"+
            "\2\1\uffff\1\12\3\uffff\6\6\24\7\3\uffff\3\7\2\11\1\10\3\11"+
            "\5\uffff\1\3\1\4\15\uffff\1\7\1\uffff\2\7",
            "",
            "",
            "\1\13\3\uffff\1\14",
            "",
            "\12\15\7\uffff\6\11\32\uffff\6\11",
            "\12\11\7\uffff\6\11\32\uffff\6\11",
            "",
            "\1\16",
            "",
            "",
            "",
            "",
            "\12\15\7\uffff\6\11\32\uffff\6\11",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | MIMECHARSETCHARS | INT | MD5VALUE | CHAR_S | LINE_S | EQUAL );";
        }
    }
 

}