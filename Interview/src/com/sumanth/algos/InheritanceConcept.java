package com.sumanth.algos;

import java.util.ArrayList;
import java.util.List;
/*
   What is the output being printed
 */

class Animal {
    public void print(){
        System.out.println("Animal");
    }
}

class Dog extends Animal{
    public void print(){
        System.out.println("Dog");
    }
}

public class InheritanceConcept {

    public static void output() {
        List<Dog> dogs= new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        List<Animal> animals = new ArrayList<Animal>();

        // Cannot assign objects of type dog to animals -> Compile time error
        //animals = dogs;

        animals.forEach(a->a.print());
    }
}
