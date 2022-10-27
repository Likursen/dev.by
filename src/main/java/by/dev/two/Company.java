package by.dev.two;

public class Company {
    private String name;
    private String url;
    private String email;

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public Company setUrl(String url) {
        this.url = url;
        return this;
    }

    public Company setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return name + "; " + url + "; " + email;
    }
}