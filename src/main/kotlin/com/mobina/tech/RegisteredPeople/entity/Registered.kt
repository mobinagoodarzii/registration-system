package com.mobina.tech.RegisteredPeople.entity

import jakarta.persistence.*
import jakarta.transaction.Transactional
import lombok.Data;
import lombok.NoArgsConstructor

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "registered_details")
class Registered {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "registered_id")
    val id: Long? = null;
    val name: String? = null;
    val age: Int? = null;
    val position: String? = null;
    val phoneNumber: Int? = null;
    
//    address_add_id
//    @OneToOne(cascade = arrayOf(CascadeType.ALL))
//    @JoinColumn(name = "fk_add_id")

//    @OneToMany(cascade = arrayOf(CascadeType.ALL))
//    @JoinColumn(name = "fk_reg_id", referencedColumnName = "registered_id")
//    val address : MutableList<Address>? =null;

    @ManyToMany
    @JoinTable(name = "registered_address",
        joinColumns = [JoinColumn(name = "registered_id")],
        inverseJoinColumns = [JoinColumn(name = "address_id")])

    var assignedAddress: MutableSet<Address> =  mutableSetOf();
    fun get_assignedAddress() = assignedAddress
    fun set_assignedAddress(value:MutableSet<Address>) { assignedAddress = value }
}
