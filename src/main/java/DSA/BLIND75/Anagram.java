package DSA.BLIND75;

public class Anagram {

    // problem statement
     public static void main(String[] args){
         String s =  "anagram";
         String t = "margana";
         checkAnagram(s,t);
     }

    private static void checkAnagram(String s, String t) {

         char[] ch = s.toCharArray();
         char[] temp = new char[s.length()];
         int j = 0;
         for(int i = ch.length - 1; i >= 0; i--) {
              temp[j] = ch[i];
              j++;
         }
        String str = new String(temp);
        if(str.equalsIgnoreCase(t)){
            System.out.println("Anagram");
        }
    }
}
