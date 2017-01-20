package entities.generation;

import entities.model.Entity;
import entities.model.Property;
import utils.CodeBuilder;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class EntityGenerator extends GeneratorBase {

    @Override
    protected String getEntityPackage() {
        return "com.hwr_goes_beuth.cardz.entities";
    }

    @Override
    protected String[] getEntityImports() {
        return new String[]
                {
                        "java.util.List",
                        "java.util.ArrayList",
                        "com.hwr_goes_beuth.cardz.entities.enums.Faction",
                        "com.hwr_goes_beuth.cardz.entities.enums.MatchPhase"
                };
    }

    @Override
    public String generateFileName(Entity entity) {
        return entity.getName();
    }

    @Override
    protected void generateClassContent(Entity entity, CodeBuilder cb) {
        for (Property property : entity.getProperties()) {
            cb.addLine("private " + property.getType() + " " + property.getName() + ";");
        }

        cb.addEmptyLine();

        for (Property property : entity.getProperties()) {
            generateGetter(property, cb);
            cb.addEmptyLine();
            generateSetter(property, cb);
            cb.addEmptyLine();
        }
    }

    private void generateGetter(Property property, CodeBuilder cb) {
        String formattedPropertyName = property.getName().substring(0, 1).toUpperCase() + property.getName().substring(1);
        cb.addLine("public " + property.getType() + " get" + formattedPropertyName + "() {");
        cb.incrIndent();
        cb.addLine("return " + property.getName() + ";");
        cb.decrIndent();
        cb.addLine("}");
    }

    private void generateSetter(Property property, CodeBuilder cb) {
        String formattedPropertyName = property.getName().substring(0, 1).toUpperCase() + property.getName().substring(1);
        cb.addLine("public void set" + formattedPropertyName + "(" + property.getType() + " " + property.getName() + ") {");
        cb.incrIndent();
        cb.addLine("this." + property.getName() + " = " + property.getName() + ";");
        cb.decrIndent();
        cb.addLine("}");
    }
}
