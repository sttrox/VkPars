package by.vandr.vkpars.ui;

/**
 * Created by V on 11.11.2017.
 */

public class ItemModel {

    public int icon;
    public String name;

    // модель данных используемая в адаптере DrawerItemCustomAdapter
    public ItemModel(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }
}