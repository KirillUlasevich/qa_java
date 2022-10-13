import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {

    @Test
    public void felineGetKittensTest(){
        Feline feline = new Feline();
        Assert.assertEquals("Количество котят по умолчанию не равно 1", 1, feline.getKittens());
    }

    @Test
    public void felineGetKittensCountTest(){
        Feline feline = new Feline();
        Assert.assertEquals(10, feline.getKittens(10));
    }

    @Test
    public void felineGetFamilyTest(){
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void felineEatMeatTest() throws Exception{
        Feline feline = new Feline();
        List<String> felineFood = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), felineFood);
    }

}
