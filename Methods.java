import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.FileReader;

public class Methods {

// This method will check if there are repetitive letters in the keyword and will return a boolean
	public static boolean checkkeyword(String s) {
// The loops will check every letter in the String against all other letters, if it ever finds a match, it will return false 		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

// This method will check if the keyword passed has any letters in upper case and will return a boolean based on the validation	
	public static boolean isUpperCase(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

// This method will write to a file, it should be passed some content and a filename
	public static void fileWrite(String content, String fname) {
// The fname in this case is the name of the file from which the system will be reading the content from because it will be used to determine the name of the new file generated	
		try {
			String path = fname.substring(0, fname.length() - 1);
// As required in the assignment, if the fname ends with P it will write to the same file name but will use C to conclude the title and write the (assumed) encrypted content to it			
			if (fname.substring(fname.length() - 1).equals("P")) {
				FileWriter filewriter = new FileWriter(path + "C.txt");
				filewriter.write(content);
				filewriter.close();
				System.out.println("Encrypted file written sucessfully");
			}
// If the fname ends with C it will write to the same file name but will use D to conclude the title and write the (assumed) decrypted content to it						
			else if (fname.substring(fname.length() - 1).equals("C")) {
				FileWriter filewriter = new FileWriter(path + "D.txt");
				filewriter.write(content);
				filewriter.close();
				System.out.println("Decrypted file written sucessfully");
			}
// If the fname does not end with either characters, it should return an output statement and not write to any file			
			else {
				System.out.println("Invalid Filename");
			}
// 	If the program cannot open or create the file it will output an error message		
		} catch (IOException e) {
			System.out.println("File could not be created or opened!");
		}

	}

// A method to read from file, passed the full filename with extension
	public static char[] fileRead(String name) {
		String fname = name + ".txt";
		String content = "";
		FileReader fr = null;
// A try catch statement that opens the file and would return an error message if it's not found

		try {
			fr = new FileReader(fname);
		} catch (FileNotFoundException e) {

			System.out.println("Could not read file or file does not exist!");
		}
// If the file exists, using a scanner, it will read the file and save the content in a variable. It will return the result in an array of characters
		Scanner s = new Scanner(fr);

		while (s.hasNextLine()) {

			content = content + s.nextLine() + "\r\n";
		}
		return content.toCharArray();
	}

// Another file writer that is especially made to be passed content from the frequencies class' analysis method. It will use the given file name to wrote to a new file with the same name and adds an F to the end
	public static void freqFileWrite(String content, String fname) {

		try {
			String path = fname.substring(0, fname.length() - 1);

			FileWriter filewriter = new FileWriter(path + "F.txt");
			filewriter.write(content);
			filewriter.close();
			System.out.println("Frequency file written sucessfully");
// An error message if the file could not be created or opened
		} catch (IOException e) {
			System.out.println("File could not be created or opened!");
		}

	}

}