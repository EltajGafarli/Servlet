package lesson2.form;

public class Student {

    private int id;
    private String name;

    private String surname;
    private String email;

    public Student(int id, String name, String surname, String email){
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public String getName(){return this.name;}
    public String getSurname(){return this.surname;}
    public String getEmail(){return this.email;}
    public int getId(){return this.id;}

}
