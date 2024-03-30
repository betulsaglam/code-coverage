import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testSize(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(0);

    c = new Compute(mq);
    assertEquals(-1, c.countNumberOfOccurrences("hw!!"));
  }

  @Test
  public void testContains(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(1);
    when(mq.contains(anyString())).thenReturn(false);

    c = new Compute(mq);
    assertEquals(0, c.countNumberOfOccurrences("Hello World!"));
  }

  @Test
  public void testNotEquals(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(5);
    when(mq.contains(anyString())).thenReturn(true);
    when(mq.getAt(anyInt())).thenReturn("x");

    c = new Compute(mq);
    assertEquals(0, c.countNumberOfOccurrences("im tired"));
  }

  @Test
  public void testCounter(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(3);
    when(mq.contains(anyString())).thenReturn(true);

    when(mq.getAt(0)).thenReturn("i should study");
    when(mq.getAt(1)).thenReturn("but i will");
    when(mq.getAt(2)).thenReturn("sleep");

    c = new Compute(mq);
    assertEquals(1, c.countNumberOfOccurrences("sleep"));
  }
}