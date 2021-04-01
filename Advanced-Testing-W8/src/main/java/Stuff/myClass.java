package Stuff;

public class myClass {
    public static int printNum(int num){

        if (num == 0){
            System.out.println("hi");
        }

        assert num != 0;
            if (num == 0){
            System.out.println(num);
            return num;
        }
            return 1;


    }
    public static void main(String[] args){
        printNum(5);

    }



}
