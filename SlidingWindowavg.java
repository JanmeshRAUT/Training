public class SlidingWindowavg {
    public static void main(String[] args) {
        int arr[]={2,3,2,1,4,5,7};
        int k=2;
        int sum=0;
        int a=0;
        for(int i=0;i<k;i++){
            sum+=i;
        }
        double Maxavg=sum/k;
        for(int i=k;i<arr.length;i++){
            sum=sum-arr[i-k]+arr[i];

            double currMax=(double) sum/k;

            if(currMax>Maxavg){
                Maxavg=currMax;
                a=
            }

        }
        System.out.println("Maximum Average:"+Maxavg);

    }    
}
