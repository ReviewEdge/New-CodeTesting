import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.awt.event.ActionEvent;

/**
 * UI screen for when the computer is guessing a number
 *
 * Displays the computer's guesses and processes human's answers
 * Tracks the computer's guesses
 *
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

        initializeGuessMessage();

        this.add(Box.createRigidArea(new Dimension(0, 40)));

        initializePrompt();

        createButton("Lower", e -> handleNextGuess(false));
        createButton("Equal", e -> handleCorrectGuess(cardsPanel, gameFinishedCallback));
        createButton("Higher", e -> handleNextGuess(true));

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                game = new ComputerGuessesGame();
                newGuessUI();
            }
        });
    }

    private void initializeGuessMessage() {
        guessMessage = new JLabel("I guess ___.");
        guessMessage.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(guessMessage);
        guessMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void initializePrompt() {
        JLabel prompt = new JLabel("Your number is...");
        this.add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,10)));
    }

    private void createButton(String text, Consumer<ActionEvent> action) {
        JButton btn = new JButton(text);
        btn.addActionListener(action::accept);
        this.add(btn);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,10)));
    }

    private void handleNextGuess(boolean isHigher) {
        game.handleGuessResponse(isHigher);
        newGuessUI();
    }

    private void handleCorrectGuess(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback) {
        guessMessage.setText("I guess ___.");

        // Send the result of the finished game to the callback
        GameResult result = game.getGameResult();
        gameFinishedCallback.accept(result);

        CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
        cardLayout.show(cardsPanel, ScreenID.GAME_OVER.name());
    }

    private void newGuessUI() {
        int lastGuess = game.newGuess();
        guessMessage.setText("I guess " + lastGuess + ".");
    }
}
