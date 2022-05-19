class MyRunnbel implements Runnable {
    private Resource lock;
    boolean flag;

    public MyRunnbel(Resource lock, boolean flag) {
        this.lock = lock;
        this.flag = flag;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                if (flag) {
                    lock.wait(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("my runnable interface");
        }
    }
}

class myRunnableNew implements Runnable {
    private Resource lock;
    boolean flag;

    public myRunnableNew(Resource lock, boolean flag) {
        this.lock = lock;
        this.flag = flag;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                if (flag) {
                    lock.wait(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("my anonymous runnable");
        }
    }
}

class Resource {
}

public class Testing {
    public static void main(String[] args) {
        Resource lock = new Resource();
        Thread t1 = new Thread(new MyRunnbel(lock, true));
        t1.start();
       Thread t2 = new Thread(new myRunnableNew(lock, false));
        t2.start();

    }


}
