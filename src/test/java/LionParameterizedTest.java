import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String SEX;
    private final boolean MANE_HAVE;

    public LionParameterizedTest(String gender, Boolean mane_have) {
        this.SEX = gender;
        this.MANE_HAVE = mane_have;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Mock
    private Feline feline;

    @Test
    public void lionHasManeTest() throws Exception {
        Lion lion = new Lion(SEX, feline);
        assertEquals(MANE_HAVE, lion.doesHaveMane());
    }

}