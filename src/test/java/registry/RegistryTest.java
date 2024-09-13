package registry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RegistryTest {
    private Registry registry= new Registry();

    @Test
    public void testValidVoter() {
        Persona person = new Persona();
        person.setId(1000862736);
        person.setAge(25);
        person.setAlive(true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void testUnderageVoter() {
        Persona person = new Persona();
        person.setId(19993765);
        person.setAge(16);
        person.setAlive(true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void testInvalidAgeVoter() {
        Persona person = new Persona();
        person.setId(1999837465);
        person.setAge(-1);
        person.setAlive(true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);

        person.setAge(130);
        person.setId(1999837464);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void testDeadVoter() {
        Persona person = new Persona();
        person.setId(1999837465);
        person.setAge(40);
        person.setAlive(false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void testDuplicated() {

        Persona person = new Persona();

        person.setName("Juanita");
        person.setId(1000862736);
        person.setAge(30);
        person.setGender(Gender.FEMALE);
        person.setAlive(true);


        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

}
