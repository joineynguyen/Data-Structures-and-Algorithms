/*
Joiney Nguyen

Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.

Implement the ParkingSystem class:

ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class. The number of slots for each parking space are given as part of the constructor.
bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get into the parking lot. carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively. A car can only park in a parking space of its carType. If there is no space available, return false, else park the car in that size space and return true.

*/

class ParkingSystem 
{
    int bigSize, mediumSize, smallSize;
    int bigCount, mediumCount, smallCount = 0;
    
    public ParkingSystem(int big, int medium, int small) 
    {
        bigSize = big;
        mediumSize = medium;
        smallSize = small;
    }
    
    public boolean addCar(int carType) 
    {
        if(carType == 1)
        {
            if(bigCount < bigSize)
            {
                bigCount++;
                return true;
            }
        }
        else if(carType == 2)
        {
            if(mediumCount < mediumSize)
            {
                mediumCount++;
                return true;
            }
        }
        else if(carType == 3)
        {
            if(smallCount < smallSize)
            {
                smallCount++;
                return true;
            }
        }
        
        return false;
    }
    
    
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
