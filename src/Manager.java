import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Manager {
    private DatabaseController db = new DatabaseController();

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
        System.out.println("Enter the product");
        String product = inputHandler();

        System.out.println("Enter the type");
        String type = inputHandler();

        System.out.println("Enter the quantity");
        int quantity = Integer.parseInt(inputHandler());

        System.out.println("Enter the price");
        int price = Integer.parseInt(inputHandler());

        db.addRecord(product,type,quantity,price);
    }

    public void updateRecord(){
        System.out.println("Enter the product");
        String field = inputHandler();

        System.out.println("Enter the type");
        String value = inputHandler();

        System.out.println("Enter the quantity");
        String updateField = inputHandler();

        System.out.println("Enter the price");
        String updateRecord = inputHandler();

        db.updateRecord(field,value,updateField, updateRecord);
    }

}
