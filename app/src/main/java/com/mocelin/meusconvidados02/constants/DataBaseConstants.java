package com.mocelin.meusconvidados02.constants;

/**
 * Created by mocelin on 08/01/2018.
 */

public class DataBaseConstants {

    private DataBaseConstants() {

    }

    public static class GUEST {
        public static final String TABLE_NAME = "Guest";

        public static class COLUMNS {
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String PRESENCE = "presence";
        }
    }
}
