
package by.vandr.vkpars.network.object.Items;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo_ {

    @SerializedName("sizes")
    @Expose
    private List<Size> sizes = null;

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

}
