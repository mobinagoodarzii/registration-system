package com.mobina.tech.RegisteredPeople.repository

import com.mobina.tech.RegisteredPeople.entity.Registered
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RegisteredRepository : JpaRepository<Registered, Long>{
    override fun findById(id:Long): Optional<Registered>;
    fun deleteAllByPosition(position:String):MutableList<Registered>;
    fun findTop2ByPositionOrderByAge(position: String): Registered
}