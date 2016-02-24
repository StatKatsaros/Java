package stathis.Week1;

import edu.duke.*;
import edu.duke.FileResource;

/**
 * Write a description of WordLengths here.
 * 
 * @author Stathis Katsaros 
 * @version 23/02/2016
 */
public class WordLengths {
    /**
     * Method countWordLengths
     *This method should read in the words from resource and count the number of words of each length for all the words in resource, 
    storing these counts in the array counts.

    - For example, after this method executes, counts[k] should contain the number of words of length k.

    - If a word has a non-letter as the first or last character, it should not be counted as part of the word length. 
    For example, the word And, would be considered of length 3 (the comma is not counted), the word “blue-jeans” 
    would be considered of length 10 (the double quotes are not counted, but the hyphen is). 
    Note that we will miscount some words, such as “Hello,” which will be counted as 6 since 
    we don’t count the double quotes but will count the comma, but that is OK as there should not be many words in that category.

    - For any words equal to or larger than the last index of the counts array, count them as the largest size represented in the counts array.

    - You may want to consider using the Character.isLetter function that returns true if a character is a letter, and false otherwise. 
    For example, Character.isLetter(‘a’) returns true, and Character.isLetter(‘-’) returns false. 
     * @param resource
     * @param counts 
     */
    
    public void countWordLengths(FileResource resource, int[] counts) {
        for(String word : resource.words()){
            String trim = word.trim(); //It returns a copy of this string with leading and trailing white space removed, or this string if it has no leading or trailing white space.
            int wordSize = trim.length();
            char firstCh = trim.charAt(0);
            char lastCh = trim.charAt(wordSize -1);
            if(Character.isLetter(firstCh) == false && Character.isLetter(lastCh) == false) {//there is no exist at abc not first nor last
                wordSize -=2;
                
                //System.out.println(wordSize);
            }
            else if(Character.isLetter(firstCh) == false || Character.isLetter(lastCh) == false) {//there is no exist at abc not first nor last
                wordSize -=1;

                //System.out.println(wordSize);
            }
            if (wordSize >= counts.length){
                counts[counts.length -1] +=1;
                //System.out.println(wordSize);
            }
            else if(counts[wordSize] !=0){
                counts[wordSize] += 1;
                //System.out.println(wordSize);
            }
            else{
                counts[wordSize] = 1;
            }
            
        }
        
    }
    
    public void testCountWordLengths (){
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr,counts);
        for (String word : fr.words()){
            //System.out.println(word);
        }
        for (int i : counts){
            //System.out.print(" " + i);
        }
        for(int k=0; k<counts.length; k++){
            System.out.println("There are  " +  counts[k] + " words with " + k + " characters");
        }
        indexOfMax(counts);
    }
    
    /*This method returns the index position of the largest element in values. 
     * @param int[] values
     */
    public void indexOfMax(int[] values){
        int max = 0;
        for(int i = 0; i <values.length; i++){
            if(values[i]>max){
                max = values[i];
            }
        }
        System.out.println( "The most common word length in the file has " + max + " characters");
    }
    
    
}
