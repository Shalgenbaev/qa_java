import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    // Тесты для класса Feline

    @Test
    public void familyShouldReturnCorrectFamily() {
        // Тест метода, возвращающего семейство
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String resultFamily = feline.getFamily();
        assertEquals("Указано некорректное семейство", expectedFamily, resultFamily);
    }

    @Test
    public void kittensShouldReturnExpectedCount() {
        Feline feline = new Feline();
        int expectedKittensCount = 1;
        int resultKittensCount = feline.getKittens();
        assertEquals("Указано некорректное количество котят", expectedKittensCount, resultKittensCount);
    }

    @Test
    public void meatShouldReturnExpectedItems() throws Exception {
        Feline feline = new Feline();
        List<String> expectedMeatList = List.of("Животные", "Птицы", "Рыба");
        List<String> resultMeatList = feline.eatMeat();
        assertEquals("Указана некорректная пища", expectedMeatList, resultMeatList);
    }

    @Test
    public void meatShouldNotReturnInvalidItems() throws Exception {
        Feline feline = new Feline();
        List<String> unexpectedMeatList = List.of("Трава", "Различные растения");
        List<String> resultMeatList = feline.eatMeat();
        assertNotEquals("Некорректная пища совпала с ожидаемой", unexpectedMeatList, resultMeatList);
    }
}
