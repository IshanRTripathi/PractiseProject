package mystifly;

public class Employee {
    String employeeName;
    int employeeId;
    String designation;

    public Employee(String employeeName, int employeeId, String designation) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "employeeName='" + employeeName + '\'' +
            ", employeeId=" + employeeId +
            ", designation='" + designation + '\'' +
            '}';
    }
}
