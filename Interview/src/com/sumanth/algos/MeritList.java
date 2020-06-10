package com.sumanth.algos;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Problem: Display merit list of students with rollNo and name with decreasing order of marks
If same marks, then lexographically sorted name
If same names, then increasing order of roll number
Input (no. of records, student records{name,roll,marks)):
3
Luna, 356, 35
Ron weasley, 289, 35
hermione granger, 533, 36
Validations:
name-only letters with spaces
roll-atmost 6 positive digits
marks-atmost 2 positive digits
Output:
533 hermione granger
356 Luna
289 Ron weasley
 */
class check implements Comparable<check> {
    public int roll, marks;
    public String name;

    public check(String name, int roll, int marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public String print() {
        return (roll + " " + name);
    }

    public int compareTo(check o) {
        //merit list is deceasing order of <marks>
        if (this.marks < o.marks) {
            return 1;
        } else if (this.marks > o.marks) {
            return -1;
        } else if (this.marks == o.marks) {
            //if same <marks>, then tie will be broken on <student_name>.
            if (this.name.compareTo(o.name) > 0) {
                return 1;
            } else if (this.name.compareTo(o.name) < 0) {
                return -1;
            } else if (this.name.compareTo(o.name) == 0) {
                //if same <student_name>, then student with smaller <roll_no>
                if (this.roll > o.roll)
                    return 1;
            } else if (this.roll < o.roll) {
                return -1;
            } else if (this.roll == o.roll) {
                return 0;
            }
        }
        return 0;
    }
}

public class MeritList
{
    public static void showMeritList()
    {
        System.out.println("Enter input values for merit list");
        int t;
        BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
        List<check> records = new ArrayList<check>();
        try{
            t =Integer.parseInt(input.readLine());

            while(t > 0 && t<=50)
            {
                String a = input.readLine();
                List<String> temp = Arrays.asList(a.split(","));
                String name = temp.get(0);
                //check if only letters and spaces
                String nameRegex="^[ A-Za-z]+$";
                boolean isNameValid=validateInput(name,nameRegex);
                String rollNo=temp.get(1).trim();
                String rollRegex="^\\d{1,6}$";
                boolean isRollValid=validateInput(rollNo,rollRegex);
                String marksValue=temp.get(2).trim();
                String marksRegex="^\\d{1,2}$";
                boolean isMarksValid=validateInput(marksValue,marksRegex);
                if(isNameValid&&isRollValid&&isMarksValid){
                    int roll=Integer.parseInt(rollNo);
                    int marks = Integer.parseInt(marksValue);
                    records.add(new check(name, roll, marks));
                }else{
                    if(!isNameValid){
                        System.out.println("Invalid Name: "+name);
                    }
                    if(!isRollValid){
                        System.out.println("Invalid Roll: "+rollNo);
                    }
                    if(!isMarksValid){
                        System.out.println("Invalid Marks: "+marksValue);
                    }

                }
                t--;
            }
        }catch (java.lang.Exception e){
            System.out.println("Error occurred while reading input");
        }

        Collections.sort(records);

        for(int i=0; i<records.size(); i++)
            System.out.println(records.get(i).print());

    }

    //validate input
    private static boolean validateInput(String name, String nameRegex) {
        Pattern pName= Pattern.compile(nameRegex);
        Matcher mName = pName.matcher(name);
        String validName="";
        return mName.matches();
    }
}
