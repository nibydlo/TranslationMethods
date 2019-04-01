// Generated from /home/dmitry/Desktop/translation_methods/HW4_2/Grammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, RETURN=2, LSB=3, RSB=4, LCB=5, RCB=6, PIPE=7, NL=8, SC=9, COL=10, 
		EQ=11, WS=12, IGNORE=13, CODE=14, REGEX=15, VARNAME=16, TOKENNAME=17, 
		RULENAME=18, VARTYPE=19, ANY=20;
	public static final int
		RULE_input = 0, RULE_ignoreRule = 1, RULE_ruleSeq = 2, RULE_setToken = 3, 
		RULE_setRule = 4, RULE_option = 5, RULE_arguments = 6, RULE_initVar = 7, 
		RULE_retValue = 8, RULE_rightPart = 9, RULE_rightPartElem = 10, RULE_passArguments = 11, 
		RULE_argument = 12, RULE_code = 13;
	public static final String[] ruleNames = {
		"input", "ignoreRule", "ruleSeq", "setToken", "setRule", "option", "arguments", 
		"initVar", "retValue", "rightPart", "rightPartElem", "passArguments", 
		"argument", "code"
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

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	 
		public InputContext() { }
		public void copyFrom(InputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToExprSeqContext extends InputContext {
		public IgnoreRuleContext ignoreRule() {
			return getRuleContext(IgnoreRuleContext.class,0);
		}
		public TerminalNode NL() { return getToken(GrammarParser.NL, 0); }
		public RuleSeqContext ruleSeq() {
			return getRuleContext(RuleSeqContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public ToExprSeqContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitToExprSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_input);
		try {
			_localctx = new ToExprSeqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			ignoreRule();
			setState(29);
			match(NL);
			setState(30);
			ruleSeq();
			setState(31);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IgnoreRuleContext extends ParserRuleContext {
		public IgnoreRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ignoreRule; }
	 
		public IgnoreRuleContext() { }
		public void copyFrom(IgnoreRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignIgnoreContext extends IgnoreRuleContext {
		public TerminalNode IGNORE() { return getToken(GrammarParser.IGNORE, 0); }
		public TerminalNode COL() { return getToken(GrammarParser.COL, 0); }
		public TerminalNode REGEX() { return getToken(GrammarParser.REGEX, 0); }
		public AssignIgnoreContext(IgnoreRuleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAssignIgnore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IgnoreRuleContext ignoreRule() throws RecognitionException {
		IgnoreRuleContext _localctx = new IgnoreRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ignoreRule);
		try {
			_localctx = new AssignIgnoreContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(IGNORE);
			setState(34);
			match(COL);
			setState(35);
			match(REGEX);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleSeqContext extends ParserRuleContext {
		public RuleSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleSeq; }
	 
		public RuleSeqContext() { }
		public void copyFrom(RuleSeqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToAssignRuleContext extends RuleSeqContext {
		public SetRuleContext setRule() {
			return getRuleContext(SetRuleContext.class,0);
		}
		public TerminalNode NL() { return getToken(GrammarParser.NL, 0); }
		public RuleSeqContext ruleSeq() {
			return getRuleContext(RuleSeqContext.class,0);
		}
		public ToAssignRuleContext(RuleSeqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitToAssignRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EndOfInputContext extends RuleSeqContext {
		public EndOfInputContext(RuleSeqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitEndOfInput(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewLineContext extends RuleSeqContext {
		public TerminalNode NL() { return getToken(GrammarParser.NL, 0); }
		public RuleSeqContext ruleSeq() {
			return getRuleContext(RuleSeqContext.class,0);
		}
		public NewLineContext(RuleSeqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNewLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToAssignTokenContext extends RuleSeqContext {
		public SetTokenContext setToken() {
			return getRuleContext(SetTokenContext.class,0);
		}
		public TerminalNode NL() { return getToken(GrammarParser.NL, 0); }
		public RuleSeqContext ruleSeq() {
			return getRuleContext(RuleSeqContext.class,0);
		}
		public ToAssignTokenContext(RuleSeqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitToAssignToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleSeqContext ruleSeq() throws RecognitionException {
		RuleSeqContext _localctx = new RuleSeqContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ruleSeq);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKENNAME:
				_localctx = new ToAssignTokenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				setToken();
				setState(38);
				match(NL);
				setState(39);
				ruleSeq();
				}
				break;
			case RULENAME:
				_localctx = new ToAssignRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				setRule();
				setState(42);
				match(NL);
				setState(43);
				ruleSeq();
				}
				break;
			case NL:
				_localctx = new NewLineContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				match(NL);
				setState(46);
				ruleSeq();
				}
				break;
			case EOF:
				_localctx = new EndOfInputContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetTokenContext extends ParserRuleContext {
		public SetTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setToken; }
	 
		public SetTokenContext() { }
		public void copyFrom(SetTokenContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignTokenContext extends SetTokenContext {
		public TerminalNode TOKENNAME() { return getToken(GrammarParser.TOKENNAME, 0); }
		public TerminalNode COL() { return getToken(GrammarParser.COL, 0); }
		public TerminalNode REGEX() { return getToken(GrammarParser.REGEX, 0); }
		public AssignTokenContext(SetTokenContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAssignToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetTokenContext setToken() throws RecognitionException {
		SetTokenContext _localctx = new SetTokenContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_setToken);
		try {
			_localctx = new AssignTokenContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(TOKENNAME);
			setState(51);
			match(COL);
			setState(52);
			match(REGEX);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetRuleContext extends ParserRuleContext {
		public SetRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setRule; }
	 
		public SetRuleContext() { }
		public void copyFrom(SetRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignRuleContext extends SetRuleContext {
		public TerminalNode RULENAME() { return getToken(GrammarParser.RULENAME, 0); }
		public TerminalNode COL() { return getToken(GrammarParser.COL, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public TerminalNode LSB() { return getToken(GrammarParser.LSB, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RSB() { return getToken(GrammarParser.RSB, 0); }
		public TerminalNode RETURN() { return getToken(GrammarParser.RETURN, 0); }
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public List<TerminalNode> PIPE() { return getTokens(GrammarParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(GrammarParser.PIPE, i);
		}
		public AssignRuleContext(SetRuleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAssignRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetRuleContext setRule() throws RecognitionException {
		SetRuleContext _localctx = new SetRuleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_setRule);
		int _la;
		try {
			_localctx = new AssignRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(RULENAME);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSB) {
				{
				setState(55);
				match(LSB);
				setState(56);
				arguments();
				setState(57);
				match(RSB);
				}
			}

			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(61);
				match(RETURN);
				setState(62);
				match(CODE);
				}
			}

			setState(65);
			match(COL);
			setState(66);
			option();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(67);
				match(PIPE);
				setState(68);
				option();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionContext extends ParserRuleContext {
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
	 
		public OptionContext() { }
		public void copyFrom(OptionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InOptionContext extends OptionContext {
		public List<RightPartElemContext> rightPartElem() {
			return getRuleContexts(RightPartElemContext.class);
		}
		public RightPartElemContext rightPartElem(int i) {
			return getRuleContext(RightPartElemContext.class,i);
		}
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public InOptionContext(OptionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitInOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_option);
		int _la;
		try {
			int _alt;
			_localctx = new InOptionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(75); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(74);
					rightPartElem();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(77); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(79);
				match(CODE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	 
		public ArgumentsContext() { }
		public void copyFrom(ArgumentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToInitVarContext extends ArgumentsContext {
		public List<InitVarContext> initVar() {
			return getRuleContexts(InitVarContext.class);
		}
		public InitVarContext initVar(int i) {
			return getRuleContext(InitVarContext.class,i);
		}
		public ToInitVarContext(ArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitToInitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arguments);
		int _la;
		try {
			_localctx = new ToInitVarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			initVar();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(83);
				match(T__0);
				setState(84);
				initVar();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitVarContext extends ParserRuleContext {
		public InitVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initVar; }
	 
		public InitVarContext() { }
		public void copyFrom(InitVarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InitializeVarContext extends InitVarContext {
		public TerminalNode VARTYPE() { return getToken(GrammarParser.VARTYPE, 0); }
		public TerminalNode VARNAME() { return getToken(GrammarParser.VARNAME, 0); }
		public InitializeVarContext(InitVarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitInitializeVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitVarContext initVar() throws RecognitionException {
		InitVarContext _localctx = new InitVarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_initVar);
		try {
			_localctx = new InitializeVarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(VARTYPE);
			setState(91);
			match(VARNAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetValueContext extends ParserRuleContext {
		public RetValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retValue; }
	 
		public RetValueContext() { }
		public void copyFrom(RetValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnValueContext extends RetValueContext {
		public TerminalNode VARTYPE() { return getToken(GrammarParser.VARTYPE, 0); }
		public TerminalNode VARNAME() { return getToken(GrammarParser.VARNAME, 0); }
		public TerminalNode TOKENNAME() { return getToken(GrammarParser.TOKENNAME, 0); }
		public TerminalNode RULENAME() { return getToken(GrammarParser.RULENAME, 0); }
		public TerminalNode EQ() { return getToken(GrammarParser.EQ, 0); }
		public TerminalNode ANY() { return getToken(GrammarParser.ANY, 0); }
		public ReturnValueContext(RetValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitReturnValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetValueContext retValue() throws RecognitionException {
		RetValueContext _localctx = new RetValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_retValue);
		int _la;
		try {
			_localctx = new ReturnValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(VARTYPE);
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VARNAME) | (1L << TOKENNAME) | (1L << RULENAME))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(95);
				match(EQ);
				setState(96);
				match(ANY);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RightPartContext extends ParserRuleContext {
		public RightPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightPart; }
	 
		public RightPartContext() { }
		public void copyFrom(RightPartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignRightPartContext extends RightPartContext {
		public List<RightPartElemContext> rightPartElem() {
			return getRuleContexts(RightPartElemContext.class);
		}
		public RightPartElemContext rightPartElem(int i) {
			return getRuleContext(RightPartElemContext.class,i);
		}
		public AssignRightPartContext(RightPartContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAssignRightPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightPartContext rightPart() throws RecognitionException {
		RightPartContext _localctx = new RightPartContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rightPart);
		int _la;
		try {
			_localctx = new AssignRightPartContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				rightPartElem();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CODE) | (1L << TOKENNAME) | (1L << RULENAME))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RightPartElemContext extends ParserRuleContext {
		public RightPartElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightPartElem; }
	 
		public RightPartElemContext() { }
		public void copyFrom(RightPartElemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RightPartElemCodeContext extends RightPartElemContext {
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public RightPartElemCodeContext(RightPartElemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitRightPartElemCode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToPassArgumentsContext extends RightPartElemContext {
		public TerminalNode RULENAME() { return getToken(GrammarParser.RULENAME, 0); }
		public TerminalNode LSB() { return getToken(GrammarParser.LSB, 0); }
		public PassArgumentsContext passArguments() {
			return getRuleContext(PassArgumentsContext.class,0);
		}
		public TerminalNode RSB() { return getToken(GrammarParser.RSB, 0); }
		public ToPassArgumentsContext(RightPartElemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitToPassArguments(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RightPartElemTokenContext extends RightPartElemContext {
		public TerminalNode TOKENNAME() { return getToken(GrammarParser.TOKENNAME, 0); }
		public RightPartElemTokenContext(RightPartElemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitRightPartElemToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightPartElemContext rightPartElem() throws RecognitionException {
		RightPartElemContext _localctx = new RightPartElemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rightPartElem);
		int _la;
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RULENAME:
				_localctx = new ToPassArgumentsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(RULENAME);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSB) {
					{
					setState(105);
					match(LSB);
					setState(106);
					passArguments();
					setState(107);
					match(RSB);
					}
				}

				}
				break;
			case TOKENNAME:
				_localctx = new RightPartElemTokenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(TOKENNAME);
				}
				break;
			case CODE:
				_localctx = new RightPartElemCodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(CODE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PassArgumentsContext extends ParserRuleContext {
		public PassArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passArguments; }
	 
		public PassArgumentsContext() { }
		public void copyFrom(PassArgumentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PassingVariablesContext extends PassArgumentsContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public PassingVariablesContext(PassArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPassingVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PassArgumentsContext passArguments() throws RecognitionException {
		PassArgumentsContext _localctx = new PassArgumentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_passArguments);
		int _la;
		try {
			_localctx = new PassingVariablesContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			argument();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(116);
				match(T__0);
				setState(117);
				argument();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode ANY() { return getToken(GrammarParser.ANY, 0); }
		public TerminalNode TOKENNAME() { return getToken(GrammarParser.TOKENNAME, 0); }
		public TerminalNode RULENAME() { return getToken(GrammarParser.RULENAME, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TOKENNAME) | (1L << RULENAME) | (1L << ANY))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeContext extends ParserRuleContext {
		public TerminalNode ANY() { return getToken(GrammarParser.ANY, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(ANY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u0082\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\63\n\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6>\n\6\3\6\3\6\5\6B\n\6\3\6\3\6\3\6\3"+
		"\6\7\6H\n\6\f\6\16\6K\13\6\3\7\6\7N\n\7\r\7\16\7O\3\7\5\7S\n\7\3\b\3\b"+
		"\3\b\7\bX\n\b\f\b\16\b[\13\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\nd\n\n\3\13"+
		"\6\13g\n\13\r\13\16\13h\3\f\3\f\3\f\3\f\3\f\5\fp\n\f\3\f\3\f\5\ft\n\f"+
		"\3\r\3\r\3\r\7\ry\n\r\f\r\16\r|\13\r\3\16\3\16\3\17\3\17\3\17\2\2\20\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\2\4\3\2\22\24\4\2\23\24\26\26\2\u0082"+
		"\2\36\3\2\2\2\4#\3\2\2\2\6\62\3\2\2\2\b\64\3\2\2\2\n8\3\2\2\2\fM\3\2\2"+
		"\2\16T\3\2\2\2\20\\\3\2\2\2\22_\3\2\2\2\24f\3\2\2\2\26s\3\2\2\2\30u\3"+
		"\2\2\2\32}\3\2\2\2\34\177\3\2\2\2\36\37\5\4\3\2\37 \7\n\2\2 !\5\6\4\2"+
		"!\"\7\2\2\3\"\3\3\2\2\2#$\7\17\2\2$%\7\f\2\2%&\7\21\2\2&\5\3\2\2\2\'("+
		"\5\b\5\2()\7\n\2\2)*\5\6\4\2*\63\3\2\2\2+,\5\n\6\2,-\7\n\2\2-.\5\6\4\2"+
		".\63\3\2\2\2/\60\7\n\2\2\60\63\5\6\4\2\61\63\3\2\2\2\62\'\3\2\2\2\62+"+
		"\3\2\2\2\62/\3\2\2\2\62\61\3\2\2\2\63\7\3\2\2\2\64\65\7\23\2\2\65\66\7"+
		"\f\2\2\66\67\7\21\2\2\67\t\3\2\2\28=\7\24\2\29:\7\5\2\2:;\5\16\b\2;<\7"+
		"\6\2\2<>\3\2\2\2=9\3\2\2\2=>\3\2\2\2>A\3\2\2\2?@\7\4\2\2@B\7\20\2\2A?"+
		"\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\f\2\2DI\5\f\7\2EF\7\t\2\2FH\5\f\7\2G"+
		"E\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\13\3\2\2\2KI\3\2\2\2LN\5\26\f"+
		"\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QS\7\20\2\2RQ\3\2"+
		"\2\2RS\3\2\2\2S\r\3\2\2\2TY\5\20\t\2UV\7\3\2\2VX\5\20\t\2WU\3\2\2\2X["+
		"\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\17\3\2\2\2[Y\3\2\2\2\\]\7\25\2\2]^\7\22"+
		"\2\2^\21\3\2\2\2_`\7\25\2\2`c\t\2\2\2ab\7\r\2\2bd\7\26\2\2ca\3\2\2\2c"+
		"d\3\2\2\2d\23\3\2\2\2eg\5\26\f\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2"+
		"\2i\25\3\2\2\2jo\7\24\2\2kl\7\5\2\2lm\5\30\r\2mn\7\6\2\2np\3\2\2\2ok\3"+
		"\2\2\2op\3\2\2\2pt\3\2\2\2qt\7\23\2\2rt\7\20\2\2sj\3\2\2\2sq\3\2\2\2s"+
		"r\3\2\2\2t\27\3\2\2\2uz\5\32\16\2vw\7\3\2\2wy\5\32\16\2xv\3\2\2\2y|\3"+
		"\2\2\2zx\3\2\2\2z{\3\2\2\2{\31\3\2\2\2|z\3\2\2\2}~\t\3\2\2~\33\3\2\2\2"+
		"\177\u0080\7\26\2\2\u0080\35\3\2\2\2\16\62=AIORYchosz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}