package edu.packt.neuralnet;

import edu.packt.neuralnet.math.IActivationFunction;

public class OutputLayer extends NeuralLayer {
    public OutputLayer(int numberofneurons, IActivationFunction iaf, int numberofinputs) {
        numberOfInputs = numberofinputs;
        numberOfNeuronsInLayer = numberofneurons;
        activationFnc = iaf;
    }

}
