import java.sql.*;

public class DatabaseController {

    public void showConn(){
        connDB();
    }

    public void createTable(String nameTable) {
        try {
            //connect
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adamo\\IdeaProjects\\ConsoleDBM\\warehouse.db");
            Statement statement = conn.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS + " + nameTable + "(product TEXT, type TEXT, quantity INTEGER, price INTEGER )");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong + " + " " + e.getMessage());
        }
    }

    public void showTable(){
            try {
                //connect
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adamo\\IdeaProjects\\ConsoleDBM\\warehouse.db");
                Statement statement = conn.createStatement();

                statement.execute("SELECT * FROM listWarehouse ");

                System.out.println("product--type--quantity--price");
                //get all the records
                ResultSet results = statement.getResultSet();
                while (results.next()){
                    System.out.println(results.getString("product") + " " +
                                        results.getString("type") + " " +
                                        results.getInt("quantity") + " " +
                                        results.getInt("price"));
                }

                statement.close();
                conn.close();

            } catch (SQLException e) {
                System.out.println("Something went wrong + " + " " + e.getMessage());
            }
    }

    public void addRecord(String product, String type, int quantity, int price){
            try {
                //connect
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adamo\\IdeaProjects\\ConsoleDBM\\warehouse.db");
                Statement statement = conn.createStatement();

                statement.execute("INSERT INTO listWarehouse (product, type, quantity, price) " +
                        "VALUES ('" + product + "', '" + type + "', '"+ quantity +"',  '"+ price +"')");


            } catch (SQLException e) {
                System.out.println("Something went wrong + " + " " + e.getMessage());
            }
    }

    public void updateRecord(String field, String value, String updateField, String updateRecord) {
        try {
            //connect
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adamo\\IdeaProjects\\ConsoleDBM\\warehouse.db");
            Statement statement = conn.createStatement();

            if(updateField.equals("quantity") || updateField.equals("price")){
                int intUpdateRecord = Integer.parseInt(updateRecord);
                statement.execute("UPDATE listWarehouse SET " + field + "=" + value + " WHERE " + updateField + "=" + "'" + intUpdateRecord + "'");
            }else{
                statement.execute("UPDATE listWarehouse SET " + field + "=" + value + " WHERE " + updateField + "=" + "'" + updateRecord + "'");
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong + " + " " + e.getMessage());
        }
    }

    public void deleteRecord(String field, String value){
        try {
            //connect
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adamo\\IdeaProjects\\ConsoleDBM\\warehouse.db");
            Statement statement = conn.createStatement();

            statement.execute("DELETE FROM listWarehouse  WHERE " + field + "=" + "'" + value + "'");


        } catch (SQLException e) {
            System.out.println("Something went wrong + " + " " + e.getMessage());
        }
    }

    private void connDB(){
            try{
                //connect
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adamo\\IdeaProjects\\ConsoleDBM\\warehouse.db");
                System.out.println("Connection succesful");

            }catch (SQLException e){
                System.out.println("Something went wrong + " + " " + e.getMessage());
            }
    }
}

