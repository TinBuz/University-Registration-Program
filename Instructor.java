
/**
 * The Instructor class represents an Instructor in this University's administration system.
 * It holds all Instructor details relevant to our situation.
 * 
 * @author (Tin Buzancic)
 * @version (2/24/2015)
 */
public class Instructor extends Member
{ 
    private String title;

    /**
     * Constructor for in the Instructor Class using 4 passed parameters.(3 from superclass, 1 independant).
     * @param
     * String Takes a String of the Instructor's name.
     * long Takes a long of the Instructor's ID.
     * Dept Takes a Dept Enum type provided of the designated Department
     * String Takes a title for the specific Instructor
     */
    public Instructor(String name, long instructorID, Dept dept, String title)
    {
        super(name, instructorID, dept);
        this.title = title;
    }
    
    public String toString()
    {
        return super.toString() + " - " + title;
    }
    
    //GETTERS AND SETTERS
    
    /**
     * Accessor method for the unique title field for the Instructor Class.
     * @return
     * String title of the instructor.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Mutator method for the title field for the Instructor Class
     * @param
     * String Takes a new title you wish to assign to the field title of Instructor class.
     */
    public void changeTitle(String newTitle)
    {
        this.title = newTitle;
    }
}
 
