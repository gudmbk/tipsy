package com.company;

import com.company.GUI.Console;
import com.company.GUI.GUI;
import com.company.Logic.Game;

public class Main {

    public static void main(String[] args) {
        GUI gameGUI = new Console(); // nota dependency injection
        gameGUI.run();
    }
}
