package com.rest.utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsUtils {

    /**
     * batches to List
     *
     * @param source source list entries
     * @param length length of list
     * @param <T>    Object
     * @return new list object in list parent
     */
    public static <T> List<List<T>> batchesToList(List<T> source, int length) {
        if (ValidateUtils.isNullOrEmpty(source) || length <= 0) {
            return Collections.emptyList();
        }
        int size = source.size();
        int fullChunks = (size - 1) / length;
        return IntStream.range(0, fullChunks + 1)
                .mapToObj(n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length))
                .collect(Collectors.toList());
    }

    /**
     * batches entry Map
     *
     * @param source source map entries
     * @param length length of list
     * @param <K>    Key
     * @param <V>    Value
     * @return new map child in list
     */
    public static <K, V> List<Map<K, V>> batchesEntryMap(Map<K, V> source, int length) {
        if (ValidateUtils.isNullOrEmpty(source) || length <= 0) {
            return Collections.emptyList();
        }

        List<Map<K, V>> batches = new ArrayList<>();
        int index = 0;
        Map<K, V> subMap = new HashMap<>();
        for (Map.Entry<K, V> entry : source.entrySet()) {
            if (index == length) {
                batches.add(subMap);
                subMap = new HashMap<>();
                index = 0;
            }
            subMap.put(entry.getKey(), entry.getValue());
            index++;
        }
        if (ValidateUtils.isNotNullOrEmpty(subMap)) {
            batches.add(subMap);
        }
        return batches;
    }

    /**
     * shuffle entry list
     *
     * @param source source list entries
     */
    public static <T> void shuffleList(List<T> source) {
        if (ValidateUtils.isNullOrEmpty(source)) {
            return;
        }
        Collections.shuffle(source);
    }

    /**
     * copy list
     *
     * @param source source list entries
     * @param <T>    Object
     * @return new list
     */
    public static <T> List<T> copyList(List<T> source) {
        if (ValidateUtils.isNullOrEmpty(source)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(source);
    }

}
