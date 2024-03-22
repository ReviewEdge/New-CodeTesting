import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/**
 * UI screen for when the computer is guessing a number
 *
 * Displays the computer's guesses and processes human's answers
 * Tracks the computer's guesses
 *
 * TODO: refactor this class
 */
public class ComputerGuessesPanel extends JPanel {
    private ComputerGuessesGame game;

    private JLabel guessMessage;

    public ComputerGuessesPanel(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback){
        game = new ComputerGuessesGame();
        buildUI(cardsPanel, gameFinishedCallback);
    }

    private void buildUI(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        guessMessage = new JLabel("I guess ___.");
        guessMessage.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(guessMessage);
        guessMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0, 40)));

        JLabel prompt = new JLabel("Your number is...");
        this.add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,10)));

        JButton lowerBtn = new JButton("Lower");
        lowerBtn.addActionListener(e -> {
            game.handleGuessResponse(false);
        });
        this.add(lowerBtn);
        lowerBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,10)));

        JButton correctBtn = new JButton("Equal");
        correctBtn.addActionListener(e -> {
            win(cardsPanel, gameFinishedCallback);
        });
        this.add(correctBtn);
        correctBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,10)));

        JButton higherBtn = new JButton("Higher");
        higherBtn.addActionListener(e -> {
            game.handleGuessResponse(true);
        });
        this.add(higherBtn);
        higherBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                game = new ComputerGuessesGame();
                int lastGuess = game.newGuess();
                guessMessage.setText("I guess " + lastGuess + ".");
            }
        });
    }

    private void win(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback) {
        guessMessage.setText("I guess ___.");

        // Send the result of the finished game to the callback
        GameResult result = game.getGameResult();
        gameFinishedCallback.accept(result);

        CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
        cardLayout.show(cardsPanel, ScreenID.GAME_OVER.name());
    }



}
