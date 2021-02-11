// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> itr;
    private boolean hasNext;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
	    this.hasNext = itr.hasNext();
	    if (hasNext) {
	    	this.next = itr.next();
	    }
	}
	
        // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
            return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer output = next;
            if (itr.hasNext()) {
                next = itr.next();
            } else {
                next = null;
                hasNext = false;
            }
            return output;
	}
	
	@Override
	public boolean hasNext() {
	    return hasNext;
	}
}
