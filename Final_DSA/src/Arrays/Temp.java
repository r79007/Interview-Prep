package Arrays;

public class Temp {


    public static double findSq(int x){

        double l = 0;
        double r = x;

        while(l<r){
            double mid = (l+r)/2;

            if(mid*mid<x){
                l = mid;
            }
            else if(mid*mid>x){
                r=mid;
            }
            else{
                return mid;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int x = 3;

        System.out.println(findSq(x));
    }

}
