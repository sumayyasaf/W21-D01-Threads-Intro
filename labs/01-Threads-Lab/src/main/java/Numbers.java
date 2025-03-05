public class Numbers implements Runnable {

    @Override
    public void run() {
for(int i = 1; i <= 5; i++){
    System.out.println(i);
    try{
        Thread.sleep(500); //delay
    }
    catch (InterruptedException e){
        System.out.println(e.getMessage());
    }
}
    }
}
