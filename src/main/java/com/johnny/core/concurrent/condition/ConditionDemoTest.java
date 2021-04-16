package com.johnny.core.concurrent.condition;

public class ConditionDemoTest {

    public static void main(String[] args) throws Exception {

        ConditionDemo conditionDemo = new ConditionDemo();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                conditionDemo.take();
            }).start();
        }
        Thread.sleep(10000);

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                conditionDemo.put();
            }).start();
        }

        Thread.sleep(10000);
        System.out.println("end");
    }

}
