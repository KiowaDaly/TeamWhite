public class Player {

    private final String name;
    private final Token token;

    Player(String name, Token token) {
        this.name = name;
        this.token = token;
    }

    public boolean hasName(String name) {
        return this.name.toLowerCase().equals(name.trim());
    }

    public String getName() {
        return name;
    }

    public Token getToken() {
        return token;
    }

    @Override
    public String toString() {
        return name + " (" + token.getName() + ")";
    }
}
