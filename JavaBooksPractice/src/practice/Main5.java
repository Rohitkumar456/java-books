package practice;

import java.util.concurrent.locks.ReentrantLock;

public class Main5 {

    public static void main(String[] args) {

        A a = new A();
        B b  = new B();

        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread t1 = new Thread(()->{
            lock1.lock();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            while(!lock2.tryLock())
                System.out.println("rohit");

        });

        Thread t2 = new Thread(()->{
            lock2.lock();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            lock1.lock();
            System.out.println("kumar");

        });

        t1.start();
        t2.start();


//        Thread t1 = new Thread(()->{
//           synchronized (a){
//               try{
//                   Thread.sleep(1000);
//               }catch (InterruptedException e){
//
//               }
//               synchronized (b){
//                   System.out.println("rohit");
//               }
//           }
//        });
//
//        Thread t2 = new Thread(()->{
//           synchronized (b){
//               try{
//                   Thread.sleep(1000);
//               }catch (InterruptedException e){
//
//               }
//               synchronized (a){
//                   System.out.println("kumar");
//               }
//           }
//        });



    }
}

class A{}
class B{}
