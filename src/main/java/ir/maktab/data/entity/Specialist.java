package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Specialist {
    @Id
    private String username;

    private String fullName;

    @Column(unique = true)
    private String email;

    @Enumerated
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Double Balance;

}
