package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
       StringBuilder sb = new StringBuilder(str);
      for (int i = 0; i < characters.length; i++) {
		sb.append(characters[i]);
	}
    	
       return sb.toString();
    }
    
    public static String reverse(String str) {
    	   StringBuilder sb = new StringBuilder(str);
    	   sb.reverse();
    	   return sb.toString();
    }
    
    public static String insert(String str, int index, char newChar) {
    	   StringBuilder sb = new StringBuilder(str);
    	   sb.insert(index, newChar);
    	   return sb.toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	   StringBuilder sb = new StringBuilder(str);
    	   sb.delete(startIndex, endIndex);
    	   return sb.toString();
    }
}