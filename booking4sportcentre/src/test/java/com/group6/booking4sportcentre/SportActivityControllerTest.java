package com.group6.booking4sportcentre;


import com.group6.booking4sportcentre.controller.CoachController;
import com.group6.booking4sportcentre.controller.SportActivityController;
import com.group6.booking4sportcentre.controller.StadiumController;
import com.group6.booking4sportcentre.model.CoachInfo;
import com.group6.booking4sportcentre.model.CoachStatus;
import com.group6.booking4sportcentre.model.SportActivity;
import com.group6.booking4sportcentre.model.Stadium;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SportActivityControllerTest {
    @Autowired
    private SportActivityController sportActivityController;

    @Autowired
    private StadiumController stadiumController;

    @Autowired
    private CoachController coachController;
    @Test
    public void testAddCoachInfo() {
        CoachInfo coachInfo = new CoachInfo();
        coachInfo.setName("belle");
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
    @Test
    public void testAddStadiumInfo() {
        Stadium stadium = new Stadium();
        stadium.setName("GM001B");
        stadium.setActivityName("Basketball");
        stadium.setRemainingSpace(100);

        String result = stadiumController.add(stadium);
        // Assert that the result is not empty
        assertNotNull(result);
    }
    @Test
    public void testFindAll(){
        List<SportActivity> sportActivityList = sportActivityController.getAllSportActivities();
        // Assert that the result is not empty
        assertNotNull(sportActivityList);
    }

    @Test
    public void testUpdateTicketNumber() {
        sportActivityController.updateTicketNumber(1, 10, 100);
        // Assert that the result is not empty
    }

    @Test
    public void testListActivity() {
        List<SportActivity> sportActivityList = sportActivityController.list();
        // Assert that the result is not empty
        assertNotNull(sportActivityList);
    }

    @Test
    public void testGetActivityById() {
        List<SportActivity> sportActivityList = sportActivityController.getById(1);
        // Assert that the result is not empty
        assertNotNull(sportActivityList);
    }

    @Test
    public void testUpdateActivity() {
        SportActivity sportActivity = new SportActivity();
        sportActivity.setId(1);
        sportActivity.setTicketNumber(10);
        sportActivity.setPrice(100);
        sportActivity.setDate(LocalDate.parse("2024-05-10"));
        sportActivity.setCoach("belle");
        sportActivity.setStadium("GM001A");
        sportActivity.setStartTime(LocalTime.parse("09:00"));
        sportActivity.setEndTime(LocalTime.parse("17:00"));

        String result = sportActivityController.update(1, sportActivity);
        // Assert that the result is not empty
        assertNotNull(result);

    }

    @Test
    public void testAddActivity() {
        SportActivity sportActivity = new SportActivity();
        sportActivity.setId(1);
        sportActivity.setTicketNumber(10);
        sportActivity.setPrice(100);
        sportActivity.setDate(LocalDate.parse("2024-04-22"));
        sportActivity.setCoach("Mingyuan.Li");
        sportActivity.setStadium("GM001B");
        sportActivity.setStartTime(LocalTime.parse("09:00"));
        sportActivity.setEndTime(LocalTime.parse("17:00"));
        String result = sportActivityController.add(sportActivity);
        // Assert that the result is not empty
        assertNotNull(result);

    }


    @Test
    public void testDeleteSportActivity() {
        String result = sportActivityController.deleteSportActivity(1);
        // Assert that the result is not empty
        assertNotNull(result);
    }

}
