// Generated from D:\Benutzer\Project0rion\Dokumente\HwrGoesBeuth\hwr-goes-beuth\BattleshipCodeGenerator\res\Opponent.g by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OpponentParser}.
 */
public interface OpponentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OpponentParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(OpponentParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link OpponentParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(OpponentParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link OpponentParser#shootSentence}.
	 * @param ctx the parse tree
	 */
	void enterShootSentence(OpponentParser.ShootSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OpponentParser#shootSentence}.
	 * @param ctx the parse tree
	 */
	void exitShootSentence(OpponentParser.ShootSentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link OpponentParser#coordinate}.
	 * @param ctx the parse tree
	 */
	void enterCoordinate(OpponentParser.CoordinateContext ctx);
	/**
	 * Exit a parse tree produced by {@link OpponentParser#coordinate}.
	 * @param ctx the parse tree
	 */
	void exitCoordinate(OpponentParser.CoordinateContext ctx);
}