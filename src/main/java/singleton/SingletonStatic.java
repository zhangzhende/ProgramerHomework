package singleton;

/**
 * @Description 写一个单利
 * 静态方式，饿汉方式
 * 线程安全，但是项目启动就加载，没有什么问题，但是相对来讲比较占资源【不管用没用，都加载了】
 * @ClassName Singleton
 * @Author zzd
 * @Create 2019/7/9 14:06
 * @Version 1.0
 **/
public class SingletonStatic {
    private static SingletonStatic mySingleton = new SingletonStatic();

    public static SingletonStatic getInstance() {
        return mySingleton;
    }

    private SingletonStatic() {
    }
}
