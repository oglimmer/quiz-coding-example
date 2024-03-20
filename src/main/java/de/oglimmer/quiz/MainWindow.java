package de.oglimmer.quiz;

import javax.swing.*;
import java.util.*;

public class MainWindow extends JFrame {

    private final List<Question> questionList = new ArrayList<>();
    private Question currentQuestion;

    public MainWindow() {
        setTitle("Super Quiz!");
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        initQuestions();

        askNextQuestion();
        pack();
    }

    private void initQuestions() {
        Question question1 = new Question("Welcher Planet ist der größte in unserem Sonnensystem?", this);
        question1.addAnswerElement(new AnswerElement("Mars", false));
        question1.addAnswerElement(new AnswerElement("Venus", false));
        question1.addAnswerElement(new AnswerElement("Jupiter", true));
        question1.addAnswerElement(new AnswerElement("Saturn", false));
        question1.addAnswerElement(new AnswerElement("Neptun", false));
        question1.addAnswerElement(new AnswerElement("Merkur", false));
        questionList.add(question1);

        Question question2 = new Question("Wie lautet der offizielle Name des Symbols \"#\"?", this);
        question2.addAnswerElement(new AnswerElement("Raute", false));
        question2.addAnswerElement(new AnswerElement("Hashtag", true));
        question2.addAnswerElement(new AnswerElement("Nummernzeichen", false));
        question2.addAnswerElement(new AnswerElement("Gitter", false));
        question2.addAnswerElement(new AnswerElement("Rautenzeichen", false));
        questionList.add(question2);

        Question question3 = new Question("Welches Element hat die chemische Bezeichnung \"Fe\"?", this);
        question3.addAnswerElement(new AnswerElement("Eisen", true));
        question3.addAnswerElement(new AnswerElement("Fluor", false));
        question3.addAnswerElement(new AnswerElement("Kohlenstoff", false));
        question3.addAnswerElement(new AnswerElement("Gold", false));
        questionList.add(question3);

        Collections.shuffle(questionList);
    }

    public void askNextQuestion() {
        if (currentQuestion != null) {
            remove(currentQuestion);
        }
        if (questionList.isEmpty()) {
            System.exit(0);
        }
        currentQuestion = questionList.removeFirst();
        add(currentQuestion);
        revalidate();
        pack();
    }


}
