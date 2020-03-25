class Consumer implements Runnable {
    
    private BlockQueue queue;

    public Consumer(BlockQueue queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            try {
                queue.removeQueue();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
