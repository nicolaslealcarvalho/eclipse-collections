import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.tuple.PairImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PairImplTest {

    @Test
    public void testGetters() {
        Pair<Integer, String> pair = new PairImpl<>(1, "one");
        Assert.assertEquals(1, (int) pair.getOne());
        Assert.assertEquals("one", pair.getTwo());
    }

    @Test
    public void testPut() {
        Pair<Integer, String> pair = new PairImpl<>(1, "one");
        Map<Integer, String> map = new HashMap<>();
        pair.put(map);
        Assert.assertEquals(1, map.size());
        Assert.assertEquals("one", map.get(1));
    }

    @Test
    public void testSwap() {
        Pair<Integer, String> pair = new PairImpl<>(1, "one");
        Pair<String, Integer> swappedPair = pair.swap();
        Assert.assertEquals("one", swappedPair.getOne());
        Assert.assertEquals(1, (int) swappedPair.getTwo());
    }

    @Test
    public void testEqualsAndHashCode() {
        Pair<Integer, String> pair1 = new PairImpl<>(1, "one");
        Pair<Integer, String> pair2 = new PairImpl<>(1, "one");
        Pair<Integer, String> pair3 = new PairImpl<>(2, "two");

        Assert.assertEquals(pair1, pair2);
        Assert.assertNotEquals(pair1, pair3);
        Assert.assertEquals(pair1.hashCode(), pair2.hashCode());
        Assert.assertNotEquals(pair1.hashCode(), pair3.hashCode());
    }

    @Test
    public void testToString() {
        Pair<Integer, String> pair = new PairImpl<>(1, "one");
        Assert.assertEquals("1:one", pair.toString());
    }

    @Test
    public void testToEntry() {
        Pair<Integer, String> pair = new PairImpl<>(1, "one");
        Map.Entry<Integer, String> entry = pair.toEntry();
        Assert.assertEquals(1, (int) entry.getKey());
        Assert.assertEquals("one", entry.getValue());
    }

    @Test
    public void testCompareTo() {
        Pair<Integer, String> pair1 = new PairImpl<>(1, "one");
        Pair<Integer, String> pair2 = new PairImpl<>(2, "two");
        Pair<Integer, String> pair3 = new PairImpl<>(1, "two");
        Pair<Integer, String> pair4 = new PairImpl<>(1, "one");

        Assert.assertTrue(pair1.compareTo(pair2) < 0);
        Assert.assertTrue(pair2.compareTo(pair1) > 0);
        Assert.assertTrue(pair1.compareTo(pair3) < 0);
        Assert.assertTrue(pair3.compareTo(pair1) > 0);
        Assert.assertTrue(pair1.compareTo(pair4) == 0);
    }
}
