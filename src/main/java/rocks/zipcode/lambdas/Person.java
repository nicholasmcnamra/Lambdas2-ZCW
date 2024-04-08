package rocks.zipcode.lambdas;

import java.time.LocalDate;
import java.util.regex.Pattern;
public class Person {

    public enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        NONBINARY("Non-binary");
        private final String text;

        Gender(final String text) {
            this.text = text;
        }
        public String getGender() {
            return text;
        }
    }

    String name;
    LocalDate birthday;
    Gender gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Gender gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        String emailRegex = "^(.+)@(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        try {
            if (emailPattern.matcher(emailAddress).matches()) {
                this.emailAddress = emailAddress;
            }
            else {
                System.out.println("Email format must be:\n[username][@][domain]");
            }
        }
        catch (NullPointerException e) {
        }
    }

    public void printPerson() {
    }

}
