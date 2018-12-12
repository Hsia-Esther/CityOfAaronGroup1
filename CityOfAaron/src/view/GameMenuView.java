package view;

import control.GameControl;
import exceptions.GameControlException;

/**
 *
 * @author brenda
 */
public class GameMenuView extends ViewBase {

//    private void annualReportView() {
//        this.console.println("annualReportView() called. Implementation coming soon");
//        AnnualReportView annualReport = new AnnualReportView();
//        annualReport.displayView();
//    }
    /**
     * Constructor
     */
    public GameMenuView() {
        //empty constructor
    }

    @Override
    protected String getMessage() {
        return "Game Menu\n"
                + "----------------------\n"
                + "V - View the Map\n"
                + "L - Move to a new Location\n"
                + "C - Manage the Crops\n"
                + "Y - Live the Year\n"
                + "R - Reports Menu\n"
                + "S - Save Game\n"
                + "M - Return to the Main Menu\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("What would you like to do?");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.

        // return false if you want this view to exit and return
        // to the view that called it.
        switch (inputs[0].trim().toUpperCase()) {
            case "V":
                mapView();
                break;
            case "L":
                moveNewLocation();
                break;
            case "C":
                manageCrops();
                break;
            case "Y":
                liveTheYear();
                break;
            case "R":
                reportsMenu();
                break;
            case "S":
                saveGame();
                break;
            case "M":
                return false;
        }

        return true;
    }

    /**
     * Control this view's display/prompt/action loop until the user chooses and
     * action that causes this view to close.
     */
    @Override //using this override to place getAnnualReport and gameShouldEnd inside displayView while loop.
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            //check to see if the game should end and if so, display a message and return to Main Menu 
            //TODO Implement try catch.
            //TODO when fully implemented, this will contain mortality rate variable from annual report 
            //TODO when fully implemented, this will contain currentYear variable from annual report.
            //TODO create end of game report showing total game statistics. Use Annual Report format but bring in stats from every year.
            //display the annual report above the GameMenuView
            liveTheYear();
            getAnnualReport();
            if (GameControl.gameShouldEnd(0)) {
                //TODO when fully implemented, this will contain mortality rate variable from annual report 
                this.console.println("More than 50% of your population died, therefore this game is over. Repent and try again.");
                return;
            } else if (GameControl.gameMatures(1)) {
                //TODO when fully implemented, this will contain currentYear variable from annual report.
                //TODO create end of game report showing total game statistics. Use Annual Report format but bring in stats from every year.
                this.console.println("Ten glorious years have passed, therefore this game is over. Congratulations on a successful game!");
                return;
            }
            // get message that should be displayed
            // only print if it is non-null
            String message = getMessage();
            if (message != null) {
                this.console.println(getMessage());
            }
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    private void mapView() {
        View mapView = new MapView();
        mapView.displayView();
    }

    private void moveNewLocation() {
        View newLocationView = new NewLocationView();
        newLocationView.displayView();
    }

    private void manageCrops() {
        View manageCropsMenu = new ManageCropMenuView();
        manageCropsMenu.displayView();
    }

    private void liveTheYear() {
        //this.console.println("liveTheYear() called."); //TODO liveTheYear stub function needs to be fully implemented
    }

    private void reportsMenu() {
        View reportsMenu = new ReportsMenuView();
        reportsMenu.displayView();
    }

    private void saveGame() {
        View saveGame = new SaveGameView();
        saveGame.displayView();
    }

    private void getAnnualReport() {
        //TODO getAnnualReport stub function needs to be fully implemented to have variables instead of static information.
        this.console.println("Annual Report\n"
                + "----------------------\n"
                + "The Year Number is 1.\n"
                + "0 people starved.\n"
                + "5 people moved into the city.\n"
                + "The current population is 100.\n"
                + "The number of acres of land owned by the city is 1000.\n"
                + "The number of bushels per acre in this year's harvest is 3.\n"
                + "The total number of bushels of wheat harvested is 3000.\n"
                + "The number of bushels paid in tithes and offerings is 300.\n"
                + "The number of bushels of wheat eaten by rats is 0.\n"
                + "The number of bushels of wheat in store is 2700.\n");

        //Version with variables:
        //"Annual Report\n"
        //+ "----------------------\n"
        //+ "The Year Number is " + yearNumber + "."\n"
        //+ peopleStarved + "people starved.\n"
        //+ peopleMovedIn + "people moved into the city.\n"
        //+ "The current population is " + currentPopulation + ".\n"
        //+ "The number of acres of land owned by the city is " + acresOwned + ".\n"
        //+ "The number of bushels per acre in this year's harvest is " + acreYield + ".\n"
        //+ "The total number of bushels of wheat harvested is " + harvested + ".\n" 
        //+ "The number of bushels paid in tithes and offerings is " + tithingAmount + ".\n"
        //+ "The number of bushels of wheat eaten by rats is " + lossToRats + ".\n"
        //+ "The number of bushels of wheat in store is " + totalWheat + ".\";
    }

}
