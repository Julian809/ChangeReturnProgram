package changereturn;

import java.util.ArrayList;
import java.util.List;

public class ChangeReturn {

    public static void main(String[] args) {
        
        System.out.println(getNumberOfBillsAndCoins(2481.46, 1262.12));
    }
    
    public static String getNumberOfBillsAndCoins(double amountPaid, double itemPrice) {
        
        double roundedChange = roundToTwoDecimals(amountPaid - itemPrice);
        
        if(roundedChange < 0) 
            System.err.println("The amount paid is less than the item price.");
        if(roundedChange == 0)
            System.out.println("No change has to be returned. We're even.");
        
        int[] intAndDecimalParts = getIntegerAndDecimalParts(String.valueOf(roundedChange));
        
        List<String> integerPartListFormatted = 
                getNunberOfDollarBills(intAndDecimalParts[0]);
        
        List<String> decimalPartListFormatted = 
                getNunberOfCentCoins(intAndDecimalParts[1]);
        
        integerPartListFormatted.addAll(decimalPartListFormatted);
        
        return integerPartListFormatted.toString();
    }
    
    private static double roundToTwoDecimals(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
    
    private static int[] getIntegerAndDecimalParts(String num) {
        
        String intPart = num.substring(0, num.indexOf("."));
        String decimalPart = num.substring(num.indexOf(".") + 1);
        
        return new int[] {
            Integer.parseInt(intPart),
            Integer.parseInt(decimalPart)
        };
    }
    
    private static List<String> getNunberOfDollarBills(int intPart) {
        
        List<String> numberOfDollarBills = new ArrayList<>();
        
        int[] de = {100, 50, 20, 10, 1};
        String[] des = new String[5];
        String mssg = " bills of $";
        
        int temp = intPart / 100;
        des[0] = (temp > 0) ? temp + mssg + de[0] : null;
        
        temp = (intPart % 100) / 50;
        des[1] = (temp > 0) ? temp + mssg + de[1] : null;
        
        temp = ((intPart % 100) % 50) / 20;
        des[2] = (temp > 0) ? temp + mssg + de[2] : null;
        
        temp = (((intPart % 100) % 50) % 20) / 10;
        des[3] = (temp > 0) ? temp + mssg + de[3] : null;
        
        temp = ((((intPart % 100) % 50) % 20) % 10) / 1;
        des[4] = (temp > 0) ? temp + mssg + de[4] : null;
        
        for(String element : des) {
            if(element != null) 
                numberOfDollarBills.add(element);
        }
        
        return numberOfDollarBills;
    }
    
    private static List<String> getNunberOfCentCoins(int decimalPart) {
        
        List<String> numberOfCentCoins = new ArrayList<>();
        
        String[] de = {" Quaters", " Dimes", " Nickels", " Pennies"};
        String[] des = new String[4];
        
        int temp = decimalPart / 25;
        des[0] = (temp > 0) ? temp + de[0] : null;
        
        temp = (decimalPart % 25) / 10;
        des[1] = (temp > 0) ? temp + de[1] : null;
        
        temp = ((decimalPart % 25) % 10) / 5;
        des[2] = (temp > 0) ? temp + de[2] : null;
        
        temp = (((decimalPart % 25) % 10) % 5) / 1;
        des[3] = (temp > 0) ? temp + de[3] : null;
        
        for(String element : des) {
            if(element != null) 
                numberOfCentCoins.add(element);
        }
        
        return numberOfCentCoins;
    }
}
