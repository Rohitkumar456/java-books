package ModernJavaInAction;

public class Child extends  Parent{
    public int a = 1;
    public int b = 2;
//    public Child(int a){
//        this.a = a;
//    }
    public void getA(){
        System.out.println("child");
        System.out.println(this.c);
    }

    public void getB() {


        System.out.println("child in B");
    }



}
