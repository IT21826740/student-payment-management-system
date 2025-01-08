package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lk.zerocode.student_payment_management_system.models.options.FeeType;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private float amount;

    private FeeType type;

    @ManyToMany
    @JoinTable(
            name = "fee_payment_plan", // Join table name
            joinColumns = @JoinColumn(name = "fee_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_plan_id")
    )
    private List<PaymentPlans> paymentPlans;

}
