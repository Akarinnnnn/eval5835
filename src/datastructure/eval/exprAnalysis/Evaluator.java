package datastructure.eval.exprAnalysis;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Stack;
import java.util.Vector;

public class Evaluator
{
	Vector<Token> tokens;
	private final Stack<Double> operands;
	private final Stack<Token> operators;
	
	public Evaluator(Tokenizer tokenizer)
	{
		tokens = tokenizer.tokenStream;
		operands = new Stack<>();
		operators = new Stack<>();
	}
	
	private boolean TryPushOperator(Token current, int subExprBegin)
	{
		if (operators.size() == subExprBegin)
			return operators.add(current);
		
		if (current.GetPriority() > operators.peek().GetPriority())
			return operators.add(current);
		else
			return false;
	}
	
	private int Parse(int currentPos)
	{
		Token curToken;
		int subExprBegin = operators.size();
		
		if(tokens.isEmpty())
		{
			Resources.PrintHelp();
			return 0;
		}
		
		for (; tokens.size() > currentPos;
			 currentPos++)
		{
			curToken = tokens.get(currentPos);
			if (curToken.type == TokenType.LBracket)
			{
				currentPos = Parse(currentPos + 1);
			}
			else if(curToken.type == TokenType.RBracket)
			{
				break;
			}
			else if (curToken.type == TokenType.Number)
			{
				operands.push(curToken.AsNumber());
			}
			else if (curToken.IsBinaryOperator() || curToken.type == TokenType.Func)
			{
				// -...
				if (curToken.type == TokenType.Sub || curToken.type == TokenType.Add)
				{
					Token prev = tokens.get(Math.max(currentPos - 1, 0));
					// 反例：
					// 122 - 1
					// ) - 1
					// 例：
					// + -1
					// + +1
					if (prev.type != TokenType.Number && prev.type != TokenType.RBracket)
					{
						// 认定为数字的一部分
						currentPos++;
						double nextNumber = tokens.get(currentPos).AsNumber();
						if(curToken.type == TokenType.Sub)
							operands.add(-nextNumber);
						else
							operands.add(nextNumber);
						continue;
					}
					// 认定为运算符，继续
				}
				
				if (!TryPushOperator(curToken, subExprBegin))
				{
					if (operators.peek().IsBinaryOperator())
					{
						double r = operands.pop();
						double l = operands.pop();
						double result = operators.pop().EvaluateBinary(l, r);
						operands.push(result);
						operators.push(curToken);
					}
				}
				else if (curToken.type == TokenType.Func)
				{
					CheckFunctionParams(currentPos);
					
					currentPos = Parse(currentPos + 2);
					double ret = curToken.AsFunc().Body.apply(operands.pop());
					operators.pop();
					operands.push(ret);
				}
			}
		}
		
		EvalSubExpression(subExprBegin);
		
		return currentPos;
	}
	
	/**
	 * 检查函数参数
	 * 反例：
	 * sin -
	 * sin 1
	 * sin )
	 * 正确输入:
	 * sin(1 + 2)
	 * cos(1)
	 * cos ( 1 )
	 */
	private void CheckFunctionParams(int currentPos)
	{
		if (currentPos + 2 >= tokens.size() || tokens.get(currentPos + 1).type != TokenType.LBracket)
			throw new InputMismatchException("函数" + tokens.get(currentPos) + "后缺少参数");
	}
	
	public double Evaluate()
	{
		try
		{
			Parse(0);
			
			EvalSubExpression(0);
			
			if (operands.size() != 1)
				throw new InputMismatchException("表达式有误。");
		}
		catch (EmptyStackException e)
		{
			throw new InputMismatchException("表达式有误。");
		}
		
		return operands.lastElement();
	}
	
	private void EvalSubExpression(int subBegin)
	{
		while (operators.size() > subBegin)
		{
			Token operator = operators.pop();
			
			if (operator.IsBinaryOperator())
			{
				double r = operands.pop();
				double l = operands.pop();
				operands.push(operator.EvaluateBinary(l, r));
			}
			else if(operator.type == TokenType.Func)
			{
				double result = operator.AsFunc().Body.apply(operands.pop());
				operands.push(result);
			}
			else
			{
				throw new AssertionError("运算符栈中出现非运算符");
			}
		}
	}
}
