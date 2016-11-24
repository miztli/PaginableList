package com.conecta.commons.utils.paginator;

/**
 * Abstract class that helps to set an index on an object
 *
 * @author  Miztli Melgoza
 */
public abstract class Indexable {
    private int internalIndex;

    public void setInternalIndex(int internalIndex) {
        this.internalIndex = internalIndex;
    }

    public int getInternalIndex() {
        return internalIndex;
    }
}
