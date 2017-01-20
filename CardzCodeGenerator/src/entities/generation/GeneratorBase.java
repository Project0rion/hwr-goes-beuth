package entities.generation;

import entities.model.Entity;
import entities.model.EntityModel;
import entities.model.Property;
import utils.CodeBuilder;

import java.util.Collection;

/**
 * Created by Project0rion on 20.01.2017.
 */
public abstract class GeneratorBase {

    protected abstract String getEntityPackage();
    protected abstract String[] getEntityImports();

    public abstract String generateFileName(Entity entity);
    protected abstract void generateClassContent(Entity entity, CodeBuilder cb);

    public final Collection<String> generate(Entity entity) {
        CodeBuilder cb = new CodeBuilder();

        cb.addLine("package " + getEntityPackage() + ";");
        cb.addEmptyLine();

        for (String importStatement : getEntityImports()) {
            cb.addLine("import " + importStatement + ";");
        }

        cb.addEmptyLine();
        cb.addLine("public class " + generateFileName(entity) + " extends Entity {");
        cb.addEmptyLine();
        cb.incrIndent();

        generateClassContent(entity, cb);

        cb.decrIndent();
        cb.addLine("}");

        return cb.getCodeLines();
    }
}
