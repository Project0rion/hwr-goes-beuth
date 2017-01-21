package entities.generation;

import entities.model.Entity;
import entities.model.Property;
import utils.CodeBuilder;
import utils.StringUtils;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Project0rion on 21.01.2017.
 */
public class SharedPrefsDAOGenerator extends GeneratorBase {

    @Override
    protected String getEntityPackage() {
        return "com.hwr_goes_beuth.cardz.core.dataAccess.SharedPreferences";
    }

    @Override
    protected String[] getEntityImports(Entity entity) {
        String entityPackage = "com.hwr_goes_beuth.cardz.entities";
        String daoPackage = "com.hwr_goes_beuth.cardz.core.dataAccess";

        Collection<Property> refProperties = entity.getProperties().stream().filter(p -> p.isEntityReference()).collect(Collectors.toList());
        Collection<String> refPropertyTypes = refProperties.stream().map(Property::getType).distinct().collect(Collectors.toList());
        refPropertyTypes.add(entity.getName());

        Collection<String> imports = Stream.concat(
                refPropertyTypes.stream().map(propType -> entityPackage + "." + propType),
                refPropertyTypes.stream().map(propType -> daoPackage + "." + propType + "DAO")
        ).collect(Collectors.toList());

        return imports.toArray(new String[0]);
    }

    @Override
    protected ClassType getClassType() {
        return ClassType.Class;
    }

    @Override
    protected String[] getImplementedInterfaces(Entity entity) {
        return new String[] { entity.getName() + "DAO" };
    }

    @Override
    public String generateClassName(Entity entity) {
        return "SharedPrefs" + entity.getName() + "DAO";
    }

    @Override
    protected void generateClassContent(Entity entity, CodeBuilder cb) {
        cb.addLine("private SharedPrefsDAOContext context;");

        for (String requiredDAO : getRequiredDAOs(entity)) {
            cb.addLine("private " + requiredDAO + " " + StringUtils.ensureStartLower(requiredDAO) + ";");
        }

        cb.addEmptyLine();
        generateConstructor(entity, cb);
        cb.addEmptyLine();
        generateGet(entity, cb);
        cb.addEmptyLine();
        generateCreate(entity, cb);
        cb.addEmptyLine();
        generateUpdate(entity, cb);
        cb.addEmptyLine();
        generateDelete(entity, cb);
    }

    private void generateConstructor(Entity entity, CodeBuilder cb) {
        String declaration = "public SharedPrefs" + entity.getName() + "DAO(SharedPrefsDAOContext context";

        Collection<String> requiredDAOs = getRequiredDAOs(entity);
        for (String requiredDAO : requiredDAOs) {
            declaration += ", " + requiredDAO + " " + StringUtils.ensureStartLower(requiredDAO);
        }

        declaration += ") {";
        cb.addLine(declaration);
        cb.incrIndent();
        cb.addLine("this.context = context;");

        for (String requiredDAO : requiredDAOs) {
            String formattedDAO = StringUtils.ensureStartLower(requiredDAO);
            cb.addLine("this." + formattedDAO + " = " + formattedDAO + ";");
        }

        cb.decrIndent();
        cb.addLine("}");
    }

    private void generateGet(Entity entity, CodeBuilder cb) {
        cb.addLine("@Override");
        cb.addLine("public " + entity.getName() + " get" + entity.getName() + "(long id) {");
        cb.incrIndent();
        cb.addLine("return context.loadFromPrefs(" + entity.getName() + ".class, id);");
        cb.decrIndent();
        cb.addLine("}");
    }

    private void generateCreate(Entity entity, CodeBuilder cb) {
        String newEntityName = "new" + entity.getName();

        cb.addLine("@Override");
        cb.addLine("public " + entity.getName() + " create" + entity.getName() + "() {");
        cb.incrIndent();
        cb.addLine(entity.getName() + " " + newEntityName + " = new " + entity.getName() + "();");
        cb.addLine(newEntityName + ".setId(context.getNextId());");
        cb.addEmptyLine();
        cb.addLine("// TODO: add additional initialization code here or remove statement");
        cb.addEmptyLine();
        cb.addLine("context.saveToPrefs(" + newEntityName + ");");
        cb.addLine("return " + newEntityName + ";");
        cb.decrIndent();
        cb.addLine("}");
    }

    private void generateUpdate(Entity entity, CodeBuilder cb) {
        String updateName = StringUtils.ensureStartLower(entity.getName());

        cb.addLine("@Override");
        cb.addLine("public void update" + entity.getName() + "(" + entity.getName() + " " + updateName + ") {");
        cb.incrIndent();
        cb.addLine("context.saveToPrefs(" + updateName + ");");
        cb.decrIndent();
        cb.addLine("}");
    }

    private void generateDelete(Entity entity, CodeBuilder cb) {
        String retrievedEntityName = StringUtils.ensureStartLower(entity.getName());

        cb.addLine("@Override");
        cb.addLine("public void delete" + entity.getName() + "(long id) {");
        cb.incrIndent();
        cb.addLine(entity.getName() + " " + retrievedEntityName + " = get" + entity.getName() + "(id);");
        Collection<Property> refProperties = entity.getProperties().stream().filter(p -> p.isEntityReference()).collect(Collectors.toList());
        if (refProperties.size() > 0)
            cb.addEmptyLine();

        for (Property property : refProperties) {
            String dao = StringUtils.ensureStartLower(property.getType()) + "DAO";

            if (property.isIterable()) {
                String loopVariable = StringUtils.ensureStartLower(property.getType()) + "Id";

                cb.addLine("for (long " + loopVariable + " : " + retrievedEntityName + ".get" + StringUtils.ensureStartUpper(property.getName()) + "Ids()) {");
                cb.incrIndent();
                cb.addLine(dao + ".delete" + property.getType() + "(" + loopVariable + ");");
                cb.decrIndent();
                cb.addLine("}");
            }
            else {
                cb.addLine(dao + ".delete" + property.getType() + "(" + retrievedEntityName + ".get" + StringUtils.ensureStartUpper(property.getName()) + "Id());");
            }
        }

        cb.addEmptyLine();
        cb.addLine("context.deleteFromPrefs(" + retrievedEntityName + ");");
        cb.decrIndent();
        cb.addLine("}");
    }

    private Collection<String> getRequiredDAOs(Entity entity) {
        Collection<Property> referencedProperties = entity.getProperties().stream().filter(p -> p.isEntityReference()).collect(Collectors.toList());
        return referencedProperties.stream().map(p -> p.getType() + "DAO").distinct().collect(Collectors.toList());
    }
}
