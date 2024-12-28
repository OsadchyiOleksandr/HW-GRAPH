package app.controller;

import app.model.GraphModel;
import app.view.GraphView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GraphController {
    GraphModel graphModel = new GraphModel();
    GraphView graphView = new GraphView();
    boolean running = true;


    // Run app
    public void runApp() {
        while (this.running) {
            try {
                mainMenu();
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                runFabric(choice);
            } catch (InputMismatchException e) {
                graphView.displayMessage("Enter Integer please");
                new Scanner(System.in).nextLine();
            }
        }
    }

    // Main menu list
    private void mainMenu() {
        graphView.displayMessage("\nMake chose:");
        graphView.displayMessage("1. Add Vertex");
        graphView.displayMessage("2. Add edge");
        graphView.displayMessage("3. Remove Vertex");
        graphView.displayMessage("4. Remove Edge");
        graphView.displayMessage("5. Check Vertex");
        graphView.displayMessage("6. Check edge");
        graphView.displayMessage("7. Show graph");
        graphView.displayMessage("8. exit");
    }

    // Fabric method to work with User
    private void runFabric(int choice) {
        switch (choice) {
            case 1:
                int vertexToAdd = graphView.getUserInput("Enter Vertex to add:");
                graphModel.addVertex(vertexToAdd);
                graphView.displayMessage("Vertex " + vertexToAdd + " is add.");
                break;
            case 2:
                int source = graphView.getUserInput("Enter start Vertex for edge");
                int destination = graphView.getUserInput("Enter end Vertex for edge:");
                graphModel.addEdge(source, destination);
                graphView.displayMessage("Edge between " + source + " and " + destination + " added.");
                break;
            case 3:
                int vertexToRemove = graphView.getUserInput("Enter Vertex to remove:");
                graphModel.removeVertex(vertexToRemove);
                graphView.displayMessage("Vertex " + vertexToRemove + " is removed.");
                break;
            case 4:
                int sourceEdge = graphView.getUserInput("Enter start Vertex for remove edge:");
                int destinationEdge = graphView.getUserInput("Enter end Vertex for remove edge:");
                graphModel.removeEdge(sourceEdge, destinationEdge);
                graphView.displayMessage("Edge between " + sourceEdge + " and " + destinationEdge + " is removed.");
                break;
            case 5:
                int vertexToCheck = graphView.getUserInput("Enter Vertex for check:");
                if (graphModel.isVertex(vertexToCheck)) {
                    graphView.displayMessage("Vertex " + vertexToCheck + " is exist.");
                } else {
                    graphView.displayMessage("Vertex  " + vertexToCheck + " is not exist.");
                }
                break;
            case 6:
                int sourceEdgeCheck = graphView.getUserInput("Enter start Vertex for check edge:");
                int destinationEdgeCheck = graphView.getUserInput("Enter end Vertex for check edge:");
                if (graphModel.isEdge(sourceEdgeCheck, destinationEdgeCheck)) {
                    graphView.displayMessage("Edge between " + sourceEdgeCheck + " and " + destinationEdgeCheck + " is exist.");
                } else {
                    graphView.displayMessage("Edge between " + sourceEdgeCheck + " and " + destinationEdgeCheck + " is not exist.");
                }
                break;
            case 7:
                graphView.displayGraph(graphModel.getGraphRepresentation());
                break;
            case 8:
                this.running = false;
                graphView.displayMessage("End of work.");
                break;
            default:
                graphView.displayMessage("Wrong choice. try again.");
                break;
        }
    }
}