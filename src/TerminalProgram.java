import java.util.*;

public class TerminalProgram {
    /**
     * A design of a single product price
     * It has a list of amounts and a list of prices. Note the index of amount matches the index of the prices list
     */

    private class ProductPrice {
        List<Integer> amounts;
        List<Double> prices;
        int size = 0;
        public ProductPrice(Double price){
            amounts = new ArrayList<>();
            prices = new ArrayList<>();
            amounts.add(1);
            prices.add(price);
            size++;
        }


        public void add(int amount, double price){
            amounts.add(amount);
            prices.add(price);
            size++;
        }

    }

    private Map<Character,ProductPrice> productsPrices = new HashMap<>();
    private Double total;

    /**
     * Sets the price for a single product with name productName
     * @param productName
     * @param price
     */
    public void setPricing(Character productName, double price){
        productsPrices.put(productName,new ProductPrice(price));
    }

    /**
     * Note a product must already contain a price for one before adding the price for more
     * @param productName
     * @param amount
     * @param price
     */
    public void setPricing(Character productName, int amount, double price){
        if(!productsPrices.containsKey(productName))
            throw new IllegalArgumentException("The price for a single product must first be added");
        productsPrices.get(productName).add(amount,price);
    }

    private Map<Character,Integer> getFrequency(String products){
        Map<Character,Integer> charTimes = new HashMap<>();
        for(int i=0; i<products.length();i++){
            char curr = products.charAt(i);
            charTimes.put(curr,charTimes.getOrDefault(curr,0) + 1);
        }

        return charTimes;
    }
    public void scan(String products){
        double totalPrice = 0;
        Map<Character,Integer> charFrequency = getFrequency(products);

        //get the price for each character amd add it to the total price
        for(Character curr: charFrequency.keySet()){
            int amount = charFrequency.get(curr);
            ProductPrice productPrices = productsPrices.get(curr);
            //search through from best value to determine the best deal
            for(int i=productPrices.size-1; i>= 0; i--){
                int currLargestAmount = productPrices.amounts.get(i);
                if(amount >= currLargestAmount){
                    totalPrice = totalPrice + (amount/currLargestAmount) * productPrices.prices.get(i);
                    amount = amount % currLargestAmount;
                }
            }
        }

        this.total = totalPrice;
    }

    String total(){
        return String.format("$ %.2f",total);
    }



}


