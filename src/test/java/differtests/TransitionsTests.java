package differtests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import basetests.BaseTest;


import static org.junit.Assert.assertTrue;

public class TransitionsTests extends BaseTest {

    @Before
    public void setUp() {
        doBefore();
        accessToken = postApi.apiReg(registerCard).getBody().path("accessToken");
        loginPage.openLoginPage();
        loginPage.doLogin(registerCard.getEmail(), registerCard.getPassword());
    }

    @Test
    @DisplayName("Проверяем переход по клику «Личный кабинет»")
    public void personalAccTransitionTest(){
        mainPage.clickPersonalAccountButton();
        assertTrue(profilePage.isKeyTitleDisplayed());
    }
    @Test
    @DisplayName("Проверяем перехода из личного кабинета в конструктор по клику на кнопку «Конструктор»")
    public void constructButtonTransitionTest(){
        mainPage.clickPersonalAccountButton();
        profilePage.clickConstructorButton();
        assertTrue(mainPage.isMakeBurgerTitleDisplayed());
    }
    @Test
    @DisplayName("Проверяем переход из личного кабинета в конструктор по клику на кнопку «Конструктор»")
    public void logoTransitionTest(){
        mainPage.clickPersonalAccountButton();
        profilePage.clickLogo();
        assertTrue(mainPage.isMakeBurgerTitleDisplayed());
    }
    @Test
    @DisplayName("Проверяем выход по кнопке «Выйти» в личном кабинете")
    public void exitTransitionTest(){
        mainPage.clickPersonalAccountButton();
        profilePage.clickExitButton();
        assertTrue(loginPage.isLoginButtonDisplayed());
    }

}