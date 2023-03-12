package practise.form;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;


public class StudentForm {

    @NotNull
    @Size(min = 4, message = "is required")
    private String username;

    @NotNull
    @Size(min = 4, message = "is required")
    @Email(message = "must be valid format...")
    private String email;

    @NotNull
    @Size(min = 4, message = "is required")
    private String id;


    public StudentForm(){}

    public StudentForm(String username, String email, String id){
        this.username = username;
        this.email = email;
        this.id = id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }

    public String getId(){
        return this.id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public String toString(){
        return this.username + " " + this.email;
    }
}

