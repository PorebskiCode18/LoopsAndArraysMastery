package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HelloController {

    @FXML
    public Label lblDisplay;

    @FXML
    public TextField txtNumber,txtNumMults,txtNumB,txtNumA, txtAnswerTypeAB,txtInputString,txtShiftNum,txtNumRolls,txtNumDice,txtNumFaces,txtFaceWeighted,txtProbWeighted,txtInputWord;
    public ListView lstMathWith1NumberOutput,lstMathWith2NumberOutput,lstCypher,lstRollDiceOutputs,lstWordSearch;

    private PrimeNumbers myprimes = new PrimeNumbers();
    private MathWith1Number mynumbers1 = new MathWith1Number();
    private MathWithAandB mynumbersAB = new MathWithAandB();
    private Cypher myCyphers = new Cypher();
    private RollDice myDies = new RollDice();
    private ArrayWordSearch myWordSearch = new ArrayWordSearch();
    @FXML
    public void handleClick(ActionEvent actionEvent) {
//        System.out.println(myprimes.isPrime(4));
//        System.out.println(myprimes.getListOfPrimeNumbers(2,13));
//        System.out.println(myprimes.numberOfPrimeNumbersInRange(2,13));
//        System.out.println(myprimes.checkNumFactor2Primes(35));
//        System.out.println(myprimes.createPrimeNumberGivenLength2RandPrimeNumbers(35));
//        int[] listOfNumbers = {2,4,5,7,8,10,11};
//        System.out.println(myprimes.getListOfPrimeNumbersFromPrimativeArray(listOfNumbers));
//        System.out.println(myprimes.getListOfNonPrimeNumbersFromPrimativeArray(listOfNumbers));

    }
    public void handleLoad(ActionEvent actionEvent) {
        lstMathWith1NumberOutput.getItems().add("Multiples Of Num");
        lstMathWith1NumberOutput.getItems().add("Even/Odd");
        lstMathWith1NumberOutput.getItems().add("Factorial");
        lstMathWith1NumberOutput.getItems().add("Prime Factorization");
        lstMathWith2NumberOutput.getItems().add("Is a divisible by b");
        lstMathWith2NumberOutput.getItems().add("a/b");
        lstMathWith2NumberOutput.getItems().add("GCF");
        lstCypher.getItems().add("Create Caesar");
        lstCypher.getItems().add("Decode Caesar");
        lstCypher.getItems().add("Encode Atbash Cipher");
        lstCypher.getItems().add("Decode Atbash Cipher");
        lstRollDiceOutputs.getItems().add("Sums given die with certain # faces");
        lstRollDiceOutputs.getItems().add("Max, Min, and Average");
        lstRollDiceOutputs.getItems().add("How Many of Each Sum");
        lstRollDiceOutputs.getItems().add("Weighted Die");
        lstWordSearch.getItems().add("Is Word In Array");
        lstWordSearch.getItems().add("Position Of Word");
        lstWordSearch.getItems().add("Word Match Search Criteria");
    }
    public void handleMathWith1Num(ActionEvent actionEvent){
        if (lstMathWith1NumberOutput.getSelectionModel().getSelectedItem().toString().equals("Multiples Of Num")){
            if (!mynumbers1.getMuliplesOfNumber(Integer.parseInt(txtNumber.getText()),Integer.parseInt(txtNumMults.getText())).isEmpty()){
                System.out.println("Multiples: "+mynumbers1.getMuliplesOfNumber(Integer.parseInt(txtNumber.getText()),Integer.parseInt(txtNumMults.getText())));
            }else{
                System.out.println("No Multiples");
            }
        } else if (lstMathWith1NumberOutput.getSelectionModel().getSelectedItem().toString().equals("Even/Odd")){
            System.out.println("Even/Odd: "+ mynumbers1.checkEvenOrOdd(Integer.parseInt(txtNumber.getText())));
        }else if (lstMathWith1NumberOutput.getSelectionModel().getSelectedItem().toString().equals("Factorial")){
            if (mynumbers1.getFactorialOfNum(Integer.parseInt(txtNumber.getText()))>0){
                System.out.println("Factorial: "+mynumbers1.getFactorialOfNum(Integer.parseInt(txtNumber.getText())));
            }else{
                System.out.println("Not Possible");
            }
        }
        else if (lstMathWith1NumberOutput.getSelectionModel().getSelectedItem().toString().equals("Prime Factorization")){
            if (Integer.parseInt(txtNumber.getText())>1){
                System.out.println("Prime Factors: "+mynumbers1.getPrimeFactorizationOfNum(Integer.parseInt(txtNumber.getText())));
            }else{
                System.out.println("Not Possible");
            }
        }
    }


    public void handleMathWithAandB(ActionEvent actionEvent) {
        if (lstMathWith2NumberOutput.getSelectionModel().getSelectedItem().toString().equals("Is a divisible by b")){
            System.out.println("A divisible by B: " + mynumbersAB.isADisivisbleByB(Integer.parseInt(txtNumA.getText()),Integer.parseInt(txtNumB.getText())));
        } else if (lstMathWith2NumberOutput.getSelectionModel().getSelectedItem().toString().equals("a/b")){
            System.out.println(mynumbersAB.getADividedB(Integer.parseInt(txtNumA.getText()),Integer.parseInt(txtNumB.getText()),txtAnswerTypeAB.getText()));
        }else if (lstMathWith2NumberOutput.getSelectionModel().getSelectedItem().toString().equals("GCF")){
            if (mynumbersAB.getGCF(Integer.parseInt(txtNumA.getText()),Integer.parseInt(txtNumB.getText()))!=0){
                System.out.println(mynumbersAB.getGCF(Integer.parseInt(txtNumA.getText()),Integer.parseInt(txtNumB.getText())));
            }else{
                System.out.println("no GCF");
            }

        }
    }

    public void handleCypher(ActionEvent actionEvent) {
        if (lstCypher.getSelectionModel().getSelectedItem().toString().equals("Create Caesar")){
            System.out.println(myCyphers.getCaesar(txtInputString.getText(),Integer.parseInt(txtShiftNum.getText())));
        } else if (lstCypher.getSelectionModel().getSelectedItem().toString().equals("Decode Caesar")){
            if (!txtInputString.getText().equals("cortez")) {
                System.out.println(myCyphers.getCaesar(txtInputString.getText(), Integer.parseInt(txtShiftNum.getText()) * -1));
            }else{
                System.out.println(myCyphers.getCortezPossibilities());
            }
        }else if (lstCypher.getSelectionModel().getSelectedItem().toString().equals("Encode Atbash Cipher")){
            System.out.println(myCyphers.atbashCipher(txtInputString.getText()));
        }else if (lstCypher.getSelectionModel().getSelectedItem().toString().equals("Decode Atbash Cipher")){
            System.out.println(myCyphers.atbashCipher(txtInputString.getText()));
        }
    }

    public void handleRollDice(ActionEvent actionEvent) {
        if (lstRollDiceOutputs.getSelectionModel().getSelectedItem().toString().equals("Sums given die with certain # faces")){
            System.out.println(myDies.getSumWithCertainNumOfFaces(Integer.parseInt(txtNumFaces.getText()),Integer.parseInt(txtNumRolls.getText()),Integer.parseInt(txtNumDice.getText())));
        } else if (lstRollDiceOutputs.getSelectionModel().getSelectedItem().toString().equals("Max, Min, and Average")){
            System.out.println(myDies.getMinMaxAvg(Integer.parseInt(txtNumFaces.getText()),Integer.parseInt(txtNumRolls.getText()),Integer.parseInt(txtNumDice.getText())));
        }else if (lstRollDiceOutputs.getSelectionModel().getSelectedItem().toString().equals("How Many of Each Sum")){
            System.out.println(myDies.getNumOfEachSum(Integer.parseInt(txtNumFaces.getText()),Integer.parseInt(txtNumRolls.getText()),Integer.parseInt(txtNumDice.getText())));
        }else if (lstRollDiceOutputs.getSelectionModel().getSelectedItem().toString().equals("Weighted Die")){
            System.out.println(myDies.getWeightedDie(Integer.parseInt(txtNumFaces.getText()),Integer.parseInt(txtNumRolls.getText()),Double.parseDouble(txtProbWeighted.getText()),Integer.parseInt(txtFaceWeighted.getText())));
        }
    }

    public void handleWordSearch(ActionEvent actionEvent) {
        if (lstWordSearch.getSelectionModel().getSelectedItem().toString().equals("Is Word In Array")){
            System.out.println(myWordSearch.getIsWordInArray(txtInputWord.getText()));
        } else if (lstWordSearch.getSelectionModel().getSelectedItem().toString().equals("Position Of Word")){
            if (myWordSearch.getPositonOfWord(txtInputWord.getText())==-1){
                System.out.println("Word is not in array");
            }else{
                System.out.println("Position: " + myWordSearch.getPositonOfWord(txtInputWord.getText()));
            }
        }else if (lstWordSearch.getSelectionModel().getSelectedItem().toString().equals("Word Match Search Criteria")){
            System.out.println(myWordSearch.getPartialWordSearchInArray(txtInputWord.getText()));
        }
    }

    public void handleSearchWord(KeyEvent keyEvent) {
        if (lstWordSearch.getSelectionModel().getSelectedItem().toString().equals("Word Match Search Criteria")){
            System.out.println(myWordSearch.getPartialWordSearchInArray(txtInputWord.getText()));
        }
    }
}