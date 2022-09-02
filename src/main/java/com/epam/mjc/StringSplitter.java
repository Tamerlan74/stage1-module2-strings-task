package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {

        Iterator<String> iterator = delimiters.iterator();
        String delim = "[ ";

        while (iterator.hasNext()) {
            String d = iterator.next();
            delim = String.join("", delim, d);
        }
        delim = String.join("", delim, "]");
        ArrayList<String> strings = new ArrayList<>();
        String[] arrays = source.split(delim);
        for (int i = 0; i <arrays.length; i++) {
            if (arrays[i] != null && !arrays[i].equals("")){
                strings.add(arrays[i]);
            }
        }
        return strings;
    }
}
