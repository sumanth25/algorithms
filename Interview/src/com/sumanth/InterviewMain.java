package com.sumanth;

import com.sumanth.algos.*;

public class InterviewMain {

    public static void main(String[] args){
        /* Walmart Interview: 25/05/2020 */
        MaximumSwap.maxNumberSwap();

        /* Zycus Interview: 10/06/2020 */
        DirectionMatrix.directionMatrix();
        MeritList.showMeritList();

        /* Morgan Stanley Interview: 24/06/2020 */
        ValidParentheses.calculate();
        RemoveDuplicatesInplace.doIt();
        Anagram.check();

        /* Klarna Interview: 25/06/2020 */
        ReversePolishCalculator.evaluateMethod();
        ConvertNumberToOrdinal.numberToOrdinalMethod();
        MaskString.maskifyMethod();

        /* SAP Interview: 03/07/2020 */
        Bingo.checkAllNUmbers();
        LargestIncrementalNumber.findLargestIncrementalNumber();
        DeskArrangement.maxStudentsWithoutCheating();
        TeamLeadName.maxNonRepetitiveLetters();

        /* Oracle Interview: 08/07/2020 */
        ThreadSync.computeWithWaitAndNotify();
        LargestNonRepeatingSubstr.findlargestSubString();
        LargestInteger.findLargestIntegerWithOneRemoval();
    }
}
