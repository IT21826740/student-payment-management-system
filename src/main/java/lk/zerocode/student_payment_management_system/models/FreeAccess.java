package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "free_access")
public class FreeAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hold_start_date")
    private  LocalDate holdStartDate;

    @Column(name = "hold_end_date")
    private LocalDate holdEndDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // One-to-One relationship with Attendance
    @OneToOne(mappedBy = "freeAccess",cascade = CascadeType.ALL)
    private Attendance attendance;

}
