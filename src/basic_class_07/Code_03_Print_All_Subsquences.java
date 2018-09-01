package basic_class_07;

public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		f(chs, 0, "");
	}

	public static void f(char[] ch, int index, String pre){
		if (index == ch.length){
			if (!pre.equals("")){
				System.out.println(pre);
			}
			return;
		}
		f(ch, index+1, pre + String.valueOf(ch[index]));
		f(ch, index+1, pre);
	}


	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
	}

}
