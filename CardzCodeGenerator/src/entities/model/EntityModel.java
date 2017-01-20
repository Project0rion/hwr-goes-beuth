package entities.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class EntityModel {

    private List<Entity> entities;

    public EntityModel() {
        entities = new ArrayList<>();
    }

    public Entity createEntity() {
        Entity entity = new Entity();
        entities.add(entity);
        return entity;
    }

    public Collection<Entity> getEntities() {
        return Collections.unmodifiableCollection(entities);
    }
}
