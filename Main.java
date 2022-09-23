class EggAndChicken extends Thread {
    String name;
    public EggAndChicken(String name) {
        this.name = name;
    }
    public void run() {
        for(int i = 0; i < 5;i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(name);
        }
    }
}
public class Main {
    public static void main(String args[]) throws InterruptedException {
        EggAndChicken chicken = new EggAndChicken("курица");
        EggAndChicken egg = new EggAndChicken("яйцо");

        chicken.start();
        egg.start();

        try {
            chicken.join();
            if (egg.isAlive()) {
                System.out.println("Первым появилось яйцо!");
            } else {
                System.out.println("Первым появилась курица!");
            }
        } catch (InterruptedException e){
            e.getMessage();
        }
    }
}