package psyh2409.treads;

public abstract class C implements Runnable{

    public void truer(Abstr a) {
        a.setBoo(true);
        Thread thread = new Thread(a);
        thread.start();
    }

    public void falser(Abstr a) {
        a.setBoo(false);
    }

}
