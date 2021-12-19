package psyh2409.earning;

import java.math.BigDecimal;
import java.util.Objects;

public class Witch implements Salary {
    private double salary;
    private BigDecimal money;
    private boolean work;

    public Witch(double salary) {
        this.salary = salary;
        this.money = new BigDecimal(0);
    }

    @Override
    public void salary() throws InterruptedException {
        long millis = 1000L * 60 * 60;
        Thread.sleep((millis) / 100_000);
        money = money.add(BigDecimal.valueOf(salary));
        System.out.println("I'm witch, my salary is " + salary + " per hour.");
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public boolean isWork() {
        return work;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void run() {
        try {
            while (isWork()) {
                this.salary();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void lostJob() {
        work = false;
    }

    @Override
    public void findJob() {
        work = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Witch witch = (Witch) o;
        return Double.compare(witch.salary, salary) == 0 && work == witch.work && Objects.equals(money, witch.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, money, work);
    }

    @Override
    public String toString() {
        return "Witch{" +
                "salary=" + salary +
                ", money=" + money +
                ", work=" + work +
                '}';
    }
}
