package security.bercy.com.week2day3;

import android.provider.BaseColumns;

/**
 * Created by Bercy on 12/6/17.
 */

public final class DatabaseContract    {

    public DatabaseContract() {
    }

    public static class CategoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "category";
        public static final String TYPE = "type";
        public static final String BODY_TYPE = "body_type";
    }
    public static class AnimalyEntry implements BaseColumns {
        public static final String TABLE_NAME = "animal";
        public static final String NAME = "name";
        public static final String WEIGHT= "Weight";
        public static final String SOUND = "sound";
        public static final String TYPE = "type";
        public static final String DESCRIPTION = "description";

    }


}
