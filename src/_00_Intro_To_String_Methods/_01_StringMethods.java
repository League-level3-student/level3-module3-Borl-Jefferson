package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
        String big="womp";
        if(s1.length()>s2.length()) {
        	    	System.out.println(s1);
        	return s1;
    
        }
        else {
                	System.out.println(s2);	
        	return s2;

        }
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	if(s.contains("underscores")) {
    		
    		s=s.replace(' ', '_');
    	}
    	
        return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
        int is1 = s1.trim().indexOf(' ');
        int is2 = s2.trim().indexOf(' ');
        int is3 = s3.trim().indexOf(' ');
    

    	if(s1.trim().charAt(is1+1)<s2.trim().charAt(is2+1)) {
    	
    		return s1.trim();
    	}
    	if(s2.trim().charAt(is2+1)<s3.trim().charAt(is3+1)) {
    
    		return s2.trim();
    	}
    	else {
    	
    		return s3.trim();
    	}
    	
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
int combined =0;
ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				list.add(Character.getNumericValue(s.charAt(i)));
			}
		}
       for (int i = 0; i < list.size(); i++) {
		combined += list.get(i);
	}
        return combined;
    }

    // Return the number of times String substring appears in String s
  
    public static int substringCount(String s, String substring) {
       int fin = 0;
    	int index = s.indexOf(substring);
    	 while( index != -1 ) {
             fin++;
             index = s.indexOf(substring, index + substring.length());
         }
    	return fin;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	byte[] bb = s.getBytes();
    	byte b = (byte) key;
    	return Utilities.encrypt(bb, b);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
        byte keyb = (byte) key;
    	return Utilities.decrypt(s, keyb);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
      int count = 0;
    	String[] strarr = s.split(" ");
       for (int i = 0; i < strarr.length; i++) {
    	   if(strarr[i].length()>substring.length()) {
    	   					if(strarr[i].substring(strarr[i].length()-substring.length(), strarr[i].length()).equals(substring)) {
			count++;
    	   					}
    	   }
	}
    	return count;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
      
        int min = s.indexOf(substring);
        int max = s.lastIndexOf(substring);
        return max-min-substring.length();
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
       s=s.trim();
       s=s.replaceAll(" ", "");
       if(s.contains("?")) {
       s=s.replace("?", "");
       }
       s=s.toLowerCase();
       if(s.contains(",")) {
    	   s=s.replaceAll(",", "");
    	   }
       if(s.contains("-")) {
    	   s=s.replaceAll("-", "");
       }
       if(s.contains(".")) {
    	   s=s.replaceAll(".", "");
       }
       if(s.contains(":")) {
    	   s.replaceAll(":", "");
       }
       boolean fin =false;
       char[] as = s.toCharArray();
       
     String srev = "";
     for (int i = s.length()-1; -1 < i; i--) {
    	 
		srev+=String.valueOf(as[i]);
		 System.out.println(srev + " MMM");
	}
     
   
     
     System.out.println(srev + s);
     if(srev.equals(s)) {
    	 System.out.println("same");
    fin = true;	
    }
     else {
    	 System.out.println("not same");
    	 }
     return fin;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static void encrypt(String s, char key) {
		// TODO Auto-generated method stub
		
	}

	public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
