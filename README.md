# Java

//////////////////////////////WordPlay/////////////////////////////////////

  Method isVowel that has one Char parameter named ch. This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise. Tester method to see if this method works correctly. For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.
    
  Method replaceVowels that has two parameters, a String named phrase and a Char named ch. This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch. For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”.
    
  Method emphasize with two parameters, a String named phrase and a character named ch. This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by

‘*’ if it is in an odd number location in the string (first character has index 0, third character has index 2, etc.), or

‘+’ if it is in an even number location in the string (second character has index 1, fourth character has index 3, etc.).

For example, the call emphasize(“dna ctgaaactga”, ‘a’) would return the string “dn* ctg+*+ctg+”, and the call emphasize(“Mary Bella Abracadabra”, ‘a’) would return the string “M+ry Bell+ +br*c*d*br+”. 

////////////////////////////Ceasar Cipher////////////////////////////////////////


  Method encrypt that has two parameters, a String named input and an int named key. This method returns a String that has been encrypted using the Caesar Cipher algorithm. Assume that all the alphabetic characters are uppercase letters. For example, the call

encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)

should return the string

“CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”

  Method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2. This method returns a String that has been encrypted using the following algorithm. Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character, and key2 is used to encrypt every other character, starting with the second character. For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc.
  
  ///////////////////////////////////WordLengths//////////////////////////////////
  
  Method countWordLengths that has two parameters, a FileResource named resource and an integer array named counts. This method should read in the words from resource and count the number of words of each length for all the words in resource, storing these counts in the array counts.

- For example, after this method executes, counts[k] should contain the number of words of length k.

- If a word has a non-letter as the first or last character, it should not be counted as part of the word length. For example, the word And, would be considered of length 3 (the comma is not counted), the word “blue-jeans” would be considered of length 10 (the double quotes are not counted, but the hyphen is). Note that we will miscount some words, such as “Hello,” which will be counted as 6 since we don’t count the double quotes but will count the comma, but that is OK as there should not be many words in that category.

- For any words equal to or larger than the last index of the counts array, count them as the largest size represented in the counts array.


  Method testCountWordLengths that creates a FileResource so you can select a file, and creates a counts integer array of size 31. This method should call countWordLengths with a file and then print the number of words of each length. 
  
  Method indexOfMax that has one parameter named values that is an integer array. This method returns the index position of the largest element in values. Then add code to the method testCountWordLengths to call indexOfMax to determine the most common word length in the file. For example, calling indexOfMax after calling countWordLengths on the file smallHamlet.txt should return 3.
  
  
  /////////////////////////////////CaesarBreaker//////////////////////////////////////
  
  Method decrypt decrypts a message that was encrypted with one key, using statistical letter frequencies of English text 'e' in our case. 
  
  Method countLetters takes as string of words and returns an array with the frequency of the letters. The index of represents 
the ch or a word (example: name has 4 characters) and inside the blocks we have the frequency of the words (example: at string "my name is jonh" we gonna have that result [0,0,2,2]).

///////////////////////////////////



