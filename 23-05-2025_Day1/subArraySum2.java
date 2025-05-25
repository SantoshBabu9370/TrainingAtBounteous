import java.util.*;
public class subArraySum2 {
     public static int subArrays2(int[] arr,int k){
        HashMap<Integer,Integer> mp=new HashMap<>();
        int sum=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k) count++;
            if(mp.containsKey(sum-k)) count+=mp.get(sum-k);
            mp.put(sum,mp.getOrDefault(sum,0)+1);    
        }
        return count;
     }
     public static void main(String[] args) {
        int[] arr={1,2,8,10};
        int tar=10;
        int res=subArraySum2.subArrays2(arr, tar);
        System.out.println(res);
    }
}
