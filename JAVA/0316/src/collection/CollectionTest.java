package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.basic();
    }
    void basic() {
        Collection<String> names = new ArrayList<>();
        System.out.println("names는 비어있는가? " + names.isEmpty());
        names.add("Comtin");
        names.add("Yoda");
        System.out.println("names는 비어있는가? " + names.isEmpty());
        System.out.println("Coco가 존재하는가? " + names.contains("Coco"));
        names.add("Coco");
        System.out.println("Coco가 존재하는가? " + names.contains("Coco"));
        names.remove("Coco");
        System.out.println("Coco가 존재하는가? " + names.contains("Coco"));
        System.out.println("names.size: " + names.size());
        String[] array = names.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
        names.clear();
        System.out.println("names.size: " + names.size());
    }
}
