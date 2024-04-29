package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.BookingInfoMapper;
import com.group6.booking4sportcentre.mapper.WalletInfoMapper;
import com.group6.booking4sportcentre.model.BookingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Fuyu.Xing
 * @create 2024-04-20 22:13
 */
//This class is used to control the view of the booking
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingInfoMapper bookingInfoMapper;

    @Autowired
    private WalletInfoMapper walletInfoMapper;

    //get all bookings
    //If there is no booking information, return empty list
    @GetMapping
    public List<BookingInfo> getBookings() {
        return bookingInfoMapper.getAllBookings();
    }

    //get booking by id
    //If the id does not exist, return null
    @GetMapping("/{id}")
    public BookingInfo getBooking(@PathVariable Long id) {

        System.out.println("id: " + id);
        BookingInfo booking = bookingInfoMapper.getBookingById(id);
        System.out.println("booking: " + booking);
        return booking;
    }

    //create a new booking
    @PostMapping
    public Long createBooking(@RequestBody BookingInfo booking) {
        if (booking == null) {
            return null;
        }
        bookingInfoMapper.createBooking(booking);

        return booking.getId();
    }

    //update a booking
    //If the booking information is not complete, return 0
    @PutMapping("/{id}")
    public int updateBooking(@PathVariable Long id, @RequestBody BookingInfo booking) {

        if (id == null || booking == null) {
            return 0;
        }
        if (booking.getWalletInfo() != null) {
            bookingInfoMapper.updateWalletInfoId(booking.getId(), booking.getWalletInfo().getId());
        }
        return bookingInfoMapper.updateBooking(id, booking);
    }

    //delete a booking
    //If the id does not exist, return 0
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingInfoMapper.deleteBooking(id);
    }

    //get booking by date
    //If there is no booking information, return empty list
    @GetMapping("/date/{date}")
    public List<BookingInfo> getBookingByDate(@PathVariable String date) {
        LocalDate localDate= LocalDate.parse(date);
        return bookingInfoMapper.getBookingByDate(localDate);
    }

    @PostMapping("/confirm")
    public void confirmBooking(@RequestParam Long bookingInfoId) {
        Map<String, Object> bookingInfo = bookingInfoMapper.getBookingCostAndWalletInfoIdById(bookingInfoId);
        Double bookingCost = (Double) bookingInfo.get("price");
        Long walletInfoId = (Long) bookingInfo.get("wallet_info_id");
        walletInfoMapper.updateWalletBalance(walletInfoId, bookingCost);
    }

    @PostMapping("/updateWalletInfoId")
    public void updateWalletInfoId(@RequestParam Long bookingInfoId, @RequestParam Long walletInfoId) {
        bookingInfoMapper.updateWalletInfoId(bookingInfoId, walletInfoId);
    }



}
