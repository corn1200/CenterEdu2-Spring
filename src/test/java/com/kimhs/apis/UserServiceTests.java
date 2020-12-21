package com.kimhs.apis;

import com.kimhs.apis.datamodel.enumModel.UserGradeEnum;
import com.kimhs.apis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTests {
    private final UserService userService;

    @Autowired
    public UserServiceTests(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceFirstGrade() {
        // Given
        int totalPaidAmount = 0;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.FirstGrade);
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceSecondGrade() {
        // Given
        int totalPaidAmount = 100001;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.SecondGrade);
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceThirdGrade() {
        // Given
        int totalPaidAmount = 1000001;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.ThirdGrade);
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceFourthGrade() {
        // Given
        int totalPaidAmount = 3000001;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.FourthGrade);
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceTopTier() {
        // Given
        int totalPaidAmount = 10000001;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.TopTier);
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceUnder0() {
        // Given
        int totalPaidAmount = -1;

        // When
        // Then
    }
}
