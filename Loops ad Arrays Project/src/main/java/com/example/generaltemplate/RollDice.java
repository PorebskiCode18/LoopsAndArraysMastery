package com.example.generaltemplate;

import java.util.ArrayList;

public class RollDice {
    /*
    precondition: 3 integer>0 for faces, rolls, and # dies
    return sum of the dies
     */
    public ArrayList<Integer> getSumWithCertainNumOfFaces(int numFaces, int numRolls,int numDies){
        ArrayList<Integer> sumsOfDies = new ArrayList<>();
        for (int i=0; i<numRolls;i++){
            sumsOfDies.add((int)(Math.random() * (numFaces)+1));
            for (int j=0;j<numDies-1;j++){
                sumsOfDies.set(i,sumsOfDies.get(i)+(int)(Math.random() * (numFaces)+1));
            }
        }
        return sumsOfDies;
    }
    public String getMinMaxAvg(int numFaces, int numRolls, int numDie){
        ArrayList<Integer> sumOfDies=getSumWithCertainNumOfFaces(numFaces,numRolls,numDie);
        int min=sumOfDies.get(0);
        int max=sumOfDies.get(0);
        double avg=0;
        for (int i=0;i<sumOfDies.size();i++){
            if (sumOfDies.get(i)<min){
                min=sumOfDies.get(i);
            }
            if (sumOfDies.get(i)>max){
                max=sumOfDies.get(i);
            }
            avg+=sumOfDies.get(i);
        }
        avg=avg/sumOfDies.size();
        avg= (double) Math.round(avg * 100) /100;
        return "Min: "+min+ " , " + "Max: " + max + " , " + "Avg: " + avg;
    }
    public ArrayList<Integer> getNumOfEachSum(int numFaces, int numRolls, int numDies){
        ArrayList<Integer> sumOfDies=getSumWithCertainNumOfFaces(numFaces,numRolls,numDies);
        ArrayList<Integer> numOfEachSums=new ArrayList<>();
        for (int j=numDies;j<=numDies*numFaces;j++){
            numOfEachSums.add(0);
        }
        for (int i=0; i<sumOfDies.size();i++){
            for (int j=numDies;j<=numDies*numFaces;j++){
                if (sumOfDies.get(i)==j){
                    numOfEachSums.set(j-numDies,numOfEachSums.get(j-numDies)+1);
                }
            }
        }
        return numOfEachSums;
    }
    public ArrayList<Integer> getWeightedDie(int numFaces, int numRolls, double ProbOfWeightedFace, int weightedFace){
        ArrayList<Integer> numsRolled=new ArrayList<>();
        for (int i=0;i<numRolls;i++) {
            double getFaceOrNo = Math.random() * 1;
            if (getFaceOrNo > ProbOfWeightedFace) {
                int randomOtherFace = (int) (Math.random() * (numFaces-1)) + 1;
                if (randomOtherFace<weightedFace){
                    numsRolled.add(randomOtherFace);
                }else {
                    numsRolled.add(randomOtherFace+1);
                }
            } else {
                numsRolled.add(weightedFace);
            }
        }
        ArrayList<Integer> numOfEachSums=new ArrayList<>();
        for (int j=0;j<numFaces;j++){
            numOfEachSums.add(0);
        }
        for (int i=0; i<numsRolled.size();i++){
            for (int j=0;j<numFaces;j++){
                if (numsRolled.get(i)==j+1){
                    numOfEachSums.set(j,numOfEachSums.get(j)+1);
                }
            }
        }
        return numOfEachSums;
    }
}
