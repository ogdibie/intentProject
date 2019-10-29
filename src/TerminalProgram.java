import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TerminalProgram {
    private Map<Character,ProductPrice> productsPrices = new HashMap<>();
    private Double total;

    //sets the price for a 1 product with productName
    public void setPricing(Character productName, double price){
        productsPrices.put(productName,new ProductPrice(price));
    }

    //Assuming that a price is already set before adding additional optionss
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
        for(Character curr: charFrequency.keySet()){
            int amount = charFrequency.get(curr);
            ProductPrice productPrices = productsPrices.get(curr);
            //search through from best value to determine the best deal
            for(int i=productPrices.size-1; i>= 0; i--){
                int currlargestAmount = productPrices.amounts.get(i);
                if(amount >= currlargestAmount){
                    totalPrice = totalPrice + (amount/currlargestAmount) * productPrices.prices.get(i);
                    amount = amount % currlargestAmount;
                }
            }
        }

        this.total = totalPrice;
    }

    String total(){
        return String.format("$ %.2f",total);
    }



}
