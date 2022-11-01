package com.shpp.p2p.cs.kservetnyk.assignment7;

/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

public class NameSurferGraph extends GCanvas
        implements NameSurferConstants, ComponentListener {

    // Array with used names in the window
    private ArrayList<NameSurferEntry> nameList = new ArrayList<>();

    /**
     * Creates a new NameSurferGraph object that displays the data.
     */
    public NameSurferGraph() {
        addComponentListener(this);
    }


    /**
     * Clears the list of name surfer entries stored inside this class.
     */
    public void clear() {
        nameList.clear();
        update();
    }

	
	/* Method: addEntry(entry) */

    /**
     * Adds a new NameSurferEntry to the list of entries on the display.
     * Note that this method does not actually draw the graph, but
     * simply stores the entry; the graph is drawn by calling update.
     */
    public void addEntry(NameSurferEntry entry) {
        nameList.add(entry);
    }


    /**
     * Updates the display image by deleting all the graphical objects
     * from the canvas and then reassembling the display according to
     * the list of entries. Your application must call update after
     * calling either clear or addEntry; update is also called whenever
     * the size of the canvas changes.
     */
    public void update() {
        // Deleting all the graphical objects
        removeAll();

        // Adding lines and labels to the background
        lines();
        labels();

        // Adding a name popularity graph
        graph();
    }


    /* Implementation of the ComponentListener interface */
    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
        update();
    }

    public void componentShown(ComponentEvent e) {
    }

    /**
     * Method that add background lines to the window
     */
    private void lines(){

        // Vertical lines
        for (int i = 0; i < NDECADES; i++) {
            line(getWidth()*i/NDECADES, 0, getWidth()*i/NDECADES, getHeight(), Color.BLACK);
        }

        // Horizontal lines
        line(0,getHeight() - GRAPH_MARGIN_SIZE, getWidth(),getHeight() - GRAPH_MARGIN_SIZE, Color.BLACK);
        line(0, GRAPH_MARGIN_SIZE, getWidth(),GRAPH_MARGIN_SIZE, Color.BLACK);

    }

    /**
     * Method that add background labels to the window
     */
    private void labels(){
        GLabel decades;
        String text;

        // Makes text for every decade from 1900 to 2010
        for (int i = 0; i < NDECADES; i++) {
            if (i < 10) text = "19" + i + "0";
            else text = "20" + (i - 10) + "0";

            // Creates Glabel from the text
            decades = new GLabel(text);
            decades.setFont("SansSerif-18");

            double x = getWidth()*i/12f;
            double y = getHeight() - decades.getDescent();

            add(decades, x, y);
        }
    }

    /**
     * Method that return necessary color by index
     * @param value - which choose color from the array
     * @return color with necessary index
     */
    public Color color(int value){
        Color[] colors = {Color.BLUE, Color.RED, Color.MAGENTA, Color.BLACK};
        int index = value % 4;
        return colors[index];
    }

    /**
     * Method that draws graph of the popularity of a name
     */
    private void graph(){

        // Works with each name
        for (int i = 0; i < nameList.size(); i++) {

            Color lineColor = color(i);
            GLabel graphLabel;
            NameSurferEntry entry = nameList.get(i);

            // Draws the lines and labels for every decade in the window
            for (int j = 0; j < NDECADES; j++) {

                // If the rate is 0 - draws the graph on the bottom
                double y1 = getHeight() - GRAPH_MARGIN_SIZE;
                double y2 = getHeight() - GRAPH_MARGIN_SIZE;

                // If the rate isn't 0
                if (entry.getRank(j) != 0){
                    y1 = entry.getRank(j)*(getHeight()-2*GRAPH_MARGIN_SIZE)/MAX_RANK + GRAPH_MARGIN_SIZE;
                }

                if (j < NDECADES - 1){

                    // If the rate isn't 0
                    if (entry.getRank(j + 1) != 0) {
                        y2 = entry.getRank(j+1)*(getHeight()-2*GRAPH_MARGIN_SIZE)/MAX_RANK + GRAPH_MARGIN_SIZE;
                    }
                    line(j*getWidth()/NDECADES, y1,
                            (j+1)*getWidth()/NDECADES, y2, lineColor);
                }

                // Draws the labels for each decade
                graphLabel = new GLabel(
                        entry.getName() + " " + entry.getRank(j),
                        j*getWidth()/NDECADES, y1);
                graphLabel.setColor(lineColor);
                add(graphLabel);
            }
        }
    }

    /**
     * Method that create and add the line object
     * @param v, v1, v2, v3 - coordinates
     * @param color - color of the line
     */
    private void line(double v, double v1, double v2, double v3, Color color){
        GLine line = new GLine(v, v1, v2, v3);
        line.setColor(color);
        add(line);
    }
}
