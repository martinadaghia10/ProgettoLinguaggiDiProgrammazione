// Generated from /Users/martinadaghia/Desktop/ProgettoLinguaggi/src/SimpLanPlus.g4 by ANTLR 4.12.0
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpLanPlusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, INTEGER=27, ID=28, WS=29, LINECOMENTS=30, BLOCKCOMENTS=31, 
		ERR=32;
	public static final int
		RULE_prog = 0, RULE_dec = 1, RULE_param = 2, RULE_body = 3, RULE_type = 4, 
		RULE_stm = 5, RULE_exp = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dec", "param", "body", "type", "stm", "exp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "','", "')'", "'{'", "'}'", "'int'", "'bool'", "'void'", 
			"'='", "'if'", "'else'", "'true'", "'false'", "'!'", "'*'", "'/'", "'+'", 
			"'-'", "'>'", "'<'", "'>='", "'<='", "'=='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", 
			"ERR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "SimpLanPlus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpLanPlusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			int _alt;
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case INTEGER:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				exp(0);
				}
				break;
			case T__6:
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(15);
					dec();
					}
					}
					setState(18); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0) );
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(20);
						stm();
						}
						} 
					}
					setState(25);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 402712580L) != 0)) {
					{
					setState(26);
					exp(0);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class DecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dec);
		int _la;
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				type();
				setState(32);
				match(ID);
				setState(33);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				type();
				setState(36);
				match(ID);
				setState(37);
				match(T__1);
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) {
					{
					setState(38);
					param();
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(39);
						match(T__2);
						setState(40);
						param();
						}
						}
						setState(45);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(48);
				match(T__3);
				setState(49);
				match(T__4);
				setState(50);
				body();
				setState(51);
				match(T__5);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			type();
			setState(56);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) {
				{
				{
				setState(58);
				dec();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(64);
					stm();
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 402712580L) != 0)) {
				{
				setState(70);
				exp(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public StmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmContext stm() throws RecognitionException {
		StmContext _localctx = new StmContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stm);
		int _la;
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(ID);
				setState(76);
				match(T__9);
				setState(77);
				exp(0);
				setState(78);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(ID);
				setState(81);
				match(T__1);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 402712580L) != 0)) {
					{
					setState(82);
					exp(0);
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(83);
						match(T__2);
						setState(84);
						exp(0);
						}
						}
						setState(89);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(92);
				match(T__3);
				setState(93);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(T__10);
				setState(95);
				match(T__1);
				setState(96);
				exp(0);
				setState(97);
				match(T__3);
				setState(98);
				match(T__4);
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					stm();
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__10 || _la==ID );
				setState(104);
				match(T__5);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(105);
					match(T__11);
					setState(106);
					match(T__4);
					setState(108); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(107);
						stm();
						}
						}
						setState(110); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__10 || _la==ID );
					setState(112);
					match(T__5);
					}
				}

				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SimpLanPlusParser.INTEGER, 0); }
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(119);
				match(INTEGER);
				}
				break;
			case 2:
				{
				setState(120);
				match(T__12);
				}
				break;
			case 3:
				{
				setState(121);
				match(T__13);
				}
				break;
			case 4:
				{
				setState(122);
				match(ID);
				}
				break;
			case 5:
				{
				setState(123);
				match(T__14);
				setState(124);
				exp(8);
				}
				break;
			case 6:
				{
				setState(125);
				match(T__10);
				setState(126);
				match(T__1);
				setState(127);
				exp(0);
				setState(128);
				match(T__3);
				setState(129);
				match(T__4);
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(130);
						stm();
						}
						} 
					}
					setState(135);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(136);
				exp(0);
				setState(137);
				match(T__5);
				setState(138);
				match(T__11);
				setState(139);
				match(T__4);
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(140);
						stm();
						}
						} 
					}
					setState(145);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(146);
				exp(0);
				setState(147);
				match(T__5);
				}
				break;
			case 7:
				{
				setState(149);
				match(T__1);
				setState(150);
				exp(0);
				setState(151);
				match(T__3);
				}
				break;
			case 8:
				{
				setState(153);
				match(ID);
				setState(154);
				match(T__1);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 402712580L) != 0)) {
					{
					setState(155);
					exp(0);
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(156);
						match(T__2);
						setState(157);
						exp(0);
						}
						}
						setState(162);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(165);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(180);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(168);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(169);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(170);
						exp(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(171);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(172);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(173);
						exp(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(174);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(175);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32505856L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(176);
						exp(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(177);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(178);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(179);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u00ba\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u0011\b\u0000\u000b\u0000\f\u0000\u0012\u0001\u0000\u0005\u0000"+
		"\u0016\b\u0000\n\u0000\f\u0000\u0019\t\u0000\u0001\u0000\u0003\u0000\u001c"+
		"\b\u0000\u0003\u0000\u001e\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001*\b\u0001\n\u0001\f\u0001-\t\u0001\u0003\u0001"+
		"/\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00016\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0005\u0003<\b\u0003\n\u0003\f\u0003?\t\u0003\u0001\u0003\u0005\u0003"+
		"B\b\u0003\n\u0003\f\u0003E\t\u0003\u0001\u0003\u0003\u0003H\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005V\b\u0005\n\u0005\f\u0005Y\t\u0005\u0003\u0005[\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0004\u0005e\b\u0005\u000b\u0005\f\u0005f\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005m\b\u0005\u000b\u0005\f\u0005"+
		"n\u0001\u0005\u0001\u0005\u0003\u0005s\b\u0005\u0003\u0005u\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u0084\b\u0006\n\u0006\f\u0006\u0087\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u008e\b\u0006"+
		"\n\u0006\f\u0006\u0091\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u009f\b\u0006\n\u0006\f\u0006"+
		"\u00a2\t\u0006\u0003\u0006\u00a4\b\u0006\u0001\u0006\u0003\u0006\u00a7"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u00b5\b\u0006\n\u0006\f\u0006\u00b8\t\u0006\u0001\u0006"+
		"\u0000\u0001\f\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0005\u0001\u0000"+
		"\u0007\t\u0001\u0000\u0010\u0011\u0001\u0000\u0012\u0013\u0001\u0000\u0014"+
		"\u0018\u0001\u0000\u0019\u001a\u00d2\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u00025\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u0006="+
		"\u0001\u0000\u0000\u0000\bI\u0001\u0000\u0000\u0000\nt\u0001\u0000\u0000"+
		"\u0000\f\u00a6\u0001\u0000\u0000\u0000\u000e\u001e\u0003\f\u0006\u0000"+
		"\u000f\u0011\u0003\u0002\u0001\u0000\u0010\u000f\u0001\u0000\u0000\u0000"+
		"\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0010\u0001\u0000\u0000\u0000"+
		"\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0017\u0001\u0000\u0000\u0000"+
		"\u0014\u0016\u0003\n\u0005\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016"+
		"\u0019\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019"+
		"\u0017\u0001\u0000\u0000\u0000\u001a\u001c\u0003\f\u0006\u0000\u001b\u001a"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001e"+
		"\u0001\u0000\u0000\u0000\u001d\u000e\u0001\u0000\u0000\u0000\u001d\u0010"+
		"\u0001\u0000\u0000\u0000\u001e\u0001\u0001\u0000\u0000\u0000\u001f \u0003"+
		"\b\u0004\u0000 !\u0005\u001c\u0000\u0000!\"\u0005\u0001\u0000\u0000\""+
		"6\u0001\u0000\u0000\u0000#$\u0003\b\u0004\u0000$%\u0005\u001c\u0000\u0000"+
		"%.\u0005\u0002\u0000\u0000&+\u0003\u0004\u0002\u0000\'(\u0005\u0003\u0000"+
		"\u0000(*\u0003\u0004\u0002\u0000)\'\u0001\u0000\u0000\u0000*-\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,/\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000.&\u0001\u0000\u0000\u0000"+
		"./\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000001\u0005\u0004\u0000"+
		"\u000012\u0005\u0005\u0000\u000023\u0003\u0006\u0003\u000034\u0005\u0006"+
		"\u0000\u000046\u0001\u0000\u0000\u00005\u001f\u0001\u0000\u0000\u0000"+
		"5#\u0001\u0000\u0000\u00006\u0003\u0001\u0000\u0000\u000078\u0003\b\u0004"+
		"\u000089\u0005\u001c\u0000\u00009\u0005\u0001\u0000\u0000\u0000:<\u0003"+
		"\u0002\u0001\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>C\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000@B\u0003\n\u0005\u0000A@\u0001\u0000\u0000"+
		"\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000FH\u0003"+
		"\f\u0006\u0000GF\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0007"+
		"\u0001\u0000\u0000\u0000IJ\u0007\u0000\u0000\u0000J\t\u0001\u0000\u0000"+
		"\u0000KL\u0005\u001c\u0000\u0000LM\u0005\n\u0000\u0000MN\u0003\f\u0006"+
		"\u0000NO\u0005\u0001\u0000\u0000Ou\u0001\u0000\u0000\u0000PQ\u0005\u001c"+
		"\u0000\u0000QZ\u0005\u0002\u0000\u0000RW\u0003\f\u0006\u0000ST\u0005\u0003"+
		"\u0000\u0000TV\u0003\f\u0006\u0000US\u0001\u0000\u0000\u0000VY\u0001\u0000"+
		"\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X[\u0001"+
		"\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000ZR\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0005\u0004\u0000"+
		"\u0000]u\u0005\u0001\u0000\u0000^_\u0005\u000b\u0000\u0000_`\u0005\u0002"+
		"\u0000\u0000`a\u0003\f\u0006\u0000ab\u0005\u0004\u0000\u0000bd\u0005\u0005"+
		"\u0000\u0000ce\u0003\n\u0005\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000"+
		"\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001"+
		"\u0000\u0000\u0000hr\u0005\u0006\u0000\u0000ij\u0005\f\u0000\u0000jl\u0005"+
		"\u0005\u0000\u0000km\u0003\n\u0005\u0000lk\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000pq\u0005\u0006\u0000\u0000qs\u0001\u0000\u0000"+
		"\u0000ri\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000"+
		"\u0000\u0000tK\u0001\u0000\u0000\u0000tP\u0001\u0000\u0000\u0000t^\u0001"+
		"\u0000\u0000\u0000u\u000b\u0001\u0000\u0000\u0000vw\u0006\u0006\uffff"+
		"\uffff\u0000w\u00a7\u0005\u001b\u0000\u0000x\u00a7\u0005\r\u0000\u0000"+
		"y\u00a7\u0005\u000e\u0000\u0000z\u00a7\u0005\u001c\u0000\u0000{|\u0005"+
		"\u000f\u0000\u0000|\u00a7\u0003\f\u0006\b}~\u0005\u000b\u0000\u0000~\u007f"+
		"\u0005\u0002\u0000\u0000\u007f\u0080\u0003\f\u0006\u0000\u0080\u0081\u0005"+
		"\u0004\u0000\u0000\u0081\u0085\u0005\u0005\u0000\u0000\u0082\u0084\u0003"+
		"\n\u0005\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000"+
		"\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0003\f\u0006\u0000\u0089\u008a\u0005\u0006\u0000"+
		"\u0000\u008a\u008b\u0005\f\u0000\u0000\u008b\u008f\u0005\u0005\u0000\u0000"+
		"\u008c\u008e\u0003\n\u0005\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0093\u0003\f\u0006\u0000\u0093\u0094"+
		"\u0005\u0006\u0000\u0000\u0094\u00a7\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0005\u0002\u0000\u0000\u0096\u0097\u0003\f\u0006\u0000\u0097\u0098\u0005"+
		"\u0004\u0000\u0000\u0098\u00a7\u0001\u0000\u0000\u0000\u0099\u009a\u0005"+
		"\u001c\u0000\u0000\u009a\u00a3\u0005\u0002\u0000\u0000\u009b\u00a0\u0003"+
		"\f\u0006\u0000\u009c\u009d\u0005\u0003\u0000\u0000\u009d\u009f\u0003\f"+
		"\u0006\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a3\u009b\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a7\u0005\u0004"+
		"\u0000\u0000\u00a6v\u0001\u0000\u0000\u0000\u00a6x\u0001\u0000\u0000\u0000"+
		"\u00a6y\u0001\u0000\u0000\u0000\u00a6z\u0001\u0000\u0000\u0000\u00a6{"+
		"\u0001\u0000\u0000\u0000\u00a6}\u0001\u0000\u0000\u0000\u00a6\u0095\u0001"+
		"\u0000\u0000\u0000\u00a6\u0099\u0001\u0000\u0000\u0000\u00a7\u00b6\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\n\u0007\u0000\u0000\u00a9\u00aa\u0007\u0001"+
		"\u0000\u0000\u00aa\u00b5\u0003\f\u0006\b\u00ab\u00ac\n\u0006\u0000\u0000"+
		"\u00ac\u00ad\u0007\u0002\u0000\u0000\u00ad\u00b5\u0003\f\u0006\u0007\u00ae"+
		"\u00af\n\u0005\u0000\u0000\u00af\u00b0\u0007\u0003\u0000\u0000\u00b0\u00b5"+
		"\u0003\f\u0006\u0006\u00b1\u00b2\n\u0004\u0000\u0000\u00b2\u00b3\u0007"+
		"\u0004\u0000\u0000\u00b3\u00b5\u0003\f\u0006\u0005\u00b4\u00a8\u0001\u0000"+
		"\u0000\u0000\u00b4\u00ab\u0001\u0000\u0000\u0000\u00b4\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7\r\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000"+
		"\u0000\u0017\u0012\u0017\u001b\u001d+.5=CGWZfnrt\u0085\u008f\u00a0\u00a3"+
		"\u00a6\u00b4\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}