package registry;

import java.util.Objects;

public class Persona {
    private String name;
    private int id;
    private int age;
    private Gender gender;
    private boolean alive;


    public Persona(){
        super();
    }
    public Persona(String name, int id, int age, Gender gender, boolean alive){

    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getAge(){
        return age;
    }
    public Gender getGender(){
        return gender;
    }
    public boolean isAlive(){
        return alive;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setGender(Gender gender){
        this.gender=gender;
    }
    public void setAlive(boolean alive){
        this.alive=alive;
    }

    @Override
    public String toString(){
        return "Person [name=" + name + ", id=" + id + ", age=" + age + ", gender=" + gender + ", alive=" + alive + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
