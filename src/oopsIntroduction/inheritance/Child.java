package oopsIntroduction.inheritance;

public class Child extends Parent {


    public Child() {
        this.weight=-1;
    }
    double weight;

    public Child(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }

    public void message(){
        System.out.println("child class is running!");
    }
//    public void info(){
//        System.out.println("child info method is called");
//    }
}
