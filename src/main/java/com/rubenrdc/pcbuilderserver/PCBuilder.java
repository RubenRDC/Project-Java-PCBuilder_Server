package com.rubenrdc.pcbuilderserver;

/**
 *
 * @author Ruben
 */
public class PCBuilder {

    public static void main(String[] args) {
        ServerLogic l = new ServerLogic(8765);
        l.startServerThread();
    }
}
