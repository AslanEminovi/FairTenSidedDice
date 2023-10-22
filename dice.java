import java.util.Random;

public class dice {
    private int rollCount;
    private int[] sideCounts;

    public dice() {
        rollCount = 0;
        sideCounts = new int[10]; 
    }

    public int roll() {
        Random random = new Random();
        int rolledNumber = random.nextInt(10) + 1; 
        rollCount++;
        sideCounts[rolledNumber - 1]++; 
        return rolledNumber;
    }

    public int getRollCount() {
        return rollCount;
    }

    public int[] getSideCounts() {
        return sideCounts;
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder("Dice has been Rolled " + rollCount + " times\n");
        for (int i = 0; i < 10; i++) {
            report.append((i + 1) + ": >" + sideCounts[i]);
            if (i < 9) {
                report.append(", ");
            }
        }
        return report.toString();
    }

    public static void main(String[] args) {
        dice dice = new dice();

        for (int i = 0; i < 20; i++) {
            int result = dice.roll();
            System.out.println("Roll " + (i + 1) + ": " + result);
        }

        System.out.println("\n" + dice.generateReport());
    }
}
