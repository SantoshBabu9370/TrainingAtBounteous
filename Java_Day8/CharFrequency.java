package Java_Day8;
import java.util.*;
import java.util.stream.*;
public class CharFrequency {
    public static void main(String[] args) {
        String word = "banana";
        Map<Character, Long> characterFrequency = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,                     
                        Collectors.counting()       
                ));
        System.out.println("Frequency of each character in " + word + ":");
        characterFrequency.forEach((character, count) ->
                System.out.println(character + " → " + count)
);
    }
}