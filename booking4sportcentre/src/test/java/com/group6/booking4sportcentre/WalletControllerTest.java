package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.WalletController;
import com.group6.booking4sportcentre.model.WalletInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Fuyu.Xing
 * @create 2024-04-29 00:28
 */

@SpringBootTest
public class WalletControllerTest {

    @Autowired
    private WalletController walletController;
    @Test
    public void testCreateWallet() {
    WalletInfo walletInfo = new WalletInfo();
    walletInfo.setBalance(1000.0);
    Long id = Long.valueOf(walletController.createWallet(walletInfo));
    assertNotNull(id);
}


}
