package containers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public HashMap<java.lang.String, Object> getMap() {
        HashMap<java.lang.String, Object> map = new HashMap<>();
        map.put("id", id);
        JSONObject categoryJSON = new JSONObject(category.getMap());
        map.put("category", categoryJSON);
        map.put("name", name);
        map.put("photoUrls", photoUrls);
        JSONArray tagsArray = new JSONArray();
        for (Tag tag : tags) {
            JSONObject newTag = new JSONObject(tag.getMap());
            tagsArray.add(newTag);
        }
        map.put("tags", tagsArray);
        map.put("status", status);
        return map;
    }


}
