package com.coding.scott.datastructure;

public class ArrayList implements List {
	
	private int size = 0;
	
	private Object[] elementData = new Object[100];
	
	public void add(Object o){
		checkSize(size + 1);
		elementData[size++] = o;
	}

	public void checkSize(int size){
		if(size >= elementData.length)
			grow();
	}

	public void grow(){
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		Object[] newElementData = new Object[newCapacity];
		System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
		elementData = newElementData;
		size = newCapacity;
	}

	public void add(int index, Object o){
		checkIndex(index);
		checkSize(size+1);
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index]=o;
		size ++;
	}
	
	public void checkIndex(int index){
		if(index>=size || index<0)
			throw new ArrayIndexOutOfBoundsException();
	}
	
	public Object get(int index){
		return elementData[index];
	}
	
	public Object remove(int index){
		checkIndex(index);
		Object o = elementData[index];
		Object[] newElementData = new Object[elementData.length];
		if(index == 0){
			System.arraycopy(elementData, 1, newElementData, 0, elementData.length-1);
		}else{
			System.arraycopy(elementData, 0, newElementData, 0, index);
			System.arraycopy(elementData, index+1, newElementData, index, size-(index+1));
		}
		elementData=newElementData;
		size--;
		return o;
	}
	
	public int size(){
		return size;
	}


//	TODO:
	public Iterator iterator(){
		Iterator i = new Iterator() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Object next() {
				return null;
			}
		};
		return null;
	}
	
}
