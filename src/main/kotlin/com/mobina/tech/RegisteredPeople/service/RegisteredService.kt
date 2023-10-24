package com.mobina.tech.RegisteredPeople.service

import com.mobina.tech.RegisteredPeople.entity.Address
import com.mobina.tech.RegisteredPeople.entity.Registered
import com.mobina.tech.RegisteredPeople.repository.AddressRepository
import com.mobina.tech.RegisteredPeople.repository.RegisteredRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.*
@Service
@Transactional
class RegisteredService {

    @Autowired
    lateinit var registeredRepository: RegisteredRepository;
    @Autowired
    lateinit var addressRepository: AddressRepository;

    fun saveRegistered(@RequestBody registered: List<Registered>): MutableList<Registered> {
        return registeredRepository.saveAll(registered)
    }

    fun getRegistered(): MutableList<Registered> {
        return registeredRepository.findAll();
    }

    fun getRegisteredById(id: Long): Optional<Registered> {
        return registeredRepository.findById(id);

    }

    fun deleteRegidteredByPosition(position: String): MutableList<Registered> {
        return registeredRepository.deleteAllByPosition(position);
    }

    fun getRegisteredByPosition(position: String): Registered {
        return registeredRepository.findTop2ByPositionOrderByAge(position)
    }

    fun saveAll(registered: List<Registered>): ResponseEntity<String> {
        registeredRepository.saveAll(registered)
        return ResponseEntity.ok("Data Saved")
    }

    fun assignAddressToRegistered(id: Long, addressId: Long): Registered? {
        var addressSet:MutableSet<Address>? = null;
        val registered:Registered = registeredRepository.findById(id).get()
        val address:Address = addressRepository.findById(addressId).get()
        addressSet = registered.get_assignedAddress()
        addressSet.add(address)
        registered.set_assignedAddress(addressSet)
        return registeredRepository.save(registered)
    }
}