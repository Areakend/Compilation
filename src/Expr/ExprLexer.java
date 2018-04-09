package Expr; // $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/Samy/Git_Telecom/Compilation2k18/Expr.g 2018-04-09 23:39:25

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ExprLexer extends Lexer {
    public static final int PRINT=17;
    public static final int BLOC=6;
    public static final int T__50=50;
    public static final int VAR=15;
    public static final int IDF=22;
    public static final int COMMENTLINE=27;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int ELSE=11;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int IF=10;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int NEWLINE=24;
    public static final int DECL=18;
    public static final int T__28=28;
    public static final int FUNC_ARGS=14;
    public static final int T__29=29;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int STRUCT=4;
    public static final int T__64=64;
    public static final int IND=19;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int SPE_UNAIRE=13;
    public static final int COMMENT=26;
    public static final int ASSOC=20;
    public static final int RETURN=12;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int ARGUMENT=7;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int WS=25;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int CST_ENT=23;
    public static final int FUNC=5;
    public static final int CALL_ARGS=21;
    public static final int AFFECT=8;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int VEC=16;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int WHILE=9;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators

    public ExprLexer() {;} 
    public ExprLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ExprLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/Samy/Git_Telecom/Compilation2k18/Expr.g"; }

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:7:7: ( 'struct' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:7:9: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:8:7: ( '{' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:8:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:9:7: ( ':' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:9:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:10:7: ( ',' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:10:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:11:7: ( '}' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:11:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:12:7: ( 'fn' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:12:9: 'fn'
            {
            match("fn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:13:7: ( '(' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:13:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:14:7: ( ')' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:15:7: ( '->' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:15:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:16:7: ( 'Vec' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:16:9: 'Vec'
            {
            match("Vec"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:17:7: ( '<' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:17:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:18:7: ( '>' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:18:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:19:7: ( '&' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:19:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:20:7: ( 'i32' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:20:9: 'i32'
            {
            match("i32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:21:7: ( 'bool' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:21:9: 'bool'
            {
            match("bool"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:22:7: ( ';' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:22:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:23:7: ( 'let' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:23:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:24:7: ( 'mut' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:24:9: 'mut'
            {
            match("mut"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:25:7: ( '=' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:25:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:26:7: ( 'return' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:26:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:27:7: ( 'while' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:27:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:28:7: ( 'if' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:28:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:29:7: ( 'else' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:29:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:30:7: ( '||' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:30:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:31:7: ( '&&' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:31:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:32:7: ( 'vec' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:32:9: 'vec'
            {
            match("vec"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:33:7: ( '![' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:33:9: '!['
            {
            match("!["); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:34:7: ( ']' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:34:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:35:7: ( 'print' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:35:9: 'print'
            {
            match("print"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:36:7: ( '!(' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:36:9: '!('
            {
            match("!("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:37:7: ( '[' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:37:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:38:7: ( '.' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:38:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:39:7: ( 'len' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:39:9: 'len'
            {
            match("len"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:40:7: ( 'true' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:40:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:41:7: ( 'false' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:41:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:42:7: ( '+' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:42:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:43:7: ( '-' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:43:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:44:7: ( '*' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:44:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:45:7: ( '/' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:45:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:46:7: ( '<=' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:46:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:47:7: ( '>=' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:47:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:48:7: ( '==' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:48:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:49:7: ( '!=' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:49:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:50:7: ( '!' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:50:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "CST_ENT"
    public final void mCST_ENT() throws RecognitionException {
        try {
            int _type = CST_ENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:244:9: ( ( '0' .. '9' )+ )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:244:10: ( '0' .. '9' )+
            {
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:244:10: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:244:10: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
        }
    }
    // $ANTLR end "CST_ENT"

    // $ANTLR start "IDF"
    public final void mIDF() throws RecognitionException {
        try {
            int _type = IDF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:245:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | CST_ENT )* )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:245:6: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | CST_ENT )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:245:28: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | CST_ENT )*
            loop2:
            do {
                int alt2=5;
                switch ( input.LA(1) ) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt2=1;
                    }
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    {
                    alt2=2;
                    }
                    break;
                case '_':
                    {
                    alt2=3;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt2=4;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:245:29: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:245:40: 'A' .. 'Z'
            	    {
            	    matchRange('A','Z'); 

            	    }
            	    break;
            	case 3 :
            	    // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:245:51: '_'
            	    {
            	    match('_'); 

            	    }
            	    break;
            	case 4 :
            	    // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:245:57: CST_ENT
            	    {
            	    mCST_ENT(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDF"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:246:8: ( ( '\\r' )? '\\n' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:246:9: ( '\\r' )? '\\n'
            {
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:246:9: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:246:9: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:247:4: ( ( ' ' | '\\t' ) )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:247:5: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:248:8: ( '/*' ( . )* '*/' )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:248:9: '/*' ( . )* '*/'
            {
            match("/*"); 

            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:248:14: ( . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='*') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='/') ) {
                        alt4=2;
                    }
                    else if ( ((LA4_1>='\u0000' && LA4_1<='.')||(LA4_1>='0' && LA4_1<='\uFFFF')) ) {
                        alt4=1;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<=')')||(LA4_0>='+' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:248:14: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "COMMENTLINE"
    public final void mCOMMENTLINE() throws RecognitionException {
        try {
            int _type = COMMENTLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:249:12: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:249:13: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:249:18: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\n'||LA5_0=='\r') ) {
                    alt5=2;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:249:18: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENTLINE"

    public void mTokens() throws RecognitionException {
        // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:8: ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | CST_ENT | IDF | NEWLINE | WS | COMMENT | COMMENTLINE )
        int alt6=50;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:10: T__28
                {
                mT__28(); 

                }
                break;
            case 2 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:16: T__29
                {
                mT__29(); 

                }
                break;
            case 3 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:22: T__30
                {
                mT__30(); 

                }
                break;
            case 4 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:28: T__31
                {
                mT__31(); 

                }
                break;
            case 5 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:34: T__32
                {
                mT__32(); 

                }
                break;
            case 6 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:40: T__33
                {
                mT__33(); 

                }
                break;
            case 7 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:46: T__34
                {
                mT__34(); 

                }
                break;
            case 8 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:52: T__35
                {
                mT__35(); 

                }
                break;
            case 9 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:58: T__36
                {
                mT__36(); 

                }
                break;
            case 10 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:64: T__37
                {
                mT__37(); 

                }
                break;
            case 11 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:70: T__38
                {
                mT__38(); 

                }
                break;
            case 12 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:76: T__39
                {
                mT__39(); 

                }
                break;
            case 13 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:82: T__40
                {
                mT__40(); 

                }
                break;
            case 14 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:88: T__41
                {
                mT__41(); 

                }
                break;
            case 15 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:94: T__42
                {
                mT__42(); 

                }
                break;
            case 16 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:100: T__43
                {
                mT__43(); 

                }
                break;
            case 17 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:106: T__44
                {
                mT__44(); 

                }
                break;
            case 18 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:112: T__45
                {
                mT__45(); 

                }
                break;
            case 19 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:118: T__46
                {
                mT__46(); 

                }
                break;
            case 20 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:124: T__47
                {
                mT__47(); 

                }
                break;
            case 21 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:130: T__48
                {
                mT__48(); 

                }
                break;
            case 22 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:136: T__49
                {
                mT__49(); 

                }
                break;
            case 23 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:142: T__50
                {
                mT__50(); 

                }
                break;
            case 24 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:148: T__51
                {
                mT__51(); 

                }
                break;
            case 25 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:154: T__52
                {
                mT__52(); 

                }
                break;
            case 26 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:160: T__53
                {
                mT__53(); 

                }
                break;
            case 27 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:166: T__54
                {
                mT__54(); 

                }
                break;
            case 28 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:172: T__55
                {
                mT__55(); 

                }
                break;
            case 29 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:178: T__56
                {
                mT__56(); 

                }
                break;
            case 30 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:184: T__57
                {
                mT__57(); 

                }
                break;
            case 31 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:190: T__58
                {
                mT__58(); 

                }
                break;
            case 32 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:196: T__59
                {
                mT__59(); 

                }
                break;
            case 33 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:202: T__60
                {
                mT__60(); 

                }
                break;
            case 34 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:208: T__61
                {
                mT__61(); 

                }
                break;
            case 35 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:214: T__62
                {
                mT__62(); 

                }
                break;
            case 36 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:220: T__63
                {
                mT__63(); 

                }
                break;
            case 37 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:226: T__64
                {
                mT__64(); 

                }
                break;
            case 38 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:232: T__65
                {
                mT__65(); 

                }
                break;
            case 39 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:238: T__66
                {
                mT__66(); 

                }
                break;
            case 40 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:244: T__67
                {
                mT__67(); 

                }
                break;
            case 41 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:250: T__68
                {
                mT__68(); 

                }
                break;
            case 42 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:256: T__69
                {
                mT__69(); 

                }
                break;
            case 43 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:262: T__70
                {
                mT__70(); 

                }
                break;
            case 44 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:268: T__71
                {
                mT__71(); 

                }
                break;
            case 45 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:274: CST_ENT
                {
                mCST_ENT(); 

                }
                break;
            case 46 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:282: IDF
                {
                mIDF(); 

                }
                break;
            case 47 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:286: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 48 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:294: WS
                {
                mWS(); 

                }
                break;
            case 49 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:297: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 50 :
                // /Users/Samy/Git_Telecom/Compilation2k18/Expr.g:1:305: COMMENTLINE
                {
                mCOMMENTLINE(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\1\43\4\uffff\1\43\2\uffff\1\52\1\43\1\55\1\57\1\61\2\43"+
        "\1\uffff\2\43\1\70\3\43\1\uffff\1\43\1\100\1\uffff\1\43\2\uffff"+
        "\1\43\2\uffff\1\105\4\uffff\1\43\1\107\1\43\2\uffff\1\43\6\uffff"+
        "\1\43\1\113\3\43\2\uffff\4\43\4\uffff\2\43\3\uffff\1\43\1\uffff"+
        "\1\43\1\130\1\131\1\uffff\1\43\1\133\1\134\1\135\3\43\1\141\4\43"+
        "\2\uffff\1\146\3\uffff\2\43\1\151\1\uffff\1\43\1\153\1\43\1\155"+
        "\1\uffff\1\43\1\157\1\uffff\1\160\1\uffff\1\161\1\uffff\1\162\4"+
        "\uffff";
    static final String DFA6_eofS =
        "\163\uffff";
    static final String DFA6_minS =
        "\1\11\1\164\4\uffff\1\141\2\uffff\1\76\1\145\2\75\1\46\1\63\1\157"+
        "\1\uffff\1\145\1\165\1\75\1\145\1\150\1\154\1\uffff\1\145\1\50\1"+
        "\uffff\1\162\2\uffff\1\162\2\uffff\1\52\4\uffff\1\162\1\60\1\154"+
        "\2\uffff\1\143\6\uffff\1\62\1\60\1\157\1\156\1\164\2\uffff\1\164"+
        "\1\151\1\163\1\143\4\uffff\1\151\1\165\3\uffff\1\165\1\uffff\1\163"+
        "\2\60\1\uffff\1\154\3\60\1\165\1\154\1\145\1\60\1\156\1\145\1\143"+
        "\1\145\2\uffff\1\60\3\uffff\1\162\1\145\1\60\1\uffff\1\164\1\60"+
        "\1\164\1\60\1\uffff\1\156\1\60\1\uffff\1\60\1\uffff\1\60\1\uffff"+
        "\1\60\4\uffff";
    static final String DFA6_maxS =
        "\1\175\1\164\4\uffff\1\156\2\uffff\1\76\1\145\2\75\1\46\1\146\1"+
        "\157\1\uffff\1\145\1\165\1\75\1\145\1\150\1\154\1\uffff\1\145\1"+
        "\133\1\uffff\1\162\2\uffff\1\162\2\uffff\1\57\4\uffff\1\162\1\172"+
        "\1\154\2\uffff\1\143\6\uffff\1\62\1\172\1\157\2\164\2\uffff\1\164"+
        "\1\151\1\163\1\143\4\uffff\1\151\1\165\3\uffff\1\165\1\uffff\1\163"+
        "\2\172\1\uffff\1\154\3\172\1\165\1\154\1\145\1\172\1\156\1\145\1"+
        "\143\1\145\2\uffff\1\172\3\uffff\1\162\1\145\1\172\1\uffff\1\164"+
        "\1\172\1\164\1\172\1\uffff\1\156\1\172\1\uffff\1\172\1\uffff\1\172"+
        "\1\uffff\1\172\4\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\7\uffff\1\20\6\uffff\1"+
        "\30\2\uffff\1\34\1\uffff\1\37\1\40\1\uffff\1\44\1\46\1\uffff\1\55"+
        "\1\56\1\57\1\60\3\uffff\1\11\1\45\1\uffff\1\50\1\13\1\51\1\14\1"+
        "\31\1\15\5\uffff\1\52\1\23\4\uffff\1\33\1\36\1\53\1\54\2\uffff\1"+
        "\61\1\62\1\47\1\uffff\1\6\3\uffff\1\26\14\uffff\1\12\1\16\1\uffff"+
        "\1\21\1\41\1\22\3\uffff\1\32\4\uffff\1\17\2\uffff\1\27\1\uffff\1"+
        "\42\1\uffff\1\43\1\uffff\1\25\1\35\1\1\1\24";
    static final String DFA6_specialS =
        "\163\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\45\1\44\2\uffff\1\44\22\uffff\1\45\1\31\4\uffff\1\15\1\uffff"+
            "\1\7\1\10\1\40\1\37\1\4\1\11\1\35\1\41\12\42\1\3\1\20\1\13\1"+
            "\23\1\14\2\uffff\25\43\1\12\4\43\1\34\1\uffff\1\32\3\uffff\1"+
            "\43\1\17\2\43\1\26\1\6\2\43\1\16\2\43\1\21\1\22\2\43\1\33\1"+
            "\43\1\24\1\1\1\36\1\43\1\30\1\25\3\43\1\2\1\27\1\5",
            "\1\46",
            "",
            "",
            "",
            "",
            "\1\50\14\uffff\1\47",
            "",
            "",
            "\1\51",
            "\1\53",
            "\1\54",
            "\1\56",
            "\1\60",
            "\1\62\62\uffff\1\63",
            "\1\64",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "\1\74",
            "\1\76\24\uffff\1\77\35\uffff\1\75",
            "",
            "\1\101",
            "",
            "",
            "\1\102",
            "",
            "",
            "\1\103\4\uffff\1\104",
            "",
            "",
            "",
            "",
            "\1\106",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\110",
            "",
            "",
            "\1\111",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\112",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\114",
            "\1\116\5\uffff\1\115",
            "\1\117",
            "",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "",
            "",
            "",
            "",
            "\1\124",
            "\1\125",
            "",
            "",
            "",
            "\1\126",
            "",
            "\1\127",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\132",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\136",
            "\1\137",
            "\1\140",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "",
            "\1\147",
            "\1\150",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\152",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\154",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\156",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | CST_ENT | IDF | NEWLINE | WS | COMMENT | COMMENTLINE );";
        }
    }
 

}
