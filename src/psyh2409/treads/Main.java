package psyh2409.treads;

public class Main {

    public static void main(String[] args) {
        Abstr a = new A();
        Abstr b = new B();
        C c = new C(){
            @Override
            public void run() {
                try {
                    this.truer(a);
                    this.truer(b);
                    Thread.sleep(500L);
                    this.falser(a);
                    this.falser(b);
                } catch (Exception ie){
                    ie.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        };
        Thread tc = new Thread(c);
        tc.start();
    }
}
