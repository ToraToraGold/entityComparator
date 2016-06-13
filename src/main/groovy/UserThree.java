import java.util.Arrays;

public class UserThree {

    private String fname;
    private String lname;
    private int age;
    private House house;

    public UserThree(String fname, String lname, int age){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.house = new House(3,  Arrays.asList("Chisinau", "str 1", "27"));
    }

    String conc(){
        return fname+lname;
    }
    void showAge(){
        System.out.println(age);
    }
}
