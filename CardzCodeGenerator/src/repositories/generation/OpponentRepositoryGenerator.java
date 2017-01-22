package repositories.generation;

import entities.generation.GeneratorBase;
import entities.model.Entity;
import entities.model.Property;
import utils.CodeBuilder;
import utils.StringUtils;

import java.util.stream.Collectors;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class OpponentRepositoryGenerator extends GeneratorBase {

    @Override
    protected String getEntityPackage() {
        return "com.hwr_goes_beuth.cardz.entities";
    }

    @Override
    protected String[] getEntityImports(Entity entity) {
        return new String[]
                {
                        "java.util.List",
                        "java.util.ArrayList",
                        "com.hwr_goes_beuth.cardz.entities.enums.Faction",
                        "com.hwr_goes_beuth.cardz.entities.enums.MatchPhase"
                };
    }

    @Override
    protected ClassType getClassType() {
        return ClassType.Class;
    }

    @Override
    public String generateClassName(Entity entity) {
        return entity.getName();
    }

    @Override
    protected String getSuperClass() {
        return "Entity";
    }

    @Override
    protected void generateClassContent(Entity entity, CodeBuilder cb) {
        for (Property property : entity.getProperties()) {
                cb.addLine("private " + generatePropertyType(property) + " " + generatePropertyName(property) + ";");
        }

        cb.addEmptyLine();

        if (entity.getProperties().stream().anyMatch(p -> p.isIterable())) {
            generateConstructor(entity, cb);
            cb.addEmptyLine();
        }

        for (Property property : entity.getProperties()) {
            generateGetter(property, cb);
            cb.addEmptyLine();

            if (!property.isIterable()) {
                generateSetter(property, cb);
                cb.addEmptyLine();
            }
        }
    }

    private String generatePropertyType(Property property) {
        if (property.isEntityReference())
            if (property.isIterable())
                return "List<long>";
            else
                return "long";
        else
            if (property.isIterable())
                return "List<" + property.getType() + ">";
            else
                return property.getType();
    }

    private String generatePropertyName(Property property) {
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

    private void generateConstructor(Entity entity, CodeBuilder cb) {
        cb.addLine("public " + entity.getName() + "() {");
        cb.incrIndent();

        for (Property iterableProperty : entity.getProperties().stream().filter(p -> p.isIterable()).collect(Collectors.toList())) {
            cb.addLine(generatePropertyName(iterableProperty) + " = new ArrayList<>();");
        }

        cb.decrIndent();
        cb.addLine("}");
    }

    private void generateGetter(Property property, CodeBuilder cb) {
        String generatedPropertyName = generatePropertyName(property);
        String formattedPropertyName = StringUtils.ensureStartUpper(generatedPropertyName);

        cb.addLine("public " + generatePropertyType(property) + " get" + formattedPropertyName + "() {");
        cb.incrIndent();
        cb.addLine("return " + generatedPropertyName + ";");
        cb.decrIndent();
        cb.addLine("}");
    }

    private void generateSetter(Property property, CodeBuilder cb) {
        String generatedPropertyName = generatePropertyName(property);
        String formattedPropertyName = StringUtils.ensureStartUpper(generatedPropertyName);

        cb.addLine("public void set" + formattedPropertyName + "(" + generatePropertyType(property) + " " + generatedPropertyName + ") {");
        cb.incrIndent();
        cb.addLine("this." + generatedPropertyName + " = " + generatedPropertyName + ";");
        cb.decrIndent();
        cb.addLine("}");
    }
}
