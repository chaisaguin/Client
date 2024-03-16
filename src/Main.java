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
        menu();
    }

    public static void deleteClient() {
        System.out.println("DELETE CLIENT/S");

        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "myuser", "remwell996");
            Statement stmt = conn.createStatement();
        ) {
            // Execute a SQL INSERT|DELETE statement via executeUpdate(),
         //   which returns an int indicating the number of rows affected.

         System.out.print("Enter the Client ID to delete: ");
         String clientIDToDelete = sc.nextLine();

         String sqlDelete = "DELETE FROM client WHERE Client_ID = '" + clientIDToDelete +"' ";
         System.out.println("The SQL statement is: " + sqlDelete + "\n");  // Echo for debugging
         int countDeleted = stmt.executeUpdate(sqlDelete);
         System.out.println(countDeleted + " records deleted.\n");
    
            // Display updated records (optional)
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();
    }
    

    public static void updateClient(){
        System.out.println("UPDATE CLIENT/S");
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
            String strSelect = "select Service_ID, Service_Status, Service_Price, Invoice_Status,Date_Availed,Client_ID from Services";
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
               String serviceID = rset.getString("Service_ID");  // retrieve a 'String'-cell in the row
               String serviceStatus = rset.getString("Service_Status");  // retrieve a 'double'-cell in the row
               String servicePrice = rset.getString("Service_Price");
               String invoiceStatus   = rset.getString("Invoice_Status");       // retrieve a 'int'-cell in the row
               String dateAvailed   = rset.getString("Date_Availed");       // retrieve a 'int'-cell in the row
               String clientID = rset.getString("Client_ID");
               System.out.println(serviceID + ", " + serviceStatus + ", " + servicePrice + ", " + invoiceStatus + ", "+ dateAvailed+", "+ clientID);
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
