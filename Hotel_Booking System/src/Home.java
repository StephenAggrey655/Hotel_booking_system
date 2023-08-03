import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;


public class Home {





    static Scanner input = new Scanner(System.in);
    static double price_of_suite = 230.00;
    static double price_of_normalRoom = 120.00, TotalPriceToPay;
    static char approve;
    static int daysOfStay;
    static String fName;
    static String lName;
    static String phoneNumber;
    static int confirm, newSuiteTotal = 0, totalNumberOfSuites = 20, TotalRooms_Available = 0, totalNumberOfApartments = 40;

//   static int totalNumberOfApartments = 50, TotalRooms, newTotal;




    public static void choose(){
        System.out.print("""
                You are welcome once again!!
                
                Please what action will you like to take
                [1]. Check type of rooms
                [2]. Check prices
                [3]. View Hotel policies
                [4]. Available rooms
                [5]. Quit progress
                """);
    }


    public static void Welcome_message(){
        System.out.print("""
                [-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-]
                []             WELCOME TO THE OASIS HOTEL           []
                []                                                  []
                []              WE ARE HAPPY TO HAVE YOU            []
                []                                                  []
                []                                                  []
                []                                                  []
                []     Please click [Y]/[N] to continue or not:     []
                []                                                  []
                [-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-]
                """
        );
    }
    public static void Room_Types(){
        System.out.println("\n");
        System.out.println("""
                [1]. Suites
                [2]. Normal Apartments
                [3]. Cancel""");
    }

    public static void Suite_Book(){
        System.out.println("=============================================");
        System.out.println("Thanks for choosing the suite\nYou are about having the best experience of a lifetime.\n" +
                "The price of the suite is " +
                "GH " +
                price_of_suite);
        System.out.println("=============================================");

    }
    public static void Normal_Apartment_Book(){
        System.out.println("=============================================");
        System.out.println("Thanks for choosing the one of our apartments,\n" +
                "The price of the apartment is " +
                "GH " +
                price_of_normalRoom);
        System.out.println("=============================================");

    }

    public static void booking_suite(){
        approve = Greater_class.approval.charAt(0);


        switch (approve) {
            case 'Y', 'y' -> {
                System.out.println("Please help provide these information>> ");
                System.out.println("Your first name:");
                fName = input.next();
                System.out.println("last name: ");
                lName = input.next();
                System.out.println("Phone number: ");
                phoneNumber = input.nextLine();
                phoneNumber = input.nextLine().trim();


                int len = phoneNumber.length();
                if(len != 10 || !phoneNumber.matches("\\d+")){
                    System.out.println("Please invalid number, re-enter:");
                    phoneNumber = input.nextLine().trim();
                }
//                while(len != 10 || !phoneNumber.matches("\\d+"));
                System.out.println("How many days will you be staying? :");
                daysOfStay = input.nextInt();
                System.out.println("Days of stay is: " + daysOfStay + ", Correct?" + "y/n\n");
                String correct1 = input.next();
                char correct = correct1.charAt(0);
                switch (correct) {
                    case 'y':
                    case 'Y':

                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + approve);
        }

    }
    public static void Booking1(){
        TotalPriceToPay = (daysOfStay * price_of_suite);
        System.out.println("The price to be paid for the suite for " + daysOfStay + " days of stay is GH " + TotalPriceToPay);
        System.out.println("""
                Confirm payment
     
                [1]. Yes, confirm
                [2]. No cancel transaction!
                Choose 1 or 2""");
         confirm = input.nextInt();
        switch (confirm) {
            case 1 -> {
                System.out.println("""
                        Confirmed!!
                                                
                        Thank you for choosing us. Enjoy your stay...""");
                if (Greater_class.type_Chosen == 1) {
                     newSuiteTotal = totalNumberOfSuites - 1;
                     System.out.println("[[Available suites left is "+
                             newSuiteTotal+ "]]");
                }
                if (confirm == 1 && Greater_class.type_Chosen == 2){
                    totalNumberOfApartments--;
                    System.out.println("[[Available normal apartments left is "+
                            totalNumberOfApartments + "]]");
                }
            }
            case 2 -> System.out.println("Transaction cancelled!!");
            default -> {
                System.out.println("Wrong choice, please enter the right choice: ");
                confirm = input.nextInt();
            }
        }
        OutputToFileExample();
    }
    public static void Booking2(){
        TotalPriceToPay = (daysOfStay * price_of_normalRoom);
        System.out.println("The price to be paid for the suite for " + daysOfStay + " days of stay is GH " + TotalPriceToPay);
        System.out.println("""
                Confirm payment
                [1]. Yes, confirm
                [2]. No cancel transaction!""");
        confirm = input.nextInt();

        switch (confirm) {
            case 1 ->
                System.out.println("""
                        Confirmed!!
                                                
                        Thank you for choosing us. Enjoy your stay...""");

            case 2 -> System.out.println("Transaction cancelled!!");
            default -> {
                System.out.println("Wrong choice, please enter the right choice: ");
                confirm = input.nextInt();
            }
        }
        OutputToFileExample();
    }

    public static void bye_Notice(){
        System.out.println("""
                
                [-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-]
                []              THE OASIS HOTEL                     []
                []                                                  []
                []              SEE YOU AGAIN!!                     []
                []                                                  []
                [-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-]
                """);
    }



    public static void policies(){
        String filePath = "C:\\Users\\Stephen\\Desktop\\Level 300\\java tests\\Hotel_Booking System\\Policies.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file: " + e.getMessage());
        }
    }
    public static void NumberOfAvailableSuites(int confirm){
        if (Greater_class.type_Chosen == 1) {
            newSuiteTotal = totalNumberOfSuites - 1;
            TotalRooms_Available = totalNumberOfSuites + totalNumberOfApartments;
            System.out.println("[[Available suites left is "+ newSuiteTotal+ "]]");

            System.out.println(TotalRooms_Available);
        }

        if (confirm == 1 && Greater_class.type_Chosen == 2){
            totalNumberOfApartments--;
            TotalRooms_Available = totalNumberOfSuites + totalNumberOfApartments;
            System.out.println("[[Available normal apartments left is "+ totalNumberOfApartments + "]]");
            
            System.out.println(TotalRooms_Available);
        }



    }

    static LocalDate date = LocalDate.now();
    static String output = """
                ===================================================
                                RECEIPT SLIP
                                ------------
                                
                                THE OASIS HOTEL
                                
                                                   
                
                Name of patronizer: %s %s
                Phone Number: %s
                
                            Amount Paid: %.2f
                            Date: %s
                            
                    Thank you for patronizing us, Enjoy your stay!
                =====================================================""";

    public static void OutputToFileExample() {
        String formattedOutput = String.format(output, fName, lName,phoneNumber, TotalPriceToPay, date);
        String name = "receipt.txt";
        writeOutputToFile(formattedOutput, name);


    }



    public static void writeOutputToFile(String output, String name) {
        try (FileWriter fileWriter = new FileWriter(name);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            // Write the output string to the file
            bufferedWriter.write(output);

            // Optionally, you can add a new line character after writing the output
            bufferedWriter.newLine();

            // Remember to close the writer to flush and release resources
            // You don't need to close FileWriter and BufferedWriter separately in Java 7 and above
            // The try-with-resources statement will automatically close them
        }
        catch (IOException e) {
            System.out.println("Error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void inputChecks(){
        boolean isCorrect = false;
        boolean isYorN = false;

        do{
            if((Greater_class.Continue_prompt.length()) == 1){
                isCorrect = Character.isLetter((Greater_class.Continue_prompt).charAt(0));
                isYorN = (((Greater_class.Continue_prompt).charAt(0) == 'y') || (((Greater_class.Continue_prompt).charAt(0)) == 'n'));
            } if(!isCorrect || !isYorN){
                System.out.println("Please enter the correct option, y/n: ");
                Greater_class.Continue_prompt = input.next();
            }
        }
        while(!isCorrect || !isYorN);
    }





}

