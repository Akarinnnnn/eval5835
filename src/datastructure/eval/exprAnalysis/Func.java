package datastructure.eval.exprAnalysis;


import java.util.function.Function;

class Func
{
	public String Name;
	public Function<Double, Double> Body;
	
	// 不认识的一律35
	public static final Func Default = new Func("五八多少", (v) ->
	{
		System.out.println(Resources.haruka);
		System.out.println("五八……五八三十五！");
		return 35.0;
	});
	
	public static final Func[] KnownFunctions = {
			Default,
			new Func("abs", Math::abs),
			new Func("sqrt", Math::sqrt),
			new Func("exp", Math::exp),
			new Func("ln", Math::log),
			new Func("log10", Math::log10),
			new Func("sin", Math::sin),
			new Func("cos", Math::cos),
			new Func("tan", Math::tan),
			new Func("tanh", Math::tanh)
	};
	
	Func(String name, Function<Double, Double> body)
	{
		Name = name;
		Body = body;
		
	}
}
