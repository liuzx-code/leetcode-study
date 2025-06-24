package leetcode.algorithm.thread;


/**
 * 多线程交替打印0-100
 */
public class ThreadAlternatePrinting {

    private static final Object lock = new Object();
    private static int number = 0;
    // 0 -> A, 1 -> B, 2 -> C
    private static int state = 0;

    public static void main(String[] args) {
//        f1();
        Thread threadA = new Thread(new Printer(0, "线程-A", 0, 30));
        Thread threadB = new Thread(new Printer(1, "线程-B", 31, 60));
        Thread threadC = new Thread(new Printer(2, "线程-C", 61, 90));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    /**
     * 多线程交替打印 0 -100
     */
    private static void f1() {
        // 线程A：打印偶数
        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (number > 100) break;
                    // 偶数线程，判断当前number是否是偶数，不是则等待
                    if (number % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                        continue;
                    }
                    System.out.println(Thread.currentThread().getName() + "~~~~~~~~~~" + number);
                    // 偶数线程，number加1，并唤醒所有线程
                    number++;
                    lock.notifyAll();
                }
            }
        }, "线程-偶数打印");

        // 线程B：打印奇数
        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (number > 100) break;
                    // 奇数线程，判断当前number是否是奇数，不是则等待
                    if (number % 2 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                        continue;
                    }
                    System.out.println(Thread.currentThread().getName() + "~~~~~~~~~~" + +number);
                    number++;
                    lock.notifyAll();
                }
            }
        }, "奇数打印线程");

        // 启动线程
        threadA.start();
        threadB.start();

        // 等待线程结束
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Printer implements Runnable {
        private final int id;
        private final String name;
        private final int start;
        private final int end;

        public Printer(int id, String name, int start, int end) {
            this.id = id;
            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // 判断是否轮到自己打印
                    if (state != id) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                        continue;
                    }

                    // 当前打印值超过范围则退出
                    if (number > end) {
                        lock.notifyAll();
                        return;
                    }

                    // 打印属于自己的区间
                    if (number >= start && number <= end) {
                        System.out.println(name + ": " + number);
                        number++;

                        // 如果超出该线程负责范围，state 转交给下一个线程
                        if (number > end) {
                            state = (id + 1) % 3;
                        }
                    }

                    lock.notifyAll();
                }
            }
        }
    }

}
