package postman;

public class RequestEchoPostman {
    private String foo1;
    private String foo2;

    public RequestEchoPostman(String object1, String object2) {
        this.foo1 = object1;
        this.foo2 = object2;
    }

    public String getFoo1() {
        return foo1;
    }

    public String getFoo2() {
        return foo2;
    }
}
