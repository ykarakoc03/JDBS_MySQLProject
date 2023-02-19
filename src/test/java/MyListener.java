import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MyListener implements RowSetListener {

	public MyListener() {
		// TODO Auto-generated constructor stub
	}

	public void cursorMoved(RowSetEvent event) {  
		System.out.println("Cursor Moved...");  
	}  
	public void rowChanged(RowSetEvent event) {  
		System.out.println("Row Changed...");  
	}  
	public void rowSetChanged(RowSetEvent event) {  
		System.out.println("RowSet changed...");  
	}  


}
