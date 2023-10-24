package com.mobina.tech.RegisteredPeople.controller

import com.mobina.tech.RegisteredPeople.entity.Address
import com.mobina.tech.RegisteredPeople.repository.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AddressController {

    @Autowired
    lateinit var addRepository : AddressRepository;

    @GetMapping("/getAddress")
    fun getAddress():MutableList<Address>{
        return addRepository.findAll();
    }
}