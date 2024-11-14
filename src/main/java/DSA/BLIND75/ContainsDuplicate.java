package DSA.BLIND75;

import java.util.HashSet;

public class ContainsDuplicate{

    public static void main(String[] args) {
        // Needs to find the duplicate
        String s = "testStringDuplicate";
        // brute force
        checkForDuplicate(s);
        optimisedDuplicateCheck(s);
    }

    private static void optimisedDuplicateCheck(String s) {

        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0; i < s.length();i++){

            if(hashSet.contains(s.charAt(i))){
                System.out.println(s.charAt(i));
                break;
            } else{
                hashSet.add(s.charAt(i));
            }
        }

    }

    private static void checkForDuplicate(String s) {
         //  O(n2) solution.
        boolean flag = false;
        for(int i = 0 ; i< s.length() - 1 ; i++){
            for(int j = i + 1 ; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println(s.charAt(i));
                break;
            }
        }
    }
}
