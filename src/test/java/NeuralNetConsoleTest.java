import edu.packt.neuralnet.*;
import edu.packt.neuralnet.math.*;

import java.util.ArrayList;

public class NeuralNetConsoleTest {
    public static void main(String[] args) {
        RandomNumberGenerator.seed = 0;

        int numberOfInputs = 2;
        int numberOfOutputs = 1;
        int[] numberOfHiddenNeurons = {3};
        IActivationFunction[] hiddenAcFnc = {new Sigmoid(1.0)};
        Linear outputAcFnc = new Linear(1.0);
        System.out.println("Creating Neural Network...");
        NeuralNet nn = new NeuralNet(
                numberOfInputs,
                numberOfOutputs,
                numberOfHiddenNeurons,
                hiddenAcFnc,
                outputAcFnc
        );
        System.out.println("Neural Network created!");
        nn.print();

        ArrayList<Double> neuralInput = new ArrayList<>(){{ add(1.5); add(0.5);}};
        ArrayList<Double> neuralOutput;
        System.out.println("Feeding the values [" + String.valueOf(neuralInput.get(0)) + " ; " + String.valueOf(neuralInput.get(1)) + "] to the neural network");
        nn.setInput(neuralInput);
        nn.calc();
        neuralOutput = nn.getOutput();

        neuralInput.set(0, 1.0);
        neuralInput.set(1, 2.1);
        nn.setInput(neuralInput);
        nn.calc();
        neuralOutput = nn.getOutput();
    }
}