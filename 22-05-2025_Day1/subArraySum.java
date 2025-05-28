class subArraySum {
    public static int subArrays(int[] arr,int k){
        int left=0;
        int currSum=0;
        int count=0;
        for(int right=0;right<arr.length;right++){
            currSum+=arr[right];
            if(currSum>k){
                while(currSum>k&&left<=right){
                    currSum-=arr[left];
                    left++;
                }
            }if(currSum==k) count++;

        }return count;

    }
    public static void main(String[] args) {
        int[] arr={1,2,3,5,1,4};
        int tar=5;
        int res=subArrays(arr, tar);
        System.out.println(res);
    }

    
}