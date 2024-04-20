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
      Long id = bookingController.createBooking(booking);
      // Assert that the result is greater than 0
      assertNotNull(id);
  }

    // Test the getBooking method
    @Test
    public void testGetBooking() {
        // Create a new booking
        BookingInfo newBooking = new BookingInfo();
        newBooking.setDate(LocalDate.now());
        newBooking.setStartTime(LocalTime.of(9, 0));
        newBooking.setEndTime(LocalTime.of(10, 0));
        newBooking.setVenue("Basketball Court");
        newBooking.setStatus(BookingStatus.PENDING);
        newBooking.setName("Basketball");
        newBooking.setPrice(100.0);
        Long id = bookingController.createBooking(newBooking);
        // Use the generated ID to get the booking
        BookingInfo booking = bookingController.getBooking(id);
        // Assert that the result is not null
        assertNotNull(booking);
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
        Long id = bookingController.createBooking(booking);
        assertNotNull(id);
        int result = bookingController.updateBooking(id, booking);
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
