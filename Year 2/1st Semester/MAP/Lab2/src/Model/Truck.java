package Model;

public class Truck implements Vehicle{
    private int repairCost;

    public Truck(int repairCost) {
        this.repairCost = repairCost;
    }

    public int getRepairCost() {
        return this.repairCost;
    }

    public void setRepairCost(int value) {
        this.repairCost = value;
    }

    @Override
    public boolean compareCost(int value) {
        return this.repairCost > value;
    }

    @Override
    public String toString() {
        return "Truck has repair cost of " + String.valueOf(this.getRepairCost()) + ".";
    }
}
