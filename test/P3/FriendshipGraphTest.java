package P3;

import static org.junit.Assert.*;

import P2.turtle.TurtleSoup;
import org.junit.Test;

public class FriendshipGraphTest {
    /**
     * Tests that assertions are enabled.
     */
    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        assert false;
    }

    // 无向图
    @Test
    public void testAll() {
        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");
        graph.addVertex(rachel);
        graph.addVertex(ross);
        graph.addVertex(ben);
        graph.addVertex(kramer);
        graph.addEdge(rachel, ross);
        graph.addEdge(ross, rachel);
        graph.addEdge(ross, ben);
        graph.addEdge(ben, ross);

        assertEquals(graph.getDistance(rachel, ross), 1);
        assertEquals(graph.getDistance(rachel, ben), 2);
        assertEquals(graph.getDistance(rachel, rachel), 0);
        assertEquals(graph.getDistance(rachel, kramer), -1);
    }

    // 有向图
    @Test
    public void testAll2() {
        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");
        graph.addVertex(rachel);
        graph.addVertex(ross);
        graph.addVertex(ben);
        graph.addVertex(kramer);
//        graph.addEdge(rachel, ross);
        graph.addEdge(ross, rachel);
        graph.addEdge(ross, ben);
        graph.addEdge(ben, ross);

        assertEquals(graph.getDistance(rachel, ross), -1);
        assertEquals(graph.getDistance(rachel, ben), -1);
        assertEquals(graph.getDistance(rachel, rachel), 0);
        assertEquals(graph.getDistance(rachel, kramer), -1);
    }

    // 添加同名人
    @Test(expected = IllegalArgumentException.class)
    public void duplicatePersonName() {
        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person rachel2 = new Person("Rachel");
        graph.addVertex(rachel);
        graph.addVertex(rachel2);
    }

    // 添加同一个人两次
    @Test(expected = IllegalArgumentException.class)
    public void samePersonTwice() {
        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        graph.addVertex(rachel);
        graph.addVertex(rachel);
    }

    // 添加一条关系链（这条链上某个人未 addVertex）
    @Test(expected = IllegalArgumentException.class)
    public void noAddedPersonName() {
        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        graph.addVertex(rachel);
        graph.addEdge(rachel, ross);
    }

    // 添加重复边
    @Test(expected = IllegalArgumentException.class)
    public void duplicateEdge() {
        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        graph.addVertex(rachel);
        graph.addVertex(ross);
        graph.addEdge(rachel, ross);
        graph.addEdge(rachel, ross);
    }
}
