import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.FileReader;

public class Main {
	public static void main(String args[]) {
// The scanner will take user input for file path and keyword. We'll store the path without the .txt for later use		
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter file name");
		String name = keyboard.next();

// Pass the file variable to a file reader to access the encrypted/decrypted text in the file. The file reader will return the content of the file into an array of characters		
		char[] content = Methods.fileRead(name);

		System.out.println("Enter keyword");
		String keyword = keyboard.next();
// If the keyword violates upper case and repetition constraints, keep asking the user for another keyword
		while (Methods.checkkeyword(keyword) == false || Methods.isUpperCase(keyword) == false) {
			System.out.println("Enter a valid keyword");
			keyword = keyboard.next();
		}

// Create an object of either one of the cipher class using the constructor and passing the keyword and content (converted into a string format)	
		MonoAlphabetic testObject = new MonoAlphabetic(keyword, String.valueOf(content));
//		Vignere testObject = new Vignere (keyword,String.valueOf(message));
// Also create an object of class Frequencies to later write a frequency file		
		Frequencies testFreq = new Frequencies();
// Depending on the user input; final letter of the file, we will call the encryption or decryption methods of the object. In both cases we will also call the Frequencies's file writer to analyze the output text		
		System.out.println(name);
		if (name.substring(name.length() - 1).equals("P")) {
			testObject.setecontent();
			Methods.fileWrite(testObject.getecontent(), name);
			Methods.freqFileWrite(testFreq.analysis(testObject.getecontent()), name);
			System.out.println("Encrypted text is \n\n" + testObject.getecontent());
		} else if (name.substring(name.length() - 1).equals("C")) {
			testObject.setdcontent();
			Methods.fileWrite(testObject.getdcontent(), name);
			Methods.freqFileWrite(testFreq.analysis(testObject.getdcontent()), name);
			System.out.println("Decrypted text is \n\n" + testObject.getdcontent());
		}
	}

}
