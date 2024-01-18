package queue;

@SuppressWarnings("unchecked")
public class Queue<E> {
    private E[] array = (E[]) new Object[]{};

    public Queue() {
        this.array = (E[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), 0);
    }

    void enqueue(E object) {
        Object[] tempArray = new Object[array.length + 1];
        for (int index = 0; index < tempArray.length; index++) {
            if (index == tempArray.length - 1) {
                tempArray[index] = object;
            } else {
                tempArray[index] = this.array[index];
            }
        }
        array = (E[]) tempArray;
    }

    void dequeue() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("No objects in queue");
        }
        Object[] tempArray = new Object[this.array.length - 1];
        System.arraycopy(this.array, 1, tempArray, 0, this.array.length - 1);
        this.array = (E[]) tempArray;
    }

    public E head() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("No objects in queue");
        }
        return this.array[0];
    }

    public E tail() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("No objects in queue");
        }
        return this.array[this.array.length - 1];
    }

    public int size() {
        return this.array.length;
    }

    public boolean isEmpty() {
        return this.array.length == 0;
    }
}
