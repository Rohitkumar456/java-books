package practice;

public enum BasicEnum {

    INSATANCE,
    INSTANCE2;

    static int  count = 0;

    void increment(){
        INSATANCE.count++;
        count++;
        System.out.println("rohit");
    }
}
