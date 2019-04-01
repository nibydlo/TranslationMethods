// Generated from /home/dmitry/Desktop/translation_methods/calc23/Calculator.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code toExprSeq}
	 * labeled alternative in {@link CalculatorParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToExprSeq(CalculatorParser.ToExprSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAssign}
	 * labeled alternative in {@link CalculatorParser#exprSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAssign(CalculatorParser.ToAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPlusMinus}
	 * labeled alternative in {@link CalculatorParser#exprSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPlusMinus(CalculatorParser.ToPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndOfInput}
	 * labeled alternative in {@link CalculatorParser#exprSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndOfInput(CalculatorParser.EndOfInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link CalculatorParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(CalculatorParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToMult}
	 * labeled alternative in {@link CalculatorParser#plusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToMult(CalculatorParser.ToMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link CalculatorParser#plusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(CalculatorParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CalculatorParser#plusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(CalculatorParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link CalculatorParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPow(CalculatorParser.ToPowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multip}
	 * labeled alternative in {@link CalculatorParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultip(CalculatorParser.MultipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link CalculatorParser#power}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(CalculatorParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link CalculatorParser#power}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAtom(CalculatorParser.ToAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeSign(CalculatorParser.ChangeSignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Brackets}
	 * labeled alternative in {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrackets(CalculatorParser.BracketsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CalculatorParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(CalculatorParser.NumberContext ctx);
}