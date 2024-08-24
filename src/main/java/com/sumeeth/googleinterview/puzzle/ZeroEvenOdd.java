package com.sumeeth.googleinterview.puzzle;

import java.util.function.IntConsumer;

class TestZeroEvenOdd {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        IntConsumer printNumber = n -> System.out.println(n);
        Runnable R1 = () -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable R2 = () -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable R3 = () -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(R1).start();
        new Thread(R2).start();
        new Thread(R3).start();
    }
}

class ZeroEvenOdd {
    private int n;
    private int prevNumber = -1;
    private boolean isPrevEven = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        if (prevNumber != 0) {
            printNumber.accept(0);
            prevNumber++;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        if (prevNumber == 0 && !isPrevEven) {
            prevNumber++;
            printNumber.accept(prevNumber);
            zero(printNumber);
        } else {
            wait();
        }

    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        if (prevNumber == 0 && isPrevEven) {
            prevNumber++;
            printNumber.accept(prevNumber);
            zero(printNumber);
        } else {
            wait();
//            if (prevNumber <= n)
//                odd(printNumber);
        }
    }
}