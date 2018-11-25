import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ListFields {
  public static List<String> getFieldNames(Class<?> clazz) {
    //clazz because "class" is a reserved word in Java
    List<String> ret = new ArrayList<>();
    //getDeclaredFields -> including non-public ones
    //getFields -> only public ones
    for(Field f : clazz.getDeclaredFields()) {
      ret.add(f.getName());
    }
    return ret;
  }

  public static void main(String[] args) {
    //print the fields of the "Fields" class
    for(String fieldName : getFieldNames(Fields.class)) {
      System.out.println(fieldName);
    }
  }
}
