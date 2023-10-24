package com.mobina.tech.RegisteredPeople.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.transaction.Transactional
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "address")
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "add_id")
    val addressId: Long? = null;
    val city: String? = null;
    val addressType: String? = null;

//    @OneToOne(mappedBy = "address")
//    val registered: Registered? = null;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedAddress")
    val registered: MutableSet<Registered> = mutableSetOf();
}