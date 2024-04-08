package rocks.zipcode.lambdas;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

import static rocks.zipcode.lambdas.Person.Gender.FEMALE;
import static rocks.zipcode.lambdas.Person.Gender.NONBINARY;
import static rocks.zipcode.lambdas.Person.printPersons;

public class PersonTests {


    @Test
    public void setNameTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person("", birthDate, gender, email);

        person.setName(name);
        Assert.assertEquals(name, person.getName());
    }

    @Test
    public void setBirthdateTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person(name, null, gender, email);

        person.setBirthday(birthDate);
        Assert.assertEquals(birthDate, person.getBirthday());
    }

    @Test
    public void setGenderTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person(name, birthDate, null, email);

        person.setGender(gender);
        Assert.assertEquals(gender, person.getGender());
    }

    @Test
    public void setEmailTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person(name, birthDate, gender, null);

        person.setEmailAddress(email);
        Assert.assertEquals(email, person.getEmailAddress());
    }

}
