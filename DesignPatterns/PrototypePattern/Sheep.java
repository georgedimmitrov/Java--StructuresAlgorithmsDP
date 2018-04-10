package DesignPatterns.PrototypePattern;

public class Sheep implements Animal {

    public Sheep() {
        System.out.println("Sheep is made.");
    }

    @Override
    public Animal makeCopy() {
        System.out.println("Sheep is being made.");

        Sheep sheepObject = null;

        try {
            // Calls the Animal super class' clone()
            // Then casts the results to Sheep

            sheepObject = (Sheep) super.clone();
        }
        // If Animal didn't extend Cloneable this error
        // is thrown
        catch (CloneNotSupportedException e) {
            System.out.println("The Sheep was Turned to Mush");

            e.printStackTrace();
        }

        return sheepObject;
    }

    public String toString(){
        return "Dolly is the sheep.";
    }
}
