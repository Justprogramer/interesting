package com.tao.reference.weak;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author: Penger
 * @time: 2019/7/11
 * @description: <p>
 * </p>
 **/
public class GCTargetWeakReference extends WeakReference<GCTarget> {
    /**
     * 弱引用的ID
     */
    String id;

    GCTargetWeakReference(GCTarget gcTarget,
                          ReferenceQueue<? super GCTarget> queue) {
        super(gcTarget, queue);
        this.id = gcTarget.id;
    }

    @Override
    protected void finalize() {
        System.out.println("Finalizing GCTargetWeakReference " + id);
    }

}
