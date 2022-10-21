package application.model;

/*
 * A massive library of string functions I wrote to solve various problems related to strings!
 */
public class StringFunc {
	
	public static String removeWhitespace(String in) {
		//old code
		// i reworked it to use a general function
//		char worker;
//		String toReturn = new String();
//		for(int i=0;i<in.length();i++) {
//			worker = in.charAt(i);
//			if(worker != ' '&&worker != '\t') {
//				toReturn = toReturn+worker;
//			}
//		}
		return replaceAllWith(" \t",in,"");
	}
	//x*10
	public static int vowelCount(String in) {
		String lv = new String("AEIOUaeiou");
		int c = 0;
		for(int i=0;i<in.length();i++) {
			for(int j=0;j<lv.length();j++) {
				if(in.charAt(i) == lv.charAt(j)){
					c++;
				}
			}
		}
		return c;
	}
	public static int consonantCount(String in) {
		return removeWhitespace(in).length()-vowelCount(in);
	}
	//linear runtime x
	public static boolean containsChar(String in,char t) {
		boolean val = false;
		for(int i=0;i<in.length();i++) {
			if(in.charAt(i) == t) {
				val = true;
				break;
			}
		}
		return val;
	}
	public static String allLowerCase(String in) {
		String toReturn = new String();
		for(int i=0;i<in.length();i++) {
			if(isUpperCase(in.charAt(i))) {
				toReturn = toReturn+(char)((int)in.charAt(i)+32);
			}
			else {
				toReturn = toReturn+in.charAt(i);
			}
		}
		return toReturn;
	}
	public static String allUpperCase(String in) {
		String toReturn = new String();
		for(int i=0;i<in.length();i++) {
			if(isLowerCase(in.charAt(i))) {
				toReturn = toReturn+(char)((int)in.charAt(i)-32);
			}
			else {
				toReturn = toReturn+in.charAt(i);
			}
		}
		return toReturn;
	}
	public static boolean isLowerCase(char c) {
		boolean toReturn = false;
		for(int i=0;i<26;i++) {
			char t = (char)((int)i+97);
			if(t == c) {
				toReturn = true;
				break;
			}
		}
		return toReturn;
	}
	public static boolean isUpperCase(char c) {
		boolean toReturn = false;
		for(int i=0;i<26;i++) {
			char t = (char)((int)i+65);
			if(t == c) {
				toReturn = true;
				break;
			}
		}
		return toReturn;
	}
	//ugly code because I was trying to fix a problem
	//I might fix the ugly code later idk
	public static String replaceAllWith(String toReplace,String in,String toInput) {
		String toReturn = new String();
		boolean found =false;
		for(int i=0;i<in.length();i++) {
			for(int j=0;j<toReplace.length();j++) {
				if(in.charAt(i) == toReplace.charAt(j)) {
					found = true;
					break;
				}
				found = false;
			}
			if(found) {
				toReturn = toReturn + toInput;
			}
			else {
				toReturn = toReturn + in.charAt(i);
			}
			found = false;
		}
		return toReturn;
	}
	public static String findAndReplace(String toReplace,String in,String toInput) {
		String toReturn = new String();
		int j =0;
		for(int i=0;i<in.length();i++) {
			for(j=0;j<toReplace.length()&&toReplace.charAt(j)==in.charAt(i+j);j++) {
				if(j==toReplace.length()-1||j+i>=in.length()) {
					toReturn = toReturn+toInput;
					break;
				}
			}
			if(j==toReplace.length()-1&&toReplace.charAt(j)==in.charAt(j+i)) {
				i=j+i;
			}
			else {
				toReturn = toReturn+in.charAt(i);
			}
		}
		return toReturn;
		
	}
}
