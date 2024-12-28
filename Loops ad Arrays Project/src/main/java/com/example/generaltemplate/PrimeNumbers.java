package com.example.generaltemplate;

import java.util.ArrayList;

public class PrimeNumbers {
    public boolean isPrime(int num){
        if (num<2){
            return false;
        }
        int testnum=2;
        while(testnum<=Math.sqrt(num)){
            if (num % testnum == 0){
                return false;
            }
            testnum++;
        }
        return true;
    }

    public ArrayList<Integer>getListOfPrimeNumbers(int startInclusive, int endInclusive){
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        for (int i =startInclusive; i<= endInclusive;i++){
            if (isPrime(i)) {
                listOfPrimes.add(i);
            }
        }
        return listOfPrimes;
    }
    /*
    precondition: this function required to numbers that indicate the range.

    return the number of prime numbers within the given range, inclusive
     */
    public int numberOfPrimeNumbersInRange(int startInclusive, int endInclusive) {
//        int numPrimes=0;
//        for (int i =startInclusive; i<= endInclusive;i++){
//            if (isPrime(i)) {
//                numPrimes++;
//            }
//        }
//        return numPrimes;

//        ArrayList<Integer> temp = getListOfPrimeNumbers(startInclusive, endInclusive);
//        int numPrimes = temp.size();
//        return numPrimes;

        return getListOfPrimeNumbers(startInclusive,endInclusive).size();

    }
    /*
        precondition: num>0
        return true if number has 2 factors that are prime
        return false if factors are not prime, or if number is prime
     */
    public boolean checkNumFactor2Primes(int num){
//        for (int i=0;i<Math.sqrt(num); i++) {
//            if (isPrime(i)) {
//                if (num % i == 0) {
//                    if (isPrime(num / i)) {
//                        System.out.println(i + "," + num / i);
//                        return true;
//                    }
//                }
//            }
//        };
//        return false;
        ArrayList<Integer> possibleDivisions = getListOfPrimeNumbers(0,(int) Math.sqrt(num));
        for(int i =0; i< possibleDivisions.size();i++){
            if (num%possibleDivisions.get(i) == 0){
                System.out.println(possibleDivisions.get(i) + "," + num/possibleDivisions.get(i));
                return isPrime(num/i);
            }
        }
        return false;
    }
    /*
    precondition: num is positive and is an integer
    return

     */
    public int createPrimeNumberGivenLength2RandPrimeNumbers(int num){
//        String nines = "";
//        for (int i = 0; i < num; i++){
//            nines+="9";
//        }
//        ArrayList<Integer> possiblePrimes = getListOfPrimeNumbers((int) Math.pow(10,num-1),Integer.parseInt(nines));
//        System.out.println(possiblePrimes);
        ArrayList<Integer> possiblePrimes = getListOfPrimeNumbers((int) Math.pow(10,num-1),(int) Math.pow(10,num)-1);
        System.out.println(possiblePrimes);
        int rnum1= possiblePrimes.get((int) (Math.random()*possiblePrimes.size()));
        int rnum2 = possiblePrimes.get((int) (Math.random()*possiblePrimes.size()));
        System.out.println(rnum1);
        System.out.println(rnum2);
        return rnum1*rnum2;
    }
    /*
    precondition:  list of numbers
    return: list of prime numbers
     */
    public ArrayList<Integer>getListOfPrimeNumbersFromPrimativeArray(int[] listOfNumbers){
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        for (int i=0;i<listOfNumbers.length;i++){
            if (isPrime(listOfNumbers[i])){
                listOfPrimes.add(listOfNumbers[i]);
            }
        }
        return listOfPrimes;
    }
    /*
    precondition:  list of numbers
    return: list of non prime numbers
     */
    public ArrayList<Integer>getListOfNonPrimeNumbersFromPrimativeArray(int[] listOfNumbers){
        ArrayList<Integer> listOfNonPrimes = new ArrayList<>();
        for (int i=0;i<listOfNumbers.length;i++){
            if (!isPrime(listOfNumbers[i])){
                listOfNonPrimes.add(listOfNumbers[i]);
            }
        }
        return listOfNonPrimes;
    }
}
