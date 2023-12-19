package LinkList;

public class Main {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertFirst(2);
        list.insertFirst(17);
        list.insertFirst(90);
        list.insertFirst(218);
        list.insertLast(12);

        list.insertPos(111,4);
//
//
        list.display();
//        System.out.println(list.deleteLast());
////        System.out.println(list.deleteFirst());
//        list.display();

        System.out.println(list.delete(4));
        list.display();



    }
}
