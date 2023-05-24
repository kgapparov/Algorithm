package customannotation;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat("Stella");

        if (cat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("This is very important");
        } else
            System.out.println("This is not very Important");

        for (Method method : cat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                try {
                    RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                    for (int i = 0; i < annotation.times(); i++) {
                        method.invoke(cat);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Method method : cat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantString.class)) {
                Object result = method.invoke(cat);
                if (result instanceof String stringValue) {

                }
            }
        }
        for (Field field : cat.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(field.get(cat), "stulla");
            }
        }
    }
}
