import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

public class GelinkteListe<E> extends AbstractList<E> implements List<E> {
	
	LinkedList<E> neu;
		
	public GelinkteListe() {
		neu = new LinkedList<E>();
	}

	@Override
	public E get(int index) {
		return neu.get(index);
	}

	@Override
	public int size() {
		return neu.size();
	}
	
	public boolean add(E o){
		neu.add(o);
		return true;
	}
	
	public E remove(int index){
		neu.remove(index);
		return null;
	}
	

}
