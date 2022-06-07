package Binary_Search;

public class FindPivot {

    public static int findPivot(int[] arr){

        int high=arr.length-1;
        int low=0;

        while(low<high){
            int mid=low+(high-low)/2;

            if(arr[mid]>high){
                low=mid+1;
            }else if(arr[mid]<high){
                high=mid;
            }

        }

        return arr[high];

    }

}
