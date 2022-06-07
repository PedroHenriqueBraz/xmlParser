package com.company.parser;

import com.company.annotations.TagName;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

public class XmlParser {

    public static String toXml(Object object) throws IllegalAccessException {
        var objectClass = object.getClass();

        StringBuilder xmlBuilder = new StringBuilder();

        if(object instanceof Collection) {
            var collection = (Collection) object;

            xmlBuilder.append("<lista>");
            for (Object o: collection){
                String xml = toXml(o);
                xmlBuilder.append(xml);
            }
            xmlBuilder.append("</lista>");
        } else {
            var fieldName = "";
            if(objectClass.isPrimitive() || isWrapper(objectClass)) {
                fieldName = "algo";
            }

             fieldName = objectClass.isAnnotationPresent(TagName.class)
                    ? objectClass.getAnnotation(TagName.class).value()
                    : objectClass.getSimpleName();

            xmlBuilder.append("<" + fieldName + ">");
            for (Field atributo: objectClass.getDeclaredFields()){
                if(atributo.getType().isAssignableFrom(List.class)) {
                    System.out.println("");
                }

                String nome = atributo.isAnnotationPresent(TagName.class)
                        ? atributo.getAnnotation(TagName.class).value()
                        : atributo.getName();
                Object valor = atributo.get(object);

                xmlBuilder.append("<" + nome + ">");
                xmlBuilder.append(valor);
                xmlBuilder.append("</" + nome + ">");
            }
            xmlBuilder.append("</" + fieldName + ">");
        }

        return xmlBuilder.toString();
    }

    private static boolean isWrapper(Object object){
        return object instanceof String || object instanceof Integer;
    }
}
