package org.example;

import javax.swing.*;

public class Panel extends JPanel {
    private JButton joke;
    private JButton math;
    private String text;
    private JLabel result;
    private JButton [] jButtons;
    private JButton [] jButtonsCategory;
    private ApiManager apiManager;

    public Panel(int x, int y, int width, int height){
        this.setBounds(x, y, width, height);
        this.setLayout(null); // Avoid using null layout, prefer layout managers
        this.apiManager = new ApiManager();
        this.jButtons = new JButton[4];
        this.jButtonsCategory = new JButton[3];
        setOption();
        setButtonJoke();
        setButtonMath();
        setLabel();
        setJokeOption();
    }

    private void setOption() {
        String [] array = {"trivia","year","date","math"};
        int x = 520, y = 200;
        for (int i = 0; i < array.length; i++) {
            JButton jButton = new JButton(array[i]);
            jButton.setBounds(x, y, 100, 30);
            y += jButton.getHeight() + 10;
            this.add(jButton);
            jButton.setVisible(false);
            this.jButtons[i] = jButton;
            jButton.addActionListener(event -> {
                this.text = apiManager.getMathApi(jButton.getText());
                this.result.setText(text);
            });
        }
    }

    private void setButtonMath() {
        this.math = new JButton("Math");
        this.math.setBounds(500, 100, 200, 50);
        this.add(this.math);
        this.math.addActionListener(event -> {
            for (int i = 0; i < this.jButtons.length; i++) {
                this.jButtons[i].setVisible(true);
            }
        });
        this.math.setVisible(true);
    }

    private void setLabel() {
        this.result = new JLabel();
        this.result.setBounds(500, 700, 400, 50);
        this.add(this.result);
        this.result.setVisible(true);
    }

    private void setJokeOption() {
        String [] category = {"Programming", "Misc", "Dark"};
        int x = 520, y = 500;
        for (int i = 0; i < category.length; i++) {
            JButton jButton = new JButton(category[i]);
            jButton.setBounds(x, y, 100, 30);
            y += jButton.getHeight() + 10;
            this.add(jButton);
            jButton.setVisible(false);
            this.jButtonsCategory[i] = jButton;
            jButton.addActionListener(event -> {
                this.text = this.apiManager.getJokeByApi(jButton.getText());
                this.result.setText(text);
            });
        }
    }

    private void setButtonJoke() {
        this.joke = new JButton("Joke");
        this.joke.setBounds(500, 400, 200, 50);
        this.add(this.joke);
        this.joke.setVisible(true);
        this.joke.addActionListener(event -> {
            for (int i = 0; i < this.jButtonsCategory.length; i++) {
                this.jButtonsCategory[i].setVisible(true);
            }
        });
    }
}
