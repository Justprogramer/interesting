package com.tao.interfacedemo;

/**
 * @author: Penger
 * @time: 2019/9/12
 * @description: <p>
 * </p>
 **/
interface InterfaceA {
    ClassB print(String text);
}

interface InterfaceB {
    ClassB print(String text);
}

interface InterfaceC {
    ClassA print(String text);
}

class ClassA {

}
class ClassB extends ClassA {

}

public class Impl implements InterfaceA, InterfaceB, InterfaceC {



    public static void main(String[] args) {
        Impl impl = new Impl();
        impl.print("test");
    }

    @Override
    public ClassB print(String text) {
        return null;
    }
}