package ru.kosti.screens;

import ru.kosti.MainFrame;
import ru.kosti.Utils;

import javax.swing.*;
import java.awt.*;

public class FinalScreen extends JPanel {
    private final MainFrame frame;

    public FinalScreen(MainFrame parent) {
        this.frame = parent;
        this.setFocusable(true);
        this.requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Utils.drawText(24, "Игра закончена", this, (Graphics2D) g);
    }
}
