package singleton;


/**
 * @Description 单例模式
 * 双重校验锁方式,双重校验，一个锁
 * 线程安全，并且有懒加载，相对较好
 * @ClassName SingletonDoubleCheck
 * @Author zzd
 * @Create 2019/7/9 14:13
 * @Version 1.0
 **/
public class SingletonDoubleCheck {
    private volatile static SingletonDoubleCheck mySingleton;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {
        if (null == mySingleton) {
            synchronized (SingletonDoubleCheck.class) {
                if (null == mySingleton) {
                    mySingleton = new SingletonDoubleCheck();
                }
            }
        }
        return mySingleton;
    }
}
