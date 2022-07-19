package Rough;

public class BuySell2 {

    public static int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n+1][2];

        for(int i=n;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(i==n){
                    dp[i][j]=0;
                }
                else{
                    if(j==1){
                        dp[i][j]=Math.max(dp[i+1][1], prices[i+1]+dp[i+1][0]);
                    }
                    else{
                        dp[i][j]=Math.max(dp[i+1][1]-prices[i-1], dp[i+1][0]);
                    }
                }
            }
        }

        return Math.max(dp[0][0], dp[0][1]);



    }


    public static void main (String[] args) throws java.lang.Exception
    {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));

    }

}
