package datastructure.eval;

import datastructure.eval.exprAnalysis.Evaluator;
import datastructure.eval.exprAnalysis.Resources;
import datastructure.eval.exprAnalysis.Tokenizer;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("表达式计算器");
		System.out.println("输入?获取使用帮助，输入exit退出");
		
		while (true)
		{
			try
			{
				String input = cin.nextLine();
				if(Objects.equals(input, "?"))
				{
					Resources.PrintHelp();
					continue;
				}
				if(Objects.equals(input, "exit"))
				{
					break;
				}
				Tokenizer tokenizer = new Tokenizer(input);
				tokenizer.Tokenize();
				Evaluator evaluator = new Evaluator(tokenizer);
				double result = evaluator.Evaluate();
				
				System.out.println("结果为：" + result);
			}
			catch (InputMismatchException e)
			{
				System.out.println("格式不正确，" + e.getMessage());
				Resources.PrintHelp();
			}
		}
	}
}
