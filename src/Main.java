import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int menuCycle;
    static String clientIDToDelete;

    static String clientNameToAdd;
    static String clientEmailToAdd;
    static String clientIDToAdd;

    static String clientIDToUpdate;
    static String clientNameToUpdate;
    static String clientEmailToUpdate;

    static String clientServiceTypeToBeAdded;
    static int clientServicePriceToBeAdded;
    static String clientIDToBeAdded;
    static String serviceIDToBeAdded;
    public static void menu(){
        System.out.println("+++++++++++++ HELLO ADMIN +++++++++++++");
        System.out.println("1. VIEW CLIENTS");
        System.out.println("2. ADD CLIENTS");
        System.out.println("3. DELETE CLIENTS");
        System.out.println("4. UPDATE CLIENT INFO");
        System.out.println("5. VIEW ALL SERVICE");
        System.out.println("6. ADD NEW SERVICE");
        System.out.println("7. DELETE A SERVICE");
        System.out.println("8. UPDATE A SERVICE");
        System.out.println("ENTER 0 TO EXIT");
        System.out.print("Answer:");
        menuCycle = sc.nextInt();
    }

    public static void viewClient(){
        System.out.println("VIEW CLIENT/S");
        try (
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "remwell996");  
               
         Statement stmt = conn.createStatement();
      ) {
         String strSelect = "select Client_ID, Name, Email from Client";
         System.out.println("The SQL statement is: " + strSelect + "\n");
 
         ResultSet rset = stmt.executeQuery(strSelect);
 
         System.out.println("The records selected are:");
         int rowCount = 0;
         
         while(rset.next()) {   
            String clientID = rset.getString("Client_ID");  
            String name = rset.getString("Name");  
            String    email   = rset.getString("Email");       
            System.out.println(clientID + ", " + name + ", " + email);
            ++rowCount;
         }
         System.out.println("Total number of records = " + rowCount);
         System.out.println("Hello");
 
      } catch(SQLException ex) {
         ex.printStackTrace();
      }
        menu();
    }
    

    public static void addClient(){
        System.out.println("ADDING CLIENT/S");

        //add to show last na gi add na Client ID

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Client name:");
        clientNameToAdd = scanner.nextLine();
        System.out.print("Enter Client Email:");
        clientEmailToAdd = scanner.nextLine();
        System.out.print("Enter Client ID:");
        clientIDToAdd = scanner.nextLine();
        addClientAction();
    }

    public static void addClientAction(){
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "myuser", "remwell996");
            Statement stmt = conn.createStatement();
        ) {
            //INSERT INTO Client (Client_ID, Name, Email) VALUES('C01', 'Rem Well Pepito', 'remwellpepito@gmail.com')

         String sqlAddClient = "INSERT INTO Client (Client_ID, Name, Email) VALUES('" + clientIDToAdd + "','" + clientNameToAdd + "','" + clientEmailToAdd + "')" ;
         System.out.println("The SQL statement is: " + sqlAddClient + "\n");  
         int countDeletedServices = stmt.executeUpdate(sqlAddClient);
         System.out.println(countDeletedServices + " records added to Client.\n");


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();

    }

    public static void deleteClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("DELETE CLIENT/S");
        System.out.print("Enter the Client ID to delete: ");
        clientIDToDelete = scanner.nextLine();
        deleteClientAction();
    }
    
    public static void deleteClientAction(){
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "myuser", "remwell996");
            Statement stmt = conn.createStatement();
        ) {
        // Execute a SQL INSERT|DELETE statement via executeUpdate(),
         //   which returns an int indicating the number of rows affected.

         String sqlDeleteServicesToDeleteClient = "DELETE FROM Services WHERE Client_ID = '"+clientIDToDelete+"'";
         System.out.println("The SQL statement is: " + sqlDeleteServicesToDeleteClient + "\n");  // Echo for debugging
         //String sqlCallServicesTable = ("SELECT * FROM Services");
         int countDeletedServices = stmt.executeUpdate(sqlDeleteServicesToDeleteClient);
         System.out.println(countDeletedServices + " records deleted from services.\n");

         String sqlDelete = "DELETE FROM Client WHERE Client_ID = '"+clientIDToDelete+"'";
         System.out.println("The SQL statement is: " + sqlDelete + "\n");  // Echo for debugging
         //String sqlCallClientTable = ("SELECT * FROM client");
         int countDeleted = stmt.executeUpdate(sqlDelete);
         System.out.println(countDeleted + " records deleted.\n");
    
            // Display updated records (optional)
            /*
            String strSelect = "SELECT * FROM clients";
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {
                String clientID = rset.getString("Client_ID");
                String name = rset.getString("Name");
                String email = rset.getString("Email");
                System.out.println(clientID + ", " + name + ", " + email);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
             */
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();
         
    }

    public static void updateClient(){
        System.out.println("UPDATE CLIENT/S");

        Scanner scanner = new Scanner(System.in);
        System.out.println("ADDING CLIENT/S");
        System.out.print("Enter Client ID:");
        clientIDToUpdate = scanner.nextLine();

        //Add here code to show client info 
        
        try (
            Connection conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                  "myuser", "remwell996");  
                  
            Statement stmt = conn.createStatement();
         ) {
            String strSelect = "SELECT * FROM Client WHERE Client_ID = '"+clientIDToUpdate+"'";
            System.out.println("The SQL statement is: " + strSelect + "\n");
    
            ResultSet rset = stmt.executeQuery(strSelect);
    
            System.out.println("Here is the Client information");
            int rowCount = 0;
            
            while(rset.next()) {   
               String clientID = rset.getString("Client_ID");  
               String name = rset.getString("Name");  
               String    email   = rset.getString("Email");       
               System.out.println(clientID + ", " + name + ", " + email);
            }
            System.out.println("Hello");
    
         } catch(SQLException ex) {
            ex.printStackTrace();
         }

        System.out.print("Enter Client updated name:");
        clientNameToUpdate = scanner.nextLine();
        System.out.print("Enter Client updated Email:");
        clientEmailToUpdate = scanner.nextLine();
        updateClientAction();
        
    }
    //UPDATE Client SET Name = 'New Name', Email = 'newemail@example.com' WHERE Client_ID = 'C01';

    public static void updateClientAction(){

        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "myuser", "remwell996");
            Statement stmt = conn.createStatement();
        ) {
            //INSERT INTO Client (Client_ID, Name, Email) VALUES('C01', 'Rem Well Pepito', 'remwellpepito@gmail.com')

         String sqlUpdateClient = "UPDATE Client SET Name = '"+clientNameToUpdate+"', Email = '"+clientEmailToUpdate+"' WHERE Client_ID = '"+clientIDToUpdate+"'" ;
         System.out.println("The SQL statement is: " + sqlUpdateClient + "\n");  
         int countDeletedServices = stmt.executeUpdate(sqlUpdateClient);
         System.out.println(countDeletedServices + " records updated to Client.\n");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();

    }

    public static void viewService(){
        System.out.println("VIEW SERVICES");
        try (
            // Step 1: Construct a database 'Connection' object called 'conn'
            Connection conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                  "myuser", "remwell996");   // For MySQL only
                  // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
    
            // Step 2: Construct a 'Statement' object called 'stmt' inside the Connection created
            Statement stmt = conn.createStatement();
         ) {
            // Step 3: Write a SQL query string. Execute the SQL query via the 'Statement'.
            //  The query result is returned in a 'ResultSet' object called 'rset'.
            String strSelect = "select Service_Type, Service_ID, Service_Status, Service_Price, Invoice_Status,Date_Added,Client_ID from Services";
            System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
    
            ResultSet rset = stmt.executeQuery(strSelect);
    
            // Step 4: Process the 'ResultSet' by scrolling the cursor forward via next().
            //  For each row, retrieve the contents of the cells with getXxx(columnName).
            System.out.println("The records selected are:");
            int rowCount = 0;
            // Row-cursor initially positioned before the first row of the 'ResultSet'.
            // rset.next() inside the whole-loop repeatedly moves the cursor to the next row.
            // It returns false if no more rows.
            while(rset.next()) {   // Repeatedly process each row
               String serviceType = rset.getString("Service_Type");  // retrieve a 'String'-cell in the row
               String serviceID = rset.getString("Service_ID");  // retrieve a 'String'-cell in the row
               String serviceStatus = rset.getString("Service_Status");  // retrieve a 'double'-cell in the row
               String servicePrice = rset.getString("Service_Price");
               String invoiceStatus   = rset.getString("Invoice_Status");       // retrieve a 'int'-cell in the row
               String dateAdded   = rset.getString("Date_Added");       // retrieve a 'int'-cell in the row
               String clientID = rset.getString("Client_ID");
               System.out.println(serviceType+", "+serviceID + ", " + serviceStatus + ", " + servicePrice + ", " + invoiceStatus + ", "+ dateAdded+", "+ clientID);
               ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
    
         } catch(SQLException ex) {
            ex.printStackTrace();
         }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
        menu();
    }
    
    public static void addService(){
        System.out.println("addS");

        //add to show last na gi add na service ID

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("PhotoShop - 600");
        System.out.println("Social Media Managing - 500");
        System.out.println("Video editing - 700");
        System.out.print("What service to avail:");
        clientServiceTypeToBeAdded =  scanner.nextLine();
        System.out.print("Service Price:");
        clientServicePriceToBeAdded =  scanner2.nextInt();
        System.out.print("Enter Client ID:");
        clientIDToBeAdded =  scanner.nextLine();
        System.out.print("Enter Service ID:");
        serviceIDToBeAdded =  scanner.nextLine();
        addServiceAction();
    }


    public static void addServiceAction(){
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "myuser", "remwell996");
            Statement stmt = conn.createStatement();
        ) {

         String sqlAddClient = "INSERT INTO Services (Service_ID, Service_Type, Service_Price, Service_Status, Invoice_Status, Date_Added, Client_ID)  VALUES('"+serviceIDToBeAdded+"', '"+clientServiceTypeToBeAdded+"', '"+clientServicePriceToBeAdded+"', 'Ongoing', 'unpaid', CURRENT_TIMESTAMP, '"+clientIDToBeAdded+"')" ;
         System.out.println("The SQL statement is: " + sqlAddClient + "\n");  
        int countDeletedServices = stmt.executeUpdate(sqlAddClient);
        System.out.println(countDeletedServices + " records added to Client.\n");


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();

    }

    public static void deleteService(){
        System.out.println("deleteS");
        menu();
    }

    public static void updateService(){
        System.out.println("updateS");
        menu();
    }

    public static void offAplication(){
        System.out.println("WE OUT");
        System.out.println("Hello");
        
    }

    public static void main(String[] args) throws Exception {
        menu();
        do{
        if(menuCycle == 0){
            offAplication();
        }else if(menuCycle == 1){
            viewClient();
        }else if(menuCycle == 2){
            addClient();
        }else if(menuCycle == 3){
            deleteClient();
        }else if(menuCycle == 4){
            updateClient();
        }else if(menuCycle == 5){
            viewService();
        }else if(menuCycle == 6){
            addService();
        }else if(menuCycle == 7){
            deleteService();
        }else if(menuCycle == 8){
            updateService();
        }
        }while(menuCycle != 0);
        offAplication();
       
    }
}
