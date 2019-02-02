import java.util.Arrays;

public class MonoAlphabetic {
// MonoAlphabetic class	setters include the creation of the variables; the key array, encrypted and decrypted text 
	private String message;
	private String econtent;
	private String dcontent;
// A key array of the length of the alphabets that will be written to later	
	private char[] keyarray=new char[26];
// The array of the upper case alphabets used to check against values in all methods 	
    public char alpha[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',

            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',

            'W', 'X', 'Y', 'Z' };
// The constructor will take the given keyword and passed some content. It will call the method setKey to process a value for the keyarray and store it 
     public MonoAlphabetic (String keyword, String content) {
    	 setKey(keyword);
    	 message = content;
     }  
// This method will take the keyword string 
    public void setKey(String s) {
    	
		char[] key = s.toCharArray();
// It will first fill the beginning of the keyarray using the values  in the key (the keyword passed converted into an array)
        for (int i=0;i<key.length;i++) {
        	keyarray[i] = key[i];
        }
// The rest of the keyarray values will be filled according to the next loop       
	    int x=0;   
	    int i=key.length;
// We check against all 26 letters in the alphabet if they are in the key word or not, if they are the flag will return false	    
        while (x<26) {
// Flag changes back to true at the beginning of the loop  to determine the existence of the letter     	
            boolean flag = true;
// The loop will go through all the letters in the key to check them against a single character in the alphabet array, if one match is found, that means the letter exists at least once it will set the value of the flag to false permenantely inside this loop
            for (int j=0;j<key.length;j++) {
        		if(key[j] == alpha[x]) {
        			flag = false;
        		}   	
        	}         
// When it leaves the j loop, if the flag's value is true, copy the alphabet to the key array            
           	if (flag) {
        		keyarray[i] = alpha[x];
        		i++;
        	}
// x will be incremented at the end of the loop to move to the next character in the alphabet and will restart the loop, changing the flag to true to conduct the next test of all alphabets against the next alphabet letter       	
            x++;
        }        
    }	
// This is the encryption method, in the form of a setter
    public void setecontent()    {
// The message passed when creating the object will be used here and converted to an array of characters
        char[] word = message.toCharArray();
// An array to store the final encrypted version of the message       
        char[] code = new char[message.length()];
        
// This loop will go through the entire message        
        for (int i = 0; i < word.length; i++)

        {
// For each character in the message it will check if it's equal to the value in the alpha array
            for (int j = 0; j < 26; j++)

            {

                if (word[i] == alpha[j])

                {
// If yes, it will store the index at which it found that equality and use it store the same index position from the key array into the code array and exists to the next iteration of the loop
                    code[i] = keyarray[j];
                    break;
// Else it will copy whatever the value is in the word array as it is to the code array
                }
                else {
                	code[i] = word[i];
                }

            }

        }
// Coded array returned as string and a successful output message is given
        econtent= String.valueOf(code);
		System.out.println("Encryption successful");	

    }
 
// This method foes the same as the above with minor changes for the reverse operation
    public  void setdcontent()

    {

        char code[] = message.toCharArray();
        
        char[] word = new char[message.length()];
// Loop through the entire code array        
        for (int i = 0; i < code.length; i++)

        {
// For each character, check it against all characters in the key array
        	for (int j = 0; j < 26; j++)

            {
// If there an equality is found, use the found index at key array to store the value of the same index in the alpha array in the word array (decrypted text)       		
                if (code[i] == keyarray[j])

                {

                    word[i] = alpha[j];

                    break;

                }
// If it's not an uppercase alphabet letter, copy the value as it is to the word array               
                else {
                	word[i] = code[i];
                }

            }

        }

        dcontent = String.valueOf(word);
		System.out.println("Decryption successful");	

    }
//	Getters to be used in the main method
    public String getecontent() {
		return econtent;
    }
    
    public String getdcontent() {
    	return dcontent;
    }
    
    
    
}
