
/**
 * Sensor Readings (6.2CR  Objects with more abilities)
 * 
 * @author Abhishek Tamang
 */
/**
 * This class is used for creating,storing and working with sensor's readings.
 **/
public class SensorData{
    //Declaration of instance variables.
    
    public enum Type{
        TEMPERATURE,LIGHT,HUMIDITY
    }
    
    private String annotation; //Short description of input sensor 
    private int readingId;    //reading identification number
    private double value;    //value of the reading
    static Type sensorType;
    
    //Constructor for initialization of instance variables.
    public SensorData(String sensorName,int readingId,double value,Type sensorType){
        annotation = sensorName;
        this.readingId = readingId;
        this.value = value;
        this.sensorType = sensorType;
    }
    //Getter method for instance variable of enum type
    public Type getType(){
        
        return sensorType;
        
    }
    //Setter method for instance variable of enum type
    public void setType(Type sensorType){
        
        this.sensorType = sensorType;
    }
    
    //Getter method for instance variable annotation.
    public String getAnnotation()
    {
        return annotation;
    }
    
        //Setter method  for instance variable annotaion.
    public void setAnnotaion(String annotation){
        this.annotation = annotation;   
    }
    
    
    //Getter method  for instance variable readingId.
    public int getReadingId()
    {
        return readingId;
    }
    
    //Setter method  for instance variable readingId initializing it with value id.
    public void setReading(int id){
        readingId = id;   
    }
    

    //Getter method  for instance variable value.
    public double getValue(){
        return value;   
    }
    
    //Setter method for instance variable value.
    public void setValue(double value){
        this.value = value;   
    }
    
    public static double getSensitivity(){
       
      double sensitivity = 0.0;//variable to store sensitivity of the sensor depending upon it's type
        switch(sensorType)
        {
            
            case TEMPERATURE:
                sensitivity = 0.1;
                break;
                
            case HUMIDITY:
                sensitivity = 0.5;
                break;
                
           case LIGHT:
                sensitivity = 1;
                 break;
                 
            default:
              break;
                
        }
        return sensitivity;
    };
    
    //toString method for the Reading class objects for generating the string representaion of them.
    public String toString()
    {
        String message = null;// initaializing a string with null value used for returning a string representation. 
        if(value == 0){
            return message = sensorType+" # "+readingId+": "+value+"("+annotation+")" +" check sensor";
        }
        else {if(value > 100){
            return message = sensorType+ "# "+readingId+": "+value+"("+annotation+")" +" check reading";
        }
        else{
            return message =  sensorType+" # "+readingId+": "+value+"("+annotation+")";
        }
        
        }
    }
}





