package entities;

import entities.antlr.EntityModelBaseListener;
import entities.antlr.EntityModelParser;
import entities.model.Entity;
import entities.model.EntityModel;
import entities.model.Property;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class EntityModelBuilder extends EntityModelBaseListener {

    private EntityModel entityModel;
    private Entity currentEntity;

    @Override
    public void enterEntities(EntityModelParser.EntitiesContext ctx) {
        System.out.println("> started parsing");

        entityModel = new EntityModel();
    }

    @Override
    public void enterEntity(EntityModelParser.EntityContext ctx) {
        String entityName = ctx.NAME().getText();

        Entity newEntity = entityModel.createEntity();
        newEntity.setName(entityName);

        currentEntity = newEntity;
    }

    @Override
    public void enterProperty(EntityModelParser.PropertyContext ctx) {
        if (currentEntity == null)
            throw new NullPointerException("currentEntity cannot be null when a property is read");

        String propertyType = ctx.NAME().get(0).getText();
        String propertyName = ctx.NAME().get(1).getText();
        boolean propertyIsIterable = ctx.LIST() != null;

        Property newProperty = currentEntity.createProperty();
        newProperty.setType(propertyType);
        newProperty.setName(propertyName);
        newProperty.setIterable(propertyIsIterable);
    }

    @Override
    public void exitEntity(EntityModelParser.EntityContext ctx) {
        currentEntity = null;
    }

    @Override
    public void exitEntities(EntityModelParser.EntitiesContext ctx) {
        System.out.println("> finished parsing");
    }

    public EntityModel getEntityModel() {
        return entityModel;
    }
}
