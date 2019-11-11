package Repository;

import Model.Vehicle;
import MyException.MyException;

public class Repository implements RepoInterface{
    private Vehicle[] vehicles;
    private int position;

    public Repository(int size) {
        this.vehicles = new Vehicle[size];
        this.position = 0;
    }

    @Override
    public void add(Vehicle v) throws MyException {
        if (this.position >= this.vehicles.length)
            throw new MyException("Not enough space!");
        else
            this.vehicles[position] = v;
            position++;
    }

    @Override
    public void delete(int index) throws MyException{
        if (index >= 0 && index < this.position) {
            this.vehicles[index] = this.vehicles[position - 1];
            this.position--;
        }
        else
            throw new MyException("Index is out of bounds!");
    }

    @Override
    public Vehicle[] getVehicles() {
        return this.vehicles;
    }

    @Override
    public int getNrOfElements() {
        return this.position;
    }

}
