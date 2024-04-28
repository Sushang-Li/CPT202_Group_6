package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.WalletController;
import com.group6.booking4sportcentre.model.WalletInfo;
import com.group6.booking4sportcentre.service.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
    Long id = walletController.createWallet(walletInfo);
    assertNotNull(id);
}


}
