package interview.questions.language;

class Singleton {
    public static Singleton obj = null;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(obj == null){
            synchronized(Singleton.class){
                if(obj == null){
                    obj = new Singleton();
                }
            }
        }
        return obj;
    }
}

public class Test{
    public static void main(String [] args){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1.equals(s2));
    }
}