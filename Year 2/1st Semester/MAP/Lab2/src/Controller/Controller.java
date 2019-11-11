package Controller;

import Model.Vehicle;
import MyException.MyException;
import Repository.RepoInterface;
import Repository.Repository;

public class Controller {
    private RepoInterface repository;

    public Controller(RepoInterface repo) {
        this.repository = repo;
    }

    public String filterByCost(int value) {
        Vehicle[] allVehicles = repository.getVehicles();
        String filtered = "";
        for(int i=0; i< repository.getNrOfElements(); i++) {
            if (allVehicles[i].compareCost(value))
                filtered = filtered + allVehicles[i].toString() + "\n";
        }

        return filtered;
    }

    public void addVehicle(Vehicle vehicle) throws MyException {
        this.repository.add(vehicle);
    }

    public void deleteVehicle(int index) throws MyException{
        this.repository.delete(index);
    }

    public String getAll() {
        Vehicle[] allVehicles =  repository.getVehicles();
        String all = "";
        for(int i=0; i< repository.getNrOfElements(); i++) {
            all = all + allVehicles[i].toString() + "\n";
        }

        return all;
    }
}
