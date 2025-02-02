import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParamLionTest {
    private final String sex;
    private final boolean expectedMane;

    public ParamLionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Object getManeParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void shouldDetermineIfMaleHasMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        boolean actualMane = lion.doesHaveMane();
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", expectedMane, actualMane);
    }
}