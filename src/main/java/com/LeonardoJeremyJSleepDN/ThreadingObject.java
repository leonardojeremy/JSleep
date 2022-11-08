package com.LeonardoJeremyJSleepDN;

public class ThreadingObject extends Thread {
    public ThreadingObject(String name){
        super(name);
    }

    public void run(){
        System.out.println(this.getName() + " is running " + currentThread());
    }
}
