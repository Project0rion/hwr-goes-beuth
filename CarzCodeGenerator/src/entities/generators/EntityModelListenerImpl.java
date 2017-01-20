package entities.generators;

import entities.antlr.EntityModelBaseListener;
import entities.antlr.EntityModelParser;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class EntityModelListenerImpl extends EntityModelBaseListener {

    @Override
    public void enterEntity(EntityModelParser.EntityContext ctx) {
        String entityName = ctx.NAME().getText();
    }

    @Override
    public void enterProperty(EntityModelParser.PropertyContext ctx) {
        String propertyType = ctx.NAME().get(0).getText();
        String propertyName = ctx.NAME().get(1).getText();
    }
}
