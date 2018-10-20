package edu.packt.neuralnet;

import math.IActivationFunction;

import java.util.ArrayList;

public class NeuralNet {
    private InputLayer inputLayer;
    private ArrayList<HiddenLayer> hiddenLayer;
    private OutputLayer outputLayer;
    private int numberOfHiddenLayers;
    private int numberOfInputs;
    private int numberOfOutputs;
    private ArrayList<Double> input;
    private ArrayList<Double> output;

    public NeuralNet(
            int numberofinputs,
            int numberofoutputs,
            int[] numberofhiddenneurons,
            IActivationFunction[] hiddenAcFnc,
            IActivationFunction outputAcFnc
    ) {
        input = new ArrayList<>(numberofinputs);
        inputLayer = new InputLayer(numberofinputs);

        //TODO there is something more...

        if (numberOfHiddenLayers > 0) {
            outputLayer = new OutputLayer(numberofoutputs, outputAcFnc, hiddenLayer.get(numberOfHiddenLayers - 1).getNumberOfNeuronsInLayer());
            hiddenLayer.get(numberOfHiddenLayers - 1).setNextLayer(outputLayer);
        } else {
            outputLayer = new OutputLayer(numberofinputs, outputAcFnc, numberofoutputs);
            inputLayer.setNextLayer(outputLayer);
        }
    }

    public void calc() {
        inputLayer.setInput(input);
        inputLayer.calc();
        for (int i = 0; i < numberOfHiddenLayers; i++) {
            HiddenLayer hl = hiddenLayer.get(i);
            hl.setInput(hl.getPreviousLayer().getOutput()); hl.calc();
        }
        outputLayer.setInput(outputLayer.getPreviousLayer().getOutput());
        outputLayer.calc();
        this.output = outputLayer.getOutput();
    }
}
