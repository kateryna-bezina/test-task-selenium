package data.enums;

public enum Items {
    SAUCE_LABS_BACKPACK("Sauce Labs Backpack"),
    SAUCE_LABS_FLEECE_JACKET("Sauce Labs Fleece Jacket"),
    SAUCE_LABS_ONESIE("Sauce Labs Onesie");

    private final String itemName;

    Items(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
