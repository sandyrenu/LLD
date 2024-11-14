package DSA.BLIND75;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        // problem statement is need to add the two integers
        int a[] = new int[]{1,2,3,4,5};
        int target = 5;

        // need to add the two integers and the target will be the sum variable
        // O(n^2)

        //brute force
        // add two loops and implement
        for(int i = 0 ; i < a.length - 1; i++) {
            for(int j = i + 1 ; j < a.length - 2 ; j++){
                if(a[i] + a[j] == target){
                    System.out.println(i);
                    System.out.println(j);
                    break;
                }
            }

        }

        // O (nlog n)
        // sort the array and do two pointer approach
        Arrays.sort(a);
         int home = 0;
         int end = a.length - 1;
         while(home < end){
             if(a[home] + a[end] == target){
                 System.out.println(home);
                 System.out.println(end);
                 break;
             }
             else if(a[home] + a[end] > target){
                 end--;
             }
             else{
                 home++;
             }
         }
        // o(n)
        // using HashMap
        // This code will work for negative numbers also and added the List<Integer>
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> hashMap = new HashMap<>();
         for(int i = 0 ; i < a.length; i++){
             int target1 = target - a[i];
             if(hashMap.containsKey(target1)){
                 List<Integer> temp = new ArrayList<>();
                 temp.add(hashMap.get(target1));
                 temp.add(i);
                 System.out.println("Optimsed");
//                 System.out.println(hashMap.get(target1));
//                 System.out.println(i);
                 System.out.println(temp);
                result.add(temp);
             }
             else{
                 hashMap.put(a[i], i);
             }
         }
        System.out.println(result);
    }
}
