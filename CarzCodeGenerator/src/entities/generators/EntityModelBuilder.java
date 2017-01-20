package entities.generators;

import entities.model.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class EntityModelBuilder {

    private List<Entity> knownEntities;

    public EntityModelBuilder() {
        knownEntities = new ArrayList<>();
    }

    public List<Entity> getKnownEntities() {
        return knownEntities;
    }
}
