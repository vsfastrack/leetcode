package interview.questions.language;


class MailBox{
    public String message;
    public void putMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
class PostManThread implements Runnable{
    private MailBox mailBox;
    PostManThread(MailBox mailBox){
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
            System.out.println("Postman is sortinhg letters "+
                    Thread.currentThread().getName() +
                    " :"+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupt received while sleeping");
        }
        synchronized (mailBox){
                mailBox.putMessage("Greetings for the day !!");
                System.out.println("Dakiya dak laya :) ");
                mailBox.notify();
            }
    }
}
class ReceiverThread implements Runnable{
    private MailBox mailBox;
    ReceiverThread(MailBox mailBox){
        this.mailBox = mailBox;
    }
    @Override
    public void run() {
        System.out.println("Received notification from postman "
                + readMessage() + " : "+
                Thread.currentThread().getName());
    }
    private String readMessage(){
        if(mailBox.message == null || mailBox.message.equals("")){
            System.out.println("Need to wait for the mailbox :"+
                    Thread.currentThread().getName());
            synchronized (mailBox){
                try {
                    mailBox.wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted by another thread");
                }
            }
        }
        return mailBox.getMessage();
    }
}
public class SynchronizedDemo {
    public static void main(String [] args){
        MailBox mailBox = new MailBox();
        Thread postmanThread = new Thread(new PostManThread(mailBox),"postman-thread");
        Thread receiverThread = new Thread(new ReceiverThread(mailBox),"receiver-thread");
        receiverThread.start();
        postmanThread.start();
    }
}
