package practice;

public class Main4 {

    public static void main(String[] args) {

        Printer printer = new Printer(10);

        Thread even  = new Thread(printer::printEven);
        Thread odd = new Thread(printer::printOdd);

        even.start();
        odd.start();


    }
}

class Printer{
    int N;
    volatile int num;

    public Printer(int N){
        this.N = N;
        this.num = 1;
    }

    public int getN() {
        return N;
    }

    public int getNum() {
        return num;
    }

    public synchronized void printEven(){
        while(num<=N){
            if(num%2!=0){
               try{
                   wait();
               }catch (InterruptedException e){

               }
            }else{
                System.out.println(num);
                num++;
                notifyAll();
            }
        }
    }

    public synchronized void printOdd(){
        while(num<=N){
            if(num%2==0){
                try{
                    wait();
                }catch (InterruptedException e){

                }
            }else{
                System.out.println(num);
                num++;
                notifyAll();
            }
        }
    }
}
