package NB3;

public class Node {
    public String data;
    public Node next;

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }


    public static void main(String[] args) {
        Node[] list = new Node[4];
        list[3] = new Node("stäppen", null);
        list[2] = new Node("på", list[3]);
        list[1] = new Node("löper", list[2]);
        list[0] = new Node("Gilgamesh", list[1]);

        Node current = list[0];
        while(current !=null){
            System.out.println(current.data + " ");
            current = current.next;
        }


        list[1].next = list[2].next;

        current = list[0];
        while(current !=null){
            System.out.println(current.data + " ");
            current = current.next;
        }
    }
}