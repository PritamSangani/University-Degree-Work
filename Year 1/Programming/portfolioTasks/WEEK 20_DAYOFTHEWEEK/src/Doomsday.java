//
// Day of the week calculator
// HL 2016
//
public class Doomsday
{	
    static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int centuryDays[] = {5, 3, 2, 0};
    static int doomsdays[] = {3, 28, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};

    static boolean LeapYear(int year)
    {
        return ((year % 400) != 0) && ((year % 4) == 0);
    }

    static boolean ValidDate(int day, int month, int year)
    {
        // note - this function WON'T do as part of your week 12 portfolio -
        // that needs to use a switch statement!

        if (year < 1583)
            return false; // Gregorian calendar started in 1582
        if (month < 1 || month > 12)
            return false;
        if (day < 1)
            return false;
        if (month == 2)
        {
            if (LeapYear(year))
            {
                if (day > 29)
                    return false;
            } else
            {
                if (day > 28)
                    return false;
            }
        }
        else
        {
            if (day > monthDays[month - 1])
                return false;
        }
        return true;
    }

    public static int GetDayOfWeek(int day, int month, int year)
    {
        // Get the day of the week for any Gregorian date using Conway's doomsday algorithm
        // input - calendar day, calendar month (Jan = 1, Feb = 2...), calendar year.
        // return: day of week as 0 (Sun), 1 (Mon) ... 6 (Sat), -1 (invalid date)

        if (!ValidDate(day, month, year))
            return -1;
        // valid date, we are good to go.
        int centuryDay = centuryDays[((year / 100) - 14) % 4];
        boolean isLeapYear = LeapYear(year);

        year = year % 100; // from now on we use year in the century.
        int anchorDay = year / 12 + (year % 12) + (year % 12) / 4;

        int doomsday = doomsdays[month - 1];
        if (isLeapYear && month < 3)
            doomsday++;

        // the +35 ensures a positive number before taking the modulus (and 35%7 = 0)
        return (centuryDay + anchorDay + day - doomsday + 35) % 7;
    }   
}
