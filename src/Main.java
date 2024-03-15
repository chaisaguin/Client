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
        System.out.println("view");
        menu();
    }

    public static void addClient(){
        System.out.println("add");
        menu();
    }

    public static void deleteClient(){
        System.out.println("delete");
        menu();
    }

    public static void updateClient(){
        System.out.println("update");
        menu();
    }

    public static void viewService(){
        System.out.println("viewS");
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
