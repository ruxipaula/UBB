package View;

import java.util.Scanner;
import Controller.Controller;
import Model.Car;
import Model.Motorcycle;
import Model.Truck;
import MyException.MyException;
import Repository.Repository;

public class View {
    private Controller controller;
    private Scanner scanner;

    public View(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void addVehicle() throws MyException{
        System.out.println("1. Add car");
        System.out.println("2. Add motorcycle");
        System.out.println("3. Add truck");

        System.out.print(">> ");
        int type = scanner.nextInt();
        System.out.print("Enter repair cost: ");
        int cost = scanner.nextInt();

        if (type == 1)
            this.controller.addVehicle(new Car(cost));
        else if (type == 2)
            this.controller.addVehicle(new Motorcycle(cost));
        else if (type == 3)
            this.controller.addVehicle(new Truck(cost));
    }

    public void removeVehicle() throws MyException{
        System.out.print("Enter position >> ");
        int position = scanner.nextInt();
        this.controller.deleteVehicle(position);
    }

    public void showFiltered() {
        System.out.println(this.controller.filterByCost(1000));
    }

    public void showAll() {
        System.out.println(this.controller.getAll());
    }

    public void menu() {
        while(true) {
            System.out.println("1. Add vehicle");
            System.out.println("2. Remove vehicle");
            System.out.println("3. Show all vehicles");
            System.out.println("4. Show vehicles filtered by cost");

            System.out.print(">> ");
            int input = scanner.nextInt();
            System.out.println(input);

            try {
                if (input == 1)
                    this.addVehicle();
                else if (input == 2)
                    this.removeVehicle();
                else if (input == 3)
                    this.showAll();
                else if (input == 4)
                    this.showFiltered();
                else System.out.println("Invalud input");
            }
            catch(MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Repository repo = new Repository(20);
            Controller controller = new Controller(repo);
            View view = new View(controller);
            view.menu();
        }
    }
}
