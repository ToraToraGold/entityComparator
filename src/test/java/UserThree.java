import java.util.Arrays;

public class UserThree {

    private String fname;
    private String lname;
    private int age;
    private House house;
//    private UserTwo userTwo;
//    private int hhh;

    public UserThree(String fname, String lname, int age){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
//        this.userTwo =  new UserTwo("ddd","sss",13);
        this.house = new House(3,  Arrays.asList("Chisinau", "27", "str 1"));
//        this.hhh = 13;
    }

    String conc(){
        return fname+lname;
    }
    void showAge(){
        System.out.println(age);
    }
}
