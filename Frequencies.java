import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.FileReader;

public class Frequencies {
// A constructor to make an object of the class Frequencies	
	public Frequencies() {
	}

// Only one method in the class, it will create the analysis and return the content as a string
	public String analysis(String s) {
// Defined variables include average frequencies already given, an array of the alphabets to have the corresponding analysis for each letter and the other empty arrays will be used to store the other analysis into 		
		double[] avgfreq = { 8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0, 0.2, 0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0,
				6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1 };

		char alpha[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',

				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',

				'W', 'X', 'Y', 'Z' };

		int[] freq = new int[26];

		double[] freqprct = new double[26];

		double[] diff = new double[26];

// First loop will check every letter in the string against all the alphabets, once it found a match in the alphabet array, it should add to the corresponding position in the frequencies array using the alphabet index found	
		int counter = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= 25; j++) {
				if (s.charAt(i) == alpha[j]) {
					freq[j] += 1;
// The counter will be used to store only the number of times an upper case alphabet letter was found giving us the same for later use
					counter += 1;
				}
			}
		}
// Second loop will use every value in the frequency array and divide it by the total number of found upper case alphabets then store the result into a new array; displaying the percentage frequencies		
		for (int i = 0; i <= 25; i++) {

			freqprct[i] = ((freq[i] / (double) counter)) * 100;

		}
// Third loop will simply subtract each value at every index of the frequency array to the corresponding value at the index of the average frequency array and will store the value into a new array	 
		for (int i = 0; i <= 25; i++) {

			diff[i] = avgfreq[i] - freq[i];
		}

// Before the start of the final loop that will fill in the content. We create and initialize the string variable content, we also add the fixed header titles of what each array will returning  	
		String content = "Letter    Freq    Freq%    AvgFreq%     Diff  \r\n";
// The final loop will print out the content of all the arrays row by row and store them into the variable content			 
		for (int i = 0; i <= 25; i++) {

			content += alpha[i] + "       " + String.format("%2d", freq[i]) + "       "
					+ String.format("%4.1f", freqprct[i]) + "       " + String.format("%4.1f", avgfreq[i]) + "       "
					+ String.format("%4.1f", diff[i]) + "\r\n";

		}
// The method will finally return the content variable		
		return content;

	}

}
