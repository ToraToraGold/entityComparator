import java.util.List;


public class House {


    private List<String> address;
    private int rooms;

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }


    public House(int rooms, List<String> address){
        this.rooms = rooms;
        this.address = address;
    }
}
