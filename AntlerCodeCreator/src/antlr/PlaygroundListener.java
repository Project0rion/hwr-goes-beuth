package antlr;// Generated from C:\Users\User\Desktop\Playground.g by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PlaygroundParser}.
 */
public interface PlaygroundListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PlaygroundParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(PlaygroundParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlaygroundParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(PlaygroundParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlaygroundParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(PlaygroundParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlaygroundParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(PlaygroundParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlaygroundParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(PlaygroundParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlaygroundParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(PlaygroundParser.ValueContext ctx);
}