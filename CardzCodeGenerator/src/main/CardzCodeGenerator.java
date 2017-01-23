package main;

import repositories.RepositoryBuilder;
import repositories.antlr.RepositoryLexer;
import repositories.antlr.RepositoryParser;
import repositories.generation.CardRepositoryGenerator;
import repositories.generation.DeckRepositoryGenerator;
import repositories.generation.OpponentRepositoryGenerator;
import repositories.model.CardRepository;
import repositories.model.DeckRepository;
import repositories.model.OpponentRepository;
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
import repositories.model.RepositoryModel;
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
        RepositoryModel parsedRepo = parseRepository("CardzCodeGenerator\\res\\Repository.txt");
        writeRepositoryToFile(parsedRepo);
}

    private static RepositoryModel parseRepository(String sourceFilePath) {
        String cardRepositorySource = null;
        try {
            cardRepositorySource = FileUtils.readFile(sourceFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RepositoryLexer lexer = new RepositoryLexer(new ANTLRInputStream(cardRepositorySource));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RepositoryParser parser = new RepositoryParser(tokens);
        RepositoryParser.FileContext fileContext = parser.file();
        ParseTreeWalker walker = new ParseTreeWalker();
        RepositoryBuilder listener = new RepositoryBuilder();
        walker.walk(listener, fileContext);

        return listener.getRepoModel();
    }

    private static void writeRepositoryToFile(RepositoryModel repoModel) {

        CardRepositoryGenerator cardGgenerator = new CardRepositoryGenerator();
        DeckRepositoryGenerator deckGenerator = new DeckRepositoryGenerator();
        OpponentRepositoryGenerator opponentGenerator = new OpponentRepositoryGenerator();

        CardRepository cardRepo = repoModel.get_cardRepo();
        DeckRepository deckRepo = repoModel.get_deckRepo();
        OpponentRepository opponentRepo = repoModel.get_opponentRepo();

        try {
            String cardFileName = "CardzCodeGenerator\\gen\\Repositories\\CardRepository.java";
            FileUtils.writeFile(cardFileName, cardGgenerator.generate(cardRepo));

            String deckFileName = "CardzCodeGenerator\\gen\\Repositories\\DeckRepository.java";
            FileUtils.writeFile(deckFileName, deckGenerator.generate(deckRepo, opponentRepo));

            String opponentFileName = "CardzCodeGenerator\\gen\\Repositories\\OpponentRepository.java";
            FileUtils.writeFile(opponentFileName, opponentGenerator.generate(opponentRepo));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
