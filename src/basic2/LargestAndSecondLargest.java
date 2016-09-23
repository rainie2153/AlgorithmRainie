package basic2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 6/29/16.
 */
//The ele will be used to store the original value in the array and all values compared to it
    //Java allows us to define a class within another class. Such a class is called a nested class.
    //The class which enclosed nested class is known as Outer class. Only nested calsses can be static.
    //what are dif between static and non-static nested classes
    //1.nested static class doesnt need reference of outer class. Non-static nested class or inner
    //class requires outer class reference.
    //2.Inner class or non-static nested class can access both static and non-static members of outer class.
    //3.An instance of inner class cannot be created witout an instance of outer class and an inner class
    //can reference data and methods defined in outer class in which it nests, so we dont need to pass
    //reference of an object to the constructor of the inner class
public class LargestAndSecondLargest {
    static class Element {
        int value;
        List<Integer> compredValues;

        Element(int value) {
            this.value = value;
            this.compredValues = new ArrayList<>();
        }
    }

    public int[] largestAndSecond(int[] array) {
        Element[] helper = covert(array);
        int largerLength = array.length;
        while (largerLength > 1) {
            compareAndSwap(helper, largerLength);
            largerLength = (largerLength + 1) / 2;
        }
        return new int[] {helper[0].value, largest(helper[0].compredValues)};
    }
    private Element[] covert(int[] array) {
        Element[] helper = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            helper[i] = new Element(array[i]);
        }
        return helper;
    }
    private void compareAndSwap(Element[] helper, int largerLength) {
        for (int i = 0; i < largerLength / 2; i++) {
            if(helper[i].value < helper[largerLength - 1 - i].value) {
                swap(helper, i, largerLength - 1 - i);
            }
            helper[i].compredValues.add(helper[largerLength - 1 - 1].value);
        }

    }
    private void swap(Element[] helper, int left, int right) {
        Element tmp = helper[left];
        helper[left] = helper[right];
        helper[right] = tmp;
    }
    private int largest(List<Integer> list) {
        int max = list.get(0);
        for (int num : list) {
            max = Math.max(max, num);
        }
        return max;
    }
}
