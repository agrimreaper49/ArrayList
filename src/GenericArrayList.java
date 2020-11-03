/**
 * Creates a GenericArrayList class
 * 
 * @author asharma
 * @version 10.21.20
 *
 * @param <E> any type of element
 */
public class GenericArrayList<E> {
    
    private int size;
    private Object [] objs;
    
    /**
     * Builds the GenericArrayList wiith a default size of 0
     * and a default length of 8
     */
    public GenericArrayList() {
        size = 0;
        objs = new Object [8];
    }
    
    /**
     * Takes in a GenericArrayList, and copies over all the old values
     * 
     * @param arr the GenericArrayList you want it to copy
     */
    public GenericArrayList(GenericArrayList<E> arr) {
        objs = new Object [arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            objs[i] = arr.get(i);
        }
        size = arr.size();
    }
    
    /**
     * Takes in an initial capacity 
     * and sets the length of the background array to it
     * Also sets the size to 0
     * 
     * @param capacity the size of the background array
     */
    public GenericArrayList(int capacity) {
        size = 0;
        objs = new Object[capacity];
    }
    
    /**
     * Returns the size 
     * @return size
     */
    
    public int size() {
        return size;
    }
    
    /**
     * Checks if the GenericArrayList contains any values
     * 
     * @return true if it contains no values, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a object to the end of the GenericArrayList
     * 
     * @param element the value to be added
     * @return true if the object was added
     */
    public boolean add(E element) {
        add(size, element);
        return true;
    }
    
    /**
     * Adds a value to a specific index in the StringArrayList
     * 
     * @param index the slot to add the value
     * @param element the value you want to add
     */
    public void add(int index, E element) {
        if ( index > size || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        if (objs.length == 0) {
            objs = new String [8];
        }
        if (size == objs.length) {
            ensureCapacity(size * 2);
        }
        for (int i = size; i > index; i--) {
            objs[i] = objs[i - 1];
        }
        objs[index] = element;
        size++;
    }
    
    /**
     * Returns the object you want to grab from a specific index 
     * in the StringArrayList
     * 
     * @param index the location of the String
     * @return the desired value
     */
    public E get(int index) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        return (E)objs[index];
    }
    
    /**
     * Ensures that the length of the GenericArrayList
     * is eqaul to minNeeded, otherwise increases the length
     * of the GenericArrayList to minNeeded
     * 
     * @param minNeeded checks if the Length is equal to this,
     * otherwise makes Length equal to this
     */
    public void ensureCapacity(int minNeeded) {
        Object [] arr = new Object [objs.length];
        if (minNeeded > objs.length) {
            arr = new Object [minNeeded];
            for (int i = 0; i < objs.length; i++) {
                arr [i] = objs [i];
            }
            objs = arr;
        }
    }
    
    /** 
     * Converts the GenericArrayList into a String
     * 
     * @return GenericArrayList as a String
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String result = "[" + objs[0];
        for (int i = 1; i < size; i++) {
            result += ", " + objs[i];
        }
        return result + "]";
    }
    
    /**
     * Replaces the value at index 
     * with the desired object
     * 
     * @param index the location of the replacement
     * @param element the object to be added
     * @return the old object that got replaced
     */
    public E set(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object s = objs[index];
        objs[index] = element;
        return (E) s;
    }
    
    /**
     * Returns whether or not the GenericArrayList is equal to
     * the incoming Object o
     * 
     * @param o the Object being compared to
     * @return true if the GenericArrayList is equal to the object, false
     * if it is not 
     * 
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GenericArrayList)) {
            return false;
        }
        GenericArrayList other = (GenericArrayList)o;
        if (size() == other.size()) {
            for (int i = 0; i < size; i++ ) {
                if (objs[i] != other.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    /**
     * Converts the GenericArrayList into an array
     * 
     * @return an Object[] 
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = objs[i];
        }
        return result;
    }
    
    /**
     * Checks to see if the GenericArrayList has o
     * 
     * @param o the Object that is being sniffed out
     * @return true if it contains o, false otherwise
     */
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (objs[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the first index of where o was found
     * 
     * @param o the object that is being looked for
     * @return the index of where o was found
     */
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (objs[i].equals(o)) {
                return i;
            }
        }
        return -1;

    }
    
    /**
     * Returns the last index of where o was found
     * 
     * @param o the object that is being looked for
     * @return the index of where o was found
     */
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (objs[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Returns the value that is to be removed at the desired index
     * 
     * @param index the location of where the object is
     * @return the object that was removed
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object o = objs[index];
        for (int i = index; i < size - 1; i++) {
            objs[i] = objs[i + 1];
        }
        size--;
        return (E)o;
    }
    
    /**
     * Returns true if the object was removed, false otherwise
     * 
     * @param o the object to be removed
     * @return true if the object was removed, false otherwise
     */
    public boolean remove(Object o) {
        if (indexOf(o) == -1) {
            return false;
        }
        remove(indexOf(o));
        return true;
    }
    
    /**
     * Clears the GenericArrayList
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            objs[i] = null;
        }
        size = 0;
    }
    
    /**
     * Adds all the value from GenericArrayList 
     * arr to the end of GenericArrayList
     * 
     * @param arr the GenericArrayList you want to add to the end
     * @return true or false if something got added
     */
    public boolean addAll(GenericArrayList<E> arr) {
        if (arr == null || arr.isEmpty() ) {
            return false;
        }
        ensureCapacity(size + arr.size());
        for (int i = 0; i < arr.size(); i++) {
            add( arr.get(i) );
        }
        return true;
    }
    
    /**
     * Adds all the values from GenericArrayList arr 
     * to a specific index of GenericArrayList
     * 
     * @param index the location to add arr
     * @param arr the GenericArrayList you want to add
     * @return return true or false if something got added
     */
    public boolean addAll(int index, GenericArrayList<E> arr) {
        if ( index > size || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        if (arr == null || arr.isEmpty()) {
            return false;
        }
        Object [] newArr = new Object[size + arr.size()];
        for (int i = 0; i < index; i++) {
            newArr[i] = objs[i];
        }
        for (int i = 0; i < arr.size(); i++) {
            newArr[i + index] = arr.get(i);
        }
        for (int i = index; i < size; i++) {
            newArr[i + arr.size()] = objs[i];
        }
        objs = newArr;
        size += arr.size();
        return true;
    }
    
    /**
     * Removes all instances of any value that 
     * is contained in GenericArrayList arr from StringArrayList
     * 
     * @param arr the GenericArrayList which contained the values to be removed
     * @return true if the values contained were removed, false otherwise
     */
    public boolean removeAll(GenericArrayList<E> arr) {
        boolean counter = false;
        for (int i = size - 1; i >= 0; i--) {
            if (arr.contains(get(i))) {
                for (int f = i; f < size - 1; f++) {
                    objs[f] = objs[f + 1];
                }
                counter = true;
                size--;
            }
        }
        return counter;
    }
    
    /**
     * Deletes unused indices
     */
    public void trimToSize() {
        objs = toArray();
    }
    
    /**
     * Returns the length of GenericArrayList
     * 
     * @return the length of the GenericArrayList
     */
    public int getCapacity() {
        return objs.length;
    }
    /**
     * Starts a given index and ends at a given index
     * Then converts those values into a GenericArrayList
     * 
     * @param start the starting index
     * @param end the ending index
     * @return the values added into a GenericArrayList
     * 
     */
    public GenericArrayList<E> subList(int start, int end) {
        if (start < 0 || start > end || end > size) {
            throw new IndexOutOfBoundsException();
        }
        GenericArrayList<E> sub = new GenericArrayList<E>(end - start);
        for (int i = start; i < end; i++) {
            sub.add((E)objs[i]);
        }
        return sub;
    }
}
