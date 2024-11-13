package DSA.BLIND75;

public class TwoSum {

    public static void main(String[] args) {
        // problem statement is need to add the two integers
        int a[] = new int[]{1,2,3,4,5};
        int target = 5;

        // need to add the two integers and the target will be the sum variable

        // O(n^2)

        //brute force
        // add two loops and implement

        for(int i = 0 ; i < a.length - 1; i++){
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

        // o(n)
        // using HashMap
    }
}
