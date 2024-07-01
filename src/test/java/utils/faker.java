package utils;

import com.github.javafaker.Faker;

public class faker {
    Faker faker=new Faker();
    public String getfirstname()
    {
        return faker.name().firstName();
    }
    public String getlastname()
    {
        return faker.name().lastName();
    }
}
