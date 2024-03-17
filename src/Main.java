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
    static String variable;

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

    static String serviceIDToBeUpdated;
    static String serviceTypeToBeUpdated;
    static int servicePriceToBeUpdated;
    static String serviceStatusToBeUpdated;
    static String serviceInvoiceStatusToBeUpdated;


    public static void menu(){
        System.out.println("\n//------------ HELLO ADMIN ------------//");
        System.out.println("1. VIEW CLIENTS");
        System.out.println("2. ADD CLIENTS");
        System.out.println("3. DELETE CLIENTS");
        System.out.println("4. UPDATE CLIENT INFO");
        System.out.println("5. VIEW ALL SERVICE");
        System.out.println("6. ADD NEW SERVICE");
        System.out.println("7. DELETE A SERVICE");
        System.out.println("8. UPDATE A SERVICE");
        System.out.println("9. SHOW STATISTICS");
        System.out.println("ENTER 0 TO EXIT");
        System.out.println("//-------------------------------------//");
        System.out.print("Answer: ");
        menuCycle = sc.nextInt();
    }

    public static void viewClient(){
        System.out.println("VIEW CLIENTS");
        try (
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "remwell996");  
               
         Statement stmt = conn.createStatement();
      ) {
         String strSelect = "select Client_ID, Name, Email from Client";
         System.out.println("The SQL statement is: " + strSelect + "\n");
 
         ResultSet rset = stmt.executeQuery(strSelect);
        
         
         System.out.println("CLIENTS IN RECORD:");
         System.out.println("--------------------------------------------------");
         int rowCount = 0;
         
         while(rset.next()) {   
            String clientID = rset.getString("Client_ID");  
            String name = rset.getString("Name");  
            String    email   = rset.getString("Email");       
            System.out.println(clientID + ", " + name + ", " + email);
            ++rowCount;
         }
         System.out.println("--------------------------------------------------");
         System.out.println("Total number of records = " + rowCount);
 
      } catch(SQLException ex) {
         ex.printStackTrace();
      }
        menu();
    }
    

    public static void addClient(){
        System.out.println("\nADDING CLIENTS");

        //add to show last na gi add na Client ID
        getLastAddedClientID();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Client Name:");
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

         String sqlAddClient = "INSERT INTO Client (Client_ID, Name, Email) VALUES('" + clientIDToAdd + "','" + clientNameToAdd + "','" + clientEmailToAdd + "')" ;
         System.out.println("The SQL statement is: " + sqlAddClient + "\n");  
         int countAddeddServices = stmt.executeUpdate(sqlAddClient);
         System.out.println(countAddeddServices + " records added to Client.\n");


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();

    }

    public static void deleteClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDELETE CLIENTS");
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

         String sqlDeleteServicesToDeleteClient = "DELETE FROM Services WHERE Client_ID = '"+clientIDToDelete+"'";
         System.out.println("The SQL statement is: " + sqlDeleteServicesToDeleteClient + "\n");  
         int countDeletedServices = stmt.executeUpdate(sqlDeleteServicesToDeleteClient);
         System.out.println(countDeletedServices + " records deleted from services.\n");

         String sqlDelete = "DELETE FROM Client WHERE Client_ID = '"+clientIDToDelete+"'";
         System.out.println("The SQL statement is: " + sqlDelete + "\n"); 
         int countDeleted = stmt.executeUpdate(sqlDelete);
         System.out.println(countDeleted + " records deleted.\n");
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();
         
    }

    public static void updateClient(){
        System.out.println("\nUPDATE CLIENT INFORMATION");

        try (
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "remwell996");  
               
         Statement stmt = conn.createStatement();
      ) {
         String strSelect = "select Client_ID, Name from Client";
         System.out.println("The SQL statement is: " + strSelect + "\n");
 
         ResultSet rset = stmt.executeQuery(strSelect);

         System.out.println("CLIENT RECORDS");
         System.out.println("--------------------------------------------------");
         int rowCount = 0;
         
         while(rset.next()) {   
            String clientID = rset.getString("Client_ID");  
            String name = rset.getString("Name");       
            System.out.println(clientID + " = " + name);
            ++rowCount;
         }
 
      } catch(SQLException ex) {
         ex.printStackTrace();
      }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nADDING CLIENTS");
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
    
            System.out.println("Here is the Client Information:");
            int rowCount = 0;
            
            while(rset.next()) {   
               String clientID = rset.getString("Client_ID");  
               String name = rset.getString("Name");  
               String    email   = rset.getString("Email");       
               System.out.println(clientID + ", " + name + ", " + email);
            }
            System.out.println("--------------------------------------------------");   

         } catch(SQLException ex) {
            ex.printStackTrace();
         }

        System.out.print("Enter Client updated name:");
        clientNameToUpdate = scanner.nextLine();
        System.out.print("Enter Client updated Email:");
        clientEmailToUpdate = scanner.nextLine();
        updateClientAction();
        
    }

    public static void updateClientAction(){

        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "myuser", "remwell996");
            Statement stmt = conn.createStatement();
        ) {

         String sqlUpdateClient = "UPDATE Client SET Name = '"+clientNameToUpdate+"', Email = '"+clientEmailToUpdate+"' WHERE Client_ID = '"+clientIDToUpdate+"'" ;
         System.out.println("The SQL statement is: " + sqlUpdateClient);  
         int countDeletedServices = stmt.executeUpdate(sqlUpdateClient);
         System.out.println("--------------------------------------------------");
         System.out.println(countDeletedServices + " records updated to Client.\n");
         

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();

    }

    public static void viewService(){
        System.out.println("VIEW SERVICES");
        try (
            Connection conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                  "myuser", "remwell996");
            Statement stmt = conn.createStatement();
         ) {
            
            String strSelect = "select Service_Type, Service_ID, Service_Status, Service_Price, Invoice_Status,Date_Added,Client_ID from Services";
            System.out.println("The SQL statement is: " + strSelect + "\n"); 
    
            ResultSet rset = stmt.executeQuery(strSelect);
    
            
            System.out.println("                                   SERVICES IN RECORD                            ");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Service Type, Service ID, Service Status, Service Price, Invoice Status, Date, Client ID");
            System.out.println("------------------------------------------------------------------------------------------");
            int rowCount = 0;

            while(rset.next()) {   
               String serviceType = rset.getString("Service_Type");  
               String serviceID = rset.getString("Service_ID");  
               String serviceStatus = rset.getString("Service_Status");  
               String servicePrice = rset.getString("Service_Price");
               String invoiceStatus   = rset.getString("Invoice_Status");    
               String dateAdded   = rset.getString("Date_Added");    
               String clientID = rset.getString("Client_ID");
               System.out.println(serviceType+", "+serviceID + ", " + serviceStatus + ", " + servicePrice + ", " + invoiceStatus + ", "+ dateAdded+", "+ clientID);
               ++rowCount;
            }
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Total number of records = " + rowCount);
    
         } catch(SQLException ex) {
            ex.printStackTrace();
         }  
        menu();
    }
    
    public static void addService(){
        System.out.println("ADDING SERVICE");

        //add to show last na gi add na service ID
        getLastAddedServiceID();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Photoshoot - 600");
        System.out.println("Social Media Managing - 500");
        System.out.println("Video editing - 700");
        System.out.print("What service to avail? :");
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
        System.out.println("DELETE SERVICE");

        //Show list of Services 
        System.out.println("CURRENT SERVICES");
        try (
            Connection conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                  "myuser", "remwell996");  
            Statement stmt = conn.createStatement();
         ) {
            
            String strSelect = "select Service_Type, Service_ID, Service_Status, Service_Price, Invoice_Status,Date_Added,Client_ID from Services";
            System.out.println("The SQL statement is: " + strSelect + "\n");
    
            ResultSet rset = stmt.executeQuery(strSelect);
    
    
            System.out.println("The records selected are:");
            int rowCount = 0;
            
            while(rset.next()) { 
               String serviceType = rset.getString("Service_Type");  
               String serviceID = rset.getString("Service_ID");  
               String serviceStatus = rset.getString("Service_Status");  
               String servicePrice = rset.getString("Service_Price");
               String invoiceStatus   = rset.getString("Invoice_Status");    
               String dateAdded   = rset.getString("Date_Added");    
               String clientID = rset.getString("Client_ID");
               System.out.println(serviceType+", "+serviceID + ", " + serviceStatus + ", " + servicePrice + ", " + invoiceStatus + ", "+ dateAdded+", "+ clientID);
               ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
    
         } catch(SQLException ex) {
            ex.printStackTrace();
         }  

        Scanner sc = new Scanner(System.in);
        System.out.println("DELETE SERVICES");
        System.out.print("Enter the Client ID to delete: ");
        variable = sc.nextLine();
        deleteServiceAction();

    }

    public static void deleteServiceAction(){

        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "myuser", "remwell996");
            Statement stmt = conn.createStatement();
        ) {
         System.out.println(variable);
         String sqlStatementDeleteService = "DELETE FROM Services WHERE Service_ID = '" + variable + "'";
         System.out.println("The SQL statement is: " + sqlStatementDeleteService + "\n");  
         int countDeletedServices = stmt.executeUpdate(sqlStatementDeleteService);
         System.out.println(countDeletedServices + " records deleted from services.\n");
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();

    }

    public static void updateService(){
        System.out.println("UPDATE SERVICE");
        try (
            Connection conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                  "myuser", "remwell996");
            Statement stmt = conn.createStatement();
         ) {
            
            String strSelect = "select Client_ID, Service_ID, Service_Type, Service_Status, Service_Price, Invoice_Status from Services";
            System.out.println("The SQL statement is: " + strSelect + "\n"); 
    
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("SERVICES RECORDS");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("ServiceID, Service Status, Invoice Status, Service Price, Date, Client ID");
            System.out.println("----------------------------------------------------------------------------");
            int rowCount = 0;

            while(rset.next()) {   
            String serviceID = rset.getString("Service_ID");  
               String serviceType = rset.getString("Service_Type");  
               String serviceStatus = rset.getString("Service_Status");  
               String servicePrice = rset.getString("Service_Price");
               String clientID = rset.getString("Client_ID");
               String invoiceStatus   = rset.getString("Invoice_Status");      
               System.out.println(serviceID+", "+  serviceStatus + ", " + serviceType + ", " + invoiceStatus + ", " + servicePrice + ", "+ clientID );
               ++rowCount;
            }
            System.out.println("------------------------------------------");
            System.out.println("Total number of records = " + rowCount);
    
         } catch(SQLException ex) {
            ex.printStackTrace();
         }  
        Scanner sc = new Scanner(System.in);
        Scanner intSc = new Scanner(System.in);
        System.out.println("\nPROCEED TO UPDATE A SERVICE...");
        System.out.println("------------------------------------------");
        System.out.print("Enter the Service ID to Update: ");
        serviceIDToBeUpdated = sc.nextLine();
        System.out.println("Photoshoot - 600");
        System.out.println("Social Media Managing - 500");
        System.out.println("Video editing - 700");
        System.out.print("Updated service to be availed:");
        serviceTypeToBeUpdated = sc.nextLine();
        System.out.print("Updated price:");
        servicePriceToBeUpdated = intSc.nextInt();
        System.out.print("Update service status:");
        serviceStatusToBeUpdated = sc.nextLine();
        System.out.print("Update invoice status:");
        serviceInvoiceStatusToBeUpdated = sc.nextLine();

        updateServiceAction();
    }

    public static void updateServiceAction(){
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "myuser", "remwell996");
            Statement stmt = conn.createStatement();
        ) {

        String sqlUpdateService = "UPDATE Services SET Service_Type = '"+serviceTypeToBeUpdated+"', Service_Price = "+servicePriceToBeUpdated+", Service_Status = '"+serviceStatusToBeUpdated+"', Invoice_Status = '"+serviceInvoiceStatusToBeUpdated+"' WHERE Service_ID = '"+serviceIDToBeUpdated+"'" ;
        System.out.println("The SQL statement is: " + sqlUpdateService + "\n");  
        int countDeletedServices = stmt.executeUpdate(sqlUpdateService);
        System.out.println(countDeletedServices + " Service Record updated.\n");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        menu();
    }

    public static void showStatistics(){

        System.out.println("\nDisplaying Statistics:");
        System.out.println("--------------------------------------------------------------");
        System.out.println("MOST AVAILED SERVICES: "+getMostFrequentService());
        System.out.println("CLIENT WITH MOST ORDERS: "+getClientWithMostOrders());
        System.out.println("WEEKLY REVENUE: " + calculateWeeklyRevenue());
        System.out.println("--------------------------------------------------------------");
        System.out.println("Analysis Displayed!");
        menu();
    }

    public static String getMostFrequentService() {
        String mostFrequentService = null;

        String url = "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user = "myuser";
        String password = "remwell996";

        String sqlQuery = "SELECT Service_Type, COUNT(*) AS service_count " +
                          "FROM Services " +
                          "GROUP BY Service_Type " +
                          "ORDER BY service_count DESC " +
                          "LIMIT 1";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
        ) {
            if (rs.next()) {
                mostFrequentService = rs.getString("Service_Type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mostFrequentService;
    }
    
    public static String getClientWithMostOrders() {
        String clientWithMostOrders = null;
        
        String url = "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user = "myuser";
        String password = "remwell996";

        String sqlQuery = "SELECT c.Client_ID, c.Name, COUNT(s.Service_ID) AS order_count " +
                          "FROM Client c " +
                          "LEFT JOIN Services s ON c.Client_ID = s.Client_ID " +
                          "GROUP BY c.Client_ID, c.Name " +
                          "ORDER BY order_count DESC " +
                          "LIMIT 1";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
        ) {

            if (rs.next()) {
                String clientId = rs.getString("Client_ID");
                String clientName = rs.getString("Name");
                clientWithMostOrders = clientName + " - Client ID: "+ clientId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientWithMostOrders;
    }

    public static int calculateWeeklyRevenue() {
        int weeklyRevenue = 0;
        
        String url = "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user = "myuser";
        String password = "remwell996";

        String sqlQuery = "SELECT SUM(Service_Price) AS totalRevenue " +
                          "FROM Services " +
                          "WHERE Date_Added >= DATE_SUB(CURDATE(), INTERVAL 1 WEEK)";
        
        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
        ) {

            if (rs.next()) {
                weeklyRevenue = rs.getInt("totalRevenue");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return weeklyRevenue;
    }

    public static void getLastAddedClientID() {
        String url = "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user = "myuser";
        String password = "remwell996";

        String sqlQuery = "SELECT Client_ID FROM Client ORDER BY Date_Added DESC LIMIT 1";
        
        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
        ) {
            if (rs.next()) {
                String clientId = rs.getString("Client_ID");
                System.out.println("Last added client ID: " + clientId );
                System.out.println("");
            } else {
                System.out.println("No clients found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getLastAddedServiceID() {
        String url = "jdbc:mysql://localhost:3306/ManagementSystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user = "myuser";
        String password = "remwell996";

        String sqlQuery = "SELECT Service_ID FROM Services ORDER BY Date_Added DESC LIMIT 1";
        
        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
        ) {
            if (rs.next()) {
                String serviceId = rs.getString("Service_ID");
                System.out.println("Last added service ID: " + serviceId);
            } else {
                System.out.println("No services found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void offApplication(){
        System.out.println("------------------------------");
        System.out.println("        PROGRAM ENDED!        ");
        System.out.println("------------------------------");
        
    }

    public static void main(String[] args) throws Exception {
        menu();
        while (menuCycle != 0) {
            switch (menuCycle) {
                case 1:
                    viewClient();
                    break;
                case 2:
                    addClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                case 4:
                    updateClient();
                    break;
                case 5:
                    viewService();
                    break;
                case 6:
                    addService();
                    break;
                case 7:
                    deleteService();
                    break;
                case 8:
                    updateService();
                    break;
                case 9:
                    showStatistics();
                    break;
                default:
                    offApplication();
                    break;
            }
        }
        offApplication();
    }

}
    
