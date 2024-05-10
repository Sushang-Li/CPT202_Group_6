package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.StadiumController;
import com.group6.booking4sportcentre.model.Stadium;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StadiumControllerTest {
    @Autowired
    private StadiumController stadiumController;

    @Test
    public void testGetStadiumInfo() {
        List<Stadium> stadiumInfoList = stadiumController.list();
        // Assert that the result is not empty
        assertNotNull(stadiumInfoList);
    }

    @Test
    public void testGetStadiumById() {
        List<Stadium> stadiumInfoList = stadiumController.getById(1);
        // Assert that the result is not empty
        assertNotNull(stadiumInfoList);
    }


    @Test
    public void testAddStadiumInfo() {
        Stadium stadium = new Stadium();
        stadium.setName("GM001A");
        stadium.setActivityName("Basketball");
        stadium.setRemainingSpace(100);

        String result = stadiumController.add(stadium);
        // Assert that the result is not empty
        assertNotNull(result);
    }

    @Test
    public void testUpdateStadiumInfo() {
        Stadium stadium = new Stadium();

        stadium.setId(1);
        stadium.setName("GM001A");
        stadium.setActivityName("Basketball");
        stadium.setRemainingSpace(100);

        String result = stadiumController.update(1, stadium);
        // Assert that the result is not empty
        assertNotNull(result);
    }

    @Test
    public void testDeleteStadiumInfo() {
        String result = stadiumController.delete(1);
        // Assert that the result is not empty
        assertNotNull(result);
    }


}
