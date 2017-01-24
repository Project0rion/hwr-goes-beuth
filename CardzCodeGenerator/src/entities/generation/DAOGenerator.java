package entities.generation;

import entities.model.Entity;
import entities.model.Property;
import utils.CodeBuilder;
import utils.StringUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Project0rion on 21.01.2017.
 */
public class DAOGenerator extends GeneratorBase {

    @Override
    protected String getEntityPackage() {
        return "com.hwr_goes_beuth.cardz.core.dataAccess";
    }

    @Override
    protected String[] getEntityImports(Entity entity) {
        String entityPackage = "com.hwr_goes_beuth.cardz.entities";

        Collection<Property> refProperties = entity.getProperties().stream().filter(p -> p.isEntityReference()).collect(Collectors.toList());
        Collection<String> refPropertyTypes = refProperties.stream().map(p -> entityPackage + "." + p.getType()).distinct().collect(Collectors.toList());
        refPropertyTypes.add(entityPackage + "." + entity.getName());

        refPropertyTypes.add("java.util.List");

        return refPropertyTypes.toArray(new String[0]);
    }

    @Override
    protected ClassType getClassType() {
        return ClassType.Interface;
    }

    @Override
    public String generateClassName(Entity entity) {
        return entity.getName() + "DAO";
    }

    @Override
    protected void generateClassContent(Entity entity, CodeBuilder cb) {
        generateDAOMethods(entity, cb);

        if (entity.getProperties().stream().anyMatch(p -> p.isEntityReference())) {
            cb.addEmptyLine();
            generateReferenceMethods(entity, cb);
        }
    }

    private void generateDAOMethods(Entity entity, CodeBuilder cb) {
        cb.addLine(entity.getName() + " get" + entity.getName() + "(long id);");
        cb.addLine(entity.getName() + " create" + entity.getName() + "();");
        cb.addLine("void update" + entity.getName() + "(" + entity.getName() + " " + StringUtils.ensureStartLower(entity.getName()) + ");");
        cb.addLine("void delete" + entity.getName() + "(long id);");
    }

    private void generateReferenceMethods(Entity entity, CodeBuilder cb) {
        for (Property refProperty : entity.getProperties().stream().filter(p -> p.isEntityReference()).collect(Collectors.toList())) {
            String returnType = refProperty.isIterable() ? "List<" + refProperty.getType() + ">" : refProperty.getType();
            String methodName = "get" + StringUtils.ensureStartUpper(refProperty.getName());

            cb.addLine(returnType + " " + methodName + "(" + entity.getName() + " " + StringUtils.ensureStartLower(entity.getName()) + ");");
        }
    }
}
