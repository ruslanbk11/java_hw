package HW1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("D://IdeaProjects/java_hw/src/HW1/test");
        Trade trade = Parser.parse(file, true);
        if (trade != null) {
            trade.print();
        }
    }
}
