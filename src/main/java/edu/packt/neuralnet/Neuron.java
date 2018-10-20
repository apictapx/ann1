package edu.packt.neuralnet;

import math.*;

import java.util.ArrayList;

public class Neuron {
    protected ArrayList<Double> weight;
    private ArrayList<Double> input;
    private Double output;
    private Double outputBeforeActivation;
    private int numberOfInputs = 0;
    protected Double bias = 1.0;
    private IActivationFunction activationFunction;

    public void setActivationFunction(IActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public void setInput(ArrayList<Double> input) {
        this.input = input;
    }

    public Double getOutput() {
        return output;
    }

    public Neuron(int numberofinputs, IActivationFunction iaf) {
        numberOfInputs = numberofinputs;
        weight = new ArrayList<>(numberofinputs + 1);
        input = new ArrayList<>(numberofinputs);
        activationFunction = iaf;
    }

    public void init() {
        for (int i = 0; i <= numberOfInputs; i++) {
            double newWeight = RandomNumberGenerator.GenerateNext();
            try {
                this.weight.set(i, newWeight);
            } catch (IndexOutOfBoundsException iobe) {
                this.weight.add(newWeight);
            }
        }
    }

    public void calc() {
        outputBeforeActivation = 0.0;
        if (numberOfInputs > 0) {
            if (input != null && weight != null) {
                for (int i = 0; i <= numberOfInputs; i++) {
                    outputBeforeActivation += (i != numberOfInputs ? input.get(i) : bias) * weight.get(i);
                }
            }
        }
        output = activationFunction.calc(outputBeforeActivation);
    }
}