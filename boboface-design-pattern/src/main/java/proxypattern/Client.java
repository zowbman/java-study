package proxypattern;

/**
 * Created by zwb on 2017/2/23.测试类
 */
public class Client {
    public static void main(String[] args) throws Exception {
		/*Car car = new Car();
		car.move();*/

        //使用继承方式
		/*Moveablem = new Car2();
		m.move();*/
        //使用聚合方式实现
		/*Car car = new Car();
		Moveable m = new CarTimeProxy(car);
		m.move();*/


        //先记录日志，再记录时间
		/*Car car = new Car();
		CarLogProxy clp = new CarLogProxy(car);
		CarTimeProxy ctp = new CarTimeProxy(clp);
		ctp.move();*/

        Car car = new Car();
        InvocationHandler h = new TimerHandler(car);
        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
        m.move();
    }
}