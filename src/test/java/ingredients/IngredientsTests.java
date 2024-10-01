package ingredients;


import io.qameta.allure.junit4.DisplayName;
import basetests.BaseTest;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class IngredientsTests extends BaseTest {

    @Before
    public void setUp()  {
        doBefore();
        mainPage.openMainPage();
    }
    @Test
    @DisplayName("Проверяем переход в блок \"Булки\"")
    public void bunTransitionTest(){
        mainPage.clickSauceTitle();
        mainPage.clickBunTitle();
        assertTrue(mainPage.isBunSelected());
    }
    @Test
    @DisplayName("Проверяем переход в блок \"Соусы\"")
    public void sauceTransitionTest(){
        mainPage.clickSauceTitle();
        assertTrue(mainPage.isSauceSelected());
    }
    @Test
    @DisplayName("Проверяем переход в блок \"Начинки\"")
    public void fillingsTransitionTest(){
        mainPage.clickFillingsTitle();
        assertTrue(mainPage.isFillingsSelected());
    }
}
