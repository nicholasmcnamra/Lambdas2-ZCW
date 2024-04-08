package rocks.zipcode.lambdas;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.LocalDate;


import static rocks.zipcode.lambdas.Person.Gender.FEMALE;
import static rocks.zipcode.lambdas.Person.Gender.NONBINARY;
import static rocks.zipcode.lambdas.Person.printPersons;

public class LocalClassesTests {


    @Test
    public void validateAgeTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person(name, birthDate, gender, email);

        Assert.assertTrue(new Person.validateAdult().test(person));
    }

    @Test
    public void validateGenderTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person(name, birthDate, gender, email);

        Assert.assertTrue(new Person.checkGender().test(person));
    }

    @Test
    public void emailValidTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person(name, birthDate, gender, email);

        Assert.assertTrue(new Person.checkEmail().test(person));
    }

    @Test
    public void emailNoValidTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse.gmail.com";
        Person person = new Person(name, birthDate, gender, email);

        Assert.assertFalse(new Person.checkEmail().test(person));
    }

    @Test
    public void printPersonsTest() {
        String name1 = "Jesse";
        LocalDate birthDate1 = LocalDate.of(1995,2,25);
        Person.Gender gender1 = NONBINARY;
        String email1 = "jesse@gmail.com";
        Person person1 = new Person(name1, birthDate1, gender1, email1);

        String name2 = "Juana";
        LocalDate birthDate2 = LocalDate.of(2000,3,7);
        Person.Gender gender2 = FEMALE;
        String email2 = "juana.gmail.com";
        Person person2 = new Person(name2, birthDate2, gender2, email2);

        printPersons(Person.getRoster(), new Person.checkEmail());
    }
}
