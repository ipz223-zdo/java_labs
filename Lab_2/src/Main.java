import com.education.ztu.Gender;
import com.education.ztu.car.Car;
import com.education.ztu.Location;
import com.education.ztu.Operation;
import com.education.ztu.human.Person;
import com.education.ztu.human.Student;
import com.education.ztu.human.Teacher;
import com.education.ztu.human.Employee;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota");
        car1.engine.startEngine();

        Student student = new Student("Alice", "Smith", 20, Gender.FEMALE, Location.KIEV, "Computer Science", "Software Engineering", "Kiev University");
        Teacher teacher = new Teacher("John", "Doe", 45, Gender.MALE, Location.ZHYTOMYR, car1, "Mathematics", "Zhytomyr University");
        Employee employee = new Employee("Jane", "Doe", 30, Gender.FEMALE, Location.VINNYTSYA, car1, "Tech Corp", "Manager");

        student.getOccupation();
        System.out.println(student.getFullInfo());

        teacher.getOccupation();
        System.out.println(teacher.getFullInfo());

        employee.getOccupation();
        System.out.println(employee.getFullInfo());

        Person.showCounter();

        System.out.println("Is student an instance of Person? " + (student instanceof Person));

        System.out.println("Sum: " + Operation.addition(1, 2, 3, 4, 5));
        System.out.println("Subtraction: " + Operation.subtraction(10, 2, 3));
        System.out.println("Multiplication: " + Operation.multiplication(2, 3, 4));
        System.out.println("Division: " + Operation.division(100, 5, 2));
        System.out.println("Average: " + Operation.average(10, 20, 30, 40, 50));
        System.out.println("Maximum: " + Operation.maximum(3, 7, 1, 9, 5));
        System.out.println("Minimum: " + Operation.minimum(3, 7, 1, 9, 5));

        System.out.println("Locations:");
        for (Location loc : Location.values()) {
            System.out.println(loc);
        }
    }
}