package com.example.generaltemplate;

import java.util.ArrayList;

public class MathWith1Number {
    /*
    precondition: num>0 and a max number inclusive
    return multiples of the number
     */
    public ArrayList<Integer> getMuliplesOfNumber(int num, int numMults){
        ArrayList<Integer> listOfMultiples = new ArrayList<>();
        if (num>0){
            for (int i=1; i<=numMults;i++){
                listOfMultiples.add(num*i);
            }
        }
        return listOfMultiples;
    }
    /*
    precondition: num is a integer
    return even or odd
     */
    public String checkEvenOrOdd(int num){
        if (num%2==0){
            return "even";
        }else{
            return "odd";
        }
    }
    /*
    precondition: integer>0
    return factorial of integer
     */

    public int getFactorialOfNum(int num){
        if (num==0){
            return 1;
        }
        for (int i=num-1;i>0;i--){
            num=num*i;
        }
        return num;
    }
    /*
    precondition: num>1
    return: array of prime factorization of the num
     */
    private PrimeNumbers myprimes = new PrimeNumbers();
    public ArrayList<Integer> getPrimeFactorizationOfNum(int num) {
        ArrayList<Integer> listOfPrimes = myprimes.getListOfPrimeNumbers(0, (int) Math.sqrt(num));
        ArrayList<Integer> listOfPrimeFactors = new ArrayList<>();
        while (!myprimes.isPrime(num)){
            for (int i=0; i< listOfPrimes.size();i++){
                if (num % listOfPrimes.get(i) == 0) {
                    listOfPrimeFactors.add(listOfPrimes.get(i));
                    num = num / listOfPrimes.get(i);
                }
            }
        }
        listOfPrimeFactors.add(num);
        return listOfPrimeFactors;
    }

}
