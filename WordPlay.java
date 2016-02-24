
/**
 * Illustrate Character methods
 * 
 * @author Stathis  
 * @version (a version number or a date)
 */


public class WordPlay{
    
    public  boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch ==  'a' || ch == 'e' ||  ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public void testIsVowel(){
        if(isVowel('A')) {
            System.out.println("it is a vowel ");
        }
        else{
            System.out.println("it is NOT a vowel ");
        }
    } 
    
    public String  replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder();
        sb.append(phrase);
        for(int i = 0; i<sb.length(); i++){
            if(isVowel(sb.charAt(i))){
                sb.setCharAt(i,ch);
            }           
        }
        return sb.toString();
    }
    
    
    public String emphasize(String phraseEm, char chEm){
        StringBuilder sbEm = new StringBuilder();
        sbEm.append(phraseEm);
        for(int i = 0; i<phraseEm.length(); i++){
            if(Character.toLowerCase(phraseEm.charAt(i)) == Character.toLowerCase(chEm)){
                if(i%2 == 0){
                   sbEm.setCharAt(i,'*'); 
                }
                else{
                    sbEm.setCharAt(i,'+');
                }
            }
        }
        return sbEm.toString();
    }
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
