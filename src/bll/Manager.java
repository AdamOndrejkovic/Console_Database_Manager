package bll;

import bll.IManager;
import dbl.DatabaseController;
import dbl.IDataController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Manager implements IManager {
    private IDataController db = new DatabaseController();
    private static boolean quit = true;

    @Override
    public void menu(){
        printWelcome();

        while (quit){
            System.out.println();
            printOptions();
            userInputHandler(inputHandler());

        }
    }

    public void userInputHandler(String input) {

        if(input.equals("create table")){
            createTable();
        }else if(input.equals("show table")){
            showTable();
        }else if(input.equals("add record")){
            addRecord();
        }else if(input.equals("update record")){
            updateRecord();
        }else if(input.equals("delete record")){
            deleteRecord();
        }else if(input.equals("quit")){
            quit = false;
        }else{
            System.out.println("Wrong input !!!");
        }
    }

    public void printWelcome(){
        System.out.println("Welcome to our warehouse product manager. \nHere you will be able to manage all your products");
    }

    public void printOptions(){
        System.out.println("Your options are");
        System.out.println("create table | show table | add record | update record | delete record | quit");
        System.out.println();
    }

    public String inputHandler(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public void createTable(){
        System.out.println("Enter the name for new table");
        String input = inputHandler();
        if(input != "") {
            db.createTable(input);
        }else {
            System.out.println("Invalid name for the table");
        }
    }

    public void showTable(){
        db.showTable();
    }

    public void addRecord(){
        System.out.println("/nEnter the product");
        String product = inputHandler();

        System.out.println("/nEnter the type");
        String type = inputHandler();

        System.out.println("/nEnter the quantity");
        int quantity = Integer.parseInt(inputHandler());

        System.out.println("/nEnter the price");
        int price = Integer.parseInt(inputHandler());

        db.addRecord(product,type,quantity,price);
    }

    public void updateRecord(){
        System.out.println("/nEnter the product");
        String field = inputHandler();

        System.out.println("/nEnter the type");
        String value = inputHandler();

        System.out.println("/nEnter the quantity");
        String updateField = inputHandler();

        System.out.println("/nEnter the price");
        String updateRecord = inputHandler();

        db.updateRecord(field,value,updateField, updateRecord);
    }

    public  void deleteRecord(){
        System.out.println("/nEnter the column name");
        String column = inputHandler();

        System.out.println("/nEnter the value");
        String value = inputHandler();

        db.deleteRecord(column,value);
    }

}
