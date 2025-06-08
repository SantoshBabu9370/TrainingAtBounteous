package Java_Day9.LibraryManagementSystem.Modules;
public class Member {
    private String memberId;
    private String name;
    private String email;
    public Member(String memberId, String name, String email) {
    this.memberId = memberId;
    this.name = name;
    this.email = email;
}

    public String getMemberId() {
        return memberId;
    }
    @Override
    public String toString(){
        return memberId+" "+name;
    }


    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

