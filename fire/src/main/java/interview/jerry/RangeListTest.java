package interview.jerry;


import org.junit.Assert;
import org.junit.Test;

public class RangeListTest {

    @Test
    public void testRangeList_Add(){
        RangeList rangeList = new RangeList();
        Assert.assertEquals("failed","[)",rangeList.toString());

        rangeList.add(new RangeList.Range(1, 5));
        Assert.assertEquals("failed","[1,5)",rangeList.toString());

        rangeList.add(new RangeList.Range(10, 20));
        Assert.assertEquals("failed","[1,5) [10,20)",rangeList.toString());


        rangeList.add(new RangeList.Range(20, 20));
        Assert.assertEquals("failed","[1,5) [10,20)",rangeList.toString());

        rangeList.add(new RangeList.Range(20, 21));
        Assert.assertEquals("failed","[1,5) [10,21)",rangeList.toString());


        rangeList.add(new RangeList.Range(2, 4));
        Assert.assertEquals("failed","[1,5) [10,21)",rangeList.toString());


        rangeList.add(new RangeList.Range(3, 6));
        Assert.assertEquals("failed","[1,6) [10,21)",rangeList.toString());


        rangeList.add(new RangeList.Range(7, 8));
        Assert.assertEquals("failed","[1,6) [7,8) [10,21)",rangeList.toString());

    }

    @Test
    public void testRangeList_remove(){
        RangeList rangeList = new RangeList();
        rangeList.add(new RangeList.Range(1, 6));
        rangeList.add(new RangeList.Range(7, 8));
        rangeList.add(new RangeList.Range(10, 21));

        rangeList.remove(new RangeList.Range(10,10));
        Assert.assertEquals("failed","[1,6) [7,8) [10,21)",rangeList.toString());


        rangeList.remove(new RangeList.Range(10,11));
        Assert.assertEquals("failed","[1,6) [7,8) [11,21)",rangeList.toString());


        rangeList.remove(new RangeList.Range(15, 17));
        Assert.assertEquals("failed","[1,6) [7,8) [11,15) [17,21)",rangeList.toString());


        rangeList.remove(new RangeList.Range(3, 6));
        Assert.assertEquals("failed","[1,3) [7,8) [11,15) [17,21)",rangeList.toString());


        rangeList.remove(new RangeList.Range(2, 19));
        Assert.assertEquals("failed","[1,2) [19,21)",rangeList.toString());

    }
}
