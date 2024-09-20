import java.util.Scanner;

public class StockDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String symbol, name, positive = "";
        double closing, current, change;

        System.out.print("Enter Stock Symbol: ");
        symbol = input.nextLine();

        System.out.print("Enter Stock Name: ");
        name = input.nextLine();

        System.out.print("Enter Stock Closing Price: ");
        closing = input.nextDouble();

        System.out.print("Enter Stock Current Price: ");
        current = input.nextDouble();

        Stock rivian = new Stock(symbol, name, closing, current);
        change = rivian.getChangePercent(closing, current);

        if (change >= 0.0) {
            positive = "+";
        }

        System.out.printf("\n%s\n", rivian.getName());
        System.out.println("------------------");
        System.out.printf("Stock Symbol: %s\n", rivian.getSymbol());
        System.out.printf("Stock Closing Price: $%.2f\n", rivian.getPriorClosingPrice());
        System.out.printf("Stock Current Price: $%.2f\n", rivian.getCurrentPrice());
        System.out.printf("Change: %s%.2f%%\n", positive, change);
        System.out.println("------------------");
        input.close();
    }
}
