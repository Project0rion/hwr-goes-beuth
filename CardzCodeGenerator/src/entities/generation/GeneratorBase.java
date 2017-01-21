package entities.generation;

import entities.model.Entity;
import utils.CodeBuilder;

import java.util.Collection;

/**
 * Created by Project0rion on 20.01.2017.
 */
public abstract class GeneratorBase {

    protected enum ClassType {
        Class, Interface, Enum
    }

    protected abstract String getEntityPackage();
    protected abstract String[] getEntityImports(Entity entity);
    protected abstract ClassType getClassType();

    protected String getSuperClass() {
        return null;
    }

    protected String[] getImplementedInterfaces(Entity entity) {
        return new String[0];
    }

    public abstract String generateClassName(Entity entity);
    protected abstract void generateClassContent(Entity entity, CodeBuilder cb);

    public final Collection<String> generate(Entity entity) {
        CodeBuilder cb = new CodeBuilder();

        cb.addLine("package " + getEntityPackage() + ";");
        cb.addEmptyLine();

        for (String importStatement : getEntityImports(entity)) {
            cb.addLine("import " + importStatement + ";");
        }

        cb.addEmptyLine();

        String classDeclaration = "public " + getClassType().toString().toLowerCase() + " " + generateClassName(entity) + " ";
        if (getSuperClass() != null && getSuperClass() != "")
            classDeclaration += "extends " + getSuperClass() + " ";
        if (getImplementedInterfaces(entity).length > 0)
            classDeclaration += "implements " + String.join(", ", getImplementedInterfaces(entity)) + " ";
        cb.addLine(classDeclaration + "{");

        cb.addEmptyLine();
        cb.incrIndent();

        generateClassContent(entity, cb);

        cb.decrIndent();
        cb.addLine("}");

        return cb.getCodeLines();
    }
}
