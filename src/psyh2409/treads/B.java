package psyh2409.treads;

import java.time.LocalTime;

public class B extends Abstr{

    private boolean boo;

    @Override
    public boolean isBoo() {
        return boo;
    }

    @Override
    public void setBoo(boolean boo) {
        this.boo = boo;
    }

    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName() + " " + LocalTime.now());
    }

    @Override
    public void run() {
        while (boo)
            print();
    }
}
