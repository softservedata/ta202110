package com.softserve.edu;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;

public class UserJUnitTest {

    static Stream<Arguments> userDataProvider() {
        return Stream.of(
                Arguments.arguments(UserRepository.get().getAwdrt(), "my"),
                Arguments.arguments(UserRepository.get().getNewUser(), "firstName3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("userDataProvider")
    public void checkUser(IUser user, String ExpectedFirstname) {
        System.out.println("\tUSER: " + user);
        Assertions.assertEquals(ExpectedFirstname, user.getFirstname());
    }
}
