package dev.denismasterherobrine.travellersbootsreloaded.config;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class SortedProperties extends Properties {
    @Override
    public void store(OutputStream out, String comments) throws IOException {
        Properties sortedProps = new Properties() {
            @Override
            public Set<Map.Entry<Object, Object>> entrySet() {
                /*
                 * Using comparator to avoid the following exception on jdk >=9:
                 * java.lang.ClassCastException: java.base/java.util.concurrent.ConcurrentHashMap$MapEntry cannot be cast to java.base/java.lang.Comparable
                 */
                Set<Map.Entry<Object, Object>> sortedSet = new TreeSet<>(Comparator.comparing(o -> o.getKey().toString()));
                sortedSet.addAll(super.entrySet());
                return sortedSet;
            }

            @Override
            public Set<Object> keySet() {
                return new TreeSet<>(super.keySet());
            }

            @Override
            public synchronized Enumeration<Object> keys() {
                return Collections.enumeration(new TreeSet<>(super.keySet()));
            }
        };

        sortedProps.putAll(this);
        sortedProps.store(out, comments);
    }
}
