package HW6;

import java.lang.reflect.Field;

public class Serializer {
    public static String toJson(Object o) throws IllegalAccessException {
        StringBuilder result = new StringBuilder("{\n");
        for (Field declaredField : o.getClass().getDeclaredFields()) {
            declaredField.setAccessible(true);
            result.append("\t").append(declaredField.getName()).append(" : ");
            if (declaredField.get(o).getClass().getSuperclass() == Number.class ||
                    (declaredField.get(o).getClass() == String.class) ||
                    declaredField.get(o).getClass() == Boolean.class
            ) {
                System.out.println("norm class");
                if (declaredField.get(o) != null) {
                    result.append(declaredField.get(o).toString()).append("\n");
                } else {
                    result.append("null\n");
                }
            } else if (declaredField.get(o).getClass().isArray()) {
                System.out.println("ya massiv");
                result.append("[ \n");
                for (Object o1 : (Object[]) declaredField.get(o)) {
                    if (o1 != null){
                        result.append(Serializer.toJson(o1));
                    }
                }
                result.append("] \n");
            } else {
                System.out.println("here");
                result.append(Serializer.toJson(declaredField.get(o)));
            }
        }
        result.append("}\n");
        return result.toString();
    }
}
