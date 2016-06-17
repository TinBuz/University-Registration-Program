import java.util.*;

/**
 * The University class allows the user to create a University with unique methods.
 * The University can add classes generate course numbers and lists the available classes
 * based on the max number of students in a class. 
 * 
 * @author (Tin Buzancic) 
 * @version (2/24/2015)
 */
public class University
{
    public static final int LOW_CNUM = 1000;
    public static final int HIGH_CNUM = 9999;
    public static final int MAX_COURSES = HIGH_CNUM - LOW_CNUM + 1;
    public static final int OUT_OF_BOUNDS = Integer.MIN_VALUE;
    public static final long OUT_OF_BOUNDS_LONG = Long.MIN_VALUE;
    public static final long LOW_ID = 100000000;
    public static final long HIGH_ID = 999999999;
    public static final long MAX_IDS = HIGH_ID - LOW_ID + 1;
    private String univName;
    private TreeMap<Integer, LabClass> classes = new TreeMap<Integer, LabClass>();
    private HashMap<Long, Member> members = new HashMap<Long, Member>();

    /**
     * One-Argument Constructor for objects of class University
     * @param
     * String Accepts a university name as type string
     */
    public University(String univName)
    {
        this.univName = univName.toUpperCase().trim();
        classes = new TreeMap<Integer, LabClass>();
    }

    /**
     * This method Generates the course number, using a cast from long to int with the .random()
     * method.
     * @return
     * Random int based on the algorithms within the generateCourseNumber() method.
     */
    public int generateCourseNumber()
    {
        int courseNumber;
        Random rand = new Random();
        if(classes.size() < MAX_COURSES && (classes != null))
        {
            do
            {
                courseNumber = rand.nextInt(MAX_COURSES) + LOW_CNUM;
            }
            while(classes.containsKey(courseNumber));
            return courseNumber;
        }
        else
        {
            return OUT_OF_BOUNDS;
        }
    }

    /**
     * Method to generate an ID Number. If statement checks if randNumb is taken and if the HashMap
     * is null
     * @return
     * Long out of bounds value if the if statement is true.
     * Long the new ID number if the if statement is false.
     */
    public long generateIdNumber()
    {
        Random rand = new Random();
        int idNumber= rand.nextInt((int)MAX_IDS);
        if(members.containsKey(idNumber) || (members == null))
        {
            return OUT_OF_BOUNDS_LONG;
        }
        else
        {
            return idNumber;
        }
    }

    /**
     *  Returns a unique ID number if one is avaiable.
     *  @return
     *  long
     *  @param
     *  AbstractMap classes of members. Either a tree map or hashmap in this case.
     *  int low number bound
     *  int high number bound
     */
    public long generateUniqueNumber(AbstractMap map, int low, int high)
    {
        if(map == null || map.size() >= high)
        {
            return OUT_OF_BOUNDS_LONG;
        }
        else
        {
            Random rand = new Random();
            int uniqueNum;
            if(map instanceof HashMap)
            {
                do
                {
                    uniqueNum = rand.nextInt(high) + low;
                }
                while(map.containsKey(uniqueNum));
                return (long)uniqueNum;
            }

            else if(map instanceof TreeMap)
            {
                do
                {
                    uniqueNum = rand.nextInt(high) + low;
                }
                while(map.containsKey(uniqueNum));
                return (long)uniqueNum;
            }

            else
            {
                return OUT_OF_BOUNDS_LONG;
            }
        }
    }

    /**
     * This method adds a class to the TreeMap classes
     * @param
     * LabClass takes a LabClass of a designated class you will to add(to the University)
     * @return
     * boolean based on the truth values of the conditional statements.
     */
    public boolean addClass(LabClass labClass)
    {
        long num = generateUniqueNumber(classes, LOW_CNUM, MAX_COURSES);
        if(num != OUT_OF_BOUNDS)
        {
            classes.put((int)num, labClass);
            return true;
        }
        else
        {  
            return false;
        }
    }

    /**
     * This is the overloaded method of addClass with two extra parameters in case labClass is not
     * available
     * @param
     * LabClass takes a LabClass of a designated class you will to add(to the University)
     * String course name of the current class
     * String max number of students possible for the class
     * @return
     * boolean based on the truth values of the conditional statements.
     */
    public boolean addClass(String courseName, int maxStudents)
    {
        LabClass labClass = new LabClass(maxStudents, courseName);
        long num = generateUniqueNumber(classes, LOW_CNUM, MAX_COURSES);
        if(num != OUT_OF_BOUNDS)
        {
            classes.put((int)num, labClass);
            return true;
        }
        else
        {  
            return false;
        }
    }

    /**
     * This method returns a boolean value if the student was added to the university successfully
     * @return
     * boolean
     * @param
     * String name of the Student
     * Dept Desired major of the student
     */
    public boolean admitStudent(String name, Dept major)
    {
        long num = generateUniqueNumber(classes, (int)LOW_ID, (int)MAX_IDS);
        if(num != OUT_OF_BOUNDS_LONG)
        {
            members.put(num, new Student(name, num, major));
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method returns a boolean value if the instructor was added to the university successfully.
     * @return
     * boolean
     * @param
     * String name of the Instructor
     * Dept Desire department they will work in
     * String title of the Instructor
     */
    public boolean hireInstructor(String name, Dept dept, String title)
    {
        long num = generateUniqueNumber(classes, (int)LOW_ID, (int)MAX_IDS);
        if(num != OUT_OF_BOUNDS_LONG)
        {
            members.put(num, new Instructor(name, num, dept, title));
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Method to add member ass instructor to an existing labclass according to the coourse number
     * and existance of a member(soon to be instructor) based on his/her idnumber
     * @return
     * boolean
     * @param
     * long the Id number of the member, soon to be instructor
     * int the course number corresponding to a specific lab class.
     */
    public boolean assignInstructor(long idNumber, int courseNumber)
    {
        if(members != null && members.containsKey(idNumber))
        {
            if(classes != null && classes.containsKey(courseNumber))
            {
                classes.get(courseNumber).setInstructor(members.get(idNumber));
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * method to register the student based on the idNumber passed and into the LabClass based on the
     * course number passed
     * @return
     * boolean
     * @param
     * long the ID number of the member(student)
     * int Course number of the lablcass we wish to enroll the student
     */
    public boolean registerStudentInClass(long idNumber, int courseNumber)
    {
        if((members != null && members.get(idNumber) instanceof Student) && members.containsKey(idNumber))
        {
            if(classes != null && classes.containsKey(courseNumber) && classes.size() < MAX_COURSES)
            {
                classes.get(courseNumber).enrollStudent((Student)members.get(idNumber));
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * method to list all the members involved within the University.
     */
    public void listMembers()
    {
        if(members != null || members.size() != 0)
        {
            System.out.println("TOTAL MEMBERS FOR ROWAN UNIVERSITY: " + members.size());
            for(Member m : members.values())
            {
                System.out.println(m);
            }
        }
        else
        {
            System.out.println("None");
        }
    }

    /**
     * Prints out the courses and all the information(Invoked with the .printClassAvailability()
     * method).
     */
    public void listClassesAvail()
    {
        int i = 0;
        System.out.println("COURSES FOR: " + univName.toUpperCase().trim());
        for(int m: classes.keySet())
        {
            if(classes.get(m) != null)
            {
                System.out.print("   #" + m + " ");
                classes.get(m).printClassAvailability();
                i++;
            }
        }
        if(i == 0)
        {
            System.out.println("   None");
        }
    }

    /**
     * Accessor Method for the members field
     * @return HashMap of hashMembers field
     */
    public HashMap<Long, Member> getMembers()
    {
        return members;
    }

    /**
     * Accessor Methods for two private instance variables
     * @return 
     * String of the universities name.
     */
    public String getUnivName()
    {
        return univName;
    }

    /**
     * @return 
     * Tree map of the classes.
     */
    public TreeMap<Integer, LabClass> getClasses()
    {
        return classes;
    }
}

