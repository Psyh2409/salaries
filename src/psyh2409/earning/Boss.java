package psyh2409.earning;

import java.util.Arrays;

public abstract class Boss implements Runnable{
    private Salary[] workers;

    protected Boss(Salary... workers) {
        this.workers = workers;
    }

    public void hire(Salary salary){
        Salary[] salaries = new Salary[workers.length+1];
        System.arraycopy(workers, 0, salaries, 0, workers.length);
        salaries[workers.length] = salary;
        salary.findJob();
        workers = salaries;
        Thread thread = new Thread(salary);
        thread.start();
    }

    public void fair(Salary salary) {
        int i = Arrays.stream(workers).toList().indexOf(salary);
        salary.lostJob();
        Salary[] salaries3 = new Salary[workers.length-1];
        if(workers.length>1) {
            System.arraycopy(workers, i != 0 ? 0 : 1, salaries3, 0, i);
            System.arraycopy(workers, i + 1, salaries3, workers.length - 2, workers.length - (workers.length - i));
            workers = salaries3;
        }else {
            workers = new Salary[0];
        }

    }

    public Salary[] getWorkers() {
        return workers;
    }

    public void setWorkers(Salary[] workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "workers=" + Arrays.toString(workers) +
                '}';
    }
}
