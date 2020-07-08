package com.sumanth.algos;
/*
 Computes summation of 1 to 100
 */
public class Compute extends Thread{
    long sum;
    public void run(){
        synchronized (this){
            //only 1 thread can enter
            for (int i = 1; i <= 100; i++) {
                sum=sum+i;
            }
            // notifies that processing is done
            notify();
        }
    }
}
