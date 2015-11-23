package edu.mctc.lisa.kindling.database;

/**
 * Created by lisa on 11/19/15.
 * Adapted from Big Nerd Ranch Guide to Android Programming, 2nd Edition
 *
 */

public class EntryDbSchema {
    public static final class EntryTable {
        public static final String DBNAME = "entries";

        public static final class Columns {
            public static final String UUID = "uuid";
            public static final String DATE = "date";
            public static final String TEXT = "text";
        }
    }
}
