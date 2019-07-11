package com.tao.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author: Penger
 * @time: 2019/7/11
 * @description: <p>java中4种引用的使用示例
 * </p>
 **/
public class ReferenceDemo {

    public static void main(String[] args) {
        // Strong reference
        Object o = new Object();
        // Soft reference
        SoftReference softReference = new SoftReference<>(o);
        // weak reference
        WeakReference weakReference = new WeakReference<>(o);
        // phantom reference, must association with a reference queue
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference phantomReference = new PhantomReference(o, queue);
        phantomReference.get();
    }
}
