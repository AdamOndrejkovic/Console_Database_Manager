package gui;

import bll.IManager;
import bll.Manager;

public class Console {

    public static void main(String[] args) {
        IManager manager = new Manager();
        manager.menu();
    }
}
