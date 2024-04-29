package com.group6.booking4sportcentre.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * @author Fuyu.Xing
 * @create 2024-04-28 20:26
 */

@TableName("wallet_info")
@Getter
@Setter
@Entity
public class WalletInfo {
    @Id
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance")
    private double balance;

    @OneToMany(mappedBy = "walletInfo")
    private List<BookingInfo> bookingInfos;




}
