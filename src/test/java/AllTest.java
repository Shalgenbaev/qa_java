import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        CatTest.class,
        FelineTest.class,
        LionTest.class,
        ParamLionTest.class
})

public class AllTest {
}
