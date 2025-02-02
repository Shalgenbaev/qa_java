import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    String sex;
    int kittensCount;

    private final Feline felineMock = Mockito.mock(Feline.class);

    @Test
    public void shouldReturnFoodList() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void shouldReturnOneKitten() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void shouldReturnValidKittensCount() {
        try {
            Lion lion = new Lion(sex, felineMock);
            Mockito.when(lion.getKittens()).thenReturn(kittensCount);
            Assert.assertEquals(1, lion.getKittens());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void shouldReturnValidFoodList() {
        try {
            Lion lion = new Lion(sex, felineMock);
            Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void shouldHaveManeForMaleLion() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Assert.assertTrue("Лев должен быть самцом", lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionForInvalidSex() throws Exception {
        // Проверка исключения
        new Lion("InvalidSex", felineMock);
    }

    @Test
    public void shouldCheckExceptionMessageForInvalidSex() {
        Feline feline = new Feline();
        Throwable exception = Assert.assertThrows(Exception.class, () -> new Lion("InvalidSex", feline));
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals("Ожидалось иное сообщение", expectedExceptionMessage, exception.getMessage());
    }
}
