package com.bebesi.andras.teszt.feladat;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Bebesi András.
 */
@Data
public class BannedLettersRepository {
    private ArrayList<Integer> chars;

    /**
     * It will generate a new ArrayList in memory.
     */
    public BannedLettersRepository() {
        chars = new ArrayList<>();
        readLettersFromConfigFile();
    }

    /**
     * It will read from the config file the banned letters.
     */
    private void readLettersFromConfigFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.conf"));
            String row;
            while ((row = br.readLine()) != null) {
                chars.add((int) row.charAt(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
