package repositories.antlr;// Generated from Repository.g by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RepositoryParser}.
 */
public interface RepositoryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(RepositoryParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(RepositoryParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(RepositoryParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(RepositoryParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#card}.
	 * @param ctx the parse tree
	 */
	void enterCard(RepositoryParser.CardContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#card}.
	 * @param ctx the parse tree
	 */
	void exitCard(RepositoryParser.CardContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#cardData}.
	 * @param ctx the parse tree
	 */
	void enterCardData(RepositoryParser.CardDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#cardData}.
	 * @param ctx the parse tree
	 */
	void exitCardData(RepositoryParser.CardDataContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#dataFaction}.
	 * @param ctx the parse tree
	 */
	void enterDataFaction(RepositoryParser.DataFactionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#dataFaction}.
	 * @param ctx the parse tree
	 */
	void exitDataFaction(RepositoryParser.DataFactionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#dataHealth}.
	 * @param ctx the parse tree
	 */
	void enterDataHealth(RepositoryParser.DataHealthContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#dataHealth}.
	 * @param ctx the parse tree
	 */
	void exitDataHealth(RepositoryParser.DataHealthContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#dataDamage}.
	 * @param ctx the parse tree
	 */
	void enterDataDamage(RepositoryParser.DataDamageContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#dataDamage}.
	 * @param ctx the parse tree
	 */
	void exitDataDamage(RepositoryParser.DataDamageContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#dataCost}.
	 * @param ctx the parse tree
	 */
	void enterDataCost(RepositoryParser.DataCostContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#dataCost}.
	 * @param ctx the parse tree
	 */
	void exitDataCost(RepositoryParser.DataCostContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#dataBehavior}.
	 * @param ctx the parse tree
	 */
	void enterDataBehavior(RepositoryParser.DataBehaviorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#dataBehavior}.
	 * @param ctx the parse tree
	 */
	void exitDataBehavior(RepositoryParser.DataBehaviorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(RepositoryParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(RepositoryParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(RepositoryParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(RepositoryParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#faction}.
	 * @param ctx the parse tree
	 */
	void enterFaction(RepositoryParser.FactionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#faction}.
	 * @param ctx the parse tree
	 */
	void exitFaction(RepositoryParser.FactionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#opponent}.
	 * @param ctx the parse tree
	 */
	void enterOpponent(RepositoryParser.OpponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#opponent}.
	 * @param ctx the parse tree
	 */
	void exitOpponent(RepositoryParser.OpponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#opponentData}.
	 * @param ctx the parse tree
	 */
	void enterOpponentData(RepositoryParser.OpponentDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#opponentData}.
	 * @param ctx the parse tree
	 */
	void exitOpponentData(RepositoryParser.OpponentDataContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#deck}.
	 * @param ctx the parse tree
	 */
	void enterDeck(RepositoryParser.DeckContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#deck}.
	 * @param ctx the parse tree
	 */
	void exitDeck(RepositoryParser.DeckContext ctx);
	/**
	 * Enter a parse tree produced by {@link RepositoryParser#deckCard}.
	 * @param ctx the parse tree
	 */
	void enterDeckCard(RepositoryParser.DeckCardContext ctx);
	/**
	 * Exit a parse tree produced by {@link RepositoryParser#deckCard}.
	 * @param ctx the parse tree
	 */
	void exitDeckCard(RepositoryParser.DeckCardContext ctx);
}