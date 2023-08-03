package com.example.master_thesis;

import java.util.ArrayList;

public class ExperimentEntity {

    ArrayList<String> steps;

    public ExperimentEntity(ArrayList<String> steps) {
        setSteps(steps);
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    private void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }
}
