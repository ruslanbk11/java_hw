package HW1;

import java.io.*;
import java.util.Scanner;

public class Parser {

    private static String tradeType;
    private static int price;

    public static Trade parse(File file, Boolean byEnum) {
        try {
            FileReader fr = new FileReader(file);
            Scanner scanner = new Scanner(fr);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int equalIndex = line.indexOf('=');
                if (equalIndex != -1) {
                    String value = line.substring(equalIndex + 1);
                    try {
                        price = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        tradeType = value;
                    }
                }
            }
            fr.close();
            if (byEnum) {
                return EnumTradeCreator.valueOf(tradeType).createTrade(price);
            } else {
                return TradeCreator.create(tradeType, price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
