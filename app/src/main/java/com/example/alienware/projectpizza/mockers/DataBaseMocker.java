package com.example.alienware.projectpizza.mockers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michael on 02/12/2016.
 */

public class DataBaseMocker {

    Map<String, String> data = new HashMap<>();

    public String get(String key) {
        return data.get(key);
    }

    public boolean set(String key, String value) {
        data.put(key, value);
        return true;
    }

}
