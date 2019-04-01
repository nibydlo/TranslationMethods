// Generated from /home/dmitry/Desktop/translation_methods/HW4_2/Grammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, RETURN=2, LSB=3, RSB=4, LCB=5, RCB=6, PIPE=7, NL=8, SC=9, COL=10, 
		EQ=11, WS=12, IGNORE=13, CODE=14, REGEX=15, VARNAME=16, TOKENNAME=17, 
		RULENAME=18, VARTYPE=19, ANY=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "RETURN", "LSB", "RSB", "LCB", "RCB", "PIPE", "NL", "SC", "COL", 
		"EQ", "WS", "IGNORE", "CODE", "REGEX", "VARNAME", "TOKENNAME", "RULENAME", 
		"VARTYPE", "ANY"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'return'", "'['", "']'", "'{'", "'}'", "'|'", "'\n'", "';'", 
		"':'", "'='", null, "'IGNORE'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "RETURN", "LSB", "RSB", "LCB", "RCB", "PIPE", "NL", "SC", 
		"COL", "EQ", "WS", "IGNORE", "CODE", "REGEX", "VARNAME", "TOKENNAME", 
		"RULENAME", "VARTYPE", "ANY"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0085\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\6\rH\n\r\r\r\16\rI\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\7\17W\n\17\f\17\16\17Z\13\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\7\20b\n\20\f\20\16\20e\13\20\3\20\3\20\3\21\3\21\6\21k\n\21\r\21\16"+
		"\21l\3\22\6\22p\n\22\r\22\16\22q\3\23\3\23\7\23v\n\23\f\23\16\23y\13\23"+
		"\3\24\3\24\6\24}\n\24\r\24\16\24~\3\25\6\25\u0082\n\25\r\25\16\25\u0083"+
		"\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26\3\2\13\5\2\13\13\17\17\"\"\4\2}}\177"+
		"\177\4\2$$))\6\2\62;C\\aac|\3\2C\\\3\2c|\4\2C\\c|\b\2..\60\60>>@@C\\c"+
		"|\t\2$$)+\62;C\\^^aac|\2\u008d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3"+
		"+\3\2\2\2\5-\3\2\2\2\7\64\3\2\2\2\t\66\3\2\2\2\138\3\2\2\2\r:\3\2\2\2"+
		"\17<\3\2\2\2\21>\3\2\2\2\23@\3\2\2\2\25B\3\2\2\2\27D\3\2\2\2\31G\3\2\2"+
		"\2\33M\3\2\2\2\35T\3\2\2\2\37]\3\2\2\2!h\3\2\2\2#o\3\2\2\2%s\3\2\2\2\'"+
		"z\3\2\2\2)\u0081\3\2\2\2+,\7.\2\2,\4\3\2\2\2-.\7t\2\2./\7g\2\2/\60\7v"+
		"\2\2\60\61\7w\2\2\61\62\7t\2\2\62\63\7p\2\2\63\6\3\2\2\2\64\65\7]\2\2"+
		"\65\b\3\2\2\2\66\67\7_\2\2\67\n\3\2\2\289\7}\2\29\f\3\2\2\2:;\7\177\2"+
		"\2;\16\3\2\2\2<=\7~\2\2=\20\3\2\2\2>?\7\f\2\2?\22\3\2\2\2@A\7=\2\2A\24"+
		"\3\2\2\2BC\7<\2\2C\26\3\2\2\2DE\7?\2\2E\30\3\2\2\2FH\t\2\2\2GF\3\2\2\2"+
		"HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\b\r\2\2L\32\3\2\2\2MN\7K\2"+
		"\2NO\7I\2\2OP\7P\2\2PQ\7Q\2\2QR\7T\2\2RS\7G\2\2S\34\3\2\2\2TX\7}\2\2U"+
		"W\n\3\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2"+
		"[\\\7\177\2\2\\\36\3\2\2\2]c\7$\2\2^b\n\4\2\2_`\7^\2\2`b\7$\2\2a^\3\2"+
		"\2\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7$"+
		"\2\2g \3\2\2\2hj\7&\2\2ik\t\5\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2"+
		"\2\2m\"\3\2\2\2np\t\6\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r$\3"+
		"\2\2\2sw\t\7\2\2tv\t\b\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x&\3"+
		"\2\2\2yw\3\2\2\2z|\t\6\2\2{}\t\t\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177"+
		"\3\2\2\2\177(\3\2\2\2\u0080\u0082\t\n\2\2\u0081\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084*\3\2\2\2\f\2IX"+
		"aclqw~\u0083\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}