package com.sumanth.algos;
/*
   Give source string s and destination string t, by shifting atmost k times, evaluate whether the destination string t can be achieved

   Constraints:
   A char from src can be chosen atmost once for shifting
   Shifting after character z will return to a as a circular list

   1<=k<=N

   Example:
   s="abc" t="ddd" k=3 -> true
   s="xyz" t="abc" k=2 -> false
 */
public class StringGame {
    private static String alphabets="abcdefghijklmnopqrstuvwxyz";

    public static void findMatchWithKShifting() {
        String s="xyz";
        String t="abc";
        int k=3;

        boolean match=canAchieve(k,s,t);
        System.out.println(match);
    }

    // Method which returns whether t can be achieved or not
    private static boolean canAchieve(int k, String s, String t) {
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char src=s.charAt(i);
            char dst=t.charAt(i);

            //Edge case to check number
            if(Character.isDigit(src)||Character.isDigit(dst)){
                return false;
            }
            for (int j = 0; j <=k; j++) {
                // shift source char by j
                char shiftedChar = giveNextCharacter(src,j);
                if(shiftedChar==dst){
                    res.append(shiftedChar);
                    break;
                }
            }
        }

        // shifted string matches or not
        if(res.toString().equals(t)){
            return true;
        }
        return false;
    }

    // Gives next char for given shift value in a circular fashion
    private static char giveNextCharacter(char ch, int shift){
        int index=alphabets.indexOf(ch);
        int shiftedIndex=(index+shift)%26;
        return alphabets.charAt(shiftedIndex);
    }
}
