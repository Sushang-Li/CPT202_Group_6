package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.CoachController;
import com.group6.booking4sportcentre.model.CoachInfo;
import com.group6.booking4sportcentre.model.CoachStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        List<CoachInfo> coachInfoList = coachController.getCoachByName("Fuyu.Xing");
        // Assert that the result is not empty
        assertNotNull(coachInfoList);
        assertFalse(coachInfoList.isEmpty(), "The list is empty");
    }

    // Test the addCoachInfo method
    @Test

    public void testAddCoachInfo() {
        CoachInfo coachInfo = new CoachInfo();
        coachInfo.setName("Si.Li");
        coachInfo.setActivity("shuttlecock");
        coachInfo.setContact("181298390");
        coachInfo.setStatus(CoachStatus.IDLE);
        coachInfo.setStartTime(LocalTime.of(9, 0, 0));
        coachInfo.setEndTime(LocalTime.of(17, 12, 0));
        String result = coachController.addCoachInfo(coachInfo);
        // Assert that the result is not empty
        assertNotNull(result);
        assertEquals("Add coach information successfully", result);
    }

    // Test the updateCoachInfo method
    @Test
    public void testUpdateCoachInfo() {
        CoachInfo coachInfo = new CoachInfo();
        coachInfo.setId(11);
        coachInfo.setName("Sa.Zhang");
        coachInfo.setActivity("shuttlecock");
        coachInfo.setContact("190298293");
        coachInfo.setStatus(CoachStatus.IDLE);
        coachInfo.setStartTime(LocalTime.of(9, 0, 0));
        coachInfo.setEndTime(LocalTime.of(17, 12, 0));
        String result = coachController.updateCoachInfo(coachInfo);
        // Assert that the result is not empty
        assertNotNull(result);
        assertEquals("Update coach information successfully", result);
    }

    // Test the deleteCoachInfo method
    @Test
    public void testDeleteCoachInfo() {
        String result = coachController.deleteCoachInfo(1);
        // Assert that the result is not empty
        assertNotNull(result);
        assertEquals("Delete coach information successfully", result);
    }
}