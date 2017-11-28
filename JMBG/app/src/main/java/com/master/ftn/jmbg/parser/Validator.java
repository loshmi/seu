package com.master.ftn.jmbg.parser;

import com.master.ftn.jmbg.data.ValidityCodes;

/**
 * Created by Loshmi on 11/27/2017.
 */

public class Validator
{
    private static final int CORRECT_LENGTH = 13;
    public static int checkLength (String jmbg)
    {
        if (jmbg.length() < CORRECT_LENGTH) return ValidityCodes.SHORTER;
        else if (jmbg.length() > CORRECT_LENGTH) return ValidityCodes.LONGER;
        else return ValidityCodes.CORRECT;
    }

    public static boolean checkParity (String jmbg)
    {
        int [] cifre = new int [CORRECT_LENGTH];

        for (int i = 0; i < CORRECT_LENGTH; i++)
        {
            cifre [i] = Integer.parseInt(Character.toString(jmbg.charAt(i)));
        }

        int izraz = 11 - (( 7 * (cifre [0] + cifre [6]) + 6 * (cifre [1] + cifre [7]) +
                5 * (cifre [2] + cifre [8]) + 4 * (cifre [3] + cifre [9]) + 3 * (cifre [4] + cifre [10]) +
                2 * (cifre [5] + cifre [11]) ) % 11);

        if (izraz > 9) izraz = 0;

        return cifre [12] ==  izraz;
    }

    public static boolean checkDate (String jmbg)
    {
        int dan = Integer.parseInt(jmbg.substring(0, 2));
        int mesec = Integer.parseInt(jmbg.substring(2, 4));
        int godina = Integer.parseInt(jmbg.substring(4, 7));

        if (godina < 800) godina += 2000;
        else godina += 1000;

        if (mesec < 1 || mesec > 12) return false;
        if (dan > getNumberOfDays (mesec, godina)) return false;
        return true;
    }

    private static int getNumberOfDays (int mesec, int godina)
    {
        switch (mesec)
        {
            case 4: case 6: case 9: case 11: return 30;
            case 2: return 28 + isLeap (godina);
            default: return 30;
        }
    }

    private static int isLeap (int godina)
    {
        if (godina % 4 == 0 && godina % 100 != 0 || godina % 400 == 0) return 1;
        return 0;
    }

    public static boolean checkLocation (String jmbg)
    {
        int locationCode = Integer.parseInt(jmbg.substring(7, 9));

        if (locationCode < 1 || locationCode == 20 || locationCode > 21 && locationCode < 26 ||
                locationCode > 26 && locationCode < 29 || locationCode == 40 || locationCode > 50 &&
                locationCode < 71 || locationCode == 84 || locationCode == 90 ||
                locationCode > 96 || locationCode == 6) return false;
        return true;
    }
}
