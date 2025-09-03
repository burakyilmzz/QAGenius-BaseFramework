package qa.base;

public abstract class ApiBaseTest extends BaseTest {
    @Override
    protected boolean isWebTest() {
        return false;
    }
}