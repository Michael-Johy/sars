package com.johnny.java.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    // true:represents empty false:represents not empty
    private boolean empty = true;

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition emptyCondition = lock.newCondition();
    private static final Condition notEmptyCondition = lock.newCondition();

    public void take() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "take get locked");
        try {
            while (empty) {
                System.out.println(Thread.currentThread().getName() + "take await before");
                emptyCondition.await();
                System.out.println(Thread.currentThread().getName() + "take await after");
            }
            //consumer
            System.out.println("consumer");
            empty = true;
            notEmptyCondition.signal();
        } catch (InterruptedException | IllegalMonitorStateException e) {
            System.out.println(lock);
            System.out.println("take task interrupted");
        } finally {
            System.out.println(Thread.currentThread().getName() + "take release locked");
            lock.unlock();
        }
    }

    public void put() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "put get locked");
        try {
            while (!empty) {
                System.out.println(Thread.currentThread().getName() + "put await before");
                notEmptyCondition.await();
                System.out.println(Thread.currentThread().getName() + "put await end");
            }
            //producer
            System.out.println("producer");
            empty = false;
            emptyCondition.signal();
        } catch (InterruptedException | IllegalMonitorStateException e) {
            System.out.println(lock);
            System.out.println("put task interrupted");
        } finally {
            System.out.println(Thread.currentThread().getName() + "put release locked");
            lock.unlock();
        }
    }

}
