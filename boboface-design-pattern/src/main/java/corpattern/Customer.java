package corpattern;

import corpattern.handler.PriceHandler;
import corpattern.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * Created by zwb on 2017/2/23.客户，请求折扣
 */
public class Customer {
    private PriceHandler priceHandler;

    public void requestDiscount(float discount) {
        priceHandler.processDiscount(discount);
    }

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());

        Random rand = new Random();

        for (int i = 1; i < 100; i++) {
            System.out.print(i + ":");
            customer.requestDiscount(rand.nextFloat());
        }
    }
}