package com.johnny.java.concurrent.stamplock;

import java.util.concurrent.locks.StampedLock;

// modes: read 、 write 、 optimistic read
public class StampedLockDemo {
    private int x;
    private int y;

    private StampedLock lock = new StampedLock();

    private void write(int deltaX, int deltaY) {
        long stamp = lock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    private double optimisticRead() {
        long stamp = lock.tryOptimisticRead(); // try optimistic read
        int x1 = x;
        int y1 = y;
        try {
            if (!lock.validate(stamp)) {  // lock invalid because other write exclusively held
                stamp = lock.readLock();  // upgrade to read lock
                x1 = x;
                y1 = y;
            }
        } finally {
            lock.unlock(stamp);
        }
        return Math.pow(x1, 2) + Math.pow(y1, 2);
    }

}
