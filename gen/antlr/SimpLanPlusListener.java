// Generated from /Users/martinadaghia/Desktop/ProgettoLinguaggi/src/SimpLanPlus.g4 by ANTLR 4.12.0
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpLanPlusParser}.
 */
public interface SimpLanPlusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpLanPlusParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpLanPlusParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(SimpLanPlusParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(SimpLanPlusParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(SimpLanPlusParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(SimpLanPlusParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(SimpLanPlusParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(SimpLanPlusParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpLanPlusParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpLanPlusParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterStm(SimpLanPlusParser.StmContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitStm(SimpLanPlusParser.StmContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(SimpLanPlusParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(SimpLanPlusParser.ExpContext ctx);
}