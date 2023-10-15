package postman;

public class ResponseEchoPostman {
    private String foo1;
    private String foo2;

    public ResponseEchoPostman(String object1, String object2) {
        this.foo1 = object1;
        this.foo2 = object2;
    }

    public ResponseEchoPostman() {
    }

    public String getFoo1() {
        return foo1;
    }

    public String getFoo2() {
        return foo2;
    }
}
