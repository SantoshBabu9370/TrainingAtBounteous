public class lenOfLast {
    public static int lenOfLast(String s){
        String[] arr=s.split(" ");
        return arr[arr.length-1].length();

    }

    public static void main(String[] args) {
        System.out.println(lenOfLast.lenOfLast("Santosh is working at Accolite"));
        
        
        
        
    }
    
}
