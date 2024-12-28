package app.view;

import java.util.Scanner;

public class GraphView {
    // show Graph
    public void displayGraph(String graphRepresentation) {
        System.out.println("Graph: " + graphRepresentation);
    }

    // messages to User
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Get data from user
    public int getUserInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

