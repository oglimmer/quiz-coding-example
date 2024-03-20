package de.oglimmer.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question extends JPanel implements ActionListener {

    private final MainWindow mainWindow;
    private final JPanel answerPanel = new JPanel();
    private final JButton submitButton;

    public Question(String questionText, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setLayout(new BorderLayout());
        JLabel questionLabel = new JLabel(questionText);
        add(questionLabel, BorderLayout.NORTH);
        add(answerPanel, BorderLayout.CENTER);
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
        submitButton = createSubmitButton();
    }

    private JButton createSubmitButton() {
        final JButton submitButton = new JButton("Einloggen");
        add(submitButton, BorderLayout.SOUTH);
        submitButton.setEnabled(false);
        submitButton.addActionListener(e -> buttonSubmitClicked());
        return submitButton;
    }

    private void buttonSubmitClicked() {
        boolean correct = false;
        for (Component component : answerPanel.getComponents()) {
            if (component instanceof AnswerElement answerElement) {
                if (answerElement.isCorrect() && answerElement.isSelected()) {
                    correct = true;
                }
            }
        }
        if (correct) {
            JOptionPane.showMessageDialog(this, "Die Antwort ist richtig!");
        } else {
            JOptionPane.showMessageDialog(this, "Die Antwort ist falsch!");
        }
        mainWindow.askNextQuestion();
    }

    public void addAnswerElement(AnswerElement answerElement) {
        answerPanel.add(answerElement);
        answerElement.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        submitButton.setEnabled(true);
        unSelectAllButtons();
        AnswerElement answerElement = (AnswerElement) e.getSource();
        answerElement.setSelected(true);
    }

    private void unSelectAllButtons() {
        for (Component component : answerPanel.getComponents()) {
            if (component instanceof AnswerElement answerElement) {
                answerElement.setSelected(false);
            }
        }
    }
}
