package de.oglimmer.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerElement extends JPanel {

    private final boolean isCorrect;
    private boolean isSelected = false;
    private final JButton button;

    public AnswerElement(String labelText, boolean isCorrect) {
        this.isCorrect = isCorrect;
        JLabel label = new JLabel(labelText);
        button = new JButton("Auswählen");
        add(label);
        add(button);
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        if (selected) {
            button.setForeground(Color.RED);
        } else {
            button.setForeground(null);
        }
    }

    public void setActionListener(ActionListener actionListener) {
        button.addActionListener(e -> actionListener.actionPerformed(new ActionEvent(this, e.getID(), e.getActionCommand())));
    }
}
