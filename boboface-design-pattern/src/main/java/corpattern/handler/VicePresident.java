package corpattern.handler;

/**
 * Created by zwb on 2017/2/23.
 */
public class VicePresident extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.5) {
            System.out.format("%s批准了折扣%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
