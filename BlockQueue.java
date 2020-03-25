import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue {
    
    final ArrayList<String> bQueue = new ArrayList<String>(10);
    final Lock lock = new ReentrantLock(true);
    final Condition condition = lock.newCondition();

    public void addQueue(String s) throws InterruptedException {
        lock.lock();
        try {
            while (bQueue.size()==10) {
                condition.await();
        }
        bQueue.add(s);
        condition.signalAll();;
        } finally {
            lock.unlock();
        }
    }

    public void removeQueue() throws InterruptedException {
        lock.lock();
        try {
            while (bQueue.size()==0) {
                condition.await();
        }
        bQueue.remove(0);
        condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return bQueue.size();
    }
}
