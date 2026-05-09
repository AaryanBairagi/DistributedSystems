package signupclient;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        String username, password;

        System.out.print("Enter Username: ");
        username = sc.nextLine();

        System.out.print("Enter Password: ");
        password = sc.nextLine();

        String result =
        signup(username, password);

        System.out.println(result);
    }

    private static String signup(String username,
                                 String password)
    {
        com.signup.SignupService_Service service =
        new com.signup.SignupService_Service();

        com.signup.SignupService port =
        service.getSignupServicePort();

        return port.signup(username, password);
    }
}