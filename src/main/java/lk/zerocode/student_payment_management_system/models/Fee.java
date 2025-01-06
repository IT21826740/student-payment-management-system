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
            joinColumns = @JoinColumn(name = "fee_id"), // Foreign key in join table for Fee
            inverseJoinColumns = @JoinColumn(name = "payment_plan_id") // Foreign key for PaymentPlans
    )
    private List<PaymentPlans> paymentPlans;

    public Fee() {
    }

    public Fee(Long id, String title, float amount, FeeType type) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.type = type;
    }
}
