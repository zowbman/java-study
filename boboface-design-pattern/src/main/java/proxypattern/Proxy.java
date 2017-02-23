package proxypattern;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by zwb on 2017/2/23.
 */
public class Proxy {
    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
        String rt = "\r\n";
        String methodStr = "";
        for (Method m : infce.getMethods()) {
            methodStr +=
                    "	@Override" + rt +
                            "	public void " + m.getName() + "() {" + rt +
                            "		try{" + rt +
                            "			Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
                            "			h.invoke(this,md);" + rt +
                            "			}catch(Exception e){e.printStackTrace();}" + rt +
                            "	}";
        }

        String str =
                "package zb_proxy;" + rt +
                        "import zb_proxy.InvocationHandler;" + rt +
                        "import java.lang.reflect.Method;" + rt +
                        "/**" + rt +
                        "* " + rt +
                        "* Title:Car3" + rt +
                        "* Description:聚合是什么，就是一个类当中调用另外一个类的对象" + rt +
                        "* @author    zwb" + rt +
                        "* @date      2016年6月6日 上午10:34:45" + rt +
                        "*" + rt +
                        "*/" + rt +
                        "public class $Proxy0 implements " + infce.getName() + " {" + rt +

                        "	public $Proxy0(InvocationHandler h) {" + rt +
                        "		this.h = h;" + rt +
                        "	}" + rt +
                        "	" + rt +
                        "	private InvocationHandler h;" + rt +
                        methodStr + rt +
                        "	" + rt +
                        "}";

        //产生代理类的java文件
        String filename = System.getProperty("user.dir") + "/bin/zb_proxy/$Proxy0.java";
        //System.out.println(filename);
        File file = new File(filename);
        FileUtils.writeStringToFile(file, str);

        //编译
        //拿到编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        //获取文件
        Iterable units = fileMgr.getJavaFileObjects(filename);
        //编译任务
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        //进行编译
        t.call();
        fileMgr.close();

        //load到内存
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass("zb_proxy.$Proxy0");

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        return ctr.newInstance(h);
    }
}