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

/*
        while (token.getType() != antlr.SimpLanPlusLexer.EOF){
            if (token.getType() == antlr.SimpLanPlusLexer.ERR) { // se il token è un errore lessicale. getType mi restituisce il tipo del token
                errori.add(token); //aggiungo all'array list degli errori il token

            }
            token = lexer.nextToken();
        }
        File f = new File("src/errori.txt");
        if (!f.exists()){
            f.createNewFile();
        } else {
            f.delete();
            f.createNewFile();
        }

        for (int i=0; i<errori.size() ;i++){
            int errLine = errori.get(i).getLine();
            String errStr = errori.get(i).getText();
            int errPos = errori.get(i).getCharPositionInLine() +1;
            String toWrite = "Errore " + i+1 + " a linea " + errLine + ", numero posizione " + errPos + " = " + errStr + "\n";
            Files.write(Paths.get("src/errori.txt"), toWrite.getBytes(), StandardOpenOption.APPEND);
        }
        */

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


        /* ESERCIZIO 2*/
        /*
        String fileInput2 = new String (Files.readAllBytes(Paths.get("src/input2.txt")));
        CharStream input2 = CharStreams.fromString(fileInput2);
        antlr.SimpLanPlusLexer lexer2 = new antlr.SimpLanPlusLexer(input2);

        Token token2 = lexer2.nextToken(); //id, parole chiave, simboli, costanti eccetera

        Map<String, String> tabella = new HashMap<>(); //creo una tabella per i simboli del programma (chiave-valore)

        while (token2.getType() != lexer2.EOF){ //se il tipo del token non è uguale alla fine del file
            String testo = token2.getText(); //chiave = identifica l'oggetto. prendo il valore testuale del token
            int tipo = token2.getType(); //valore = l'oggetto. è intero perchè il metodo restituisce un intero
            System.out.println(token2.getText());
            //if (token2.getText().equals("void"))

        }
        */
    }
}
