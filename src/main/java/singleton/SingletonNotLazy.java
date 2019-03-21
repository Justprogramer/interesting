package singleton;

/**
 * author: TAOPENG
 * time ： 2019/3/21
 **/
public class SingletonNotLazy {
    /**
     * 饿汉式创建，使用static final能保证类加载的时候就创建instance
     * 能保证线程安全，不是懒加载的
     * 缺点是不能通过配置文件动态生成，或者类加载之前必须使用参数定义他的配置参数
     */
    private static final SingletonNotLazy SINGLETON_TWO = new SingletonNotLazy();

    private SingletonNotLazy() {
    }

    public SingletonNotLazy getInstance() {
        return SINGLETON_TWO;
    }
}
