public class firstOccurence {
    public static int firstOccur(String haystack,String needle){
        return haystack.indexOf(needle);
    }
    public static void main(String[] args) {
        System.out.println(firstOccurence.firstOccur("sadbutsad","sad"));
    }
    
}
