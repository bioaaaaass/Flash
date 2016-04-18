package thread;

/**
 * Created by huangzhibo on 4/5/16.
 */
public class Consumer implements Runnable{
    private QueueBuffer q;

    Consumer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}
