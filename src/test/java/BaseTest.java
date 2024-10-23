import com.codeborne.selenide.Configuration;
import org.junit.Before;

public abstract class BaseTest {

    @Before
    public void configureTests() {
        Configuration.timeout = 10000;
    }
}
