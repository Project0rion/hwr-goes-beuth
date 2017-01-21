package main;

import entities.antlr.EntityModelLexer;
import entities.antlr.EntityModelParser;
import entities.EntityModelBuilder;
import entities.generation.DAOGenerator;
import entities.generation.EntityGenerator;
import entities.generation.GeneratorBase;
import entities.generation.SharedPrefsDAOGenerator;
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
        runCardRepositoryGeneration();
    }

    private static void runEntityModelGeneration() {
        EntityModel parsedEntityModel = parseEntityModel("CardzCodeGenerator\\res\\EntityModel.txt");
        writeEntityModelToFile(parsedEntityModel);
    }

    private static void runCardRepositoryGeneration() {
        // TODO: implement generation of CardRepository, DeckRepository and OpponentRepository here
    }

    private static EntityModel parseEntityModel(String sourceFilePath) {
        String entityModelSource = null;
        try {
            entityModelSource = FileUtils.readFile(sourceFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EntityModelLexer lexer = new EntityModelLexer(new ANTLRInputStream(entityModelSource));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EntityModelParser parser = new EntityModelParser(tokens);
        EntityModelParser.EntitiesContext entityModelContext = parser.entities();
        ParseTreeWalker walker = new ParseTreeWalker();
        EntityModelBuilder listener = new EntityModelBuilder();
        walker.walk(listener, entityModelContext);

        return listener.getEntityModel();
    }

    private static void writeEntityModelToFile(EntityModel entityModel) {

        GeneratorBase[] generators = { new EntityGenerator(), new DAOGenerator(), new SharedPrefsDAOGenerator()};

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
