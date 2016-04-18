package thread;

/**
 * Created by huangzhibo on 4/5/16.
 */
public class Producer implements Runnable{
    private QueueBuffer q;

    Producer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}
