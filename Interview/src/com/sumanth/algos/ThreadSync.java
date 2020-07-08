package com.sumanth.algos;
/*
  Create two threads which computes summation from 1 to 100 and showcase inter-thread communication printing valid result
 */
public class ThreadSync {

    public static void computeWithWaitAndNotify() {
        Compute thread1=new Compute();
        Compute thread2=new Compute();
        thread1.start();
        thread2.start();

        synchronized (thread1){
            try {
                thread1.wait();
            }catch (InterruptedException e){
                System.out.println("Thread execution interrupted "+e);
            }
        }

        synchronized (thread2){
            try {
                thread2.wait();
            }catch (InterruptedException e){
                System.out.println("Thread execution interrupted "+e);
            }
        }

        long sum1=thread1.sum;
        long sum2=thread2.sum;

        System.out.println("The summation from thread 1 is: "+sum1+" and thread 2 is: "+sum2);
    }
}
