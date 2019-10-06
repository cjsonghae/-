package ��������Ʈ;

public class ArrayList {
    private int size = 0;
    private static final int DEFAULT_SIZE =10; // ó���� ũ�⸦ �󸶳� �������ִ��� �߿�
    private Object[] elementData = new Object[DEFAULT_SIZE]; //�迭�� ũ�⸦ ������
 
    public ArrayList() {
 
    }
     
    public boolean addLast(Object element) {
    	checkSize();
        elementData[size] = element;
        size++;
        return true;
    }
     
    public boolean add(int index, Object element) {
    	checkSize();
        // ������Ʈ �߰��� �����͸� �߰��ϱ� ���ؼ��� ���� ������Ʈ���� index�� ������ �ڷ� ��ĭ�� �̵����Ѿ� �մϴ�.
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        // index�� ��带 �߰��մϴ�.
        elementData[index] = element;
        // ������Ʈ�� ���ڸ� 1 ���� ��ŵ�ϴ�.
        size++;
        return true;
    }
     
    public boolean addFirst(Object element){
        return add(0, element);
    }
 
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += elementData[i];
            if (i < size - 1)
                str += ",";
        }
        return str + "]";
    }
     
    public Object remove(int index) {
        // ������Ʈ�� �����ϱ� ���� ������ �����͸� removed ������ �����մϴ�.
        Object removed = elementData[index];
        // ������ ������Ʈ ���� ������Ʈ���� ������ ������Ʈ���� ���������� �̵��ؼ� ���ڸ��� ä��ϴ�.
        for (int i = index + 1; i <= size - 1; i++) {
            elementData[i - 1] = elementData[i];
        }
        // ũ�⸦ ���Դϴ�.
        size--;
        // ������ ��ġ�� ������Ʈ�� ��������� �������ݴϴ�. 
        elementData[size] = null;
        return removed;
    }   
     
    public Object removeFirst(){
        return remove(0);
    }
 
    public Object removeLast(){
        return remove(size-1);
    }
 
    public Object get(int index) {
        return elementData[index];
    }
 
    public int size() {
        return size;
    }
 
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    } 
    
    public void checkSize() {
    	if(size == elementData.length) {
    	    Object[] newElements = new Object[elementData.length * 2];
            System.arraycopy(elementData, 0, newElements, 0, elementData.length);
            elementData = newElements;
    	}
    }
}