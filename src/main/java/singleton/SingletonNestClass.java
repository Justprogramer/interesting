package singleton;

import lombok.Data;

/**
 * author: TAOPENG
 * time ： 2019/3/21
 **/
@Data
public class SingletonNestClass {
    /**
     * 把Singleton实例放到一个静态内部类中，
     * 这样就避免了静态实例在Singleton类加载的时候就创建对象，
     * 并且由于静态内部类只会被加载一次，所以这种写法也是线程安全的
     */
    private static class Holder {
        private static final SingletonNestClass SINGLETON_NEST_CLASS = new SingletonNestClass();
    }

    private SingletonNestClass() {
    }

    public static SingletonNestClass getInstance() {
        return Holder.SINGLETON_NEST_CLASS;
    }
}
