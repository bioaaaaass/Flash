package thread;

/**
 * Created by huangzhibo on 4/5/16.
 */
public class TestWaitNotify {
    public static void main(String[] args) throws InterruptedException{
        /**
         * java.lang.IllegalMonitorStateException
         * 执行wait, notify时，不获得锁会如何？
         */
//        Object object = new Object();
//        object.wait();
//        object.notify();

        /**
         * 执行wait, notify时，不获得该对象的锁会如何？
         * java.lang.IllegalMonitorStateException
         */
//        Object obj = new Object();
//        Object lock = new Object();
//        synchronized (lock) {
//            obj.wait();
//            obj.notifyAll();
//        }

        QueueBuffer q = new QueueBuffer();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop.");

    }
}
