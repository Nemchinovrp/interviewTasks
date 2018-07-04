package nemchinovrp.deadlock;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        Thread thread1 = new Thread(new ThreadLock(obj1, obj2));
        Thread thread2 = new Thread(new ThreadLock(obj2, obj3));
        Thread thread3 = new Thread(new ThreadLock(obj3, obj1));

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
        Thread.sleep(1000);
    }
}
