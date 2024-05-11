package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.ReportController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ReportControllerTest {
    @Autowired
    private ReportController reportController;

    // Test the getMonthlySalesAndQuantity method
    @Test
    public void testGetMonthlySalesAndQuantity() {
        assertNotNull(reportController.getMonthlySalesAndQuantity());
    }

}
