import java.util.*;
public class NextGreaterElement {
    public static void findNextGreater(int[] nums) {
        int len=nums.length;
        int[] res=new int[len];
        Stack<Integer> stk = new Stack<>();
        for (int i=len-1;i>=0;i--){
            while (!stk.isEmpty() && stk.peek()<=nums[i]) stk.pop();
            res[i] = stk.isEmpty()?-1:stk.peek();
            stk.push(nums[i]);
        }
        for(int n:res) System.out.print(n + " ");
    }
    public static void main(String[] args) {
        int[] data = {1,3,2,4};
        findNextGreater(data);
    }
}
