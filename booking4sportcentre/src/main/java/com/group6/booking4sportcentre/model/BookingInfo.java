package com.group6.booking4sportcentre.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Fuyu.Xing
 * @create 2024-04-20 21:44
 */
@Setter
@Getter
@Entity
@TableName("booking_info")
public class BookingInfo {
    @Id
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //用户name
    @Column(name = "user_name")
    private String userName;

    //新增： 用户的ID
    private Integer userId;

    private LocalDate date;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    private String venue;
    //BookingStatus: PENDING, CONFIRMED, CANCELLED
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    //活动name
    @Column(name = "act_name")
    private String actName;
    private Long quantity;

    private double price;

    @Override
    public String toString() {
        return "BookingInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", venue='" + venue + '\'' +
                ", status=" + status +
                ", name='" + actName + '\'' +
                ", price=" + price +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "wallet_info_id")
    private WalletInfo walletInfo;

    public long getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public LocalDate getDate(){
        return this.date;
    }
}
