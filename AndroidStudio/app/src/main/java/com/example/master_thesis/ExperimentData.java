package com.example.master_thesis;

import java.util.ArrayList;

public class ExperimentData {

    ExperimentEntity experiment;

    public ExperimentData() {

        ArrayList<String> steps = new ArrayList<String>();

        steps.add("Schritt1");
        steps.add("Schritt2");
        steps.add("Schritt3");

        experiment = new ExperimentEntity(steps);

        }

    public ExperimentEntity getExperiment() {
        return experiment;
    };

}
