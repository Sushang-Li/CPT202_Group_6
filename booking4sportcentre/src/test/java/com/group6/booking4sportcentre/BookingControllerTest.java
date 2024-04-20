package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.BookingController;
import com.group6.booking4sportcentre.model.BookingInfo;
import com.group6.booking4sportcentre.model.BookingStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Fuyu.Xing
 * @create 2024-04-20 22:47
 */

@SpringBootTest
public class BookingControllerTest {

    @Autowired
    private BookingController bookingController;

    // Test the getBookings method
    @Test
    public void testGetBookings() {
        List<BookingInfo> bookingList = bookingController.getBookings();
        // Assert that the result is not empty
        assertNotNull(bookingList);
    }

    // Test the getBooking method
    @Test
    public void testGetBooking() {
        BookingInfo booking = bookingController.getBooking(1L);
        // Assert that the result is not empty
        assertNotNull(booking);
    }

    // Test the createBooking method
    @Test
    public void testCreateBooking() {
        BookingInfo booking = new BookingInfo();
        booking.setDate(LocalDate.now());
        booking.setStartTime(LocalTime.of(9, 0));
        booking.setEndTime(LocalTime.of(10, 0));
        booking.setVenue("Basketball Court");
        booking.setStatus(BookingStatus.PENDING);
        booking.setName("Basketball");
        booking.setPrice(100.0);
        int result = bookingController.createBooking(booking);
        // Assert that the result is greater than 0
        assertTrue(result > 0);
    }

    // Test the updateBooking method
    @Test
    public void testUpdateBooking() {
        BookingInfo booking = new BookingInfo();
        booking.setDate(LocalDate.now());
        booking.setStartTime(LocalTime.of(9, 0));
        booking.setEndTime(LocalTime.of(10, 0));
        booking.setVenue("Golf Room");
        booking.setStatus(BookingStatus.PENDING);
        booking.setName("Golf");
        booking.setPrice(200.0);
        int result = bookingController.updateBooking(1L, booking);
        // Assert that the result is greater than 0
        assertTrue(result > 0);
    }

    // Test the deleteBooking method
    @Test
    public void testDeleteBooking() {
        bookingController.deleteBooking(1L);
        // No return value to assert
    }

    // Test the getBookingByDate method
    @Test
    public void testGetBookingByDate() {
        List<BookingInfo> bookingList = bookingController.getBookingByDate("2003-10-13");
        // Assert that the result is not empty
        assertNotNull(bookingList);
    }
}
