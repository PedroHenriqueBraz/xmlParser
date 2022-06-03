package com.company.parser;

import com.company.annotations.TagName;

import java.lang.reflect.Field;
import java.util.Collection;

public class XmlParser {

    public String toXml(Object object) throws IllegalAccessException {
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
            String nomeClasse = objectClass.isAnnotationPresent(TagName.class)
                    ? objectClass.getAnnotation(TagName.class).value()
                    : objectClass.getSimpleName();

            xmlBuilder.append("<" + nomeClasse + ">");
            for (Field atributo: objectClass.getDeclaredFields()){
                atributo.setAccessible(true);
                String nome = atributo.isAnnotationPresent(TagName.class)
                        ? atributo.getAnnotation(TagName.class).value()
                        : atributo.getName();
                Object valor = atributo.get(object);

                xmlBuilder.append("<" + nome + ">");
                xmlBuilder.append(valor);
                xmlBuilder.append("</" + nome + ">");
            }
            xmlBuilder.append("</" + nomeClasse + ">");
        }

        return xmlBuilder.toString();
    }
}
