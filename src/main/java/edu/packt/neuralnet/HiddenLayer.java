package edu.packt.neuralnet;

import edu.packt.neuralnet.math.IActivationFunction;

public class HiddenLayer extends NeuralLayer {
    public HiddenLayer(int numberofneurons, IActivationFunction iaf, int numberofinputs) {
        numberOfNeuronsInLayer = numberofneurons;
        activationFnc = iaf;
        numberOfInputs = numberofinputs;
    }

}
