package datastructures;

import java.util.ArrayList;
import java.util.List;

class Container<T extends Number, K> {
    T val;

    void setVal(T val) {
        this.val = val;
    }

    T getVal() {
        return val;
    }

    void printList(List<? super T> list) {
        System.out.println(list.toString());
    }

}

class Method<T> {
    <K extends Number> void doThis(K obj, K ob2) {

        System.out.println(obj.intValue() + ob2.doubleValue());

    }

    <V> V getSomething(V d) {
        return d;
    }

}

class ContainerExtend extends Container<Integer, String> {

    @Override
    void setVal(Integer value) {
        val = value;
    }

    @Override
    Integer getVal() {
        return val;
    }
}

class ContainerExtender2 extends Container<Double, Integer> {

    @Override
    void setVal(Double val) {
        this.val = val;
    }

    @Override
    Double getVal() {
        return val;
    }


}

public class GenericsTut {

    public static void main(String[] args) {

        ContainerExtend containerExtend = new ContainerExtend();
        containerExtend.setVal(1);
        System.out.println(containerExtend.getVal());

        ContainerExtender2 containerExtender2 = new ContainerExtender2();
        containerExtender2.setVal(1938.31);

        System.out.println(containerExtender2.getVal());

        Container<Float, Double> container = new Container<>();
        container.setVal(49.2f);
        System.out.println(container.getVal());

        List<Float> integerList = new ArrayList<>();
        integerList.add(1f);
        integerList.add(2.2f);
        container.printList(integerList);


        //raw use
        // Method method = new Method();
        // method.doThis(1, 2);
        // System.out.println(method.getSomething(1));
    }
}
