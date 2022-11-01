package com.shpp.p2p.cs.kservetnyk.assignment7;

/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.util.Arrays;

public class NameSurferEntry implements NameSurferConstants {

    private String name = null;
    // Array with name popularity in 12 decades
    private final int[] rate = new int[(int) NDECADES];

    /**
     * Creates a new NameSurferEntry from a data line as it appears
     * in the data file.  Each line begins with the name, which is
     * followed by integers giving the rank of that name for each
     * decade.
     */
    public NameSurferEntry(String line) {

        // Makes an array from the line. First element is a name, else are rate
        String[] split = line.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (i == 0) name = split[i].toLowerCase();
            else {
                rate[i-1] = Integer.parseInt(split[i]);}
        }
    }

    /**
     * Returns the name associated with this entry.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the rank associated with an entry for a particular
     * decade.  The decade value is an integer indicating how many
     * decades have passed since the first year in the database,
     * which is given by the constant START_DECADE.  If a name does
     * not appear in a decade, the rank value is 0.
     */
    public int getRank(int decade) {
        return rate[decade];
    }

    /**
     * Returns a string that makes it easy to see the value of a
     * NameSurferEntry.
     */
    public String toString() {
        return name + Arrays.toString(rate);
    }
}