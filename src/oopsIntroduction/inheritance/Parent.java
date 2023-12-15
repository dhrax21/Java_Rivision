package oopsIntroduction.inheritance;

public class Parent {
    double l;
    double h;
    double w;

    Parent(){
        this.l=-1;
        this.h=-1;
        this.w=-1;
    }
    // ccube
    Parent(double side){
        this.l=side;
        this.h=side;
        this.w=side;
    }


    Parent(double l , double h, double w){
        this.l=l;
        this.h=h;
        this.w=w;
    }

    Parent(Parent old){
        this.l=old.l;
        this.h=old.h;
        this.w=old.w;
    }


    public void info() {
        System.out.println("parent info is called!");
    }
}
