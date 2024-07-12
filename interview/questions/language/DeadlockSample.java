package interview.questions.language;

class FigmaDesign{
    private String designName;
    FigmaDesign(String designName){
        this.designName = designName;
    }
}
class CodeBase{
    private String code;
    CodeBase(String code){
        this.code = code;
    }
}
class ProductDesigner implements Runnable{
    FigmaDesign mockups;
    CodeBase codebase;
    ProductDesigner(FigmaDesign design, CodeBase codebase){
        this.mockups = design;
        this.codebase = codebase;
    }
    @Override
    public void run() {
        synchronized (codebase){
            System.out.println("Locked codebase. Proceeding with designs !! "+
                    Thread.currentThread().getName());
            synchronized (mockups){
                System.out.println("Developing mockups");
                try{
                    Thread.sleep(5000);
                    System.out.println("Designed mockups now ready for Developer to proceed !!");
                }catch(InterruptedException exception){
                    System.out.println("Interrupt received by "+ Thread.currentThread().getName());
                }
            }
        }
    }
}
class Developer implements Runnable{
    FigmaDesign mockups;
    CodeBase codebase;
    Developer(FigmaDesign design, CodeBase codebase){
        this.mockups = design;
        this.codebase = codebase;
    }
    @Override
    public void run() {
        synchronized (mockups){
            System.out.println("Locked mockups. Proceeding with development !! "+
                    Thread.currentThread().getName());
            synchronized (codebase){
                System.out.println("Implementing designs");
                try{
                    Thread.sleep(5000);
                    System.out.println("Feature released!!");
                }catch(InterruptedException exception){
                    System.out.println("Interrupt received by "+ Thread.currentThread().getName());
                }
            }
        }
    }
}

public class DeadlockSample {

    public static void main(String [] args){
        FigmaDesign design = new FigmaDesign("Food ordering UI");
        CodeBase codeBase = new CodeBase("React Native");
        Developer developer = new Developer(design,codeBase);
        ProductDesigner designer = new ProductDesigner(design,codeBase);
        Thread developerThread = new Thread(developer);
        Thread designerThread = new Thread(designer);
        developerThread.start();
        designerThread.start();
    }
}
