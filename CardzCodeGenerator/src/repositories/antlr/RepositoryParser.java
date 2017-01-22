package repositories.antlr;// Generated from Repository.g by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RepositoryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ENDLINE=11, SPACE=12, SEPARATOR=13, POINTS=14, BEHAVIOR=15, FACTION=16, 
		NUMBER=17, CHAR=18, WHITESPACE=19;
	public static final int
		RULE_file = 0, RULE_row = 1, RULE_card = 2, RULE_cardData = 3, RULE_dataFaction = 4, 
		RULE_dataHealth = 5, RULE_dataDamage = 6, RULE_dataCost = 7, RULE_dataBehavior = 8, 
		RULE_value = 9, RULE_name = 10, RULE_faction = 11, RULE_opponent = 12, 
		RULE_opponentData = 13, RULE_deck = 14, RULE_deckCard = 15;
	public static final String[] ruleNames = {
		"file", "row", "card", "cardData", "dataFaction", "dataHealth", "dataDamage", 
		"dataCost", "dataBehavior", "value", "name", "faction", "opponent", "opponentData", 
		"deck", "deckCard"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Card'", "'{'", "'}'", "'faction'", "'health'", "'damage'", "'cost'", 
		"'behavior'", "'Opponent'", "'Cards'", "';'", "' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "ENDLINE", 
		"SPACE", "SEPARATOR", "POINTS", "BEHAVIOR", "FACTION", "NUMBER", "CHAR", 
		"WHITESPACE"
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
	public String getGrammarFileName() { return "Repository.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RepositoryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RepositoryParser.EOF, 0); }
		public List<CardContext> card() {
			return getRuleContexts(CardContext.class);
		}
		public CardContext card(int i) {
			return getRuleContext(CardContext.class,i);
		}
		public List<OpponentContext> opponent() {
			return getRuleContexts(OpponentContext.class);
		}
		public OpponentContext opponent(int i) {
			return getRuleContext(OpponentContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(34);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(32);
					card();
					}
					break;
				case T__8:
					{
					setState(33);
					opponent();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==T__8 );
			setState(38);
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

	public static class RowContext extends ParserRuleContext {
		public CardContext card() {
			return getRuleContext(CardContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(RepositoryParser.ENDLINE, 0); }
		public TerminalNode WHITESPACE() { return getToken(RepositoryParser.WHITESPACE, 0); }
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitRow(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			card();
			setState(41);
			match(ENDLINE);
			setState(43);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(42);
				match(WHITESPACE);
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

	public static class CardContext extends ParserRuleContext {
		public TerminalNode SPACE() { return getToken(RepositoryParser.SPACE, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public CardDataContext cardData() {
			return getRuleContext(CardDataContext.class,0);
		}
		public CardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_card; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterCard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitCard(this);
		}
	}

	public final CardContext card() throws RecognitionException {
		CardContext _localctx = new CardContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_card);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__0);
			setState(46);
			match(SPACE);
			setState(47);
			name();
			setState(48);
			match(T__1);
			setState(49);
			cardData();
			setState(50);
			match(T__2);
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

	public static class CardDataContext extends ParserRuleContext {
		public DataFactionContext dataFaction() {
			return getRuleContext(DataFactionContext.class,0);
		}
		public DataHealthContext dataHealth() {
			return getRuleContext(DataHealthContext.class,0);
		}
		public DataDamageContext dataDamage() {
			return getRuleContext(DataDamageContext.class,0);
		}
		public DataCostContext dataCost() {
			return getRuleContext(DataCostContext.class,0);
		}
		public CardDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterCardData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitCardData(this);
		}
	}

	public final CardDataContext cardData() throws RecognitionException {
		CardDataContext _localctx = new CardDataContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cardData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			dataFaction();
			setState(53);
			dataHealth();
			setState(54);
			dataDamage();
			setState(55);
			dataCost();
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

	public static class DataFactionContext extends ParserRuleContext {
		public TerminalNode POINTS() { return getToken(RepositoryParser.POINTS, 0); }
		public FactionContext faction() {
			return getRuleContext(FactionContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(RepositoryParser.ENDLINE, 0); }
		public DataFactionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataFaction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterDataFaction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitDataFaction(this);
		}
	}

	public final DataFactionContext dataFaction() throws RecognitionException {
		DataFactionContext _localctx = new DataFactionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dataFaction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__3);
			setState(58);
			match(POINTS);
			setState(59);
			faction();
			setState(60);
			match(ENDLINE);
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

	public static class DataHealthContext extends ParserRuleContext {
		public TerminalNode POINTS() { return getToken(RepositoryParser.POINTS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(RepositoryParser.ENDLINE, 0); }
		public DataHealthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataHealth; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterDataHealth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitDataHealth(this);
		}
	}

	public final DataHealthContext dataHealth() throws RecognitionException {
		DataHealthContext _localctx = new DataHealthContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dataHealth);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__4);
			setState(63);
			match(POINTS);
			setState(64);
			value();
			setState(65);
			match(ENDLINE);
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

	public static class DataDamageContext extends ParserRuleContext {
		public TerminalNode POINTS() { return getToken(RepositoryParser.POINTS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(RepositoryParser.ENDLINE, 0); }
		public DataDamageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataDamage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterDataDamage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitDataDamage(this);
		}
	}

	public final DataDamageContext dataDamage() throws RecognitionException {
		DataDamageContext _localctx = new DataDamageContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dataDamage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__5);
			setState(68);
			match(POINTS);
			setState(69);
			value();
			setState(70);
			match(ENDLINE);
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

	public static class DataCostContext extends ParserRuleContext {
		public TerminalNode POINTS() { return getToken(RepositoryParser.POINTS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(RepositoryParser.ENDLINE, 0); }
		public DataCostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataCost; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterDataCost(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitDataCost(this);
		}
	}

	public final DataCostContext dataCost() throws RecognitionException {
		DataCostContext _localctx = new DataCostContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataCost);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__6);
			setState(73);
			match(POINTS);
			setState(74);
			value();
			setState(75);
			match(ENDLINE);
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

	public static class DataBehaviorContext extends ParserRuleContext {
		public TerminalNode POINTS() { return getToken(RepositoryParser.POINTS, 0); }
		public TerminalNode BEHAVIOR() { return getToken(RepositoryParser.BEHAVIOR, 0); }
		public TerminalNode ENDLINE() { return getToken(RepositoryParser.ENDLINE, 0); }
		public DataBehaviorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataBehavior; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterDataBehavior(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitDataBehavior(this);
		}
	}

	public final DataBehaviorContext dataBehavior() throws RecognitionException {
		DataBehaviorContext _localctx = new DataBehaviorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dataBehavior);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__7);
			setState(78);
			match(POINTS);
			setState(79);
			match(BEHAVIOR);
			setState(80);
			match(ENDLINE);
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

	public static class ValueContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(RepositoryParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(RepositoryParser.NUMBER, i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				match(NUMBER);
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER );
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

	public static class NameContext extends ParserRuleContext {
		public List<TerminalNode> CHAR() { return getTokens(RepositoryParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(RepositoryParser.CHAR, i);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				match(CHAR);
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CHAR );
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

	public static class FactionContext extends ParserRuleContext {
		public TerminalNode FACTION() { return getToken(RepositoryParser.FACTION, 0); }
		public FactionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_faction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterFaction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitFaction(this);
		}
	}

	public final FactionContext faction() throws RecognitionException {
		FactionContext _localctx = new FactionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_faction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(FACTION);
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

	public static class OpponentContext extends ParserRuleContext {
		public TerminalNode SPACE() { return getToken(RepositoryParser.SPACE, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public OpponentDataContext opponentData() {
			return getRuleContext(OpponentDataContext.class,0);
		}
		public OpponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opponent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterOpponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitOpponent(this);
		}
	}

	public final OpponentContext opponent() throws RecognitionException {
		OpponentContext _localctx = new OpponentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_opponent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__8);
			setState(95);
			match(SPACE);
			setState(96);
			name();
			setState(97);
			match(T__1);
			setState(98);
			opponentData();
			setState(99);
			match(T__2);
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

	public static class OpponentDataContext extends ParserRuleContext {
		public DataFactionContext dataFaction() {
			return getRuleContext(DataFactionContext.class,0);
		}
		public DataBehaviorContext dataBehavior() {
			return getRuleContext(DataBehaviorContext.class,0);
		}
		public DeckContext deck() {
			return getRuleContext(DeckContext.class,0);
		}
		public OpponentDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opponentData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterOpponentData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitOpponentData(this);
		}
	}

	public final OpponentDataContext opponentData() throws RecognitionException {
		OpponentDataContext _localctx = new OpponentDataContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_opponentData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			dataFaction();
			setState(102);
			dataBehavior();
			setState(103);
			deck();
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

	public static class DeckContext extends ParserRuleContext {
		public List<DeckCardContext> deckCard() {
			return getRuleContexts(DeckCardContext.class);
		}
		public DeckCardContext deckCard(int i) {
			return getRuleContext(DeckCardContext.class,i);
		}
		public List<TerminalNode> SEPARATOR() { return getTokens(RepositoryParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(RepositoryParser.SEPARATOR, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(RepositoryParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(RepositoryParser.WHITESPACE, i);
		}
		public DeckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterDeck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitDeck(this);
		}
	}

	public final DeckContext deck() throws RecognitionException {
		DeckContext _localctx = new DeckContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_deck);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__9);
			setState(106);
			match(T__1);
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(107);
				deckCard();
				setState(108);
				match(SEPARATOR);
				setState(110);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(109);
					match(WHITESPACE);
					}
				}

				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CHAR );
			setState(116);
			match(T__2);
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

	public static class DeckCardContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public DeckCardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deckCard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).enterDeckCard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RepositoryListener ) ((RepositoryListener)listener).exitDeckCard(this);
		}
	}

	public final DeckCardContext deckCard() throws RecognitionException {
		DeckCardContext _localctx = new DeckCardContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_deckCard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			name();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25{\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\6\2%\n"+
		"\2\r\2\16\2&\3\2\3\2\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\6\13V\n\13\r\13"+
		"\16\13W\3\f\6\f[\n\f\r\f\16\f\\\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20q\n\20\6\20s\n"+
		"\20\r\20\16\20t\3\20\3\20\3\21\3\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \2\2q\2$\3\2\2\2\4*\3\2\2\2\6/\3\2\2\2\b\66\3\2\2\2\n"+
		";\3\2\2\2\f@\3\2\2\2\16E\3\2\2\2\20J\3\2\2\2\22O\3\2\2\2\24U\3\2\2\2\26"+
		"Z\3\2\2\2\30^\3\2\2\2\32`\3\2\2\2\34g\3\2\2\2\36k\3\2\2\2 x\3\2\2\2\""+
		"%\5\6\4\2#%\5\32\16\2$\"\3\2\2\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2"+
		"\2\2\'(\3\2\2\2()\7\2\2\3)\3\3\2\2\2*+\5\6\4\2+-\7\r\2\2,.\7\25\2\2-,"+
		"\3\2\2\2-.\3\2\2\2.\5\3\2\2\2/\60\7\3\2\2\60\61\7\16\2\2\61\62\5\26\f"+
		"\2\62\63\7\4\2\2\63\64\5\b\5\2\64\65\7\5\2\2\65\7\3\2\2\2\66\67\5\n\6"+
		"\2\678\5\f\7\289\5\16\b\29:\5\20\t\2:\t\3\2\2\2;<\7\6\2\2<=\7\20\2\2="+
		">\5\30\r\2>?\7\r\2\2?\13\3\2\2\2@A\7\7\2\2AB\7\20\2\2BC\5\24\13\2CD\7"+
		"\r\2\2D\r\3\2\2\2EF\7\b\2\2FG\7\20\2\2GH\5\24\13\2HI\7\r\2\2I\17\3\2\2"+
		"\2JK\7\t\2\2KL\7\20\2\2LM\5\24\13\2MN\7\r\2\2N\21\3\2\2\2OP\7\n\2\2PQ"+
		"\7\20\2\2QR\7\21\2\2RS\7\r\2\2S\23\3\2\2\2TV\7\23\2\2UT\3\2\2\2VW\3\2"+
		"\2\2WU\3\2\2\2WX\3\2\2\2X\25\3\2\2\2Y[\7\24\2\2ZY\3\2\2\2[\\\3\2\2\2\\"+
		"Z\3\2\2\2\\]\3\2\2\2]\27\3\2\2\2^_\7\22\2\2_\31\3\2\2\2`a\7\13\2\2ab\7"+
		"\16\2\2bc\5\26\f\2cd\7\4\2\2de\5\34\17\2ef\7\5\2\2f\33\3\2\2\2gh\5\n\6"+
		"\2hi\5\22\n\2ij\5\36\20\2j\35\3\2\2\2kl\7\f\2\2lr\7\4\2\2mn\5 \21\2np"+
		"\7\17\2\2oq\7\25\2\2po\3\2\2\2pq\3\2\2\2qs\3\2\2\2rm\3\2\2\2st\3\2\2\2"+
		"tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7\5\2\2w\37\3\2\2\2xy\5\26\f\2y!\3\2"+
		"\2\2\t$&-W\\pt";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}