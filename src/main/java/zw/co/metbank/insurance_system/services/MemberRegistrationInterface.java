package zw.co.metbank.insurance_system.services;

import zw.co.metbank.insurance_system.users.Company;
import zw.co.metbank.insurance_system.users.Person;

import java.util.List;

public interface MemberRegistrationInterface {

    public Person newClientPerson(Person person);
    public Person updateClientPerson(Person person);
    public Person person(Integer id);
    public List<Person> allClientPersons();
    public Person removePerson(Integer id);

    public Company newClientCompany(Company company);
    public Company updateClientCompany(Company company);
    public Company company(Integer id);
    public List<Company> allClientCompanies();
    public Company removeCompany(Integer id);


}
