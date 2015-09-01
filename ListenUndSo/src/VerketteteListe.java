public class VerketteteListe {
	private VerketteteListe next;
	private String data;
	
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
		
	private VerketteteListe getListenElement(int index) {
		VerketteteListe out = null;
		if (index == 0) {
			if (next == null) {
				throw new IndexOutOfBoundsException("index ist zu groß");
			}
			else {
				out = this;
			}
		}
		else if(index >= getSize()){
			throw new IndexOutOfBoundsException("index ist zu groß");
		}
		else if (index > 0) {
			out = next.getListenElement(index - 1);
		}
		else{
			throw new IndexOutOfBoundsException("ungültiger wert");
		}
		return out;		
	}
		
	public int getSize(){
		int size = 0;
		if (next != null){
			size = next.getSize(size + 1);
		}
		return size;
	}
	
	public int getSize(int size){
		if (next != null){
			size = next.getSize(size + 1);
		}
		return size;
	}
		
	public void add (String a){
		if (next == null) {	
			next = new VerketteteListe();
			this.setData(a);		
		}
		else {
			next.add(a);
		}
	}
	
	public String get(int index) {
		String out = getListenElement(index).data;
		return out;
	}
	
	public void remove(int index){
		if (index < 0 || index >= getSize()) {
			throw new IndexOutOfBoundsException("ungültiger wert");
		}
		if(index == 0){
			if (next != null) {				
				data = next.data;
				next = next.next;
			}
			else {
				throw new IndexOutOfBoundsException("ungültiger wert");
			}
		}
		else if (index == getSize() - 1) {
			getListenElement(index - 1).next = null;
		}
		else if(index > 0){
			getListenElement(index -1).next = getListenElement(index + 1);
		}
	}			
}
	

