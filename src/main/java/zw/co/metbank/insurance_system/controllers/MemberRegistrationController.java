package zw.co.metbank.insurance_system.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.metbank.insurance_system.services.MemberRegistrationService;
import zw.co.metbank.insurance_system.users.Company;
import zw.co.metbank.insurance_system.users.Person;

import java.util.List;

@RestController
@RequestMapping(value="/insurance/member-registration")
@Slf4j
public class MemberRegistrationController {
    @Autowired
    private MemberRegistrationService memberRegistrationService;


    //########### CLIENT PERSON REGISTRATION API


    @PostMapping(value="/person")
    public ResponseEntity<Person> newClientPerson(@RequestBody Person person){
       // log.info(person.getEmail());
        Person savedPerson = memberRegistrationService.newClientPerson(person);
        if(savedPerson!=null)
            return new ResponseEntity<>(savedPerson, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @PutMapping(value="/person")
    public ResponseEntity<Person> updateClientPerson(@RequestBody Person person){
        Person savedPerson = memberRegistrationService.updateClientPerson(person);
        if(savedPerson!=null)
            return new ResponseEntity<>(person, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @GetMapping(value="/person/{id}")
    public ResponseEntity<Person> person(@PathVariable("id") Integer id){
        Person person = memberRegistrationService.person(id);
        if(person != null)
            return new ResponseEntity<>(person,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/person")
    public ResponseEntity<List<Person>> allPersons(){
        List<Person> persons = memberRegistrationService.allClientPersons();
        if(persons != null)
            return new ResponseEntity<>(persons,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @DeleteMapping(value="/person/{id}")
    public ResponseEntity<Person> removePerson(@PathVariable("id") Integer id){
        Person person = memberRegistrationService.removePerson(id);
        if (person!=null){
            return new ResponseEntity<>(person,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }




    //########### CLIENT COMPANY REGISTRATION API


    @PostMapping(value="/company")
    public ResponseEntity<Company> newClientCompany(@RequestBody Company company){
        Company savedCompany = memberRegistrationService.newClientCompany(company);
        if(savedCompany!=null)
            return new ResponseEntity<>(savedCompany, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @PutMapping(value="/company")
    public ResponseEntity<Company> updateClientCompany(@RequestBody Company company){
        Company savedCompany = memberRegistrationService.updateClientCompany(company);
        if(savedCompany!=null)
            return new ResponseEntity<>(savedCompany, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @GetMapping(value="/company/{id}")
    public ResponseEntity<Company> company(@PathVariable("id") Integer id){
        Company company = memberRegistrationService.company(id);
        if(company != null)
            return new ResponseEntity<>(company,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/company")
    public ResponseEntity<List<Company>> allCompanies(){
        List<Company> companies = memberRegistrationService.allClientCompanies();
        if(companies != null)
            return new ResponseEntity<>(companies,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @DeleteMapping(value="/company/{id}")
    public ResponseEntity<Company> removeCompany(@PathVariable("id") Integer id){
        Company company = memberRegistrationService.removeCompany(id);
        if (company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
