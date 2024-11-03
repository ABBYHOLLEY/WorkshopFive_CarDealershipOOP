package com.ps;

import javax.tools.ForwardingJavaFileManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private static Vehicle vehicle;

    private static void init(){
    }

    static Scanner commandscanner = new Scanner(System.in);
    static Scanner inputScanner = new Scanner(System.in);
    static ArrayList<Vehicle> allVehiclesInInventory = new ArrayList<>();

    public static void display(){
        init();
        loadVehiclesFromCSV();
        showMainMenu();
    }
    public static void loadVehiclesFromCSV(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("dealership.csv"));
            String input;
            bufferedReader.readLine();

            while ((input = bufferedReader.readLine())!= null){
                String[] dealershiparray = input.split("\\|");

                String vin = dealershiparray[0];
                int year = Integer.parseInt(dealershiparray[1]);
                String make = dealershiparray[2];
                String model = dealershiparray[3];
                String vehicleType = dealershiparray[4];
                String vehicleColor = dealershiparray[5];
                int odometer = Integer.parseInt(dealershiparray[6]);
                double price = Double.parseDouble(dealershiparray[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, vehicleColor, odometer, (double) price);
                allVehiclesInInventory.add(vehicle);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void showMainMenu(){
        int mainMenuCommand;
        do {
            System.out.println("Welcome to Abby's Like-New Cars! What would you like to do?");
            System.out.println("1) Search by price");
            System.out.println("2) Search by make and model");
            System.out.println("3) Search by color");
            System.out.println("4) Search by mileage");
            System.out.println("5) Search by vehicle type (car, truck, suv, van)");
            System.out.println("6) View all vehicles");
            System.out.println("7) Add vehicle to inventory");
            System.out.println("8) Remove vehicle from inventory");
            System.out.println("9) Sell or lease a vehicle");
            System.out.println("0) Exit");
            System.out.println("Enter your command");

            try {
                mainMenuCommand = commandscanner.nextInt();
            } catch (InputMismatchException ime){
                System.out.println("Invalid. Please enter a valid command.");
                commandscanner.nextLine();
                mainMenuCommand = -1;
            }
            switch (mainMenuCommand){
                case 1:
                    searchByPrice();
                    break;
                case 2:
                    searchByMakeModel();
                    break;
                case 3:
                    searchByColor();
                    break;
                case 4:
                    searchByMileage();
                    break;
                case 5:
                    searchByType();
                    break;
                case 6:
                    searchAll();
                    break;
                case 7:
                    addVehicle();
                    break;
                case 8:
                    removeVehicle();
                    break;
                case 9:
                    sellOrLeaseVehicle();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found. Please try again!");

            }
        }while (mainMenuCommand !=0);
    }
    public static void searchByPrice(){
        System.out.println("Enter the price range of the vehicle you are looking for");
    }
    public static void searchByMakeModel(){}
    public static void searchByColor(){}
    public static void searchByMileage(){
        System.out.println("Enter the minimum mileage of the vehicle you are looking for: ");
        int minMileage = inputScanner.nextInt();
        System.out.println("Enter the maximum mileage of the vehicle you are looking for: ");
        int maxMileage = inputScanner.nextInt();
    }
    public static void searchByType(){}
    public static void searchAll(){
        System.out.println("Displaying all vehicles in inventory..");
        for (Vehicle vehicle: allVehiclesInInventory){
            System.out.println(vehicle);
        }
    }
    public static void addVehicle(){
        System.out.println("Please enter the details of the vehicle you would like to add.");

        System.out.println("Enter vehicle vin: ");
        String vin = inputScanner.nextLine();

        System.out.println("Enter vehicle year: ");
        int year = inputScanner.nextInt();
        inputScanner.nextLine();

        System.out.println("Enter vehicle make: ");
        String make = inputScanner.nextLine();

        System.out.println("Enter vehicle model: ");
        String model = inputScanner.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehicleType = inputScanner.nextLine();

        System.out.println("Enter vehicle color: ");
        String color = inputScanner.nextLine();

        System.out.println("Enter odometer number: ");
        int odometer = inputScanner.nextInt();
        inputScanner.nextLine();

        System.out.println("Enter vehicle price: ");
        double price = inputScanner.nextDouble();
        inputScanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, (int) price);
        allVehiclesInInventory.add(vehicle);

        System.out.println("New vehicle added to inventory!");

    }
    public static void removeVehicle(){

        System.out.println("Please enter the details of the vehicle you would like to remove.");

        System.out.println("Enter vehicle vin: ");
        String vin = inputScanner.nextLine();

        System.out.println("Enter vehicle year: ");
        int year = inputScanner.nextInt();
        inputScanner.nextLine();

        System.out.println("Enter vehicle make: ");
        String make = inputScanner.nextLine();

        System.out.println("Enter vehicle model: ");
        String model = inputScanner.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehicleType = inputScanner.nextLine();

        System.out.println("Enter vehicle color: ");
        String color = inputScanner.nextLine();

        System.out.println("Enter odometer number: ");
        int odometer = inputScanner.nextInt();
        inputScanner.nextLine();

        System.out.println("Enter vehicle price: ");
        double price = inputScanner.nextDouble();
        inputScanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, (double) price);
        allVehiclesInInventory.remove(vehicle);

        System.out.println("Vehicle has been removed from inventory.");
    }
    public static void sellOrLeaseVehicle(){

    }
}
