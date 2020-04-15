package smith.tukahirwa.core;

public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;


    public Account(String id, AccountStatus status, String name, Address address, String email, String phone) {
        this.id = id;
        this.status = status;
        this.person = new Person(name,  address,  email, phone);
    }

    // overloaded for quick usage - librarians e.g
    public Account(String id, AccountStatus status, Person person) {
        this.id = id;
        this.status = status;
        this.person = person;
    }

    public Account(String id, String password, AccountStatus status, Person person) {
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public boolean resetPassword(){
      //implement
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", person=" + person +
                '}';
    }
}
