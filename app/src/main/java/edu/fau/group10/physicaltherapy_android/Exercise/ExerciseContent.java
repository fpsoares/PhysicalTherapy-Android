package edu.fau.group10.physicaltherapy_android.Exercise;

import android.content.Context;
import android.content.pm.LauncherApps;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceConfigurationError;

import edu.fau.group10.physicaltherapy_android.data.remote.API;
import retrofit2.Callback;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ExerciseContent {

    /**
     * An array of sample (dummy) items.
     */
    /*public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();*/

    /**
     * A map of sample (dummy) items, by ID.
     */
    /*public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();*/

    public static Map<String, Exercise> EXERCISE_MAP = new HashMap<String, Exercise>();

    private Context mContext;

    private List<Integer> exercise_ids = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);

    public ExerciseContent() {
        exercise_ids = API.getExercises(exercise_ids).enqueue(new Callback<List<Exercise>>);
    }
// TODO: 4/26/2016 finish with object loading from list in server SEE CH 35.6 in Android book 
    exerciseAPI = API.Factory.getInstance(mContext);

    exerciseAPI
    /*private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }*/

    /*private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }*/

    /*private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }*/

    /*private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }*/

    /**
     * A dummy item representing a piece of content.
     */
    /*public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }*/

    public static class Exercise {
        public Integer exercise_id;
        public String exercise_name;
        public String url;
        public String description;

        public Exercise(Integer exercise_id, String exercise_name, String url, String description) {
            this.exercise_id = exercise_id;
            this.exercise_name = exercise_name;
            this.url = url;
            this.description= description;
        }

        @Override
        public String toString() {
            return exercise_name;
        }
    }

}
