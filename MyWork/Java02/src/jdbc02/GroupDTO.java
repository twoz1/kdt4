package jdbc02;

public class GroupDTO {
	private int jno;
	private int count;
	private int sum;
	private double avg;
	private int max;
	private int min;
	
	// getter / setter
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	
	// toString
	@Override
	public String toString() {
		return "GroupDTO [jno=" + jno + ", count=" + count + ", sum=" + sum + ", avg=" + avg + ", max=" + max + ", min="
				+ min + "]";
	}
	
	
}
