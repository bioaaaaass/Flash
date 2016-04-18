package designpattern;

/**
 * 外界无法通过构造器来创建对象，该类必须提供一个静态方法向外界提供该类的唯一实例。
 *
 * Created by huangzhibo on 4/6/16.
 */
public class Singleton {
    /**
     * 饿汉式
     */
//    private Singleton(){}
//    private static Singleton instance = new Singleton();
//    public static Singleton getInstance(){
//        return instance;
//    }

    /**
     * 懒汉式
     */
    private static Singleton instance = null;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if (instance == null) instance = new Singleton();
        return instance;
    }
}
