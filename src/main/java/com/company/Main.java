package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(GUI.class);

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
    }
}
