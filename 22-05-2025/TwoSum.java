class TwoSum{
    public static int[] twoSum(int[] arr,int tar){
        int left=0;
        int right=arr.length-1;
        int[] res={-1,-1};
        while(left<right){
            if(arr[left]+arr[right]<tar){
                left++;
            }
            else if(arr[left]+arr[right]>tar){
                right--;
            }else{
                res[0]=left;
                res[1]=right;
                break;
            } 
        }return res;
    }
    public static void main(String[] args){
        int[] arr={-3,-1,5,6};
        int tar=3;
        int[] res=TwoSum.twoSum(arr, tar);
        if(res[0]==-1){
            System.out.println("No pair adding to the given sum");
            return;
        }
        System.out.println(res[0]+" "+res[1]);

        
    }
}