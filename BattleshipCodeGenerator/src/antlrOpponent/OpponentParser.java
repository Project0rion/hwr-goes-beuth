// Generated from D:\Benutzer\Project0rion\Dokumente\HwrGoesBeuth\hwr-goes-beuth\BattleshipCodeGenerator\res\Opponent.g by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OpponentParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SHOOT=1, COLUMN=2, ROW=3, PERIOD=4, WHITESPACE=5;
	public static final int
		RULE_instructions = 0, RULE_shootSentence = 1, RULE_coordinate = 2;
	public static final String[] ruleNames = {
		"instructions", "shootSentence", "coordinate"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Shoot at'", null, null, "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SHOOT", "COLUMN", "ROW", "PERIOD", "WHITESPACE"
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
	public String getGrammarFileName() { return "Opponent.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OpponentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InstructionsContext extends ParserRuleContext {
		public List<ShootSentenceContext> shootSentence() {
			return getRuleContexts(ShootSentenceContext.class);
		}
		public ShootSentenceContext shootSentence(int i) {
			return getRuleContext(ShootSentenceContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(OpponentParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(OpponentParser.WHITESPACE, i);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OpponentListener ) ((OpponentListener)listener).enterInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OpponentListener ) ((OpponentListener)listener).exitInstructions(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_instructions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(6);
				shootSentence();
				setState(8);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(7);
					match(WHITESPACE);
					}
				}

				}
				}
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SHOOT );
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

	public static class ShootSentenceContext extends ParserRuleContext {
		public TerminalNode SHOOT() { return getToken(OpponentParser.SHOOT, 0); }
		public CoordinateContext coordinate() {
			return getRuleContext(CoordinateContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(OpponentParser.PERIOD, 0); }
		public ShootSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shootSentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OpponentListener ) ((OpponentListener)listener).enterShootSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OpponentListener ) ((OpponentListener)listener).exitShootSentence(this);
		}
	}

	public final ShootSentenceContext shootSentence() throws RecognitionException {
		ShootSentenceContext _localctx = new ShootSentenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_shootSentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(SHOOT);
			setState(15);
			coordinate();
			setState(16);
			match(PERIOD);
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

	public static class CoordinateContext extends ParserRuleContext {
		public TerminalNode COLUMN() { return getToken(OpponentParser.COLUMN, 0); }
		public TerminalNode ROW() { return getToken(OpponentParser.ROW, 0); }
		public CoordinateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OpponentListener ) ((OpponentListener)listener).enterCoordinate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OpponentListener ) ((OpponentListener)listener).exitCoordinate(this);
		}
	}

	public final CoordinateContext coordinate() throws RecognitionException {
		CoordinateContext _localctx = new CoordinateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_coordinate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(COLUMN);
			setState(19);
			match(ROW);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7\30\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\5\2\13\n\2\6\2\r\n\2\r\2\16\2\16\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\2\2\5\2\4\6\2\2\26\2\f\3\2\2\2\4\20\3\2\2\2\6\24\3\2"+
		"\2\2\b\n\5\4\3\2\t\13\7\7\2\2\n\t\3\2\2\2\n\13\3\2\2\2\13\r\3\2\2\2\f"+
		"\b\3\2\2\2\r\16\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\3\3\2\2\2\20\21"+
		"\7\3\2\2\21\22\5\6\4\2\22\23\7\6\2\2\23\5\3\2\2\2\24\25\7\4\2\2\25\26"+
		"\7\5\2\2\26\7\3\2\2\2\4\n\16";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}