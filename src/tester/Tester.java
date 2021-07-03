package tester;

import java.text.SimpleDateFormat;
import java.util.*;

public class Tester {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 6, 5);
        Date checkInDate = calendar.getTime();
        System.out.println(checkInDate);
        calendar.set(2021, 6, 9);
        Date checkOutDate = calendar.getTime();
        System.out.println(checkOutDate);

        System.out.println("-----------------");
        System.out.println(getDatesBetweenUsingJava(checkInDate, checkOutDate));


    }

    // ref: https://www.baeldung.com/java-between-dates
    public static List<Date> getDatesBetweenUsingJava(Date checkInDate, Date checkOutDate) {
        List<Date> datesInRange = new ArrayList<>();
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(checkInDate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(checkOutDate);

        //ref: http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        //String date = simpleDateFormat.format(new Date());
        //System.out.println(date);

        while (startCalendar.before(endCalendar)) {
            Date result = startCalendar.getTime();
            datesInRange.add(result);
            startCalendar.add(Calendar.DATE, 1);
        }
        return datesInRange;
    }


}
