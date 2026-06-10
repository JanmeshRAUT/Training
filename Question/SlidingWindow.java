package Question;
public class SlidingWindow {
    public static void main(String[] args) {
        int arr[]={2,3,2,1,4,5,7};
        int k=3;

        int maxWindow=0;
        for(int i=0;i<k;i++){
            maxWindow+=arr[i];
        }
        int currentMax=maxWindow;
        for(int i=k;i<arr.length;i++){
            maxWindow=maxWindow+arr[i]-arr[i-k];
            if(currentMax<maxWindow){
                currentMax=maxWindow;
            }
        }
        System.out.println("Max Sum: "+currentMax);
    }
}
