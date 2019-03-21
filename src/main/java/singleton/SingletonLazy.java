package singleton;

/**
 * author: TAOPENG
 * time ： 2019/3/21
 **/
public class SingletonLazy {
    /**
     * 懒汉模式，需要的时候再创建，属于懒加载
     * 但是会造成线程安全问题，多线程会创建多个instance
     * 使用synchronized修饰方法，解决多线程问题
     * 但是 new SingletonLazy() 不是原子操作，所以如果不加volatile会出问题
     */
    private static volatile SingletonLazy singleton;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (singleton == null) {
            synchronized (SingletonLazy.class) {
                if (singleton == null) {
                    return singleton = new SingletonLazy();
                }
                return singleton;
            }
        }
        return singleton;
    }
}
