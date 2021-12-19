package psyh2409.earning;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee implements Salary{
    private double salary;
    private BigDecimal money;
    private boolean work;

    public Employee(double salary) {
        this.salary = salary;
        this.money = new BigDecimal(0);
    }

    @Override
    public void salary() throws InterruptedException {
        long millis = 1000L *60*60*24*30;
        Thread.sleep( (millis)/100_000);
        money = money.add(BigDecimal.valueOf(salary));
        System.out.println("I'm employee, my salary is " + salary + " per month.");
    }

    public BigDecimal getMoney() {
        return money;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isWork() {
        return work;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && work == employee.work && Objects.equals(money, employee.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, money, work);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", money=" + money +
                ", work=" + work +
                '}';
    }

    @Override
    public void run() {

        try {
            while (isWork()){
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
}
