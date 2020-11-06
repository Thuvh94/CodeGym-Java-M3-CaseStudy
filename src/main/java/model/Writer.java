package model;

public class Writer {
    private int writerId;
    private String writerName;
    private String email;
    private boolean isAdmin;
    private String password;

    public Writer() {
    }

    public Writer(int writerId, String writerName, String email, boolean isAdmin) {
        this.writerId = writerId;
        this.writerName = writerName;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public Writer(int writerId, String writerName, String email, boolean isAdmin, String password) {
        this.writerId = writerId;
        this.writerName = writerName;
        this.email = email;
        this.isAdmin = isAdmin;
        this.password = password;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
