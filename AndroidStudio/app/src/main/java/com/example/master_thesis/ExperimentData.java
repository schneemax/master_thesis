package com.example.master_thesis;

import java.util.ArrayList;

public class ExperimentData {

    ExperimentEntity experiment;

    public ExperimentData() {

        ArrayList<String> steps = new ArrayList<String>();
        String groupAllocation = "Random";
        String infoScreen = "Welcome to our study! In the first phase, provide consent and participate. In the second phase, complete a brief demographic questionnaire. Lastly, engage in a 15-minute chess games against an opponent. After each game, share your strategic insights. Your contribution will enrich our understanding of decision-making. Consent to begin.";
        //String infoScreen = "Thanks for participating! We will evaluate the results and send you a thank you gift.";

        steps.add("com.example.master_thesis.InfoScreenActivity");
        steps.add("com.example.master_thesis.ChooseTestSubjectActivity");
        steps.add("com.example.master_thesis.QuestionnaireActivity");
        steps.add("com.example.master_thesis.ChessExperimentActivity");

        experiment = new ExperimentEntity(steps, groupAllocation, infoScreen);

        }

    public ExperimentEntity getExperiment() {
        return experiment;
    };

}
