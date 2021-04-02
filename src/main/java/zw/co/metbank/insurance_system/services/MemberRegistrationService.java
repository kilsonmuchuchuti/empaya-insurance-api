package zw.co.metbank.insurance_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.metbank.insurance_system.repositories.CompanyRepository;
import zw.co.metbank.insurance_system.repositories.PersonRepository;
import zw.co.metbank.insurance_system.users.Company;
import zw.co.metbank.insurance_system.users.Person;

import java.util.List;
import java.util.Optional;

@Service
public class MemberRegistrationService implements MemberRegistrationInterface {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public Person newClientPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updateClientPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person person(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if(personOptional.isPresent()){
            return personOptional.get();
        }
        return null;
    }

    @Override
    public List<Person> allClientPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person removePerson(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if(personOptional.isPresent()){
            personRepository.deleteById(personOptional.get().getId());
            return personOptional.get();
        }
        return null;
    }

    @Override
    public Company newClientCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateClientCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company company(Integer id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            return companyOptional.get();
        }
        return null;
    }

    @Override
    public List<Company> allClientCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company removeCompany(Integer id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            companyRepository.deleteById(companyOptional.get().getId());
            return companyOptional.get();
        }
        return null;
    }
}
