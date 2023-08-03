import java.util.Scanner;

public class Greater_class {
    static String Continue_prompt;
    static int ToRs;

    static Scanner input = new Scanner(System.in);
    static String approval;
    static int type_Chosen;

    public static void main(String[] args) {
        Home.Welcome_message();
        Continue_prompt = input.next();
        Home.inputChecks();
        char mngInput = Continue_prompt.charAt(0);

        switch (mngInput) {
            case 'Y', 'y' -> {

                Home.choose();
                ToRs = input.nextInt();
                while(ToRs != 5){
                    if (ToRs == 1) {
                        Home.Room_Types();
                        System.out.println();
                        System.out.println("What is your choice to book: ");
                         type_Chosen = input.nextInt();
                        if (type_Chosen == 1) {
                            Home.Suite_Book();
                            System.out.println("""
                                Continue to book? :
                                Click [Yes] to book or [No] to go back""");
                            approval = input.next();
                            Home.booking_suite();
                            Home.Booking1();
                        } else if (type_Chosen == 2) {
                            Home.Normal_Apartment_Book();
                            System.out.println("""
                                    Continue to book? :
                                    Click [Yes] to book or [No] to go back""");
                            approval = input.next();
                            Home.booking_suite();
                            Home.Booking2();
                        }
                        else{
                            Home.choose();
                            ToRs = input.nextInt();
                        }
                    }
                    if (ToRs == 2) {
                        System.out.println("=======================================");
                        System.out.println("The prices of the rooms are:" +
                                "\n[1]. Suites are" +
                                Home.price_of_suite +
                                "\n and that of \n" +
                                "[2]. Normal Apartment is " +
                                Home.price_of_normalRoom);

                        System.out.println("=======================================");
                        System.out.println();
                        System.out.println("Want to book?\n[1]. Yes\n[2]. No\n");
                        int answer = input.nextInt();
                        while (answer < 1 || answer > 2)
                        {
                            System.out.println("Please enter the right option: ");
                            answer = input.nextInt();
                        }
                            if(answer == 1){
                                Home.Room_Types();
                                System.out.println();
                                System.out.println("What is your choice to book: ");
                                int type_Chosen = input.nextInt();
                                if (type_Chosen == 1) {
                                    Home.Suite_Book();
                                    System.out.println("""
                                Continue to book? :
                                Click [Yes] to book or [No] to go back""");
                                    approval = input.next();
                                    Home.booking_suite();
                                    Home.Booking1();
                                    Home.OutputToFileExample();
                                } else if (type_Chosen == 2) {
                                    Home.Normal_Apartment_Book();
                                    System.out.println("""
                                    Continue to book? :
                                    Click [Yes] to book or [No] to go back""");
                                    approval = input.next();
                                    Home.booking_suite();
                                    Home.Booking2();
                                    Home.OutputToFileExample();
                                }
                                else{
                                    Home.choose();
                                    ToRs = input.nextInt();
                                }

                            }
                            if(answer == 2){
                                Home.bye_Notice();
                                return;
                            }

                    }
                    else if (ToRs == 3) {
                            Home.policies();
                            return;
                    }
                    else if (ToRs == 4) {
                        Home.NumberOfAvailableSuites(Home.confirm);
                        Home.choose();
                        ToRs = input.nextInt();
                    }

                }
                Home.bye_Notice();


            }
            case 'N', 'n' -> Home.bye_Notice();
            default -> System.out.println("Inoperable");
        }

    }
}
