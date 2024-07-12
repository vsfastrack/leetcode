package interview.questions.language;

public class ThreadDemo {
    public static void main(String [] args){
        /*
            Simply pass lambda expression as runnable is
            an example for functional interface with single
            abstract method as public void run()
         */
        Thread demoThread = new Thread(()->{
            //Body of run method
            System.out.println(Thread.currentThread().getName());
        },"Child Thread");
        demoThread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
