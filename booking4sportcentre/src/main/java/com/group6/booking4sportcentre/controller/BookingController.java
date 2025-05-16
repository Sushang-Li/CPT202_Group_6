package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.BookingInfoMapper;
import com.group6.booking4sportcentre.mapper.SportActivityMapper;
import com.group6.booking4sportcentre.mapper.UserInfoMapper;
import com.group6.booking4sportcentre.model.BookingInfo;
import com.group6.booking4sportcentre.model.BookingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Fuyu.Xing
 * @create 2024-04-20 22:13
 */
// This class is used to control the view of the booking
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingInfoMapper bookingInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    //一些新增的部分，主要是预定的添加和活动票数的减少
    @Autowired
    private SportActivityMapper sportActivityMapper;


    //从前端获得表单，在数据库中新增一条表单
    //后端测试成功，前端需要完善一些细节
//    {
//            "userName": "John Doe",
//            "date": "2024-05-01",
//            "startTime": "10:00:00",
//            "endTime": "12:00:00",
//            "venue": "Main Hall",
//            "status": "CONFIRMED",
//            "actName": "Music Concert",
//            "price": 50.0
//    }
    @PostMapping("/addOneBooking")
    public void addOneBooking(@RequestBody BookingInfo bookingInfo) {
        bookingInfoMapper.insert(bookingInfo);
    }
    //end

    //返回所有的订单，这里偷懒了，其实应该根据用户的id返回订单的，现在是获取全部的订单，然后在前端进行筛选
    @GetMapping("/getAllBookings")
    public List<BookingInfo> getAllBookings() {
        return bookingInfoMapper.getAllBookings();
    }

    //删除订单
    @GetMapping("/deleteOneBooking/{id}")
    public void deleteOneBooking(@PathVariable long id) {
        bookingInfoMapper.deleteById(id);
    }

    //更新订单的状态，pending -> confirmed
    @GetMapping("/updateOneBooking/{id}")
    public void updateOneBooking(@PathVariable long id) {
        BookingInfo bookingInfo = bookingInfoMapper.getBookingById(id);
        bookingInfo.setStatus(BookingStatus.CONFIRMED);
        bookingInfoMapper.updateById(bookingInfo);

    }

    //更新多个订单，用于处理payall的情况
    @PostMapping("/processArray")
    public ResponseEntity<String> processArray(@RequestBody List<Long> myArray) {

        // 处理接收到的数组数据
        for (Long element: myArray) {
            BookingInfo bookingInfo = bookingInfoMapper.getBookingById(element);
            bookingInfo.setStatus(BookingStatus.CONFIRMED);
            bookingInfoMapper.updateById(bookingInfo);
        }
        return ResponseEntity.ok("Array processed successfully");
    }

    // get all bookings
    // If there is no booking information, return empty list
    @GetMapping
    public List<BookingInfo> getBookings() {
        return bookingInfoMapper.getAllBookings();
    }

    // get booking by id
    // If the id does not exist, return null
    @GetMapping("/{id}")
    public BookingInfo getBooking(@PathVariable Long id) {

        System.out.println("id: " + id);
        BookingInfo booking = bookingInfoMapper.getBookingById(id);
        System.out.println("booking: " + booking);
        return booking;
    }

    // create a new booking
    @PostMapping("/api/createBooking")
    public Long createBooking(@RequestBody BookingInfo booking) {
        if (booking == null) {
            return null;
        }
        bookingInfoMapper.createBooking(booking);

        return booking.getId();
    }

    // update a booking
    // If the booking information is not complete, return 0
    @PutMapping("/{id}")
    public int updateBooking(@PathVariable Long id, @RequestBody BookingInfo booking) {

        if (id == null || booking == null) {
            return 0;
        }
        return bookingInfoMapper.updateBooking(id, booking);
    }

    // delete a booking
    // If the id does not exist, return 0
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingInfoMapper.deleteBooking(id);
    }

    // get booking by date
    // If there is no booking information, return empty list
    @GetMapping("/date/{date}")
    public List<BookingInfo> getBookingByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return bookingInfoMapper.getBookingByDate(localDate);
    }

    @Transactional
    @PostMapping("/confirm")

    public ResponseEntity<String> confirmBooking(@RequestParam Long bookingInfoId) {
        try {
            System.out.println("Booking ID: " + bookingInfoId);
            BookingInfo bookingInfo = bookingInfoMapper.getBookingById(bookingInfoId);
            System.out.println("Booking info: " + bookingInfo);
            if (bookingInfo == null) {
                return ResponseEntity.badRequest().body("Booking not found");
            }
            double bookingCost = bookingInfo.getPrice();
            Integer userId = bookingInfo.getUserId();
            System.out.println("User ID: " + userId);
            if (userId == null) {
                return ResponseEntity.badRequest().body("User ID is null");
            }

            //
            double currentBalance = userInfoMapper.getBalance(userId);
            System.out.println("Current balance: " + currentBalance);

            if (currentBalance < bookingCost) {
                return ResponseEntity.badRequest().body("Insufficient balance");
            }

            Double newBalance = currentBalance - bookingCost;
            System.out.println("Current balance: " + currentBalance);
            System.out.println("Booking cost: " + bookingCost);
            System.out.println("New balance: " + newBalance);
            userInfoMapper.updateBalance(userId, newBalance);

            double updatedBalance = userInfoMapper.getBalance(userId);
            System.out.println("Updated balance: " + updatedBalance);
            if (!newBalance.equals(updatedBalance)) {
                return ResponseEntity.badRequest().body("Failed to update balance");
            }

            bookingInfo.setStatus(BookingStatus.CONFIRMED);
            bookingInfoMapper.updateById(bookingInfo);

            return ResponseEntity.ok("Booking confirmed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error confirming booking");
        }
    }



    //    Admin查看所有预定信息
    @GetMapping("/admin_get_BookingInfo")
    public List<BookingInfo> getBookingsForAdmin() {
        return bookingInfoMapper.getAllBookings();
    }

}
