package entities.generation;

import entities.model.Entity;
import entities.model.Property;
import utils.CodeBuilder;
import utils.StringUtils;

import java.util.stream.Collectors;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class EntityGenerator extends GeneratorBase {

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
                cb.addLine("private " + GenerationUtils.generatePropertyType(property) + " " + GenerationUtils.generatePropertyName(property) + ";");
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

    private void generateConstructor(Entity entity, CodeBuilder cb) {
        cb.addLine("public " + entity.getName() + "() {");
        cb.incrIndent();

        for (Property iterableProperty : entity.getProperties().stream().filter(p -> p.isIterable()).collect(Collectors.toList())) {
            cb.addLine(GenerationUtils.generatePropertyName(iterableProperty) + " = new ArrayList<>();");
        }

        cb.decrIndent();
        cb.addLine("}");
    }

    private void generateGetter(Property property, CodeBuilder cb) {
        String generatedPropertyName = GenerationUtils.generatePropertyName(property);
        String formattedPropertyName = StringUtils.ensureStartUpper(generatedPropertyName);

        cb.addLine("public " + GenerationUtils.generatePropertyType(property) + " get" + formattedPropertyName + "() {");
        cb.incrIndent();
        cb.addLine("return " + generatedPropertyName + ";");
        cb.decrIndent();
        cb.addLine("}");
    }

    private void generateSetter(Property property, CodeBuilder cb) {
        String generatedPropertyName = GenerationUtils.generatePropertyName(property);
        String formattedPropertyName = StringUtils.ensureStartUpper(generatedPropertyName);

        cb.addLine("public void set" + formattedPropertyName + "(" + GenerationUtils.generatePropertyType(property) + " " + generatedPropertyName + ") {");
        cb.incrIndent();
        cb.addLine("this." + generatedPropertyName + " = " + generatedPropertyName + ";");
        cb.decrIndent();
        cb.addLine("}");
    }
}
