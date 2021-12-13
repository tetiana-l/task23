package Task23;

import java.lang.reflect.Field;

public class XMLConverter {

    public static String convertToXML(Object o) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        Class<?> clazz = o.getClass();

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
        }

        String className = clazz.getSimpleName().toLowerCase();

        builder.append("<").append(className).append(">\n");

        for (Field field : declaredFields) {
            String name;
            if (!field.isAnnotationPresent(Ignore.class)) {
                if (!field.isAnnotationPresent(Pseudonym.class)) {
                    name = field.getName();
                } else {
                    name = field.getDeclaredAnnotation(Pseudonym.class).value();
                }
                Object value = field.get(o);

                builder.append("\t<").append(name).append(">").append(value).
                        append("</").append(name).append(">").append("\n");
            }
        }

        builder.append("</").append(className).append(">");

        return builder.toString();
    }
}
