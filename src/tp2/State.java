package tp2;

import java.io.Serializable;
import java.util.Date;

public class State implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private int q;
	private Date lastOp;
	
	public State(String id, int Q, Date lastOp){
		this.id = id;
		this.q = Q;
		this.lastOp = lastOp;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getq() {
		return q;
	}

	public void setq(int q) {
		this.q = q;
	}

	public Date getLastOp() {
		return lastOp;
	}

	public void setLastOp(Date lastOp) {
		this.lastOp = lastOp;
	}
	
}
