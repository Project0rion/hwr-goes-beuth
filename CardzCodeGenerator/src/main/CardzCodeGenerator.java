package main;

import entities.antlr.EntityModelLexer;
import entities.antlr.EntityModelParser;
import entities.EntityModelBuilder;
import entities.generation.DAOGenerator;
import entities.generation.EntityGenerator;
import entities.generation.GeneratorBase;
import entities.model.Entity;
import entities.model.EntityModel;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import utils.FileUtils;

import java.io.IOException;

/**
 * Created by Project0rion on 12.01.2017.
 */
public class CardzCodeGenerator {

    public static void main(String[] args) {
        runEntityModelGeneration();
    }

    private static void runEntityModelGeneration() {
        EntityModel parsedEntityModel = parseEntityModel("CardzCodeGenerator\\res\\EntityModel.txt");
        writeEntityModelToFile(parsedEntityModel);
    }

    private static EntityModel parseEntityModel(String sourceFilePath) {
        String entityModelSource = null;
        try {
            entityModelSource = FileUtils.readFile(sourceFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EntityModelLexer lexer = new EntityModelLexer(new ANTLRInputStream(entityModelSource));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        EntityModelParser parser = new EntityModelParser(tokens);

        // Specify our entry point
        EntityModelParser.EntitiesContext entityModelContext = parser.entities();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        EntityModelBuilder listener = new EntityModelBuilder();
        walker.walk(listener, entityModelContext);

        return listener.getEntityModel();
    }

    private static void writeEntityModelToFile(EntityModel entityModel) {

        GeneratorBase[] generators = { new EntityGenerator(), new DAOGenerator()};

        try {
            for (GeneratorBase generator : generators) {
                for (Entity entity : entityModel.getEntities()) {
                    String entityFileName = "CardzCodeGenerator\\gen\\" + generator.getClass().getSimpleName() + "\\" + generator.generateClassName(entity) + ".java";
                    FileUtils.writeFile(entityFileName, generator.generate(entity));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
