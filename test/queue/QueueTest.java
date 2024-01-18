package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class QueueTest {
    final Queue<Integer> queue = new Queue<>();

    @Test
    @DisplayName("enqueue will add an element last in queue")
    void enqueue() {
        queue.enqueue(3);
        queue.enqueue(2);
        Assertions.assertEquals(2, queue.size());

    }

    @Test
    @DisplayName("dequeue will remove the first element in queue")
    void dequeue() {
        queue.enqueue(3);
        queue.enqueue(2);
        Assertions.assertEquals(2, queue.size());
        queue.dequeue();
        Assertions.assertEquals(1, queue.size());

    }

    @Test
    void dequeueWillThrowWhenEmpty() {
        queue.enqueue(1);
        queue.dequeue();

        final IndexOutOfBoundsException actaulException = Assertions.assertThrowsExactly(
                IndexOutOfBoundsException.class,
                queue::dequeue,
                "Expected tail() to throw, but it didn't");

        Assertions.assertEquals("No objects in queue", actaulException.getMessage());
    }


    @Test
    @DisplayName("head will return the first element in Queue")
    void head() {
        queue.enqueue(3);
        queue.enqueue(2);
        Assertions.assertEquals(3, queue.head());
        queue.dequeue();
        Assertions.assertEquals(2, queue.head());
    }

    @Test
    void headWillThrowWhenEmpty() {
        queue.enqueue(1);
        queue.dequeue();

        final IndexOutOfBoundsException actaulException = Assertions.assertThrowsExactly(
                IndexOutOfBoundsException.class,
                queue::head,
                "Expected tail() to throw, but it didn't");

        Assertions.assertEquals("No objects in queue", actaulException.getMessage());
    }

    @Test
    @DisplayName("tail will return the first element in Queue")
    void tail() {
        queue.enqueue(1);
        Assertions.assertEquals(1, queue.tail());
        queue.enqueue(2);
        Assertions.assertEquals(2, queue.tail());
        queue.dequeue();
        Assertions.assertEquals(2, queue.tail());
    }

    @Test
    void tailWillThrowWhenEmpty() {
        queue.enqueue(1);
        queue.dequeue();

        final IndexOutOfBoundsException actaulException = Assertions.assertThrowsExactly(
                IndexOutOfBoundsException.class,
                queue::tail,
                "Expected tail() to throw, but it didn't");

        Assertions.assertEquals("No objects in queue", actaulException.getMessage());
    }
}