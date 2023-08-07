package com.example.master_thesis;

import java.util.ArrayList;

public class ExperimentData {

    ExperimentEntity experiment;

    public ExperimentData() {

        ArrayList<String> steps = new ArrayList<String>();
        String groupAllocation = "Random";
        String infoScreen = "Did you ever hear the tragedy of Darth Plagueis the Wise? I thought not. It's not a story the Jedi would tell you. It's a Sith legend. Darth Plagueis was a Dark Lord of the Sith so powerful and so wise, he could use the Force to influence the midi-chlorians to create life. He had such a knowledge of the dark side, he could even keep the ones he cared about from dying.";

        steps.add("com.example.master_thesis.InfoScreenActivity");
        steps.add("com.example.master_thesis.ChooseTestSubjectActivity");
        steps.add("com.example.master_thesis.QuestionnaireActivity");



        experiment = new ExperimentEntity(steps, groupAllocation, infoScreen);

        }

    public ExperimentEntity getExperiment() {
        return experiment;
    };

}
