package callable;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        service.insertEmployee(1,"chaitanya",4000.00);
    }
}
