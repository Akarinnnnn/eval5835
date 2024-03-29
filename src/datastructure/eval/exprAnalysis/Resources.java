package datastructure.eval.exprAnalysis;

public class Resources
{
	@SuppressWarnings("SpellCheckingInspection") static String haruka =
			"""
⠀⢠⣿⡿⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠀
⣀⣾⠏⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣀
⡿⠃⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠈⣿⣿⣿⣿⣿⣿⣿⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠛⠛⠿⢿⣿⣿⣿⣿⣿⣿⣿
⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⣿⣿⣿⣿⣿⣿⣿⡄⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠈⣿⣿⣿⣿⣿⣿⡿⠛⢁⣀⣠⣤⣶⣦⣄⣀⡈⠛⢿⣿⣿⣿⣿
⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⣀⣴⣿⣿⣿⣿⣿⣿⣿⡇⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠸⣿⠀⢻⣿⠏⠀⣴⣿⣿⣿⠀⢀⣿⣿⠿⢿⣦⡀⠹⣿⣿⣿
⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⢻⠀⠀⠏⠀⣾⣿⡟⠉⠀⠀⠙⠻⠇⠀⢀⣿⣷⠀⠸⣿⣿
⠟⠀⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⣼⣿⣿⠉⢻⣿⣿⣿⣿⣿⣿⣇⠀⠀⠉⢿⣿⣿⣿⣿⣿⣿⣿⣧⠈⡆⠀⠀⠀⢿⣿⣇⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⡇⠀⢸⣿
⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣿⣿⣿⠀⠘⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣄⠇⠀⠀⠀⠈⠿⣿⣷⣶⣶⣄⠀⠀⣀⡾⠿⣿⠇⠀⢸⣿
⠀⣼⣿⣿⣿⣿⣿⠏⢹⣿⠀⢀⣿⣿⣿⠀⠀⠸⣇⠉⢿⣿⣿⣿⣷⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠈⠙⠛⠿⣿⣿⣿⡟⠛⣶⠟⠀⢠⣿⣿
⠀⣿⢿⣿⣿⣿⣿⠀⢸⣿⠀⢸⣿⣿⣿⣧⡄⠀⠙⣆⠀⠻⣿⣿⣿⣦⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⡀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠈⠉⠀⠀⣿⣿⣿
⢠⣿⠘⣿⣿⣿⡿⠀⠀⣿⠀⣿⣿⣿⣿⣿⣧⠛⠄⠈⠂⠀⠙⢿⣿⣿⡄⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⣆⠀⢳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿
⣿⡏⠀⣿⣿⣿⡇⠀⠀⠋⠀⣿⡿⠿⠛⠉⠁⠀⠀⠠⠄⠀⠀⡀⠙⢿⣿⡄⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⣆⠀⠛⠷⣄⠀⠀⠁⠀⠀⢠⢠⣶⡀⠀⠈⣿⠋
⣿⡇⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⣙⠻⢶⣽⣿⣶⣄⠀⠀⠀⠀⠀⠙⢏⠉⠛⢿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⢿⠀
⣿⡇⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠈⢻⣿⣧⡀⠀⠈⣶⣼⣿⣿⣿⣿⣷⣄⠀⠀⠀⠐⢿⣷⠄⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⣾⣿⠀⠀⠀⠀⠀
⣿⡧⠀⠀⠘⣿⡇⠀⠀⠀⠀⢰⣯⠀⠀⠀⠀⠀⠀⣿⣿⣷⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠘⢳⡄⠀⠀⣠⣶⣶⠟⠉⠉⠉⠲⣤⡀⠀⠀⠈⣿⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠈⠃⠀⠀⠀⠀⢸⣿⣦⣀⠀⢀⣠⣾⣿⣿⣿⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⠃⠀⢰⣿⣿⡇⠀⠀⠀⠀⠀⢹⣷⡄⠀⠈⡿⠀⠀⠀⠀⠀
⠀⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⢸⣿⣿⣷⡀⠀⠀⠀⣠⣿⣿⡷⠀⠀⠁⠀⠀⠀⠀⠀
⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠸⣿⣿⣿⣿⣷⣶⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠛⠉⠁⠀⢀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⡀⠀⠘⠿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡶⢀⣀⣀⣀⣀⣤⣴⣶⣿⣿⣿⣿⣿⣿⣿⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣀⠀⠀⠈⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣦⣤⣶⣶⣄⣤⣤⠄⠀⠀⠀⠀⠀⠀⠀
⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀
⠙⡀⠀⠀⠀⠀⠀⠀⠀⠄⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡅⠈⠛⠛⠛⠛⠛⠛⠋⠉⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠒⠀⠀⠀⠀⠀⠀⠀
⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣤⣶⣤⣤⣄⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠
⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠘⣿⣿⣿⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿
⣿⣿⣿⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠛⠿⢿⣿⣿⣿⣿⣿⣤⠼⠿⠟⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⠟
⠛⠋⠉⠀⢀⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⠛⠁⢠			""";
	
	static String help_message =
			"""
   
			使用帮助
			
			输入一行待计算的表达式，如：1+2+ -3 -(4^5)%6 *7 / 8 + sin(7)
			此程序支持下列函数：
			""";
	
	public static void PrintHelp()
	{
		System.out.print(Resources.help_message);
		for (Func func : Func.KnownFunctions)
			System.out.println(func.Name);
		System.out.println();
	}
	
}
