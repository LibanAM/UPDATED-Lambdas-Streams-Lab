package org.example.streamapi;

import org.example.streamapi.model.Bodybuilder;
import org.example.streamapi.model.Friend;
import org.example.streamapi.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.streamapi.model.User.GENDER.UNKNOWN;

public class Extension {
    /*
        Given two int numbers a and b, return int [] with values that are in the range between smaller and bigger arg:
        - use IntStream.range
        - swap the argument's values without introducing a new, local variable.
    */
    public int[] streamNumbers(int a, int b) {
        // Implement me :)
        return IntStream.range(Math.min(a, b), Math.max(a, b)).toArray();
    }

    /*
        Given a list of users, return a User with the given user id. If there is no user with this id,
        return new user with the name "New user", given id, gender "unknown".

        (use Optional API)
    */
    public User getUserByIdOrCreateNew(List<User> users, long userId) {
        // Implement me :)
        return users
                .stream()
                .filter(u -> u.getId() == (userId))
                .findAny()
                .orElse(new User(userId, "New user", UNKNOWN));
    }

    /*
        Given List<Friend>, filter the ones who are available on Saturday and want to party:
        - getAvailableDay returns "Saturday" and
        - getActivity returns "Party"
        - define predicates and use '.and' method.
    */

    public List<String> partyWithFriends(List<Friend> friends) {
        // Implement me :)
        return friends.stream()
                .filter(friend -> friend.getActivity() == "Party" && friend.getAvailableDay() == "Saturday")
                .map(friend -> friend.getName())
                .toList();
    }

    /*
        Return names of sorted bodybuilders.

        Sort List<Bodybuilder> using your custom comparator.

        Write a comparator for type BodyBuilder that will sort bodybuilders by:
        - who can lift more,
        - then who is younger,
        - then name alphabetically.
     */
    public List<String> sortBodybuilders(List<Bodybuilder> bodybuilders) {
        // Implement me :)
        return bodybuilders.stream()
                .sorted(Comparator.comparingInt(Bodybuilder::getLift).reversed()
                .thenComparing((Bodybuilder::getAge))
                .thenComparing((Bodybuilder::getName)))
//                .sorted(Comparator.comparingInt(Bodybuilder::getAge))
//                .sorted(Comparator.comparing(Bodybuilder::getName))
                .map(Bodybuilder::getName)
                .toList();

    }
}

