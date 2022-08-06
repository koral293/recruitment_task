package containers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private long id;
    private long petId;
    private long quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public HashMap<String, Object> getMap() {
        HashMap<java.lang.String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("petId", petId);
        map.put("quantity", quantity);
        map.put("shipDate", shipDate);
        map.put("status", status);
        map.put("complete", complete);
        return map;
    }

}
