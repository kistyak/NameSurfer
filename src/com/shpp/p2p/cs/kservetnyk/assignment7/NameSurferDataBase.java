package com.shpp.p2p.cs.kservetnyk.assignment7;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class NameSurferDataBase implements NameSurferConstants {

    // Array with name-decades pairs
    private static final HashMap<String, NameSurferEntry> nameArray = new HashMap<>();

    /**
     * Creates a new NameSurferDataBase and initializes it using the
     * data in the specified file.  The constructor throws an error
     * exception if the requested file does not exist or if an error
     * occurs as the file is being read.
     */
    public NameSurferDataBase(String filename) {
        try {
            // Reads the file and work with each line
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String name = br.readLine();

            while (name != null){
                NameSurferEntry entry = new NameSurferEntry(name.toLowerCase());

                // Puts the name and NameSurferEntry object to the array
                nameArray.put(entry.getName(), entry);
                name = br.readLine();
            }
            br.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the NameSurferEntry associated with this name, if one
     * exists.  If the name does not appear in the database, this
     * method returns null.
     */
    public NameSurferEntry findEntry(String name) {
        return nameArray.get(name.toLowerCase());
    }
}