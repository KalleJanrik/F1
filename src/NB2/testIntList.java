package NB2;

import java.util.ArrayList;

public class testIntList {

    public static void main(String[] args) {
        IntList test = new IntList(10);
        for (int i = 0; i < 10; i++) {
            test.add(i+1);
        }
        System.out.println(test.toString());
        System.out.println("Index should be 3: "+test.indexOf(4));
        test.add(2,23);
        System.out.println(test.toString());
        System.out.println("Index should be 4: "+test.indexOf(4));

        System.out.println("Should be 4: "+test.get(4));

        test.remove(4);
        System.out.println(test.toString());
        System.out.println(test.size());
        test.set(5,29);
        System.out.println(test.toString());

    }
}
