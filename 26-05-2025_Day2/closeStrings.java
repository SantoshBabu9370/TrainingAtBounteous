import java.util.*;
import java.util.HashSet;

public class closeStrings{
    public static boolean closestrings(String word1, String word2) {
        
       HashSet<Character> st1=new HashSet<>();
       HashSet<Character> st2=new HashSet<>();
       for(char c : word1.toCharArray()) st1.add(c);
       for(char c : word2.toCharArray()) st2.add(c);
       return st1.equals(st2);
       
    }
    public static void main(String[] args){
        System.out.println(closeStrings.closestrings("abc","bca"));

    }
}
