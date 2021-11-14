package com.group8.discountmanager._fortests;


public class TestThread implements Runnable{

    VoidCallback callback;
    VoidCallback execute;

    public TestThread(VoidCallback execute, VoidCallback callback) {
        this.execute = execute;
        this.callback = callback;
    }

    @Override
    public void run() {
        execute.execute();
        callback.execute();
    }
}
