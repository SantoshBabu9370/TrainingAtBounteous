import java.util.*;

public class nextGreater {
    public static int nxtGreater(int n){
        int piv=-1;
        char[] arr=Integer.toString(n).toCharArray();
        int i=arr.length-2;
       while(i>=0&&arr[i]>=arr[i+1]) i--;
       //Hiiee
    
        if(i==-1) return -1;
        int j=arr.length-1;

       while(arr[j]<=arr[i]) j--;
        swap(arr,i,j);
        
        reverse(arr, i+1, arr.length-1);
        return Integer.parseInt(new String(arr));
    }
    public static void swap(char[] arr,int i,int j){
        char temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;    
    }
    public static void reverse(char[] arr,int i,int j){
        while(i++<j--){
            swap(arr,i,j);
        }
    }
    public static void main(String[] args) {
        System.out.println(nextGreater.nxtGreater(213));
        
    }
}
