import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash;

        do
        {
            System.out.print(prompt + ": ");

            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                break;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer, not " + trash);
            }

        } while (true);

        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0.0;
        String trash;

        do
        {
            System.out.print(prompt + ": ");

            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                break;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double, not " + trash);
            }

        } while (true);

        return retVal;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();

                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("That value is not in range [" + low + " - " + high + "].");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid int in range [" + low + " - " + high + "].");
            }

        } while (!done);

        return retVal;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0.0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();

                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("That value is not in range [" + low + " - " + high + "].");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double in range [" + low + " - " + high + "].");
            }

        } while (!done);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";
        boolean done = false;
        boolean retVal = false;

        do {
            System.out.print(prompt + "[Y/N]: ");
            response = pipe.nextLine();

            if(response.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if (response.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            }
            else {
                System.out.println("You must enter Y or N.");
            }
        } while (!done);

        return retVal;

    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retVal = "";

        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();

            if (!retVal.matches(regEx)) {
                System.out.println("Invalid input. please try again.");

            }
        } while (!retVal.matches(regEx));

        return retVal;
    }

    public static void prettyHeader(String msg) {
        for (int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        int spaces = 54 - msg.length();
        int leftSpaces = spaces / 2;
        int rightSpaces = spaces - leftSpaces;

        System.out.print("***");

        for (int i = 0; i < leftSpaces; i++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int i = 0; i < rightSpaces; i++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        for (int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }



    /**
     *display a msg string centered in a 60 character header
     * @param pipe
     * @param prompt
     * @return
     */



}