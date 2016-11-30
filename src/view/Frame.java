/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import game.Game;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import model.User;
import model.Userbank;

/**
 *
 * @author David Darío Del Prado González
 */
public class Frame extends javax.swing.JFrame
{
    //Create the panels
    private Start startView;
    private Play playView;
    private Menu menuView;
    private GlobalStats globalStatsView;
    private UserStats userStatsView;
    
    //Create the layout
    private CardLayout cardLayout;
    
    //Create the panel to contain the cards
    private JPanel cards;
    
    //Create the userbank
    private Userbank userbank;
    
    //Create a User object to handle the user operations
    private User user;
    
    //Create a Game object to let the user play
    private Game game;

    /**
     * Creates new form Frame
     */
    public Frame()
    {
        //Initialize the components
        initComponents();
        
        //Initialize the panels and reference them.
        initPanels();
        
        //Show the start panel
        cardLayout.show(cards, "Start");  
        
        //Instantiate the Game object
        game = new Game();        
        
        //Collocate the window and set it visible
        initWindow();
    }
    
    public Frame(Userbank userbank)
    {
        this();
        
        //Reference the userbank
        this.userbank = userbank;
        
        //Set the stats cards tables the userbank as tablemodel
        globalStatsView.setTableModel(userbank);
    }
    
    
    /**
     * Logs the user in the program and shows the Menu panel.
     * @param username Username the user accessed with.
     */
    void logIn(String username)
    {
        //Add the user and check if it already existed, then set the Menu personalized text
        if (userbank.addUser(username))
        {
            menuView.setLblGreetingsText("Hola, " + username);
        }
        else
        {
            menuView.setLblGreetingsText("Hola de nuevo, " + username);
        }
        
        //Reference the auxiliar User object to the User stored in the model
        user = userbank.getUser(username);
	
	// Set the UserStats View model
        userStatsView.showData(user);
        
        //Swap to Menu JPanel
        cardLayout.show(cards, "Menu");
    }
    
    void logOut()
    {
        //Null out the user object
        user = null;
        
        //Swap to the Start JPanel
        cardLayout.show(cards, "Start");
    }
    
    /**
     * Swaps to the Play panel and starts a new Game
     */
    void goToGame()
    {
        //Swap to Play JPanel
        cardLayout.show(cards, "Play");
        
        // Start the game
        createOperation();
    }
    
    /**
     * Swaps to the UserStats panel and loads the user stats
     */
    void goToUserStats()
    {
        //Swap to UserStats JPanel
        cardLayout.show(cards, "UserStats");
    }
    
    /**
     * Swaps to the GlobalStats panel and loads the global stats
     */
    void goToGlobalStats()
    {
        //Swap to GlobalStats JPanel
        cardLayout.show(cards, "GlobalStats");
    }
    
    void goToMenu()
    {
        // Swap to Play JPanel
        cardLayout.show(cards, "Menu");
    }
    
    /**
     * Creates an operation for the Play view, using the <ii>Game</ii> class.
     */
    void createOperation()
    {
        //Generate a new operation
        game.generateOperation();
        
        //Generate a string array containing operation data
        String[] data = new String[3];
        
        //Get the operation data and store it in the array
        data[0] = String.valueOf(game.getOperand1());
        data[1] = game.getStringOperation();
        data[2] = String.valueOf(game.getOperand2());
        
        //Command the view to plot the operation data
        playView.plotOperation(data);
    }
    
    /**
     * Checks if the answer given by the user is correct. If it is, then stores
     * the corresponding punctuation and creates a new operation. If it's not,
     * then stores the total punctuation and takes the user to their stats.
     */
    void checkOperation(int answer, int timeBonus, boolean isFirstOperation)
    {
        if (answer == game.getSolution())
        {
            /*
                TODO Calculate the points based on how much time the user used to
                calculate
            */
            
            if (isFirstOperation)
            {
                // Add the operation points to the user's last score
                user.setLastPunctuation(game.calculatePoints(timeBonus));
            }
            else
            {
                // Add the operation points to the user last punctuation
                user.setLastPunctuation(user.getLastPunctuation() + game.calculatePoints(timeBonus));
            }
            
            // Add a resolved operation to the operations list the user has.
            user.addResolvedOperation(game.getStringOperation());
            
            //Increase the difficulty
            game.increaseDifficulty();
            
            // Create a new operation
            createOperation();
        }
        else
        {
            // TODO Logic for wrong anwser
        }
    }
    
    /**
     * Instantiates all the panels and set them as cards for the <ii>CardLayout</ii>
     * attribute named <ii>cardLayout</ii>.
     */
    private void initPanels()
    {
        //Instantiate the panels
        startView   = new Start(this);
        playView    = new Play(this);
        menuView    = new Menu(this);
        globalStatsView = new GlobalStats(this);
        userStatsView   = new UserStats(this);
                
        //Reference the JPanel to the Frame's one
        cards = (JPanel) this.getContentPane();
        
        //Reference the cardLayout to the Frame's one
        cardLayout = (CardLayout) cards.getLayout();
        
        //Set panels as cards for the layout
        cards.add(startView, "Start");
        cards.add(playView, "Play");
        cards.add(menuView, "Menu");
        cards.add(globalStatsView, "GlobalStats");
        cards.add(userStatsView, "UserStats");
    }
    
    /**
     * Sets the Frames size relative to the screen and it's position centered,
     * then sets the window as enabled and visible.
     */
    private void initWindow()
    {
        //Get the screen dimensions
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        //Set the preferred window size
        dim.setSize(dim.getWidth()/2, dim.getHeight()/2);
        
        //Set the window size
        this.setSize(dim);
        
        //Center the frame
        this.setLocationRelativeTo(null);
        
        //Set the window visible and enabled
        this.setVisible(true);
        this.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        //Save the user's data.
        userbank.saveToJSON();
    }//GEN-LAST:event_formWindowClosing
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
