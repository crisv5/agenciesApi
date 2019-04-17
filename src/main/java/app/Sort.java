package app;

import java.util.Arrays;
import java.util.Comparator;

public class Sort  {

    public static <T extends Comparable<T>> void sortBy(T[] arr){
        Arrays.sort(arr, Comparator.nullsLast(T::compareTo));

    }
}
