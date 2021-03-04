package Week4;

public class Disk {
	private int x;
	private int y;

	Disk(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void manipulate () {
		int threshold = 1000;
		while ((threshold - (x + y)) > 0) {
			if (x > 5) {
				threshold = threshold - 1;
			}
			else if (y <= 12) {
				threshold = threshold - 2;
			}
			if (x <= 1000) {
				threshold = threshold - 3;
			}
			else if (y < 1) {
				// threshold incremented
				threshold = threshold + 1;
			}
		}
	}
}

// how to make while loop never stop? If you can find an input that exits t = t - 1 and t = t + 1
// with no other statements executes other threshold affecting statements,
// threshold can never decrease and you are triggering false (basically trying to stir shit) with potential x and y values


