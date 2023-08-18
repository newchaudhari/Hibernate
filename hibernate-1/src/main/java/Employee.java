import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
//    @Column(name = "employee_id")
    private int employeeId;
    private String employeeName;
    private int employeeSalary;
}
