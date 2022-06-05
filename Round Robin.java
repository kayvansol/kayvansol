package test;
  
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
  
import junit.framework.TestCase;

/**
 * This is a utility class for JDBC connection.
 * @author Kayvan Soleimani
 */  
class Robin {
private int i;
  
public Robin(int i) {
this.i = i;
}
  
public int call() {
return i;
}
}
  
class RoundRobin {
private Iterator<Robin> it;
private List<Robin> list;
  
public RoundRobin(List<Robin> list) {
this.list = list;
it = list.iterator();
}
 
public int next() {
// *** if we get to the end, start again ***
if (!it.hasNext()) {
it = list.iterator();
}
Robin robin = it.next();
 
return robin.call();
}
}
  
public class RoundRobinTest extends TestCase {
List<Robin> items = new ArrayList<Robin>();
RoundRobin round;
 
public void testOne() {
items.add(new Robin(1));
round = new RoundRobin(items);
assertEquals(1, round.next());
assertEquals(1, round.next());
}
 
public void testTwo() {
items.add(new Robin(1));
items.add(new Robin(2));
round = new RoundRobin(items);
assertEquals(1, round.next());
assertEquals(2, round.next());
assertEquals(1, round.next());
assertEquals(2, round.next());
}
 
public void testThree() {
items.add(new Robin(1));
items.add(new Robin(2));
items.add(new Robin(3));
round = new RoundRobin(items);
assertEquals(1, round.next());
assertEquals(2, round.next());
assertEquals(3, round.next());
assertEquals(1, round.next());
assertEquals(2, round.next());
assertEquals(3, round.next());
}
}
