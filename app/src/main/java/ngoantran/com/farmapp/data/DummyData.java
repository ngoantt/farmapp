package ngoantran.com.farmapp.data;

import java.util.ArrayList;
import java.util.List;

import ngoantran.com.farmapp.R;
import ngoantran.com.farmapp.model.Topic;

/**
 * Created by NgoanTT on 4/2/2016.
 */
public class DummyData {

    public DummyData() {
    }

    public static List<Topic> createDataExplore() {
        List<Topic> topicList = new ArrayList<>();
        topicList.add(new Topic("Taj Mahal", R.drawable.brazil));
        topicList.add(new Topic("Brazil Christ", R.drawable.colosseum));
        topicList.add(new Topic("Great Wall", R.drawable.eiffel_tower));
        topicList.add(new Topic("Colosseum", R.drawable.greatwall));
        topicList.add(new Topic("Eiffel Tower", R.drawable.pyramid));
        topicList.add(new Topic("Pyramid", R.drawable.statue));
        topicList.add(new Topic("Liberty Statue", R.drawable.brazil));
        topicList.add(new Topic("Taj Mahal", R.drawable.colosseum));
        topicList.add(new Topic("Brazil Christ", R.drawable.eiffel_tower));
        topicList.add(new Topic("Great Wall", R.drawable.greatwall));
        topicList.add(new Topic("Colosseum", R.drawable.pyramid));
        topicList.add(new Topic("Eiffel Tower", R.drawable.statue));
        topicList.add(new Topic("Pyramid", R.drawable.brazil));
        topicList.add(new Topic("Liberty Statue", R.drawable.colosseum));
        topicList.add(new Topic("Taj Mahal", R.drawable.eiffel_tower));
        topicList.add(new Topic("Brazil Christ", R.drawable.greatwall));
        topicList.add(new Topic("Great Wall", R.drawable.pyramid));
        topicList.add(new Topic("Colosseum", R.drawable.statue));
        return topicList;
    }
}
