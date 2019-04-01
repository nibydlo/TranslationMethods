// Generated from /home/dmitry/Desktop/translation_methods/HW4_2/Grammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code toExprSeq}
	 * labeled alternative in {@link GrammarParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToExprSeq(GrammarParser.ToExprSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignIgnore}
	 * labeled alternative in {@link GrammarParser#ignoreRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignIgnore(GrammarParser.AssignIgnoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAssignToken}
	 * labeled alternative in {@link GrammarParser#ruleSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAssignToken(GrammarParser.ToAssignTokenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAssignRule}
	 * labeled alternative in {@link GrammarParser#ruleSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAssignRule(GrammarParser.ToAssignRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewLine}
	 * labeled alternative in {@link GrammarParser#ruleSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewLine(GrammarParser.NewLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndOfInput}
	 * labeled alternative in {@link GrammarParser#ruleSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndOfInput(GrammarParser.EndOfInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignToken}
	 * labeled alternative in {@link GrammarParser#setToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignToken(GrammarParser.AssignTokenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignRule}
	 * labeled alternative in {@link GrammarParser#setRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignRule(GrammarParser.AssignRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InOption}
	 * labeled alternative in {@link GrammarParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInOption(GrammarParser.InOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToInitVar}
	 * labeled alternative in {@link GrammarParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToInitVar(GrammarParser.ToInitVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitializeVar}
	 * labeled alternative in {@link GrammarParser#initVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializeVar(GrammarParser.InitializeVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnValue}
	 * labeled alternative in {@link GrammarParser#retValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnValue(GrammarParser.ReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignRightPart}
	 * labeled alternative in {@link GrammarParser#rightPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignRightPart(GrammarParser.AssignRightPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPassArguments}
	 * labeled alternative in {@link GrammarParser#rightPartElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPassArguments(GrammarParser.ToPassArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RightPartElemToken}
	 * labeled alternative in {@link GrammarParser#rightPartElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightPartElemToken(GrammarParser.RightPartElemTokenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RightPartElemCode}
	 * labeled alternative in {@link GrammarParser#rightPartElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightPartElemCode(GrammarParser.RightPartElemCodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PassingVariables}
	 * labeled alternative in {@link GrammarParser#passArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassingVariables(GrammarParser.PassingVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(GrammarParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(GrammarParser.CodeContext ctx);
}