package com.example.master_thesis;

import java.util.ArrayList;

public class ExperimentData {

    ExperimentEntity experiment;

    public ExperimentData() {

        ArrayList<String> steps = new ArrayList<String>();
        String groupAllocation = "Random";
        String infoScreen = "Exploring the effects of chromatic light on plant growth, set up three groups of potted plants—Group A exposed to blue light, Group B to red light, and Group C to a combination of green and yellow light. Ensure all other environmental factors remain constant. Measure growth parameters such as height, leaf count, and color intensity over a span of four weeks. Analyze the data using ANOVA to determine if different light spectra significantly influence plant growth. This experiment aims to contribute insights into optimizing indoor horticulture techniques for improved yield and quality.";

        steps.add("com.example.master_thesis.InfoScreenActivity");
        steps.add("com.example.master_thesis.ChooseTestSubjectActivity");
        steps.add("com.example.master_thesis.QuestionnaireActivity");

        experiment = new ExperimentEntity(steps, groupAllocation, infoScreen);

        }

    public ExperimentEntity getExperiment() {
        return experiment;
    };

}
