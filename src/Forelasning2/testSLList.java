package Forelasning2;



public class testSLList {
    public static void main(String[] args) {

        SLList<String> list = new SLList<>();

        for (int i = 0; i < 4; i++)
        {
            list.add("e" + i);
        }
        list.remove(3);
        list.add(0,"först");
        list.add("sist");
        System.out.println(list);

    }

}

