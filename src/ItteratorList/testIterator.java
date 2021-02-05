package ItteratorList;

import java.util.Iterator;

public class testIterator {
    public static void main(String[] args) {
        SLListIterator<String> list = new SLListIterator<>();
        for (int i = 0; i < 10; i++)
        {
            list.add("e" + i);
        }

        Iterator<String> iter = list.iterator();


        iter.remove();
        System.out.println(list);

    }
}
