package com.tao.dynamicproxy.jdk;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>
 * </p>
 **/
public class CookImpl implements Cook {
    @Override
    public void dealwith(String material) {
        System.out.println("正在洗" + material);
    }

    @Override
    public void cook(String material) {
        System.out.println("正在烹饪" + material);
    }
}
