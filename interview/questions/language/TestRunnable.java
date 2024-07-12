package interview.questions.language;


class DemoThreadRunnable implements Runnable{
    //Executes the task independently
    @Override
    public void run() {
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println("Child thread calling");
        }
    }
}

//Extending class Thread
class DemoThread extends Thread{
    //Perform the independent task
    @Override
    public void run() {
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println("Child thread calling");
        }
    }
}
public class TestRunnable{
    public static void main(String [] args){
        //Creates the thread
        Thread testThread = new Thread(new DemoThread());
        //starts the thread
        testThread.start();
        System.out.println("Main thread calling");
    }
}
