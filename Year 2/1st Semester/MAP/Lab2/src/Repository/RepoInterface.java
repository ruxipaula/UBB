package Repository;

import Model.Vehicle;
import MyException.MyException;

public interface RepoInterface {
    public void add(Vehicle v) throws MyException;
    public void delete(int index) throws MyException;
    public Vehicle[] getVehicles();
    public int getNrOfElements();
}
