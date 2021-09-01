public class Demo {
    public static void main(String args[]) {
        Oyun oyun = new Oyun();

        while(oyun.getEmptyBlock() != 0) {
            while (!oyun.playA((int) (Math.random() * 4) - 0, (int)(Math.random() * 4) - 0) && oyun.getEmptyBlock() != 0); //play until you find empty block
            while (!oyun.playB((int) (Math.random() * 4) - 0, (int)(Math.random() * 4) - 0) && oyun.getEmptyBlock() != 0); //play until you find empty block
        }

        System.out.println("A: " + oyun.checkA());
        System.out.println("B: " + oyun.checkB());
    }
}
