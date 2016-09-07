package failure;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestThisWillFailAbunch {
    @Test
    public void aFailingTest() {
         assertTrue("I expected this to pass!", true);
    }

    @Ignore
    @Test
    public void aFailingTest2() {
         assertTrue("I expected this to pass!", true);
    }

    @Ignore
    @Test
    public void aFailingTest3() {
         assertTrue("I expected this to pass!", true);
    }

    //@Ignore
    @Test
    public void aFailingTest4() {
         assertTrue("I expected this to pass!", true);
    }

    @Ignore
    @Test
    public void aNewFailingTest31() {
         assertTrue("I expected this to pass!", true);
    }

    @Test
    public void aNotherNewFailingTest4() {
         assertTrue("I expected this to pass!", true);
    }

    @Test
    public void aFailingTest5() {
         assertTrue("I expected this to pass!", true);
    }

    @Test
    public void aFailingTest6() {
         assertTrue("I expected this to pass!", true);
    }

    @Test
    public void aPassingTest3() {
         assertTrue("Success!", true);
    }

    @Test
    public void aPassingTest4() {
         assertTrue("Success!", true);
    }
}
