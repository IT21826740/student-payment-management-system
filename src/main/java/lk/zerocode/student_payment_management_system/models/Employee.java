package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "fiscal_code" , nullable = false)
    private  String fiscalCode;

    @Column(name = "mobile_number",nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private  String address;

    @Column(name = "job_role", nullable = false)
    private String jobRole;


}
