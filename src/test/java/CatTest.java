import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @Test
    public void soundShouldBeCorrect() {
        Cat cat = new Cat(felineMock);
        String expected = "Мяу";
        String result = cat.getSound();
        assertEquals("Ожидался корректный звук", expected, result);
    }

    @Test
    public void foodShouldContainExpectedItems() throws Exception {
        Cat cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> resultFood = cat.getFood();
        assertEquals("Некорректный список еды", expectedFood, resultFood);
    }
}
