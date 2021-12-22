package datastructure.eval.exprAnalysis;


public class Token
{
	TokenType type;
	
	String content;
	
	int begin, end;
	
	public Token(TokenType t, String content, int begin, int end)
	{
		type = t;
		this.content = content;
		this.begin = begin;
		this.end = end;
	}
	
	public TokenType Type()
	{
		return type;
	}
	
	public double AsNumber()
	{
		if (type != TokenType.Number)
			throw new UnsupportedOperationException("不是一个数字token。");
		
		return Double.parseDouble(content);
	}
	
	public Func AsFunc()
	{
		if (type != TokenType.Func)
			throw new UnsupportedOperationException("不是一个函数token。");
		
		for (Func func : Func.KnownFunctions)
			if (func.Name.equalsIgnoreCase(content))
				return func;
		
		// throw new UnsupportedOperationException("不支持这个函数。");
		// 35.0
		return Func.Default;
	}
	
	public int GetPriority()
	{
		return switch (type)
					   {
						   case Add, Sub -> 0;
						   case Div, Mul, Mod -> 1;
						   case Pow -> 2;
						   case Func -> 3;
						   default -> throw new IllegalArgumentException();
					   };
	}
	
	public boolean IsBinaryOperator()
	{
		return type.ordinal() > TokenType.RBracket.ordinal() &&
			   type.ordinal() < TokenType.Func.ordinal();
	}
	
	public double EvaluateBinary(double l, double r)
	{
		return switch (type)
					   {
						   case Add -> l + r;
						   case Sub -> l - r;
						   case Mul -> l * r;
						   case Div -> l / r;
						   case Mod -> l % r;
						   case Pow -> Math.pow(l, r);
						   default -> throw new IllegalArgumentException();
					   };
	}
	
	/**
	 * @return '{content}' - (begin, end)
	 */
	@Override
	public String toString()
	{
		return '\'' + content + '\'' +
			   " - (" +
			   begin + ", " + end +
			   ')';
	}
}


