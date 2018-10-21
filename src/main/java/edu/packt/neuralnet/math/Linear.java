package edu.packt.neuralnet.math;

public class Linear implements IActivationFunction {
    private double a = 1.0;

    public Linear(double _a) {
        this.a = _a;
    }

    @Override
    public double calc(double x) {
        return a;
    }
}
