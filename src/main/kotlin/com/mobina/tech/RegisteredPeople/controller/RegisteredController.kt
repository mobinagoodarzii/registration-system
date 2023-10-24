package com.mobina.tech.RegisteredPeople.controller

import com.mobina.tech.RegisteredPeople.entity.Registered
import com.mobina.tech.RegisteredPeople.service.RegisteredService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class RegisteredController {

    @Autowired
    var registeredService = RegisteredService()

    @PostMapping("/saveRegistered")
    fun saveRegistered(@RequestBody registered: List<Registered>): ResponseEntity<String> {
        registeredService.saveAll(registered)
        return ResponseEntity.ok("Data Saved")
    }
    @GetMapping("/getRegistered")
    fun getRegistered():MutableList<Registered>{
        return registeredService.getRegistered();
    }

    @GetMapping("/getRegisteredById/{id}")
    fun getRegisteredById(@PathVariable id: Long): Optional<Registered> {
        return registeredService.getRegisteredById(id);
    }
    @DeleteMapping("/deleteRegisteredByPosition/{position}")
    fun deleteRegisteredByPosition(@PathVariable position: String): MutableList<Registered>{
        return registeredService.deleteRegidteredByPosition(position);
    }
    @GetMapping("/getRegisteredByPosition/{position}")
    fun getRegisteredByPosition(@PathVariable position: String):Registered{
        return registeredService.getRegisteredByPosition(position);
    }
    @PutMapping("{id}/address/{addressId}")
    fun assignAddressToRegistered(@PathVariable id: Long, @PathVariable addressId: Long):Registered?{
        return registeredService.assignAddressToRegistered(id, addressId);
    }
}
