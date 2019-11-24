package javabeans02;
/**
   @author Faisal Akhtar
 */
class EmployeeBeans implements java.io.Serializable {
    private int employeeID;
    private String name;
    
    public EmployeeBeans() {
    }
    
    public void SetEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    public int GetEmployeeID() {
        return this.employeeID;
    }
    
    public void SetName(String name) {
        this.name = name;
    }
    
    public String GetName() {
        return this.name;
    }
}

public class JavaBeans02 {

    public static void main(String[] args) {
        EmployeeBeans a = new EmployeeBeans();
        a.SetEmployeeID(1001);
        a.SetName("Faisal");
        
        System.out.println("Employee ID: " + a.GetEmployeeID());
        System.out.println("Employee name: " + a.GetName());
    }
    
}
