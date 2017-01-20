package entities.antlr;// Generated from EntityModel.g by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EntityModelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NAME=1, BEGIN=2, END=3, LIST=4, ENDLINE=5, WHITESPACE=6;
	public static final int
		RULE_entities = 0, RULE_entity = 1, RULE_property = 2;
	public static final String[] ruleNames = {
            "entities", "entity", "property"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'{'", "'}'", "'[]'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NAME", "BEGIN", "END", "LIST", "ENDLINE", "WHITESPACE"
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
	public String getGrammarFileName() { return "EntityModel.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EntityModelParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EntitiesContext extends ParserRuleContext {
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(EntityModelParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(EntityModelParser.WHITESPACE, i);
		}
		public EntitiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entities; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EntityModelListener ) ((EntityModelListener)listener).enterEntities(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EntityModelListener ) ((EntityModelListener)listener).exitEntities(this);
		}
	}

	public final EntitiesContext entities() throws RecognitionException {
		EntitiesContext _localctx = new EntitiesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entities);
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
				entity();
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
			} while ( _la==NAME );
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

	public static class EntityContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(EntityModelParser.NAME, 0); }
		public TerminalNode BEGIN() { return getToken(EntityModelParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(EntityModelParser.END, 0); }
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EntityModelListener ) ((EntityModelListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EntityModelListener ) ((EntityModelListener)listener).exitEntity(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(NAME);
			setState(15);
			match(BEGIN);
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(16);
				property();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			match(END);
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

	public static class PropertyContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(EntityModelParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(EntityModelParser.NAME, i);
		}
		public TerminalNode WHITESPACE() { return getToken(EntityModelParser.WHITESPACE, 0); }
		public TerminalNode ENDLINE() { return getToken(EntityModelParser.ENDLINE, 0); }
		public TerminalNode LIST() { return getToken(EntityModelParser.LIST, 0); }
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EntityModelListener ) ((EntityModelListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EntityModelListener ) ((EntityModelListener)listener).exitProperty(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(NAME);
			setState(26);
			_la = _input.LA(1);
			if (_la==LIST) {
				{
				setState(25);
				match(LIST);
				}
			}

			setState(28);
			match(WHITESPACE);
			setState(29);
			match(NAME);
			setState(30);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b#\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\5\2\13\n\2\6\2\r\n\2\r\2\16\2\16\3\3\3\3\3\3\7\3\24"+
		"\n\3\f\3\16\3\27\13\3\3\3\3\3\3\4\3\4\5\4\35\n\4\3\4\3\4\3\4\3\4\3\4\2"+
		"\2\5\2\4\6\2\2#\2\f\3\2\2\2\4\20\3\2\2\2\6\32\3\2\2\2\b\n\5\4\3\2\t\13"+
		"\7\b\2\2\n\t\3\2\2\2\n\13\3\2\2\2\13\r\3\2\2\2\f\b\3\2\2\2\r\16\3\2\2"+
		"\2\16\f\3\2\2\2\16\17\3\2\2\2\17\3\3\2\2\2\20\21\7\3\2\2\21\25\7\4\2\2"+
		"\22\24\5\6\4\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2"+
		"\26\30\3\2\2\2\27\25\3\2\2\2\30\31\7\5\2\2\31\5\3\2\2\2\32\34\7\3\2\2"+
		"\33\35\7\6\2\2\34\33\3\2\2\2\34\35\3\2\2\2\35\36\3\2\2\2\36\37\7\b\2\2"+
		"\37 \7\3\2\2 !\7\7\2\2!\7\3\2\2\2\6\n\16\25\34";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}