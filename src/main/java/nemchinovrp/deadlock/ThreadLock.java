package nemchinovrp.deadlock;

public class ThreadLock implements Runnable {
    private Object ob1;
    private Object ob2;

    public ThreadLock(Object o1, Object o2) {
        this.ob1 = o1;
        this.ob2 = o2;
    }

    public void run() {
        synchronized (ob1) {
            System.out.println("I am start working first sync block 1 - " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            work();

            synchronized (ob2) {
                System.out.println("I am start working first sync block 2 - " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                work();
            }
        }
    }

    private void work() {
        System.out.println("work method - " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
