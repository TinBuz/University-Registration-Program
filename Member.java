
/**
 * This is the Superclass Member with subclasses Student and Instructor. This is where the subclasses
 * retrieve most methods and the three fields for the super constructor.
 * 
 * @author (Tin Buzancic) 
 * @version (2/24/2015)
 */
public class Member
{
    private String name;
    private long memberId;
    private Dept dept;

    /**
     * Constructor for objects of class Member
     * @param
     * String Takes a String as the Members name.
     * long Takes a long for the memberId.
     * Dept Takes an enum class Dept for the department of the member.
     */
    public Member(String name, long memberId, Dept dept)
    {
        this.name = name.toUpperCase().trim();
        this.memberId = memberId;
        this.dept = dept;
    }

    /**
     * Method to print the information of a Member Object. Now Instructors or Students can use this
     * method.
     */
    public String toString()
    {
        return "   " + name + " #" + memberId + " " + dept;
    }

    /**
     * Compares two members based on their id field ONLY. 
     * @param
     * Object the user wishes to compare to the member class and check the IDs
     */
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;  
        }
        if(!(obj instanceof Member))
        {
            return false;
        }
        Member member = (Member) obj;
        if(this.memberId == member.memberId)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //GETTERS AND SETTERS

    /**
     * Accessor for Member class name.
     * @return
     * String Instance Variable of Member Class name.
     */
    protected String getNameString()
    {
        return this.name;
    }

    /**
     * Accessor method for memberId.
     * @return
     * Instance Class Variable of memberId of Member.
     */
    protected String getMemberIdString()
    {
        return "" + this.memberId;
    }

    /**
     * Accessor method for Member Department
     * @return
     * Instance Class Variable of dept of Member.
     */
    protected String getDeptString()
    {
        return this.dept.toString();
    }

    /**
     * Mutator for the Member Class name field. Option to change the name.
     * @param
     * String of the new name you wish to name the Member
     */
    public void changeName(String newName)
    {
        this.name = newName.toUpperCase().trim();
    }

    /**
     * Mutator for the Member Class dept field. Option to change the department.
     * @param
     * Dept of the new Department you wish to assign the Member.
     */
    public void changeDept(Dept newDept)
    {
        this.dept = newDept;
    }
}
