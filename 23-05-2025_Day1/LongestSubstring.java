import java.util.*;
class longestSubstring {
    public static int longestSubStr(String s) {
        // code here
        HashSet<Character> st=new HashSet<>();
        int res=-1;
        int left=0;
        int n=s.length();
        for(int right=0;right<n;right++){
             while(st.contains(s.charAt(right))){
                    st.remove(s.charAt(left));
                    left++;
                }
           st.add(s.charAt(right));
            res=Math.max(res,st.size());
        }return res;
    }
    public static void main(String[] args) {
        System.out.println(longestSubstring.longestSubStr("qwertyuuu"));
        
    }
}
