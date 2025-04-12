import java.util.Scanner;

class Node2 {
    Object coeff;
    Node2 next, prev;

    Node2() {
        coeff = 0;
        next = null;
        prev = null;
    }

    Node2(Object c, Node2 n, Node2 p) {
        coeff = c;
        next = n;
        prev = p;
    }
}


class DoubleList {
    private Node2 header, tailer;
    private int size;
    public DoubleList() {
        // Initialize header and tailer nodes
        header = new Node2();
        tailer = new Node2();
        size=0;
        // Link them together
        header.next = tailer;
        tailer.prev = header;
    }

    public void add(Object element){
        Node2 i=new Node2();
        i.coeff=element;
        i.next=tailer;
        i.prev=tailer.prev;
        tailer.prev.next=i;
        tailer.prev=i;
        ++size;
    }


    public void add(int index, Object element)throws  Exception{

        if (index>size||index<0) {
            throw new Exception("you insert in not valid index");
        }


        Node2 p=header;
        Node2 i=new Node2();
        i.coeff=element;

        while ((index)!=0){
            p=p.next;
            --index;}

        i.next=p.next;
        p.next.prev=i;
        p.next=i;
        i.prev=p;
        ++size;
    }

    public Object get(int index)throws Exception{
        if (index>=size||index<0) {
            throw new Exception("you insert in not valid index");
        }
        Node2 p=header.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.coeff;

    }

    public void set(int index, Object element) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Invalid index");
        }

        Node2 p = header.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.coeff = element;
    }

    public void remove(int index)throws Exception{
        if (index>=size||index<0){
            throw new Exception("you delete not valid index");
        }
        Node2 p=header;
        while (index!=0){
            p=p.next;
            --index;
        }
        p.next.next.prev=p;
        p.next=p.next.next;
        --size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        Node2 p = header.next;
        while (p != tailer) {
            if (p.coeff.equals(o)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public DoubleList sublist(int fromIndex, int toIndex)throws Exception {
        if (fromIndex < 0 || toIndex < 0 || fromIndex >= size || toIndex >= size|| toIndex<fromIndex) {
            throw new Exception("not valid");
        }
        DoubleList copy=new DoubleList();
        Node2 p=header.next;
        int num=toIndex-fromIndex+1;
        int j=fromIndex;
        while (j!=0){
            p=p.next;
            --j;
        }
        int count=0;

        while(count!=num){
            copy.add(p.coeff);
            ++count;
            p=p.next;
        }
        return copy;

    }

    public void clear() {
        header.next = tailer;
        tailer.prev = header;
        size = 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        Node2 p= header;
        while (p.next.next!=tailer){
            p=p.next;
            System.out.printf("%d, ",(int)p.coeff);
        }
        System.out.printf("%d]",tailer.prev.coeff);
}}

public class M {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DoubleList list = new DoubleList();

        


            String list_str = input.nextLine().trim();
            if (!list_str.equals("[]")) {
                list_str = list_str.substring(1, list_str.length() - 1);
                String[] char_num = list_str.split(",");

                int[] list1 = new int[char_num.length];
                for (int i = 0; i < char_num.length; ++i) {
                    list1[i] = Integer.parseInt(char_num[i].trim());
                }

                int size = list1.length;

                for (int i = 0; i < size; ++i) {

                    int value = list1[i];
                    list.add(value);
                }


            }


            String need = input.nextLine();

            switch (need) {
                case "add":
                    int value_add = input.nextInt();
                    list.add(value_add);
                    list.print();
                    break;

                case "addToIndex":
                    try {
                        int index_toindex = input.nextInt();
                        int value_toindex = input.nextInt();
                        list.add(index_toindex, value_toindex);
                        list.print();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;

                case "get":
                    try {
                        int index_toget = input.nextInt();
                        System.out.println(list.get(index_toget));
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;

                case "set":
                    try {
                        int index_toset = input.nextInt();
                        int value_toset = input.nextInt();
                        list.set(index_toset, value_toset);
                        list.print();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;

                case "remove":
                    try {
                        int index_toremove = input.nextInt();
                        list.remove(index_toremove);
                        list.print();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;

                case "isEmpty":
                    if (list.isEmpty()) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");

                    }

                    break;

                case "contains":
                    int value_tocontain = input.nextInt();
                    if (list.contains(value_tocontain)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");

                    }
                    break;

                case "size":
                    System.out.println(list.size());
                    break;

                case "clear":
                    list.clear();
                    list.print();
                    break;

                case "sublist":
                    try {
                        int fromindex = input.nextInt();
                        int toindex = input.nextInt();
                        DoubleList copy = list.sublist(fromindex, toindex);
                        copy.print();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;

                default:
                    System.out.println("invalid operation");
            }
        
    }
}
