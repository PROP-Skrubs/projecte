package Testers;

import java.util.Scanner;

/**
 * Created by daniel on 09/11/15.
 */
public class MenuTesters
{
    static String[] opcions = {
            "1 - TaulerParticionat",
            "2 - ValidarHidato"
    };

    public static void main(String[] args)
    {
        System.out.println("Quin tester vols realitzar?");
        for (String opcio : opcions)
        {
            System.out.println(opcio);
        }

        Scanner in = new Scanner(System.in);
        int opcio = in.nextInt();
        switch (opcio)
        {
            case 1:
                TaulerParticionat.run();
                break;
            case 2:
                ValidarHidato.run();
                break;
        }
    }
}
