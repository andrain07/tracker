package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }

        throw new UserNotFoundException(String.format("User \"%s\" not found", login));
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException(
                    String.format("Invalid user \"%s\"", user.getUsername())
            );
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException(
                    String.format("Username \"%s\" length less then 3", user.getUsername())
            );
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}