package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {

    // Stock class to store the price and index
    public class Stock {
        int price;
        int index;

        // Constructor to initialize price and index
        public Stock(int price, int index) {
            this.price = price;
            this.index = index;
        }

        // Getter for price
        public int getPrice() {
            return price;
        }

        // Getter for index
        public int getIndex() {
            return index;
        }
    }
    public ArrayList<Integer> stockSpan(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Stock> st = new Stack<>();
        int n = arr.length;

        for(int i=0; i<n; i++) {

            if(st.empty()) {
                ans.add(-1);
            }
            else if(!st.empty() && st.peek().getPrice() >= arr[i]) {
                ans.add(i - st.peek().getIndex());
            }
            else if(!st.empty() && st.peek().getPrice() < arr[i]) {

                while(!st.empty() && st.peek().getPrice() < arr[i] ) {
                    st.pop();
                }
                if(st.empty()) {
                    ans.add(-1);
                }
                else {
                    ans.add(i - st.peek().getIndex());
                }
            }
            st.push(new Stock(arr[i],i));
        }
        return ans;
    }


    public static void main(String[] args) {
        StockSpan ss = new StockSpan();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> result = ss.stockSpan(prices);

        // Print the stock span for each price
        for (int span : result) {
            System.out.print(span + " ");
        }
    }
}
