import java.util.*;

class SmartPowerGrid {
    static class Line {
        int load, loss;
        double efficiency;

        Line(int load, int loss) {
            this.load = load;
            this.loss = loss;
            this.efficiency = (double) load / loss;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of transmission lines: ");
        int n = sc.nextInt();
        Line[] lines = new Line[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter load and loss for line " + (i + 1) + ": ");
            int load = sc.nextInt();
            int loss = sc.nextInt();
            lines[i] = new Line(load, loss);
        }

        System.out.print("Enter total available power: ");
        int totalPower = sc.nextInt();

        
        Arrays.sort(lines, (a, b) -> Double.compare(b.efficiency, a.efficiency));

        double totalLoss = 0;
        int remainingPower = totalPower;

        System.out.println("\n--- Power Allocation Details ---");
        for (int i = 0; i < n && remainingPower > 0; i++) {
            int powerAllocated = Math.min(lines[i].load, remainingPower);
            remainingPower -= powerAllocated;
            double loss = (double) powerAllocated / lines[i].efficiency;
            totalLoss += loss;

            System.out.println("Line " + (i + 1) + " -> Allocated: " + powerAllocated +
                    " units, Loss: " + String.format("%.2f", loss));
        }

        System.out.println("\nTotal Power Supplied: " + (totalPower - remainingPower));
        System.out.println("Total Loss: " + String.format("%.2f", totalLoss));
    }
}
