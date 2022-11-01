package com.shpp.p2p.cs.kservetnyk.assignment7;

/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import com.shpp.cs.a.simple.SimpleProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NameSurfer extends SimpleProgram implements NameSurferConstants {

    private static final int NUM_COLUMNS = 10;
    private JButton graphButton;
    private JButton clearButton;
    private JTextField textField;
    private NameSurferGraph graph;

    /**
     * This method has the responsibility for reading in the data base
     * and initializing the interactors at the top of the window.
     */
    public void init() {

        add(new JLabel("Name: "), NORTH);
        textField = new JTextField(NUM_COLUMNS);
        graphButton = new JButton("Graph");
        clearButton = new JButton("Clear");
        graph = new NameSurferGraph();

        add(graph);
        add(textField, NORTH);
        add(graphButton, NORTH);
        add(clearButton, NORTH);
        addActionListeners();
    }

    /**
     * This class is responsible for detecting when the buttons are
     * clicked, so you will have to define a method to respond to
     * button actions.
     */
    public void actionPerformed(ActionEvent e) {

        // When the graph button pressed
        if (e.getSource() == graphButton){

            NameSurferDataBase db = new NameSurferDataBase(NAMES_DATA_FILE);
            NameSurferEntry entry = db.findEntry(textField.getText());

            if (entry != null) {
                graph.addEntry(entry);
                graph.update();
            }
        }
        // When clear button pressed
        else if (e.getSource() == clearButton){
            graph.clear();
        }
    }
}