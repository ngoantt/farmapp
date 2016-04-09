package ngoantran.com.farmapp.model;

/**
 * Created by NgoanTT on 4/2/2016.
 */
public class FeedItem {
    public int id;
    public String name;
    public String status;
    public String image;
    public String profilePic;
    public String timestamp;
    public String url;

    public FeedItem() {
    }

    public FeedItem(int id, String name, String status, String image, String profilePic, String timestamp, String url) {
        super();
        this.id = id;
        this.name = name;
        this.status = status;
        this.image = image;
        this.profilePic = profilePic;
        this.timestamp = timestamp;
        this.url = url;
    }
}
