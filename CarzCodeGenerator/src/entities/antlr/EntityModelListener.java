package entities.antlr;// Generated from EntityModel.g by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EntityModelParser}.
 */
public interface EntityModelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EntityModelParser#entities}.
	 * @param ctx the parse tree
	 */
	void enterEntities(EntityModelParser.EntitiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link EntityModelParser#entities}.
	 * @param ctx the parse tree
	 */
	void exitEntities(EntityModelParser.EntitiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link EntityModelParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(EntityModelParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link EntityModelParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(EntityModelParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link EntityModelParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(EntityModelParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EntityModelParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(EntityModelParser.PropertyContext ctx);
}