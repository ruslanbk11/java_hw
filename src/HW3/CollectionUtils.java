import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
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

    public static <T> void removeAll(List<? super T> removeFrom, List<? super T> c2){
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? super T> c2){
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

    public static <T> boolean containsAny(List<? super T> c1, List<? super T> c2){
        for (Object o : c2) {
            for (Object o1 : c1) {
                if (o1.equals(o)){
                    return true;
                }
            }
        }
        return false;
    }

    public static <T> List<? super T> range(List<? super T> list, T min, T max){
        int minInd = list.indexOf(min);
        int maxInd = list.indexOf(max);
        return list.subList(minInd, maxInd);
    }

    /*public static List<? super T> range(List<? super T> list, Object min, Object max, Comparator comparator){

    }*/

}
