package containers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    public HashMap<String, Object> getMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);
        map.put("firstName", firstName);
        map.put("lastName", lastName);
        map.put("email", email);
        map.put("password", password);
        map.put("phone", phone);
        map.put("userStatus", userStatus);
        return map;
    }


}
