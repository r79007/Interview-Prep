package MathWorks;

class ThreadDemo implements Runnable{

    static private String threadName;
    static private Thread t;

    ThreadDemo(String tName){
        threadName = tName;
        System.out.println(threadName);
    }
    public void run(){
        System.out.println(threadName);
    }

    public void start(){
        if(t==null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Main Class ");
        ThreadDemo thr1 = new ThreadDemo("1");
        thr1.start();
        ThreadDemo thr2=new ThreadDemo("2");
        thr2.start();
    }

}
