/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.recursion;

import com.fptuni.csd201.utils.Turtle;
import java.awt.Color;

/**
 *
 * @author DUNGHUYNH
 */
public class VonKnockSnowflake {

    Turtle turtle = new Turtle();

    public void snowflake(int n, double step) {
        if (n == 0) {
            turtle.move(step);
            return;
        }
        snowflake(n - 1, step / 3);
        turtle.addAngle(60);
        snowflake(n - 1, step / 3);
        turtle.addAngle(-120.0);
        snowflake(n - 1, step / 3);
        turtle.addAngle(60.0);
        snowflake(n - 1, step / 3);
    }

    public void draw() {

        for (int i = 0; i < 3; i++) {
            snowflake(2, 200);
            turtle.addAngle(-120);
        }

    }

}
