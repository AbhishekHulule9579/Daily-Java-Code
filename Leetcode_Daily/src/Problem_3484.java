import java.util.HashMap;
import java.util.Map;

class Spreadsheet {
    private Map<String, Integer> spreadSheet = new HashMap<>();

    public Spreadsheet(int rows) {

    }

    public void setCell(String cell, int value) {
        spreadSheet.put(cell, value);
    }

    public void resetCell(String cell) {
        spreadSheet.put(cell, 0);
    }

    public int getValue(String formula) {
        //=X+Y
        String input = formula.substring(1);
        String[] operands = input.split("\\+");

        int num1 = 0;
        int num2 = 0;

        if (isInteger(operands[0])) {
            num1 = Integer.parseInt(operands[0]);
        } else {
            num1 = spreadSheet.getOrDefault(operands[0], 0);
        }

        if (isInteger(operands[1])) {
            num2 = Integer.parseInt(operands[1]);
        } else {
            num2 = spreadSheet.getOrDefault(operands[1], 0);
        }

        return num1 + num2;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}

public class Problem_3484 {
    public static void main(String[] args) {
        Spreadsheet obj = new Spreadsheet(5);

        obj.setCell("A1", 10);
        obj.setCell("B1", 20);

        System.out.println("Value of =A1+B1 : " + obj.getValue("=A1+B1")); // 30
        System.out.println("Value of =A1+50 : " + obj.getValue("=A1+50")); // 60
        System.out.println("Value of =100+200 : " + obj.getValue("=100+200")); // 300

        obj.resetCell("B1");
        System.out.println("After reset, value of =A1+B1 : " + obj.getValue("=A1+B1")); // 10
    }
}
/*
* Problem 3484
* */