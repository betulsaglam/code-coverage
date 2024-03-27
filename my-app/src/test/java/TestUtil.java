import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void testLengthOne(){
    assertFalse(c.compute(1));
  }

  @Test
  public void testLengthEven(){
    assertFalse(c.compute());
  }

  @Test(expected = RuntimeException.class)
  public void testException(){
    c.compute(0,1,2);
  }


}