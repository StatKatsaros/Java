
package stathis.Week1;
import edu.duke.*;

public class CaesarCipher {
    
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lalphabet = "abcdefghijklmnopqrstuvwxyz";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        String shiftedLAlphabet = lalphabet.substring(key)+ lalphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            if(Character.isLowerCase(currChar)){
                int idx = lalphabet.indexOf(currChar);
                if(idx != -1){
                    char newChar = shiftedLAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
            
                }
            }
            else{
                //Find the index of currChar in the alphabet (call it idx)
                int idx = alphabet.indexOf(currChar);
                if(idx != -1){
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabet.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
            }
            
            //If currChar is in the alphabet
            
            //Otherwise: do nothing
        }
       // System.out.println(encrypted.toString());
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1,int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String result = "";
        for (int i = 0; i<encrypted.length(); i++){
            if(i%2 == 0){
                String temp3 = Character.toString(encrypted.charAt(i));
                String temp1 = encrypt(temp3, key1);
                result = result + temp1;
            }
            else{
                String temp4 = Character.toString(encrypted.charAt(i));
                String temp2 = encrypt(temp4,key2);
                result = result + temp2;
            }
        }
        System.out.println(result);
        return result;
    }
    
    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
}

