package interview.questions;

public class MaximizeStockProfit {

    public static int maximizeProfit(int[] prices){
       int length = prices.length;
       int nextBig = -1 , j = length -1 , maxProfit = 0 , profit;
       while(j >= 0){
           if(nextBig < prices[j])
               nextBig = prices[j];
           if(nextBig > prices[j]){
               profit = nextBig - prices[j];
               if(profit > maxProfit)
                   maxProfit = profit;
           }
           j--;
       }
       return maxProfit;
    }
    public static void main(String [] args){
        int [] input = {7,6,4,3,1};
        int maxProfit = maximizeProfit(input);
        System.out.println("Max profit = "+maxProfit);
    }
}
