package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner {


    @Autowired
    PersonRepository personRepository;
    ManagerRepository managerRepository;

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setName("John");
        personRepository.save(person);

        Manager manager = new Manager();
        manager.setLastName("Mu");
        managerRepository.save(manager);

        Person personFromDb = personRepository.findFirstByName("John");
        System.out.println(personFromDb);
        Manager managerFromDb = managerRepository.findByLastName("Mu");
        System.out.println(managerFromDb);
    }
}
