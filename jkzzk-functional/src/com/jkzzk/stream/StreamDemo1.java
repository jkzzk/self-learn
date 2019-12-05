package com.jkzzk.stream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class StreamDemo1 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("zzk");
        names.add("zzkmn");
        names.add("zzkhk");
        names.add("zzkds");
        names.add("zzkjk");
        names.add("zzkdn");

//        noUseStream(names);

        useStream(names);

    }

    private static void useStream(List<String> names) {
        names.stream()
                .filter(name->name.endsWith("k"))
                .filter(name->name.length() == 5)
                .forEach(name -> System.out.println(name));
    }

    private static void noUseStream(List<String> names) {

        List<String> endWithK = new ArrayList<>();
        for (String name : names) {
            if(name.endsWith("k")){
                endWithK.add(name);
            }
        }

        List<String> length5 = new ArrayList<>();
        for (String s : endWithK) {
            if(s.length() == 5) {
                length5.add(s);
            }
        }

        for (String s : length5) {
            System.out.println(s);
        }
    }

}
