package cityofaaron;

import model.Game;
import view.View;
import view.StartProgramView;
import java.io.*;

public class CityOfAaron {

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;

    //keep a copy of the current game Object in the main class   
    public static Game currentGame = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game game) {
        currentGame = game;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        CityOfAaron.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setinFile(BufferedReader inFile) {
        CityOfAaron.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        CityOfAaron.logFile = logFile;
    }

    public static void main(String[] args) {

        try {
            inFile = new BufferedReader(new InputStreamReader(System.in));
            outFile = new PrintWriter(System.out, true);
            logFile = new PrintWriter("logFile.txt");

            View startProgramView = new StartProgramView();
            startProgramView.displayView();
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
        } finally {

            try {
                if (inFile != null) {
                    inFile.close();
                }

                if (outFile != null) {
                    outFile.close();
                }

                if (logFile != null) {
                    logFile.close();
                }
            } catch (IOException ex) {
                System.out.println("Error Closing File: " + ex.getMessage());
            }
        }

    }

}
