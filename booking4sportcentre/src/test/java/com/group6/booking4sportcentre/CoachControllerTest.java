package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.CoachController;
import com.group6.booking4sportcentre.model.CoachInfo;
import com.group6.booking4sportcentre.model.CoachStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Mingyuan.Li
 * @create 2024-04-20 17:20
 */
@SpringBootTest
public class CoachControllerTest {

    @Autowired
    private CoachController coachController;

    // Test the viewCoachInfo method
    @Test
    public void testViewCoachInfo() {
        List<CoachInfo> coachInfoList = coachController.viewCoachInfo();
        // Assert that the result is not empty
        assertNotNull(coachInfoList);
    }

    // Test the getCoachByName method
    @Test
    public void testGetCoachByName() {
        List<CoachInfo> coachInfoList = coachController.getCoachByName("Mingyuan.Li");
        // Assert that the result is not empty
        assertNotNull(coachInfoList);
    }

    // Test the addCoachInfo method
    @Test
    public void testAddCoachInfo() {
        CoachInfo coachInfo = new CoachInfo();
        coachInfo.setName("Lin Xi");
        coachInfo.setActivity("Basketball");
        coachInfo.setContact("123456789");
        coachInfo.setStatus(CoachStatus.IDLE);
        coachInfo.setStartTime(LocalTime.of(9, 0, 0));
        coachInfo.setEndTime(LocalTime.of(17, 12, 0));
        String result = coachController.addCoachInfo(coachInfo);
        // Assert that the result is not empty
        assertNotNull(result);
    }

    // Test the updateCoachInfo method
    @Test
    public void testUpdateCoachInfo() {
        CoachInfo coachInfo = new CoachInfo();
        coachInfo.setId(1);
        coachInfo.setName("Lin Xi");
        coachInfo.setActivity("Basketball");
        coachInfo.setContact("123456789");
        coachInfo.setStatus(CoachStatus.IDLE);
        coachInfo.setStartTime(LocalTime.of(9, 0, 0));
        coachInfo.setEndTime(LocalTime.of(17, 12, 0));
        String result = coachController.updateCoachInfo(coachInfo);
        // Assert that the result is not empty
        assertNotNull(result);
    }

    // Test the deleteCoachInfo method
    @Test
    public void testDeleteCoachInfo() {
        String result = coachController.deleteCoachInfo(1);
        // Assert that the result is not empty
        assertNotNull(result);
    }
}