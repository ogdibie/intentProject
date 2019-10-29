import java.util.ArrayList;
import java.util.List;


public class ProductPrice {
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
