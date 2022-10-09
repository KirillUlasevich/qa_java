import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {
    private final String SEX;
    private final boolean MANE_HAVE;

    public LionTest(String gender, Boolean mane_have) {
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
    @Test
    public void lionSexTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Падальщик", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
    @Test
    public void lionGetKittensTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }
    @Test
    public void getFoodLionTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, lion.getFood());
    }
}