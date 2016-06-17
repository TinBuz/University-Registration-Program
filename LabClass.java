import java.util.*;

/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 * 
 * @author (Tin Buzancic)
 * @version (2/24/2015)
 */
public class LabClass
{
    //INSTANCE VARIABLES

    private Member instructor;
    private String courseName;
    private String room;
    private String timeAndDay;
    private ArrayList<Student> students;
    private int capacity;

    /**
     * Default constructor for a LabClass object. It takes two parameters, and sets the remaining unused instance variables to
     * the default values listed below.
     * @param
     * int Max number of Students for a desired LabClass
     * String Name for the desired Course.
     */
    public LabClass(int maxNumberOfStudents, String courseName)
    {
        // Initializing the instance instructor within the labclass to a new Instructor with unique parameters.
        this.instructor = new Member("STAFF", -1000, null);
        this.courseName = courseName.toUpperCase().trim();
        this.room = "unknown";
        this.timeAndDay = "unknown";
        this.students = new ArrayList<Student>();
        this.capacity = maxNumberOfStudents;
    }

    /**
     * Add a student to the current LabClass. If the arraylist size passes the capacity, an "error" message will appear.
     * If the arraylist size is less than the capacity, the enrollStudent() method will add the newStudent Student to the ArrayList
     * of Students.
     * @param
     * Student takes a parameter of Student to be added to a class.
     */
    public void enrollStudent(Student newStudent)
    {
        if(students.size() == capacity) {
            System.out.println("The class is full, you cannot enroll.");
        }
        else {
            students.add(newStudent);
        }
    }
    
    /**
     * The following method first checks a conditional statement based the size of the students ArrayList. If the size is zero, the method
     * branches off into a error test and prints "none". If the arrayList size is not equal to 0, then the else statement will trigger,
     * neatly printing information base on the current LabClass and it's students.
     */
    public void printList()
    {
        if(students.size() == 0)
        {
            System.out.println("None");
        }
        else
        {
            System.out.println("Lab class: " + this.timeAndDay);
            System.out.println("Instructor: " + instructor.getNameString());
            System.out.println("Room: " + this.room);
            System.out.println("Course Name: " + this.courseName);
            System.out.println("Class list:");
            for(Student student : students) {
                System.out.println(student);
            }
            System.out.println("Number of students: " + numberOfStudents() + "\n");
        }
    }

    /**
     * The method below prints the avaiability of a class. It will print the courseName, name of the Instructor, and the current capacity
     * based on the number of students enrolled in the class.
     */
    public void printClassAvailability()
    {
        System.out.println(this.courseName + " (" + this.instructor.getNameString() + ") - " + (this.capacity - students.size()) + " available");
    }

    //GETTERS AND SETTERS

    /**
     * @return the number of students currently enrolled in this LabClass.
     */
    public int numberOfStudents()
    {
        return students.size();
    }

    /**
     * Set the room number for the current LabClass.
     * @param takes in aa room number which gets set to room.
     */
    public void setRoom(String roomNumber)
    {
        this.room = roomNumber;
    }

    /**
     * @param
     * String takes a String as a parameter to be assigned to the instance variable timeAndDay.
     * Set the time for this LabClass. The parameter should define the day
     * and the time of day, such as "Friday, 10am".
     */
    public void setTime(String timeAndDayString)
    {
        this.timeAndDay = timeAndDayString;
    }

    /**
     * Modified setInstructor which uses the Instructor class instead of the previous String name parameter.
     * Instead of passing a name, you pass the actual Instructor which contains even more unique fields.
     * @param
     * Instructor takes an Instructor as aparameter to be assigned to the instance variable instructor.
     */
    public void setInstructor(Member instructorName)
    {
        this.instructor = instructorName;
    }

    /**
     * @return the object Instructor as a String.
     */
    public String getInstructor()
    {
        String stringInstructor = "" + instructor.toString();
        return stringInstructor;
    }

    /**
     * @return the courseName as a String.
     */
    public String getCourseName()
    {
        return courseName;
    }

    /**
     * @return the room as a String.
     */
    public String getRoom()
    {
        return room;
    }

    /**
     * @return the timeAndDay as a String.
     */
    public String getTimeAndDay()
    {
        return timeAndDay;
    }

    /**
     * @return the capacity(of a designated course) as an int.
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * @return students as an arraylist.
     */
    public ArrayList<Student> getStudents()
    {
        return students;
    }
}
