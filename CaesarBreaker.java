
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package stathis.Week1;
import edu.duke.*;
import java.io.*;
import java.util.*;




public class CaesarBreaker {
    
    public int maxIndex(int[] freqs) {
        int maxDex = 0;
        for (int i = 1; i < freqs.length; i++) {
            if (freqs[i] > freqs[maxDex]) {
                maxDex = i;
            }
        } 
        return maxDex;
        //return max;
    }
    
     public int[] countLetters(String message) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k<message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = abc.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
     public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted); //creates an array with every ch or string encrypted and every box has the frequency number of every ch.
        int maxDex = maxIndex(freqs);//find the ch with maximum frequency, we assume that would be 'e', according to statistics of english language
        int dkey = maxDex - 5; //finds the distance from 'e' location, so we found the key.
        if(maxDex < 5) {
            dkey = 26 - ( 5 - maxDex); 
        }
        // we use the appropriate key to return to decrypte string. the ch 'e' it is landmark. So 4 steps behind and we are at 'a',
        //but we have to count and the negative solution. if the 'e' is at position 2 for example. For key 4 the dkey should be 21.
        System.out.println(25-dkey);
        return cc.encrypt(encrypted, 25-dkey); // we can use encrypt method,same package
    }
    
    public String decryptWithKey(String encrypted, int key) {
        CaesarCipher cc = new CaesarCipher();

        return cc.encrypt(encrypted, 26-key); // we can use encrypt method,same package
    }
    
    /**
     * This method should return a new String that is every other character from message 
     * starting with the start position. For example, the call halfOfString(“Qbkm Zgis”, 0) 
     * returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1) returns the String
     * “bm Zi” . Be sure to test this method with a small example.
     * 
     * @param message
     * @param start
     * @return 
     */
    public String halfOfString(String message, int start ){
        String newMessage1 = "";
        String newMessage2 = "";
        StringBuilder sb = new StringBuilder(message);
        for(int i=0; i<sb.length(); i++){
            if(i%2 ==0){
                newMessage1 += message.charAt(i);
            }
            else{
                newMessage2 += message.charAt(i);
            }
        }
        if(start == 0){
            return newMessage1;
        }
        else if(start == 1){
            return newMessage2;
        }
        else{
            return "please insert int between 0 and 1";
        }
    }
    
    /**
     * This method should call countLetters to get an array of the letter frequencies in String s
     * and then use maxIndex to calculate the index of the largest letter frequency, which is
     * the location of the encrypted letter ‘e’, which leads to the key, which is returned.
     * 
     * @param s 
     * @return  
     */
    public int getKey(String s) {
        int[] freqs = countLetters(s);
        return maxIndex(freqs);
    }
    
    /**
     * In order to decrypt the encrypted String, it may be easier to split the String 
     * into two Strings, one String of all the letters encrypted with key1 
     * and one String of all the letters encrypted with key2 . Then use the algorithm from the
     * lesson to determine the key for each String, and then use those keys and the two key
     * encryption method to decrypt the original encrypted message. 
     * For example, if the encrypted message was “Qbkm Zgis” , then you would split this String into
     * two Strings: “Qk gs” , representing the characters in the odd number positions and “bmZi”
     * representing the characters in the even number positions. Then you would get the key for each
     * half String and use the two key encryption method to find the message. Note this example is so
     * small it likely won’t find the keys, but it illustrates how to take the Strings apart.
     * 
     * This method attempts to determine the two keys used to encrypt the message, 
     * prints the two keys, and then returns the decrypted String with those two keys. 
     * More specifically, this method should:
     *     ○ Calculate a String of every other character starting with the first character of the
     *       encrypted String by calling halfOfString.
     *     ○ Calculate a String of every other character starting with the second character of
     *      the encrypted String.
     *     ○ Then calculate the key used to encrypt each half String.
     *     ○ You should print the two keys found.
     *     ○ Calculate and return the decrypted String using the encryptTwoKeys method
     *      from your CaesarCipher class, again making sure it is in the same folder as your
     *      CaesarBreaker class.
     * 
     * @param encrypted
     * @return 
     */
    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String s1 = halfOfString(encrypted,0);
        String s2 = halfOfString(encrypted,1);
        int firstKey = getKey(s1);
        int secondKey = getKey(s2);
        System.out.println("The first key is: " + firstKey + " the second key is: " + secondKey);
        return cc.encryptTwoKeys(encrypted, firstKey, secondKey);
    }
    
    
    public void testExerc(){
        String s = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        StringBuilder sb = new StringBuilder(s);
        //String l = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        //String sNew = "";
        String s1 = decryptWithKey(halfOfString(s,0),14);
        StringBuilder s1b = new StringBuilder(s1);
        StringBuilder sbNew = new StringBuilder();
        String s2 = decryptWithKey(halfOfString(s,1),24);
        StringBuilder s2b = new StringBuilder(s2);
        for(int i = 0; i<(s.length()/2); i++){
            sbNew.append(s1.charAt(i));
            sbNew.append(s2.charAt(i));
            
        }
        
        
        //String la = halfOfString(l,0);
        //String lb = halfOfString(l,0);
        //System.out.println(sa);
        //System.out.println(sb);
        //System.out.println(la);
        //System.out.println(lb);
     
        System.out.println(sbNew.toString());
    }
    
    public void testExerc2(){
        String s = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sE = new StringBuilder();
        String s1 = halfOfString(s,0);
        String s2 = halfOfString(s,1);
        String s1d = decrypt(s1);
        String s2d = decrypt(s2);
        StringBuilder sb1 = new StringBuilder(s1d);
        StringBuilder sb2 = new StringBuilder(s2d);
        //System.out.println(s1);
        //System.out.println(s2);
        for(int i = 0; i<(s.length()/2); i++){
            sE.append(sb1.charAt(i));
            sE.append(sb2.charAt(i));
            
        }
        //sE.setLength(s.length()); //sE is now 45 blocks
        // 45/2 =22 not 22,5
        int sb1Size = sb1.length()-1;
        //System.out.println(sb1Size);
        if(s.length()%2 !=0){
           
           sE.append(sb1.charAt(sb1Size));
        }
        
        System.out.println(sb.toString());
        
        System.out.println(sE.toString());
    }
    
    public void testExerc3() throws IOException {
        FileResource fr = new FileResource();
        String message = fr.asString();
        message = message.replaceAll("\\s+", " "); //all whitespace beetween the words became one whitespace
        //System.out.println(message);
        String message1 = halfOfString(message,0);
        String message2 = halfOfString(message,1);
        String message1d = decrypt(message1);
        String message2d = decrypt(message2);
        StringBuilder message1b = new StringBuilder(message1d);
        StringBuilder message2b = new StringBuilder(message2d);
        StringBuilder mB = new StringBuilder();
        System.out.println(message.length()); //2732 %2 =0, no need for last character
        for(int i = 0; i<(message.length()/2); i++){
            mB.append(message1b.charAt(i));
            mB.append(message2b.charAt(i));
            
        }
        //String s = "Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin";
        //String s1 = decryptWithKey(halfOfString(s,0),9);
        //String s1 = halfOfString(s,0);
        //String s2 = halfOfString(s,1);
        //String s2 = decryptWithKey(halfOfString(s,1),22);
        //System.out.println(s1);
        //System.out.println(s2);
        System.out.println(mB.toString());
       
        
        
        
        
        
    }
    
    
        
    
}
