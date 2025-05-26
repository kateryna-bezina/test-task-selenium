package core.utils;

public class PriceParser {

    public static Double parse(String rawText) {
        String number = rawText.replaceAll("[^\\d.]", "");
        return Double.parseDouble(number);
    }
}