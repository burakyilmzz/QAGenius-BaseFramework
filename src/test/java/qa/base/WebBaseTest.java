package qa.base;

public abstract class WebBaseTest extends BaseTest {
    @Override
    protected boolean isWebTest() {
        return true;
    }
}