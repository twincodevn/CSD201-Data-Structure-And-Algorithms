package com.fptuni.csd201.utils;

import javax.swing.*;
import java.awt.*;

/** An instance is a turtle in a panel within a JFrame.
    A turtle is a spot on the panel that you can move from place
    to place. All instances of Turtle use the same JFrame and
    panel. */
public class Turtle {
    /** The frame on which the turtles move. */
    private static JFrame jframe;
    
    /** The panel in the JFrame. */
    private static JPanel panel; 
    
    /** The graphics associated with the panel. */
    private static Graphics graphics;
    
    /** The difference between frame and panel heights. */
    private int difference; 
    
    /** The panel on which the turtle moves is of
        size (width, height). */
    public static int width= 500;
    
    /** The panel on which the turtle moves is of
        size (width, height). */
    public static int height= 500;
     
    /** The turtle is at point (x, y). */
    private double x, y;
    
    /** The turtle points in direction angle: 0 <= angle < 360.
        0: east, 90:north, 180: west, 270 south. */
    private double angle; 
    
    /** = "the pen is down". */
    private boolean penDown= true;
    
    /** the pen color. */
    private Color turtleColor= Color.black;
    
    /** Constructor: a black turtle starting at the middle of the
                     panel with angle 0 (looking east).
        East (right) is angle 0; north (up), 90; west (left), 180;
        South (down). 270. The pen is down.*/
    public Turtle() {
        this(width/2, height/2, 0);
    }
    
    
    /** Constructor: a black turtle starting at (x,y) with angle ang.
        East (right) is angle 0; north (up), 90; west (left), 180;
        South (down), 270. The pen is down. */
    public Turtle(double x, double y, double ang) {
        if (jframe == null) {
            jframe= new JFrame("Turtle window");
            panel= new JPanel();
            panel.setPreferredSize(new Dimension(width, height));
            panel.setBackground(Color.white);
            jframe.getContentPane().add(panel, BorderLayout.CENTER);
            jframe.pack();
            jframe.setVisible(true);
            graphics= panel.getGraphics();
            difference= jframe.getHeight() - panel.getHeight();
            pause(100);
            clear();
            pause(100);
        }
        
        this.x= x;
        this.y= y;
        angle= ang;
    }
    
    /** = the Color value for c. The values are as follows:
        1 black, 2 blue, 3 cyan, 4 dark gray, 5 gray,
        6 green, 7 light gray, 8 magenta, 9 orange,
        10 pink, 11 red, 12 white, 13 yellow,
        any other integer black.
        */
    public static Color tColor(int c) {
        if (c == 1) return Color.black;
        if (c == 2) return Color.blue;
        if (c == 3) return Color.cyan;
        if (c == 4) return Color.darkGray;
        if (c == 5) return Color.gray;
        if (c == 6) return Color.green;
        if (c == 7) return Color.lightGray;
        if (c == 8) return Color.magenta;
        if (c == 9) return Color.orange;
        if (c == 10) return Color.pink;
        if (c == 11) return Color.red;
        if (c == 12) return Color.white;
        if (c == 13) return Color.yellow;
        return Color.black;
    }
    
    // = a random integer in 0..255
    private static int rand255() {
        return (int) (Math.random() * 256.0);
    }
    
    /** Set the color to a random value (not necessarily one of the ones available to tColor). */
    public static Color randColor() {
        return new Color(rand255(), rand255(), rand255());
    }

    /** Set panel size as big as possible in the current window. */
    public void setPanelSize() {
        width= jframe.getWidth();
        height= jframe.getHeight()-difference;
        Dimension d= new Dimension(width, height);
        panel.setPreferredSize(d);
        graphics= panel.getGraphics();
        jframe.pack();
        clear();
        pause(100);
    }
    
    /** = x-coordinate of the turtle. */
    public double getX() {
        return x;   
    }
    
    /** = y-coordinate of the panel. */
    public double getY() {
        return y;   
    }

    /** = angle of the turtle (in degrees). East (right) is angle 0;
        north (up), 90; west (left), 180; South (down), 270. */
    public double getAngle() {
        return angle;   
    }

    /** = width of panel. */
    public int getWidth() {
        return width;   
    }
    
    /** = height of the panel. */
    public int getHeight() {
        return height;   
    }
    

    /** Set the angle to ang degrees. East (right) is angle 0;
        north (up), 90; west (left), 180; South (down), 270.*/
    public void setAngle(double ang) {
        angle= mod(ang, 360);
    }
    
    /** Add ang degrees to the angle. */
    public void addAngle(double ang) {
        angle= mod (angle + ang, 360);
    }
    
    /** Lift pen. */
    public void liftPen() {
        penDown= false;   
    }
    
    /** Put pen down. */
    public void putPenDown() {
        penDown= true;   
    }
    
    /** Set the color of the turtle to c. */
    public void setColor(Color c) {
        turtleColor= c;
    }
    
    /** = the current color. */
    public Color getColor() {
        return turtleColor;
    }
    
    /** Move the turtle to (x,y), without drawing,
        and face it at angle ang. */
    public void moveTo(double x, double y, double ang) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        this.x= x;
        this.y= y;
        angle= ang;
        graphics.setColor(save);
    }
    
    /** Draw a circle with center at current pen position of diameter d. */
    public void drawCircle(double d) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        int id= (int) Math.round(d);
        graphics.drawOval((int)Math.round(x-d/2), (int)Math.round(y-d/2), id, id);
        graphics.setColor(save);
    }
    
    /** Fill a circle with center at current pen position of diameter d. */
    public void fillCircle(double d) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        int id= (int) Math.round(d);
        graphics.fillOval((int)Math.round(x-d/2), (int)Math.round(y-d/2), id, id);
        graphics.setColor(save);
    }
    
    /** Draw a rectangle with center at current pen position of width w, height h. */
    public void drawRectangle(double w, double h) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        graphics.drawRect((int)Math.round(x-w/2), (int)Math.round(y-h/2),
                          (int)Math.round(w), (int)Math.round(h));
        graphics.setColor(save);
    }
    
    /** Fill a rectangle with center at current pen position of width w, height h. */
    public void fillRectangle(double w, double h) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        graphics.fillRect((int)Math.round(x-w/2), (int)Math.round(y-h/2),
                          (int)Math.round(w), (int)Math.round(h));
        graphics.setColor(save);
    }
    
    /** Move the turtle d units in its current direction.
        If the pen is down, a line will be drawn; if the pen
        is up, it won't be drawn.*/
    public void move(double d) {
        double rAngle= (angle * Math.PI) / 180;
        double newX= x + Math.cos(rAngle) * d;
        double newY= y - Math.sin(rAngle) * d;
        if (penDown) {
            Color save= graphics.getColor();
            graphics.setColor(turtleColor);
            graphics.drawLine((int)Math.round(x), (int)Math.round(y),
                          (int)Math.round(newX), (int)Math.round(newY));
            graphics.setColor(save);
        }
        x= newX;
        y= newY;
    }
    
    /** = x mod y. Precondition: y != 0. */
    private double mod(double x, double y) {
        double ans= x % y;
        if (ans < 0) 
            ans= ans + y;
        return ans;
    }
    
    /** Clear the screen (make it all white). */
    public void clear() {
        Color c= graphics.getColor();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(c);
    }
    
    /** Pause the program for msec milliseconds. */
    public void pause(int msec) {
        try { Thread.currentThread().sleep(msec); }
        catch (InterruptedException e) { }
    }   

}