public class Fruits {
    public static void main(String[] args) {
        Thread numberThread = new Thread(new Numbers());

        Letters lettersThread = new Letters();
        //Lambda Expression for Fruit Names
        Thread fruitsThread = new Thread(() -> {
            String[] fruits = { "Apple", "Mango", "Orange", "Watermelon" };
            for(String fruit : fruits) {
                System.out.println("fruit " + fruit);
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        });
        //Start the thread
        fruitsThread.start();
        lettersThread.start();
        numberThread.start();
    }
}
