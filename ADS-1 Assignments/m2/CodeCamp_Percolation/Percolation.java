public class Percolation {
	private int topnode;
	private int bottomnode;
	private int size;
	private int count;
	private boolean[][] gridnodes;
	private Weighted wt;
	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
		gridnodes = new boolean[n][n];
		topnode = 0;
		count = 0;
		size = n;
		bottomnode = (n * n) + 1;
		wt = new Weighted((n * n) + 2);
	}
	// open site (row, col) if it is not open already
	public void open(int row, int col) {
		if (isOpen(row, col)) {
			count++;
			return;
		}
		gridnodes[row - 1][col - 1] = true;
		if (row == 1) {
			wt.Union(topnode, getIndex(row, col));
		}
		if (row == size) {
			wt.Union(getIndex(row, col), bottomnode);
		}
	}
	public int getIndex(int row, int col) {
		return ((row - 1) * size) + col;
	}
	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		return gridnodes[row - 1][col - 1];
	}
	// is site (row, col) full?
	public boolean isFull(int row, int col) {
		return wt.connected(topnode, getIndex(row, col));
	}
	// does the system percolate?
	public boolean percolates() {
		return wt.connected(topnode, bottomnode);
	}
}