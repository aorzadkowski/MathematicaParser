import java.util.ArrayList;

public class MathematicaParser {

	public static String parseToOneLine(String in) {
		String out = "";
		if (in.contains("\n")) {
			String[] splitString = in.split("\n");
			

			
			if (splitString.length == 2) {
				System.out.println("There is at least one exponential.");
			} else if (splitString.length == 3) {
				System.out.println("There is at least one fraction here");
				
			} else if (splitString.length >= 4) {
				System.out.println("There is at least one fraction and one exponent.");
			}
			
			char[][] charMatrix = charMatrix(in);
			
			for (int i = 0; i < charMatrix.length; i++) {
				out += new String(charMatrix[i]) + "\n";
			}
			
		} else {
			out = in;
		}
		return out;
	}
	
	public static char[][] charMatrix(String in) {
		String[] splitString = in.split("\n");
		
		String commentLine = "String Describing the above matrix can go here.";
		
		int height = splitString.length;
		int width = 0;
		for (int i = 0; i < splitString.length; i++) {
			if (splitString[i].length() > width) 
				width = splitString[i].length();
		}
		
		char[][] charMatrix = new char[height + 1][width]; //+1 is the "comment" line.
		
		charMatrix[charMatrix.length - 1] = commentLine.toCharArray();
		
		for (int i = 0; i < splitString.length; i++) {
			for (int j = 0; j < charMatrix[0].length; j++) {
				if (j < splitString[i].length()) 
				{
					charMatrix[i][j] = splitString[i].charAt(j);
					//Potentially process the difference between minus, negative, and division line here.
					if (charMatrix[i][j] == '-' && j + 1 < splitString[i].length()) {
						if ((j - 1 >= 0 && splitString[i].charAt(j - 1) == '-') || splitString[i].charAt(j + 1) == '-' || 
							(i - 1 > 0 && i + 1 < splitString.length && (splitString[i - 1].charAt(j) != ' ' || splitString[i + 1].charAt(j) != ' '))) {
							System.out.println("Divinding Line at: " + i + " " + j);
						} else if (splitString[i].charAt(j + 1) != '-' && splitString[i].charAt(j + 1) != ' ') {
							System.out.println("Negative Sign at: " + i + " " + j);
						} else {
							System.out.println("Subtraction at: " + i + " " + j);
						}
					}
				}
				else 
					charMatrix[i][j] = '@';
			}
		}
		
		return charMatrix;
	}
	
//	private static boolean characterAboveCurrentCharacter (String[] strings, int y, int x) {
//		boolean bool 
//	}
	
	private static String appendToListInString(String original, String listHeader, String appendedString) {
		String toReturn = original;
		
		if (original.contains(listHeader)) {
			//List is in the string
		}
		
		return toReturn;
	}
	
	public static int countSpacesBeforeFirstCharacter(String in) {
		int counter = 0;
		char ch = in.charAt(0);
		while (ch == ' ') {
			counter++;
			ch = in.charAt(counter);
		}
		return counter;
	}
}