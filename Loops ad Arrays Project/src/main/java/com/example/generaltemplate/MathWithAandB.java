package com.example.generaltemplate;

public class MathWithAandB {
    /*
    precondition: 2 integers
    return boolean if the ints are divisivle
     */
    public boolean isADisivisbleByB(int numA,int numB){
        if (numA!=0 && numB!=0){
            return numA%numB==0;
        }
        return false;
    }
    /*
    precondition: 2 integers and a answer type (Decimal, Proper, Improper)
    return desired type of the quotient of the 2 integers
     */
    public String getADividedB(int numA,int numB, String type){
        if (type.equals("Decimal")){
            if (numA%numB==0){
                return ""+ numA/numB;
            }else{
                return "" +  (double)Math.round((double)numA/numB*100)/100;
            }

        }else if(type.equals("Improper")){
            return reduceFraction(numA,numB);
        }else if (type.equals("Proper")){
            if (!isADisivisbleByB(numA,numB)){
                if (numA>=numB){
                    int properInt = numA/numB;
                    numA-=properInt*numB;
                    return properInt + " " + reduceFraction(numA,numB);
                }else{
                    return "" + reduceFraction(numA,numB);
                }
            }else{
                return ""+numA/numB;
            }


        }
        return "Choose a answer type";
    }
    //can be used for improper and proper functions
    public String reduceFraction(int numA,int numB){
        if (numA>numB){
            for (int i=numB; i>=2;i--){
                if (numA%i==0 && numB%i==0){
                    if (numB/i==1){
                        return ""+numA/i;
                    }
                    return numA/i+ "/"+ numB/i;
                }
            }
        }else if (numB>numA){
            for (int i=numA; i>=2;i--){
                if (numA%i==0 && numB%i==0){
                    return numA/i+ "/"+ numB/i;
                }
            }
        }else{
            return "1";
        }
        return numA + "/" + numB;
    }
    /*
    precondition: 2 integers
    return the gcf of the 2 integers if any
     */
    public int getGCF(int numA,int numB){
        if (numA>numB){
            for (int i=numB; i>=2;i--){
                if (numA%i==0 && numB%i==0){
                    return i;
                }
            }
            return 0;
        }else if (numB>numA){
            for (int i=numA; i>=2;i--){
                if (numA%i==0 && numB%i==0){
                    return i;
                }
            }
            return 0;
        }
        return numA;
    }
}
