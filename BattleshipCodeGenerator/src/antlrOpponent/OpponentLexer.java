// Generated from D:\Benutzer\Project0rion\Dokumente\HwrGoesBeuth\hwr-goes-beuth\BattleshipCodeGenerator\res\Opponent.g by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OpponentLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SHOOT=1, COLUMN=2, ROW=3, PERIOD=4, WHITESPACE=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SHOOT", "COLUMN", "ROW", "PERIOD", "WHITESPACE"
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


	public OpponentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Opponent.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\7$\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\5\3\30\n\3\3\4\3\4\3\5\3\5\3\6\6\6\37\n\6\r\6\16\6 \3\6\3\6\2\2\7\3\3"+
		"\5\4\7\5\t\6\13\7\3\2\4\4\2C\\c|\5\2\13\f\16\17\"\"$\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2\5\27\3\2\2\2\7"+
		"\31\3\2\2\2\t\33\3\2\2\2\13\36\3\2\2\2\r\16\7U\2\2\16\17\7j\2\2\17\20"+
		"\7q\2\2\20\21\7q\2\2\21\22\7v\2\2\22\23\7\"\2\2\23\24\7c\2\2\24\25\7v"+
		"\2\2\25\4\3\2\2\2\26\30\t\2\2\2\27\26\3\2\2\2\30\6\3\2\2\2\31\32\4\63"+
		";\2\32\b\3\2\2\2\33\34\7\60\2\2\34\n\3\2\2\2\35\37\t\3\2\2\36\35\3\2\2"+
		"\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\b\6\2\2#\f\3\2\2\2"+
		"\5\2\27 \3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}