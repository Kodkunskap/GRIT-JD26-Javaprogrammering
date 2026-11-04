public class User {

    String name;
    int followers = 0;
    int following = 0;

    User(String username) {
        name = username;
    }

    // User pelle = new User("Pelle");
    // User anna = new User("Anna");

    // anna.follow(pelle)
    boolean follow(User other) {
        following++;
        other.followers++;

        return true;
    }

    boolean isPopularThan(User other) {

        if (followers > other.followers) {
            return true;
        }

        return false;       // return followers > other.followers;
    }

    public String toString() {
        return "Name: " + name + ", Followers: " + followers + ", Following: " + following;
    }


}
