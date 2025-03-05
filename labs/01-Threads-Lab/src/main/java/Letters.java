public class Letters extends Thread {
    @Override
    public void run() {
        for(char c = 'A'; c <= 'E'; c++){
            System.out.println("Letters: " + c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
