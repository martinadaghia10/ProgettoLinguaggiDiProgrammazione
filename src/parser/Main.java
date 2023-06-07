package parser;

import org.antlr.v4.runtime.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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


        /* ESERCIZIO 3 */


    }
}
