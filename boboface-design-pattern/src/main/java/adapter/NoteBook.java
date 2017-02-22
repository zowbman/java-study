package adapter;

/**
 * Created by zwb on 2017/2/22.我的笔记本电脑
 */
public class NoteBook {
    private ThreePlugIf plug;//如果你的笔记本需要三相插座供电

    public NoteBook(ThreePlugIf plug) {
        this.plug = plug;
    }

    public void charge() {
        plug.powerWithThree();
    }

    public static void main(String[] args) {
        //第一种：组合方式
        GBTwoPlug gbTwoPlug = new GBTwoPlug();
        ThreePlugIf threePlugIf = new TwoPlugAdapter(gbTwoPlug);//只有二相插座供电->要转3插
        NoteBook noteBook = new NoteBook(threePlugIf);
        noteBook.charge();

        //第二种、继承方式
        ThreePlugIf threePlugIf2 = new TwoPlugAdapterExtends();
        NoteBook noteBook2 = new NoteBook(threePlugIf2);
        noteBook2.charge();
    }
}
