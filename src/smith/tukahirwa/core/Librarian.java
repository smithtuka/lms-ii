package smith.tukahirwa.core;

public class Librarian extends Account {

    public Librarian(String id,  AccountStatus status, Person person) {
        super(id,  status, person);
    }


    public boolean addBookItem(BookItem bookItem){
        // implement
        return false;
    }

    public boolean blockMember(Member member){
        //implement
        return false;
    }

    public boolean unBlockMember(Member member){
        // implement
        return false;
    }

    @Override
    public String toString() {
        return "Librarian{} " + super.toString();
    }
}
