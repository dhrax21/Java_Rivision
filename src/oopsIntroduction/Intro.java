package oopsIntroduction;

public class Intro {

    class A {
        static void greet() {
            System.out.println("Hi Good Evening!");
        }
    }

    static void greet(){
        System.out.println("Hi bad morning!");
    }

    public static void main(String[] args) {
//       Intro obj=new Intro();
//       A ob1=new A();
//       obj.greet();
       Intro.greet();
    }

}
