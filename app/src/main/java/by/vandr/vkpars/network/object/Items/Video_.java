
package by.vandr.vkpars.network.object.Items;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video_ {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("items")
    @Expose
    private List<Item_____> items = null;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Item_____> getItems() {
        return items;
    }

    public void setItems(List<Item_____> items) {
        this.items = items;
    }

}
