package collection;

import java.util.Arrays;
import java.util.List;

public class NewCollectionMethod {
    public static void main(String[] args) {
        List<String> list = List.of("Hello", "World");
        Object[] array1 = list.toArray();
        System.out.println(Arrays.toString(array1));

        String[] array2 = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(array2));

        String[] array3 = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array3));

        // New toArray - create an array of the necessary size using the passed array constructor reference
        String[] array4 = list.toArray(String[]::new);
        System.out.println(Arrays.toString(array4));
    }
}
