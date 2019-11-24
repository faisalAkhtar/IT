package javabeans01;
/**
   @author Faisal Akhtar
 */
class StudentBeans implements java.io.Serializable {
    private int rollNo;
    private String name;

    public StudentBeans() {
    }
    
    public void SetRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    
    public int GetRollNo() {
        return this.rollNo;
    }
    
    public void SetName(String name) {
        this.name = name;
    }
    
    public String GetName() {
        return this.name;
    }
}

public class JavaBeans01 {

    public static void main(String[] args) {
        StudentBeans a = new StudentBeans();
        a.SetRollNo(10);
        a.SetName("Faisal");
        
        System.out.println("Student roll no.: " + a.GetRollNo());
        System.out.println("Student name: " + a.GetName());
    }
    
}
