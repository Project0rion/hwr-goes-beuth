package entities.generation;

import entities.model.Property;

/**
 * Created by Project0rion on 24.01.2017.
 */
public class GenerationUtils {

    public static String generatePropertyType(Property property) {
        if (property.isEntityReference())
            if (property.isIterable())
                return "List<Long>";
            else
                return "long";
        else
        if (property.isIterable())
            return "List<" + getWrapperForPrimitiveType(property.getType()) + ">";
        else
            return property.getType();
    }

    public static String generatePropertyName(Property property) {
        String currentName = property.getName();

        if (property.isEntityReference())
            if (property.isIterable())
                if (currentName.toLowerCase().endsWith(property.getType().toLowerCase() + "s"))
                    return currentName.substring(0, currentName.length() - 1) + "Ids";
                else
                    return currentName + "Ids";
            else {
                return currentName + "Id";
            }
        else
            return currentName;
    }

    public static String getWrapperForPrimitiveType(String primitiveType) {
        switch (primitiveType) {
            case "boolean":
                return "Boolean";
            case "int":
                return "Integer";
            case "long":
                return "Long";
        }

        return primitiveType;
    }
}
