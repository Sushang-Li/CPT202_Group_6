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
    @Options(useGeneratedKeys = true, keyProperty = "id")
     void createWalletInfo(WalletInfo walletInfo);

    @Select("SELECT balance FROM wallet_info WHERE id = #{walletInfoId}")
    double getWalletBalance(@Param("walletInfoId") Long walletInfoId);

   @Update("UPDATE wallet_info SET balance = #{newBalance} WHERE id = #{walletInfoId}")
   void updateWalletBalance(@Param("walletInfoId") Long walletInfoId, @Param("newBalance") Double newBalance);

}