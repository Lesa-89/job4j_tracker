package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User checkingUser : users) {
            if (checkingUser.getUsername().equals(login)) {
                result = checkingUser;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("UserNotFound");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("UserInvalid");
        }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = findUser(users, "Petr Arsentev");
        try {
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            throw new UserInvalidException("This user is not valid");
        } catch (UserNotFoundException enf) {
            throw new UserNotFoundException("This user not found");
        }
    }
}