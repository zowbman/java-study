package adapter;

/**
 * Created by zwb on 2017/2/22.二相插头设配器
 */
public class TwoPlugAdapter implements ThreePlugIf {
    private GBTwoPlug plug;//使用组合的方式

    /**
     * 修改设配器构造方法
     *
     * @param plug
     */
    public TwoPlugAdapter(GBTwoPlug plug) {
        this.plug = plug;
    }

    @Override
    public void powerWithThree() {
        System.out.println("通过转换");
        plug.powerWithTwo();
    }
}
