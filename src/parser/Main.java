package parser;

import ast.ErrorType;
import ast.Node;
import ast.SimpLanVisitorImpl;
import evaluator.ExecuteVM;
import org.antlr.v4.runtime.*;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Map;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws IOException {

        /* ESERCIZIO 1 */

        String fileInput = new String (Files.readAllBytes(Paths.get("src/input.txt")));
        CharStream input = CharStreams.fromString(fileInput);
        antlr.SimpLanPlusLexer lexer = new antlr.SimpLanPlusLexer(input);

        //creo una lista di token che mi conterranno gli errori
        List<Token> errori = new ArrayList<>();
        Token token = lexer.nextToken();

        //controlliamo tutti i token presi dal file di input
        for (Token tok : lexer.getAllTokens()) {
            if (tok.getType() == lexer.ERR) { // se il token è un errore lessicale. getType mi restituisce il tipo del token
                errori.add(tok); //aggiungo all'array list degli errori il token
                //System.out.println(tok);
            }

        }

        File fileOutput = new File("src/errori.txt"); //creo il file txt
        boolean fileExists = fileOutput.exists();

        //se il file non esiste lo creo, se ci sono degli errori durante la creazione del file invio una eccezione
        if (!fileExists) {
            try {
                fileOutput.createNewFile();
                System.out.println("File creato con successo.");
            } catch (IOException e) {
                System.err.println("Errore durante la creazione del file: " + e.getMessage());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput))) {
            for (int i = 0; i < errori.size(); i++) {
                //System.out.println("Ci sono " + errori.size() + "errori");
                int numRiga = errori.get(i).getLine();
                int numPosizione = errori.get(i).getCharPositionInLine() +1; //incremento il numero di posizione in quanto tutte sono diminuite di 1
                String testoTokenErrato = errori.get(i).getText();

                //System.out.println("numRiga " + numRiga);
                //System.out.println("numPosizione " + numPosizione);
                //System.out.println("testoTokenErrato " + testoTokenErrato);

                String errore = "ERRORE: \n" +
                        "     riga " + numRiga + ", numero di posizione " + numPosizione + " = " + testoTokenErrato + "\n";
                writer.write(errore);
                writer.newLine();
            }

            System.out.println("File di output per gli errori creato con successo.");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file di output: " + e.getMessage());
        }


        /* ESERCIZIO 2 */
        FileInputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        SimpLanLexer lexer = new SimpLanLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SimpLanPlusParser parser = new SimpLanPlusParser(tokens);
        SimpLanVisitorImpl visitor = new SimpLanVisitorImpl();
        Node ast = visitor.visit(parser.prog()); //generazione AST

        //SIMPLE CHECK FOR LEXER ERRORS
        if (lexer.lexicalErrors > 0){
            System.out.println("The program was not in the right format. Exiting the compilation process now");
        } else {
            SymbolTable ST = new SymbolTable();
            ArrayList<SemanticError> errors = ast.checkSemantics(ST, 0);
            if(errors.size()>0){
                System.out.println("You had: " + errors.size() + " errors:");
                for(SemanticError e : errors)
                    System.out.println("\t" + e);
            } else {
                System.out.println("Visualizing AST...");
                System.out.println(ast.toPrint(""));

                Node type = ast.typeCheck(); //type-checking bottom-up
                if (type instanceof ErrorType)
                    System.out.println("Type checking is WRONG!");
                else
                    System.out.println(type.toPrint("Type checking ok! Type of the program is: "));


                // CODE GENERATION  prova.SimpLan.asm
                String code=ast.codeGeneration();
                BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm"));
                out.write(code);
                out.close();
                System.out.println("Code generated! Assembling and running generated code.");

                FileInputStream isASM = new FileInputStream(fileName+".asm");
                ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
                SVMLexer lexerASM = new SVMLexer(inputASM);
                CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
                SVMParser parserASM = new SVMParser(tokensASM);

                //parserASM.assembly();

                SVMVisitorImpl visitorSVM = new SVMVisitorImpl();
                visitorSVM.visit(parserASM.assembly());

                //System.out.println("You had: "+lexerASM.lexicalErrors+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.");
                //if (lexerASM.lexicalErrors>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);

                System.out.println("Starting Virtual Machine...");
                ExecuteVM vm = new ExecuteVM(visitorSVM.code);
                vm.cpu();
            }
        }

        /* ESERCIZIO 3 */


    }
}
