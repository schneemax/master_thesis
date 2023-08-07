package com.example.master_thesis;

import java.util.ArrayList;

public class ExperimentEntity {

    ArrayList<String> steps;

    String groupAllocation;

    String infoScreen;

    public int getCurrentParticipant() {
        return currentParticipant;
    }

    public void setCurrentParticipant(int currentParticipant) {
        this.currentParticipant = currentParticipant;
    }

    int currentParticipant;

    public ExperimentEntity(ArrayList<String> steps, String groupAllocation, String infoScreen) {
        setSteps(steps);
        setGroupAllocation(groupAllocation);
        setInfoScreen(infoScreen);
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    private void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    public String getGroupAllocation() {
        return groupAllocation;
    }

    private void setGroupAllocation(String groupAllocation) {
        this.groupAllocation = groupAllocation;
    }

    public String getInfoScreen() {
        return infoScreen;
    }

    private void setInfoScreen(String infoScreen) {
        this.infoScreen = infoScreen;
    }

    public void setMetaData(float num){
        //Do Nothing
    };
}
