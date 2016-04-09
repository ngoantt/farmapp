package ngoantran.com.farmapp.model;

/**
 * Created by NgoanTT on 4/6/2016.
 */
public class UserChat {
    public int id;
    public String profilePic;
    public String name;
    public String status;

    public UserChat() {
    }

    public UserChat(int id, String profilePic, String name, String status) {
        this.id = id;
        this.profilePic = profilePic;
        this.name = name;
        this.status = status;
    }
}
