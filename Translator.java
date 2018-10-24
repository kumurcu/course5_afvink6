package afvink6;



public class Translator {
  static final char[] Polair = { 'R', 'N', 'D', 'C', 'Q', 'E', 'G', 'H', 'K', 'S', 'T', 'Y' };
  static final char[] Apolair = { 'A', 'F', 'I', 'L', 'M', 'P', 'W', 'V' };  
  
  public static void main(String[] args) {
      
  }
  
  
  public static int Polair(String symbol) throws NotAnAA {
    int p = 0;
    for (char e : symbol.toCharArray()) {
        for (char f : Polair) {
            if (e == f){
                p++;
            }
        }
    }
    
    return p;
  }
 
  public static int Apolair (String symbol) throws NotAnAA{
    int a = 0;
    for (char c : symbol.toCharArray()) {
        for (char b : Apolair) {
            if (c == b) {
                a++;
            }
        }
    }

        
    return a;
  }

  
   
    
    class NotAnAA extends Exception {

/**
* Overschrijven van de constructor van Exception
*/
  public NotAnAA() {
  /** call van de constructor van de super class: Exception
  */
    super();
  }

  public NotAnAA(String err) {
    super(err);
  }
    }
}
    