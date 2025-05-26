package data.records;

public record CheckoutInfo(String firstName, String lastName, String postalCode) {
    public static CheckoutInfo defaultInfo() {
        return new CheckoutInfo("Test", "Kate", "12345");
    }
}
