import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    String sex = "Самец";
    int kittensCount = 1;

    private final Feline felineMock = Mockito.mock(Feline.class);

    @Test
    public void shouldReturnFoodList() throws Exception {
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(sex, felineMock);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void shouldReturnOneKitten() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void shouldReturnValidKittensCount() throws Exception {
        Mockito.when(felineMock.getKittens()).thenReturn(kittensCount);
        Lion lion = new Lion(sex, felineMock);
        assertEquals(kittensCount, lion.getKittens());
    }

    @Test
    public void shouldReturnValidFoodList() throws Exception {
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(sex, felineMock);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void shouldReturnTrueIfLionIsMale() throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void shouldCheckExceptionMessageForInvalidSex() {
        Throwable exception = Assert.assertThrows(Exception.class, () -> new Lion("InvalidSex", felineMock));
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals("Ожидалось иное сообщение", expectedExceptionMessage, exception.getMessage());
    }
}