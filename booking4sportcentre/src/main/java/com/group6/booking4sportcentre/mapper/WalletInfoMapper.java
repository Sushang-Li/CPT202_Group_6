package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.WalletInfo;
import org.apache.ibatis.annotations.*;

/**
 * @author Fuyu.Xing
 * @create 2024-04-29 00:26
 */

@Mapper
public interface WalletInfoMapper extends BaseMapper<WalletInfo> {
    @Insert("INSERT INTO wallet_info(user_id, balance) VALUES(#{userId}, #{balance})")
    @Options(useGeneratedKeys = false)
     void createWalletInfo(WalletInfo walletInfo);

    @Select("SELECT balance FROM wallet_info WHERE user_id = #{userId}")
    double getWalletBalance(@Param("userId") int userId);

   @Update("UPDATE wallet_info SET balance = #{newBalance} WHERE user_id = #{userId}")
   void updateWalletBalance(@Param("userId") int userId, @Param("newBalance") Double newBalance);

    @Select("SELECT balance FROM wallet_info WHERE user_id = #{userId}")
    double selectBalanceByUserId(@Param("userId") int userId);

    @Select("SELECT balance FROM wallet_info WHERE user_id = #{userId}")
    WalletInfo selectByUserId(@Param("userId") int userId);

    @Update("UPDATE wallet_info SET balance = #{newBalance} WHERE user_id = #{userId}")
    void updateWalletBalanceByUserId(@Param("userId") int userId, @Param("newBalance") double newBalance);
}
