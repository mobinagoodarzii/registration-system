package com.mobina.tech.RegisteredPeople.repository

import com.mobina.tech.RegisteredPeople.entity.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<Address, Long>{
}