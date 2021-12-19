package psyh2409;

import com.psyh2409.earning.Boss;
import com.psyh2409.earning.Employee;
import com.psyh2409.earning.Salary;
import com.psyh2409.earning.Witch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Salary employee = new Employee(100500);
        Salary witch = new Witch(1050);
        Boss boss = new Boss(){
            @Override
            public void run() {
                try {
                    this.hire(employee);
                    this.hire(witch);
                    Thread.sleep(100_000L);
                    Arrays.stream(this.getWorkers()).forEach(this::fair);
                } catch (Exception ie){
                    ie.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        };
        Thread thread = new Thread(boss);
        thread.start();
    }
}
