package login;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import basetests.BaseTest;


import static org.junit.Assert.assertEquals;

public class LoginTests extends BaseTest {

    @Before
    public void setUp() {
        doBefore();
        accessToken = postApi.apiReg(registerCard).getBody().path("accessToken");
    }
    @Test
    @DisplayName("Проверяем успешную авторизацию по кнопке в форме регистрации")
    public void formRegisterTest(){
        loginPage.openLoginPage();
        loginPage.doLogin(registerCard.getEmail(), registerCard.getPassword());
        assertEquals(registerCard.getEmail(),getApi.apiGetUser(accessToken));
    }
    @Test
    @DisplayName("Проверяем успешную авторизацию по кнопке «Войти в аккаунт» на главной")
    public void mainPageRegTest(){
        mainPage.openMainPage();
        mainPage.clickEnterAccountButton();
        loginPage.doLogin(registerCard.getEmail(), registerCard.getPassword());
        assertEquals(registerCard.getEmail(),getApi.apiGetUser(accessToken));
    }
    @Test
    @DisplayName("Проверяем успешный вход через кнопку «Личный кабинет»")
    public void personalAccountRegTest(){
        mainPage.openMainPage();
        mainPage.clickPersonalAccountButton();
        loginPage.doLogin(registerCard.getEmail(), registerCard.getPassword());
        assertEquals(registerCard.getEmail(),getApi.apiGetUser(accessToken));
    }
    @Test
    @DisplayName("Проверяем успешноый вход через кнопку в форме восстановления пароля")
    public void ForgotPageRegTest(){
        forgotPage.openForgotPage();
        forgotPage.clickLoginButton();
        loginPage.doLogin(registerCard.getEmail(), registerCard.getPassword());
        assertEquals(registerCard.getEmail(),getApi.apiGetUser(accessToken));
    }
}
