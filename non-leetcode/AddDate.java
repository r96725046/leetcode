public class AddDate {

  public static String getDate(String date, int n) {
    // date is YYYYMMDD format
    int[] daysInMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int year;
    int month;
    int day;

    year = Integer.parseInt(date.substring(0,4));
    month = Integer.parseInt(date.substring(4,6));
    day = Integer.parseInt(date.substring(6,8));

    int d = day;

    while (n > 0) {
      // determin whether to add 1 in Feb
      if (month == 2) {
        daysInMonth[month - 1] = getFebDays(year);
      }
      if (n - (daysInMonth[month - 1] - d) > 0) {
        // filling current month
        n -= daysInMonth[month - 1] - d;
        d = 0;
        month++;
        if (month > 12) {
          year += month / 12;
          month = month % 12;
        } 
      } else if (d == 0) {
          day = n;
          break;
      } else {
        day += n;
        break;
      }
    }

    return "" + year + formatDayOrMonth(month) + formatDayOrMonth(day);

  }

  public static String formatDayOrMonth(int d) {
    if (d < 10) {
      return "0" + d;
    }
    return "" + d;
  }

  public static int getFebDays(int year) {
    // return 28 or 29 depending on whether it's leap year
      if (year % 100 != 0 && year % 4 == 0 && year % 400 == 0) {
          return 29;
      }
      return 28;
  }

  public static void main(String[] args) {
      String date = "20190212";
      int n = 365;
      System.out.println(getDate(date, n));
      n = 10;
      System.out.println(getDate(date, n));
      n = 100;
      System.out.println(getDate(date, n));
      n = 0;
      System.out.println(getDate(date, n));
  }
}