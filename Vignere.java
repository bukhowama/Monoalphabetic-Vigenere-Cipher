
public class Vignere {
	private String message;
	private String econtent;
	private String dcontent;
	private String keyword;
	private char[][] keyarray;
	private int keywordLength;

	public char alpha[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',

			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',

			'W', 'X', 'Y', 'Z' };

// The constructor will take the key word along with the message (regardless of encyrption or decryption purposes)
	public Vignere(String k, String content) {
// The keyarray's length can only be defined at this point as it will use the length of the passed keyword for the row length 	    	
		keyarray = new char[k.length()][26];
// In the constructor we will also used the passed keyword to call the setKey method creating the key array
		setKey(k);
// Store the passed variables into the class's variables
		keyword = k;
		message = content;

	}

// This method will take the string keyword and use it to create the key array 
	public void setKey(String s) {

		char[] key = s.toCharArray();
		char alpha = ' ';
// The loop will go through all the elements of the keyword and will move downwards through the key array depending on the length of the keyword creating the rows of the key array     
		for (int i = 0; i < key.length; i++) {
// It will store the value of the current index of the key into alpha 
			alpha = key[i];
// And for each element in the keyword that has been stored in alpha, it will first write that element into the key array's row, go to the next using ASCII code numbers and write it
// It will continue doing this for 26 times in each row, if it reaches Z before 26 times , it will restart at A (65) and keep writing
			for (int j = 0; j < 26; j++) {

				keyarray[i][j] = alpha;
				alpha = (char) (alpha + 1);
				int code = (int) (alpha);
				if (code > 90) {
					alpha = 'A';
				}
			}
		}

	}

// This method will create the encrypted text using the message passed when creating the object
	public void setecontent()

	{

		char[] word = message.toCharArray();

		char[] code = new char[message.length()];
// index variable will be used later so that if we reach the last row of the key array and we still have more to encode, then it will restart at the 1st row again  	        
		int index = 0;
// This will loop through all elements in the message	        
		for (int i = 0; i < word.length; i++) {
// Each element of the message will be checked against all the alphabet letters	        	
			for (int j = 0; j <= 25; j++) {
// If there's a match, the saved index of the alpha array will be used as the column index pointer to find the corresponding position in the key array. For each element in the message, the index variable keeps the same fixed row inside the loop until the next iteration for the next element in the message
				if (word[i] == alpha[j]) {
					code[i] = keyarray[index][j];
// If found, and copied to the code array, we will move the index down by 1 and break to the next iteration
					index++;
					break;
				}
// Else, we will copy the content of the array index in the message to the code as it is	        	
				else {
					code[i] = word[i];
				}
// Here we restart the index at 0 to start from the first row of the keyword again	        	
			}
			if (index == keyword.length()) {
				index = 0;
			}

		}
// Save the array as string into econtent and display successful message	      	  
		econtent = String.valueOf(code);
		System.out.println("Encryption successful");

	}

// This method works vice-versa for the decryption of the passed message to the object	    
	public void setdcontent() {

		char[] code = message.toCharArray();

		char[] word = new char[message.length()];

		int index = 0;

		for (int i = 0; i < code.length; i++) {

			for (int j = 0; j <= 25; j++) {
// This time we will check the elements of the message against the key array, changing the columns but keeping the same row for each element in the message
				if (code[i] == keyarray[index][j]) {
// If found we will use the column index found in the key array to get the value at the alpha array of the corresponding position and store it in the word array; the decrypted messaage
					word[i] = alpha[j];
					index++;
					break;
				}

				else {
					word[i] = code[i];
				}

			}
			if (index == keyword.length()) {
				index = 0;
			}

		}

		dcontent = String.valueOf(word);
		System.out.println("Decryption successful");

	}

	public String getecontent() {
		return econtent;
	}

	public String getdcontent() {
		return dcontent;
	}

}
