package _03_Intro_To_Regular_Expressions;

/*
 * Use String.replaceAll() to change the portion of the e-mail addresses after
 * the '@' to mail.com in the original message string below. For example,
 * johnDoe@newmail.com => johnDoe@mail.com
 * janeDoe@wwwmail.com => janeDoe@mail.com
 * 
 * You can assume:
 * 1. There are only word characters (\\w) after the '@' and there will always
 *    be at least 1.
 * 2. The string will always end in ".com" (\\.com)
 */

public class _01_RegularExpressionsIntro {
    /*
     * Code method below! 
     */
	
    String emailRemover(String message) {
    String fin ="";
    /*
      Replace all characters including and in between ',' and 'x'  
     
      '.' represents any character (except a new line),
      '+' means match 1 or more characters, so it reads
      <comma><1 or more characters><x character>
     
    regEx = "[,].+[x]";
    output = testString.replaceAll(regEx, "_");
    System.out.println(output);
    */
    String regEx = "[@].+[.]";
     fin = message.replaceAll(regEx, "@mail.");
    System.out.println(fin);
    
    return fin;
    }
}
