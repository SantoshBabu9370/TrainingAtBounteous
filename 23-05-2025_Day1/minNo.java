public class minNo {
    public static int minNum(int n){
        if(n==0) return n;
        int[] fq=new int[10];
        while(n!=0){
            fq[n%10]++;
            n/=10;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<10;i++){
            if(fq[i]!=0){
                sb.append(i);
                fq[i]--;
                break;
            }
        }
        for(int i=0;i<10;i++){
            for(int j=0;j<fq[i];j++) sb.append(i);   
            } 
        return Integer.parseInt(sb.toString());}
    public static void main(String[] args) {
        System.out.println(minNo.minNum(3100));
        
    }
    
}
