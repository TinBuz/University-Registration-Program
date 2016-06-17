
/**
 * (NEW)The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context. The Student is a subclass of member
 * and shares 3 instance variables(name, memberID, and department) as well as all the methods within
 * the Member Class.
 * 
 * @author (Tin Buzancic)
 * @version (2/24/2015)
 */
public class Student extends Member
{
    private int credits;

    /**
     * Create a new student with a given name, ID number, and Department.
     * @param
     * String Takes a String of the Students Full Name.
     * Long Takes a long of numberic value of studentID
     * Dept Takes a Dept Enum type for the major.
     */
    public Student(String fullName, long studentID, Dept dept)
    {
        super(fullName, studentID, dept);        
        this.credits = 0;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     * @param
     * int Takes an int of any additional credit points needed to be added.
     */
    public void addCredits(int additionalPoints)
    {
        this.credits += additionalPoints;
    }

    /**
     * @return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }
    
    /**
     * Overriding toString() method which is inherited from the superclass.
     * @return
     * String representation of the students info.
     */
    public String toString()
    {
        return super.toString() + " - " + credits + " credits";
    }
}
