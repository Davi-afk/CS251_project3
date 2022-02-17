/**
 * CS 251: Data Structures and Algorithms
 * Project 3: Part 1
 * <p>
 *
 *
 * @author Shivam Bairoloya, Jordan Davis
 * @username sbairoli, davi1304
 * @sources -,
 */

public class Tuple<Item extends Comparable<Item>> {

    private Item[] items;

    /**
     * Initialize items
     *
     * @param items the initial value
     */
    public Tuple(Item[] items) {
        this.items = items;
    }

    /**
     * Getter
     *
     * @return items
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * Setter
     *
     * @param items to set
     */
    public void setItems(Item[] items) {
        this.items = items;
    }

    /**
     * Returns a String representation of the items
     *
     * @return toString representation
     */
    @Override
    public String toString() {
        StringBuilder x = new StringBuilder("");
        for (int i = 0; i < items.length; i++) {
            x.append(items[i]);
        }
        return x.toString();
    }

    /**
     * Lexicographically compares the items
     *
     * @param toCompare items to compare with
     * @return -1 if less 0 if it is the same and 1 if it is greater
     */

    public int compareTo(Tuple<Item> toCompare) {
        Item[] c = getItems();
        String t1 = "";
        for (int i = 0; i < c.length; i++)
        {
            t1 = t1 + c[i];
        }
        String t2 = toCompare.toString();
        int x = t1.compareTo(t2);
        if (x == 0)
        {
            return 0;
        }
        else if (x > 0)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    /**
     * For manual testing
     * @param args
     */


    public static void main(String[] args) {
        //Main can be used for manual testing
        //Look at TestTuple to generate your own cases
    }
}
