import java.util.Scanner;

/**
 * Sensor Readings (6.2CR  Objects with more abilities)
 * 
 * @author Abhishek Tamang
 */

public class DataHandling{
    
    //This method asks the users to select a sensor from a list of sensors created using enum and returns it
    public static SensorData.Type sensorGenre(Scanner input){
        
        int choice;//variable used to choose the type of sensor
        SensorData.Type sensorType = null;//variable to store user's choice
        System.out.println("Choose from the given variety of sensors:- ");
        System.out.println("1: TEMPERATURE");
        System.out.println("2: HUMIDITY");
        System.out.println("3: LIGHT");
        System.out.println("Enter a number to select your sensor type: ");
        choice = input.nextInt();
        switch(choice){
            
            case 1:
                sensorType = SensorData.Type.TEMPERATURE;
                break;
                
            case 2:
                sensorType = SensorData.Type.HUMIDITY;
                break;
                
            case 3:
                sensorType = SensorData.Type.LIGHT;
                break;
                
            default:
               System.out.println("No opttions found for sensor.");
        }
        return sensorType;
    }
    
    /** This method reads sensor's reading from the user
      * instantiates a new Reading object using those details
      * ensures there is a meaningful annotation provided (its length is at least 15) 
      * asks for the values to be re-entered if annotation's length gets less than 15
      * returns that object to the calling code in main()
      **/
    public static SensorData readReading(Scanner input){ 
        
        String annotation;//Short description of input sensor 
        int readingId;//reading identification number of the sensors
        double value;//reading value of the sensor
        SensorData user;//Creating a Reading class object named user
        SensorData.Type sensorType;
        do{    
            System.out.println("Enter the brief description of the sensor whose value you want to find:"); 
            annotation = input.next();//Taking user's choice of String input for the annotation variable
            
        }while(annotation.length() <= 15);
        
        System.out.println("Enter the reading id of the sensor?");
        readingId = input.nextInt();//Taking user's choice of integer input for the readingId variable
        System.out.println("Enter the Value of the sensor?");
        value = input.nextDouble();//Taking user's choice of  input for the value variable
        sensorType = sensorGenre(input);//Storing the result of the method sensorGenre
        user = new SensorData(annotation,readingId,value,sensorType);//passing the above values to created user object of Reading class
        return user;//returning the object user from readReading method
    }  
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SensorData reading = null;//Creating and declaring a new Reading class object named reading 
        System.out.println("-Enter reading data-");
        reading = readReading(sc);//passing reading object to readReading method
        System.out.println(reading);//Printing out the String representation of the object reading
        System.out.println(" Sensitivity:"+ reading.getSensitivity());//Displaying the sensitivity of the sensor of reading object
    }
}