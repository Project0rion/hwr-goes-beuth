package entities.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class Entity {

    private String name;
    private List<Property> properties;

    public Entity() {
        properties = new ArrayList<>();
    }

    public Property createProperty() {
        Property property = new Property();
        properties.add(property);
        return property;
    }

    public Collection<Property> getProperties() {
        return Collections.unmodifiableCollection(properties);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.substring(0, 1).equals(name.substring(0, 1).toLowerCase()))
            System.out.println("#WARNING: entity name should start with upper case character: " + name);

        this.name = name;
    }
}
