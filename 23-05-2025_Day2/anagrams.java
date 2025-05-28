import java.util.*;
public class anagrams {
    public static List<List<String>> grpAnagrams(String[] arr){
        HashMap<String,List<String>> mp=new HashMap<>();
        for(String s:arr){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String sorted=new String(c);
            if(mp.containsKey(sorted)){
                mp.get(sorted).add(s);
            }else{
                List<String> val=new ArrayList<>();
                val.add(s);
                mp.put(sorted,val);
            }
       }
        return new ArrayList<>(mp.values());
   }
    public static void main(String[] args) {
        String[] arr={"rtea","reat","hi","ih"};
        List<List<String>> res=anagrams.grpAnagrams(arr);
        System.out.println(res);
    }
    
}
