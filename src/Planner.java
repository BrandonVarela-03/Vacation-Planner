import java.util.Scanner;
import java.io.File;
public class Planner{
	public static void main(String[] args){ 
    //Cart
    double subTotal = 0;
    int totalTickets = 0;
    double totalCost = 0;
    int vacationNum;
    int numTickets;
    double taxes = 0.0825;


    //Arrays for the file
    String[] names = new String[27];
    String[] category = new String[27];
    int[] price = new int[27];
    loadData("Vacation_Planner.txt", names, category,  price);
    //Switch
    Scanner in = new Scanner(System.in);
    int choice = 0;
    int vacationType = 0;




    // Use a while loop for Menu and subOptions vacationType
    while (choice != 7 ) {
        printMenu();
        System.out.println("Select an Option: ");
        choice = in.nextInt();

        switch (choice){
            case 1: {
                System.out.println("Select Vacation Type:");
                vacationPlanMenu();
                vacationType = in.nextInt();
                //SubSwitch for vacations Category
                switch (vacationType) {

                    case 1:
                        System.out.println("Resort Options:");
                        displayVacationType("Resort", names, category, price);
                        System.out.println("Select Vacation Number:");
                        vacationNum = in.nextInt();
                        System.out.println("How many tickets?");
                        numTickets = in.nextInt();
                        in.nextLine();
                        subTotal = price[vacationNum -1] * numTickets;
                        totalTickets += numTickets;
                        totalCost += subTotal;
                        System.out.println("Added to cart!");
                        break;


                    case 2:
                        System.out.println("Experience Options:");
                        displayVacationType("Experience", names, category, price);
                        System.out.println("Select Vacation Number:");
                        vacationNum = in.nextInt();
                        System.out.println("How many tickets?");
                        numTickets = in.nextInt();
                        in.nextLine();
                        subTotal = price[vacationNum -1] * numTickets;
                        totalTickets += numTickets;
                        totalCost += subTotal;
                        System.out.println("Added to cart!");
                        break;

                    case 3:
                        System.out.println("Activity Options:");
                        displayVacationType("Activity", names, category, price);
                        vacationNum = in.nextInt();
                        System.out.println("How many tickets?");
                        numTickets = in.nextInt();
                        in.nextLine();
                        subTotal = price[vacationNum -1] * numTickets;
                        totalTickets += numTickets;
                        totalCost += subTotal;
                        break;

                    case 4:
                        System.out.println("Travel Options:");
                        displayVacationType("Travel", names, category, price);
                        vacationNum = in.nextInt();
                        System.out.println("How many tickets?");
                        numTickets = in.nextInt();
                        in.nextLine();
                        subTotal = price[vacationNum -1] * numTickets;
                        totalTickets += numTickets;
                        totalCost += subTotal;
                        break;


                    case 5:
                        System.out.println("Event Options:");
                        displayVacationType("Event", names, category, price);
                        vacationNum = in.nextInt();
                        System.out.println("How many tickets?");
                        numTickets = in.nextInt();
                        in.nextLine();
                        subTotal = price[vacationNum -1] * numTickets;
                        totalTickets += numTickets;
                        totalCost += subTotal;
                        break;

                    case 6:
                        System.out.println("Cruises Options:");
                        displayVacationType("Cruise", names, category, price);
                        vacationNum = in.nextInt();
                        System.out.println("How many tickets?");
                        numTickets = in.nextInt();
                        in.nextLine();
                        subTotal = price[vacationNum -1] * numTickets;
                        totalTickets += numTickets;
                        totalCost += subTotal;
                        break;

                        default:
                        System.out.println("Dont Exist");
                }
                break;
            }
            case 2:{
                System.out.println( "View Cart");
                if (totalTickets == 0 && totalCost == 0)
                    System.out.println("No items have been picked");
                            else
                                System.out.println("Total tickets: " + totalTickets); System.out.println("SubTotal: " +"$"+ totalCost);
                break;
            }

            case 3: {
                System.out.println("Are you sure you would like to clear the contents of your cart?(yes/no)");
                String yesNo = in.next();
                if (yesNo.equals("yes")) {
                    totalCost = 0;
                    totalTickets = 0;
                    subTotal = 0;
                    System.out.println("Cart cleared.");
                }
                    else if (yesNo.equals("no")){
                        System.out.println("Cart still the same.");
                    }

                break;
            }
            case 4: {
                System.out.println("Checkout");
                System.out.println("Tickets: " + totalTickets);
                System.out.println("Subtotal: " + "$" + totalCost);
                System.out.println("Tax: " + totalCost * taxes);
                System.out.println("Gold_Pass or Regular? (Gold_Pass or Regular):");
                String goldRegular = in.next();
                if (goldRegular.equals("Gold_Pass")){
                    System.out.println("Gold pass includes a $7.00 fee.");
                subTotal += 7;
                totalCost +=7;
                subTotal *= taxes;
                totalCost += subTotal;
                }
                in.nextLine();
                while (true){
                    System.out.println("Enter a 16-digit credit card number:");
                    String card = in.nextLine();

                    if (card.length() == 16){
                        printVacationPlan(totalTickets, totalCost);
                        break;


                    }else{
                        System.out.println("Invalid. Must be exactly 16 digits.");
                    }
                }


                break;

            }



            case 5:
                System.out.println("Thank you for using Miner Vacation Planner!");
                break;

            case 6:
                vacationPriceSummary(category, names, price);
                break;



            default:
                System.out.println("Invalid choice.");
        }

        System.out.println(); // spacing
    }

    in.close();
}
// First Menu
public static void printMenu() {
    //Code Goes here
    System.out.println("====== Miner Vacation Travel ======");
    System.out.println("1. Order");
    System.out.println("2. View Cart");
    System.out.println("3. Manage Order");
    System.out.println("4. Checkout");
    System.out.println("5. Exit");
    System.out.println("6. Vacation Price Summary");

}
//Sub Menu
public static void vacationPlanMenu() {
    //Code Goes here
    System.out.println("− 1) Resort");
    System.out.println("− 2) Experience");
    System.out.println("− 3) Activity");
    System.out.println("− 4) Travel");
    System.out.println("- 5) Event");
    System.out.println("- 6) Cruises");
}
//Load file
public static void loadData(String fileName, String[] names ,String[] category,  int[] price) {
    try {
        File f = new File(fileName);
        Scanner fileScan = new Scanner(f);
        int i = 0;
        while (fileScan.hasNext() && i < names.length) {
            names[i] = fileScan.next();
            category[i] = fileScan.next();
            price[i] = fileScan.nextInt();
            i++;
        }
        fileScan.close();
    } catch (Exception e) {
        System.out.println("File not Found.");

    }
}
// Method to print the different categories of experiences Show all events of a specific ticket type when the user selects it.
public static void displayVacationType(String ticketType, String[] names , String[] category, int[] price){
    int num = 1;
    for (int i = 0; i < names.length; i++ ) {
        if (category[i] != null && category[i].equals(ticketType)) {

            System.out.println(num + ")" + names[i] + " $" + price[i]);

        }num++;
    }
}
// Method to print final receipt After checkout,
// print receipt including total tickets, subtotal, tax, delivery fees, and discounts.
public static void printVacationPlan(int totalTickets, double totalCost){
    System.out.println("===== Receipt =====");
    System.out.println("Total tickets: " + totalTickets);
    System.out.println("Final total: " + "$"+ totalCost);
    System.out.println("Thank you for your purchase!");
}
// ChatGPT Method vacationPrieceSummary
public static void vacationPriceSummary(String[] category, String[] names, int[] price) {
    // Step 1: Initialize values
    int minPrice = price[0];
    int maxPrice = price[0];
    int sum = 0;

    // Step 2: Find min, max, and sum
    for (int i = 0; i < price.length; i++) {
        if (price[i] < minPrice) {
            minPrice = price[i];
        }
        if (price[i] > maxPrice) {
            maxPrice = price[i];
        }
        sum += price[i];
    }

    // Step 3: Calculate average
    double average = (double) sum / price.length;

    // Step 4: Print lowest price events
    System.out.println("Lowest Price Event(s):");
    for (int i = 0; i < price.length; i++) {
        if (price[i] == minPrice) {
            System.out.println(names[i] + " (" + category[i] + ")");
        }
    }

    // Step 5: Print highest price events
    System.out.println("\nHighest Price Event(s):");
    for (int i = 0; i < price.length; i++) {
        if (price[i] == maxPrice) {
            System.out.println(names[i] + " (" + category[i] + ")");
        }
    }

    // Step 6: Print average price
    System.out.println("\nAverage Price: $" + average);
}

}