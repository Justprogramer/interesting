package com.tao.reference.weak;

/**
 * @author: Penger
 * @time: 2019/7/11
 * @description: <p>
 * </p>
 **/
public class GCTarget {
    /**
     * 对象的ID
     */
    String id;

    /**
     * 占用内存空间
     */
    byte[] buffer = new byte[1024];

    GCTarget(String id) {
        this.id = id;
    }

    @Override
    protected void finalize() {
        // 执行垃圾回收时打印显示对象ID
        System.out.println("Finalizing GCTarget, id is : " + id);
    }

}
