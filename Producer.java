class Producer implements Runnable {
    
    private BlockQueue queue;

    public Producer(BlockQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                queue.addQueue("Item");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
