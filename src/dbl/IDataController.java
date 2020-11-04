package dbl;

public interface IDataController {
    void showConn();

    void createTable(String nameTable);

    void showTable();

    void addRecord(String product, String type, int quantity, int price);

    void updateRecord(String field, String value, String updateField, String updateRecord);

    void deleteRecord(String field, String value);
}
