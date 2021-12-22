package datastructure.eval.exprAnalysis;

import java.util.InputMismatchException;
import java.util.Vector;

import static java.lang.Character.*;

public class Tokenizer
{
	private final String input;
	private final StringBuilder sb;
	final Vector<Token> tokenStream;
	
	public Tokenizer(String input)
	{
		this.input = input;
		tokenStream = new Vector<>(128);
		sb = new StringBuilder(48);
	}
	
	/**
	 * 数字文法检查
	 *
	 * @return int end
	 */
	private int on_Number(int beginPos) throws InputMismatchException
	{
		char current = input.charAt(beginPos);
		boolean dotDefined = false;
		int curPos = beginPos;
		try
		{
			for (; Character.isDigit(current) || current == '.'; curPos++, current = input.charAt(curPos))
			{
				if (dotDefined && current == '.')
					throw new InputMismatchException("数字中出现多个小数点。");
				else if (current == '.')
					dotDefined = true;
				
				sb.append(current);
			}
			// 指回数字
			curPos--;
			// 检查意外情况
			if (curPos < beginPos)
				throw new InputMismatchException("输入不符合词法");
			
			tokenStream.add(new Token(TokenType.Number, sb.toString(), beginPos, curPos));
			// sb.clear()
			sb.setLength(0);
			return curPos;
		}
		catch (StringIndexOutOfBoundsException e)
		{
			curPos--;
			tokenStream.add(new Token(TokenType.Number, sb.toString(), beginPos, curPos));
			// sb.clear()
			sb.setLength(0);
			return curPos;
		}
	}
	
	private int on_funcName(int beginPos)
	{
		int curPos = beginPos;
		char ch;
		
		while (curPos != input.length())
		{
			ch = input.charAt(curPos);
			if (isJavaIdentifierPart(ch))
			{
				sb.append(ch);
				curPos++;
			}
			else
			{
				break;
			}
		}
		
		curPos--;
		// 检查意外情况
		if (curPos < beginPos)
			throw new InputMismatchException("输入不符合词法");
		
		tokenStream.add(new Token(TokenType.Func, sb.toString(), beginPos, curPos));
		sb.setLength(0);
		return curPos;
	}
	
	public void Tokenize() throws InputMismatchException
	{
		for (int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			
			switch (ch)
			{
				case '%' -> tokenStream.add(new Token(TokenType.Mod, "%", i, i));
				case '^' -> tokenStream.add(new Token(TokenType.Pow, "^", i, i));
				case '*' -> tokenStream.add(new Token(TokenType.Mul, "*", i, i));
				case '/' -> tokenStream.add(new Token(TokenType.Div, "/", i, i));
				case '+' -> tokenStream.add(new Token(TokenType.Add, "+", i, i));
				case '-' -> tokenStream.add(new Token(TokenType.Sub, "-", i, i));
				case '(' -> tokenStream.add(new Token(TokenType.LBracket, "(", i, i));
				case ')' -> tokenStream.add(new Token(TokenType.RBracket, ")", i, i));
				default -> {
					if (getType(ch) == DECIMAL_DIGIT_NUMBER)
						i = on_Number(i);
					else if (isJavaIdentifierStart(ch))
						i = on_funcName(i);
				}
			}
		}
	}
}
