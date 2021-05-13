import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final float conversionFactor = 1200;

        int principal = 0 ;
        float interestRateAnnual = 0;
        byte period =0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Principal:");
            principal = scanner.nextInt();
            if(principal>= 1000 && principal <= 10000000) break;
            System.out.println("Please enter a value between 1000 and 1000000");
        }

        while(true)
        {
            System.out.print("Annual Interest Rate:");
            interestRateAnnual = scanner.nextFloat();
            if(interestRateAnnual >= 1 && interestRateAnnual <= 30) break;
            System.out.println("Please enter a value between 1 and 30");
        }

        while(true)
        {
            System.out.print("Period in years:");
            period = scanner.nextByte();
            if(period>=1 && period <= 50) break;
            System.out.println("Please enter a value between 1 and 50");

        }
        float interestRateMonthly = interestRateAnnual/ conversionFactor;
        int numberOfPayments = period* 12;

        double term = Math.pow((1+ interestRateMonthly), numberOfPayments);
        double mortgage = principal * interestRateMonthly* term/(term -1);


        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formattedMortgage = currency.format(mortgage);

        System.out.println("Mortgage: " + formattedMortgage);

    }
}
