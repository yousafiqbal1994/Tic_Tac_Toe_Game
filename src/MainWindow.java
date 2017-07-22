/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Haroon
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
// End of imports

/**
 *
 * @author Haroon
 */
public class MainWindow extends JFrame {

    /**
     * @param args the command line arguments
     */
    
    MainWindow()
    {
        super("Tic TacToe");
        setLayout(new BorderLayout());
        //setSize(320, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        pack();
    }
    
    private void initComponents() {
        
        layout = new GridBagLayout();
        cnstr = new GridBagConstraints();
        gamePanel = new GamePanel();
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        
        
        gameMenu = new JMenu("New Game");
        singlePlayer = new JMenu("Single Player");
        
        easy = new JMenuItem("Easy");
        easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player = 1;
                mode = 'E';
                gamePanel.reset();
                gamePanel.setInfoText();
                gamePanel.setVisible(true);
                            }
        });
        medium = new JMenuItem("Medium");
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player = 1;
                mode = 'M';
                gamePanel.reset();
                gamePanel.setInfoText();
                gamePanel.setVisible(true);
                            }
        });
        hard = new JMenuItem("Hard");
        hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player = 1;
                mode = 'H';
                gamePanel.reset();
                gamePanel.setInfoText();
                gamePanel.setVisible(true);
                            }
        });
        singlePlayer.add(easy);
        singlePlayer.add(medium);
        singlePlayer.add(hard);
        
        multiPlayer = new JMenuItem("Multi Player");
        multiPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player = 2;
                gamePanel.reset();
                gamePanel.setInfoText();
                gamePanel.setVisible(true);
            }
        });
        
        gameMenu.add(singlePlayer);
        gameMenu.add(multiPlayer);
        menuBar.add(fileMenu);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);
        
        getContentPane().add(new JScrollPane(gamePanel),BorderLayout.CENTER);
        gamePanel.setVisible(false);
        
    }
    
    private void setGamePanel()
    {
       
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus."
                                                        + "NimbusLookAndFeel");

            }catch(Exception e)
            {
                
            }
                new MainWindow().setVisible(true);

            } //end of run
        }); // End of invokeLater
    } //End of main
    
    
    
    //Variables Declaration
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitMenuItem;
    private JMenu gameMenu;
    private JMenu singlePlayer;
    private JMenuItem easy;
    private JMenuItem medium;
    private JMenuItem hard;
    private JMenuItem multiPlayer;
    private GamePanel gamePanel;
    private GridBagLayout layout;
    static int player = 0;
    private GridBagConstraints cnstr;
    static char mode = 'A';
    
    
}
