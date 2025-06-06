package model.items;

public class Equipment extends Item {
    public Equipment(String name) {
        super(name, 0, 0, false);
    }

    @Override
    public String getCategory() {
        return "Equipment";
    }

    @Override
    public String getImagePath() {
        return "/items/equipment/" + getName().toLowerCase().replace(" ", "_") + ".png";
    }
}