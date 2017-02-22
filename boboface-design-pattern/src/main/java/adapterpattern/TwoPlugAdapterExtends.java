package adapterpattern;

/**
 * Created by zwb on 2017/2/22.
 */
public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf {
    public void powerWithThree() {
        System.out.println("借助继承适配器");
        this.powerWithTwo();
    }
}
