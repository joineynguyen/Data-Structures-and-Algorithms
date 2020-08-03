/* Joiney Nguyen
*
* An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
* out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
* or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
* that type). They cannot select which specific animal they would like. Create the data structures to
* maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
* and dequeueCat. You may use the built-in Linked List data structure. 
*/
import java.util.*;

abstract class Animal
{
    String type;
    int order;

    public Animal()
    {
        this.type = type;
    }

    public void setOrder(int order)
    {
        this.order = order;
    }

 
}

class Dog extends Animal
{
    public Dog()
    {
        this.type = "dog";
    }
}

class Cat extends Animal
{
    public Cat()
    {
        this.type = "cat";
    }
}

class AnimalShelter
{
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();

    int count = 0;

    public void enqueue(Animal animal) throws Exception
    {
        boolean isDog = animal.type.equals("dog");
        boolean isCat = animal.type.equals("cat");

        if(!isDog && !isCat)
        {
            throw new Exception("This is not a dog or cat");
        }

        animal.setOrder(count++);

        if(isDog)
        {
            dogs.add((Dog) animal);
        }
        else if(isCat)
        {
            cats.add((Cat) animal);
        }
    }

    public void dequeueAny() throws Exception
    {
        
        boolean noDogs = dogs.isEmpty();
        boolean noCats = cats.isEmpty();
        //used to randomly return cat or dog if both animals have same order index
        Random coinFlipper = new Random();


        //if no dogs or cats, exit
        if(noCats && noDogs)
        {
            throw new Exception("There are no dogs or cats available!");
        }
        //if no cats, return the first dog queue'd in
        else if(noCats)
        {
            dogs.poll();
        }
        //if no dogs, return the first cat queue'd in
        else if(noDogs)
        {
            cats.poll();
        }
        //if there are both dogs and cats available
        else
        {
            //peek each first animal queue'd in to see who was first between two

            //if first dog's order index is less than first cat order index, return dog
            if(dogs.peek().order < cats.peek().order)
            {
                dogs.poll();
            }
            //if first cat's order index is less than first dog order index, return cat
            else if(cats.peek().order < dogs.peek().order)
            {
                cats.poll();
            }
            //if first cat and first dog have same order index
            else if(dogs.peek().order == dogs.peek().order)
            {
                if(coinFlipper.nextBoolean())
                {
                    dogs.poll();
                }
                else
                {
                    cats.poll();
                }
            }
        }

    }

    public void dequeueCat() throws Exception
    {
        if(cats.isEmpty())
        {
            throw new Exception("There are no more cats!");
        }

        cats.poll();
    }

    public void dequeueDog() throws Exception
    {
        if(dogs.isEmpty())
        {
            throw new Exception("There are no more dogs!");
        }

        dogs.poll();
    }

}

class Main
{
    
    public static void main(String[] args) throws Exception
    {
        AnimalShelter myShelter = new AnimalShelter();

        myShelter.enqueue(new Dog());
        myShelter.enqueue(new Dog());
        myShelter.enqueue(new Dog());
        myShelter.enqueue(new Cat());
        myShelter.enqueue(new Cat());
        myShelter.enqueue(new Cat());
        myShelter.enqueue(new Cat());
        myShelter.enqueue(new Cat());
        myShelter.enqueue(new Cat());
        myShelter.dequeueAny();
        myShelter.dequeueCat();
        myShelter.dequeueDog();

        System.out.println(myShelter.dogs.size());
        System.out.println(myShelter.cats.size());

    }

}

