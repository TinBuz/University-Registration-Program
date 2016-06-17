import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UniversityTest. Here you can see the toUpperCase() method works as well as all the
 * methods we created step by step in the lab. The meat of the test ficture is within the setUp().
 *
 * @author  (Tin Buzancic)
 * @version (2/24/2015)
 */
public class UniversityTest
{
    private University rowanU;
    

    /**
     * Default constructor for test class UniversityTest
     */
    public UniversityTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        rowanU = new University("rowaN uniVersity");
        rowanU.hireInstructor("instructor1", Dept.CSCI, "title1");
        rowanU.hireInstructor("instructor2", Dept.MATH, "title2");
        rowanU.admitStudent("student1", Dept.CSCI);
        rowanU.admitStudent("student2", Dept.ENGR);
        rowanU.admitStudent("student3", Dept.MEDC);
        rowanU.addClass("ioop1", 25);
        rowanU.addClass("ioop2", 25);
        rowanU.addClass("oopda3", 25);
        rowanU.addClass("oopda4", 25);
        rowanU.listMembers();
        rowanU.listClassesAvail();
        rowanU.assignInstructor(246355679, 1695);
        rowanU.assignInstructor(653298563, 1387);
        rowanU.assignInstructor(668855270, 9607);
        rowanU.registerStudentInClass(668855270, 1387);
        rowanU.registerStudentInClass(44266473, 9607);
        rowanU.registerStudentInClass(44266473, 1387);
        rowanU.registerStudentInClass(773005675, 3777);
        rowanU.registerStudentInClass(773005675, 9607);
        rowanU.registerStudentInClass(773005675, 1387);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
