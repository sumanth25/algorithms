package com.sumanth.algos;
/*
Write a program, that takes the names of all the five people in a team and tells who should
 be the team lead.

Input
Five line input with the names of the employee in each line of the input

Output

Name of the lead

Your program should decide the team lead based on simple criteria, one who has a
maximum number of letters (ignoring the duplicates and spaces) in his/her name would
be the team lead. If there is a tie choose the one whose name comes early in alphabetical order.

The maximum number of letters in the name "Mickey mouse" (ignoring the duplicates and spaces)
is 9. Note: Here, "M" and "m" are treated as duplicate letters.

Example
Test Case

Input:
kylan charles
raymond strickland
julissa shepard
andrea meza
destiney alvarado

Output:
raymond strickland

Explaination:

kylan charles (number of letters: 10)

raymond strickland (number of letters: 13)

julissa shepard (number of letters: 11)

andrea meza (number of letters: 7)

destiney alvarado (number of letters: 12)
 */
public class TeamLeadName {

    public static void maxNonRepetitiveLetters(){
        String[] inputNames={"kylan charles",
                "andrea meza",
                "strickland raymond",
                "destiney alvarado",
                "raymond strickland"};
        String teamLead="";
        int maxLength=0;
        for (String input: inputNames) {
            int length =removeDuplicatesAndSpaceAndCountLength(input);
            if(length>maxLength){
                maxLength=length;
                teamLead=input;
            }else if(length==maxLength){
                //check equal case and resolve lexographical order
               if(input.compareTo(teamLead)<0){
                   teamLead=input;
               }
            }
        }
        System.out.println("Team Lead is "+teamLead+ " and max length is "+maxLength);
    }

    // Algorithm to remove duplicates, space and count length
    private static int removeDuplicatesAndSpaceAndCountLength(String input) {
        //convert all string to lower case
        String lowerCase=input.toLowerCase();

        //remove all whitespaces
        String lowerCaseWithoutSpaces = lowerCase.replaceAll("\\s", "");

        //remove duplicates
        StringBuilder sb=new StringBuilder();
        lowerCaseWithoutSpaces.chars().distinct().forEach(ch -> sb.append((char)ch));
        return sb.toString().length();
    }

}
