package HW3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils{
    public static <T> void addAll(List<? extends T> source, List<? super T> destination){
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList(){
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? super T> source, T object){
        return source.indexOf(object);
    }

    public static <T> List<? extends T> limit(List<? extends T> source, int size) {
        return source.subList(0, size);
    }

    public static <T> void add(List<? super T> source, T object) {
        source.add(object);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2){
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2){
        for (Object o : c2) {
            boolean flag = false;
            for (Object o1 : c1) {
                if (o1.equals(o)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2){
        for (Object o : c2) {
            for (Object o1 : c1) {
                if (o1.equals(o)){
                    return true;
                }
            }
        }
        return false;
    }

    public static <L, T extends Comparable<? super L>> List<L> range(List<L> list, T min, T max) {
        List<L> newArray = CollectionUtils.newArrayList();
        for (L element : list) {
            if (min.compareTo(element) <= 0 && max.compareTo(element) >= 0) {
                newArray.add(element);
            }
        }
        return newArray;
    }

    public static <L, T extends L> List<L> range(List<L> list, T min, T max, Comparator<? super L> comparator) {
        List<L> newArray = CollectionUtils.newArrayList();
        for (L element : list) {
            if (comparator.compare(min, element) <= 0 && comparator.compare(max, element) >= 0) {
                newArray.add(element);
            }
        }
        return newArray;
    }

}