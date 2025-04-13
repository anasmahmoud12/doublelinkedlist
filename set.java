import java.util.Scanner;

public class Main {
//  public static     int a_size;
//   public static int b_size;
//   public static int c_size;
    public static DoubleList from_array_to_list(int []array){
        int size=array.length;

     //   System.out.println("we are in from arr");

        DoubleList s=new DoubleList();
        int a=size-1;
        for (int i=0;i<size;++i){
            int value=array[i];
            int exp=a;
            s.add(value,a);
            --a;
        }
        return s;
    }


    public static DoubleList from_str_to_array(String str_list){
        DoubleList s= new DoubleList();
      ////  System.out.println("we are in from str");
        if (!str_list.equals("[]")) {
            str_list = str_list.substring(1, str_list.length() - 1);
            String[] char_num = str_list.split(",");

            int[] list1 = new int[char_num.length];
            for (int i = 0; i < char_num.length; ++i) {
                list1[i] = Integer.parseInt(char_num[i].trim());
            }

            s = from_array_to_list(list1);
        }
        return s;
    }



    public static void main(String[] args) {
DoubleList a =new DoubleList();
        DoubleList b =new DoubleList();
        DoubleList c =new DoubleList();
Scanner input = new Scanner(System.in);

while (input.hasNextLine()){
    String y=input.nextLine();
    if (y.equals("set")){
        String ch=input.nextLine();
        String j=input.nextLine();
        if (ch.equals("a"))
        {
            a=from_str_to_array(j);
        }
        else if(ch.equals("b")){
            b=from_str_to_array(j);
        }
        else if(ch.equals("c")){
            c=from_str_to_array(j);
        }
    }
a.print();

}




    }

}
