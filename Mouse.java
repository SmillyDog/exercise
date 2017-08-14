package classics;

/**
 * �Թ�����
 * 
 */
public class Mouse {

	public static void main(String[] args) {

		// 2��ʾ�����ߣ�0��ʾ����
		int[][] maze = { { 2, 2, 2, 0, 2, 2, 2, 0, 0 }, { 2, 0, 0, 0, 0, 0, 2, 0, 0 }, { 2, 0, 2, 2, 2, 2, 2, 2, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 2 }, { 2, 0, 2, 2, 2, 2, 0, 2, 2 }, { 2, 0, 2, 2, 0, 0, 0, 2, 2 },
				{ 2, 0, 2, 2, 0, 2, 2, 0, 2 }, { 2, 0, 2, 0, 0, 0, 0, 0, 0 }, { 2, 0, 2, 2, 2, 2, 2, 2, 2 } };
		Map map = new Map(maze, new Point(7, 8)); // �Թ���ͼ
		Mouse.go(map, new Point(0, 3));
		map.print(); // ��ӡ���Թ���·��
/*	
		System.out.println(map.getClass().getSimpleName()); // Map
		System.out.println(map.getClass().getName()); // classics.Map
		System.out.println(maze.getClass().getName()); // [[I
		System.out.println(maze.getClass().getSimpleName()); // int[][]
*/		

	}

	public static void go(Map map, Point p) {
		map.step(p);
		if (p.y < map.maze[0].length - 1) { // �У���������
			test(map, new Point(p.x, p.y + 1));
		}
		if (p.x < map.maze.length - 1) { // �У���������
			test(map, new Point(p.x + 1, p.y));
		}
		if (p.y >= 1) { // �У���������
			test(map, new Point(p.x, p.y - 1));
		}
		if (p.x >= 1) { // �У���������
			test(map, new Point(p.x - 1, p.y));
		}
		if (!map.isArrived()) // �ĸ����򶼲����ߣ���û�е����յ㣬�����
			map.empty(p);
	}

	public static void test(Map map, Point p) { // �Ƿ����
		if (!map.isArrived() && map.isEmpty(p)) { // ��ǰ���������δ�����յ�
			go(map, p);
		}
	}
}

class Point {
	int x;
	int y;

	public Point(int x1, int y1) {
		x = x1;
		y = y1;
	}
}

// �Թ���ͼ
class Map {
	int[][] maze;
	Point end; // �յ�

	public Map(int[][] maze, Point end) {
		this.maze = maze;
		this.end = end;
	}

	// �Ƿ񵽴��յ�
	public boolean isArrived() {
		return maze[end.x][end.y] == 1;
	}

	// ��ǰ��һ���Ƿ����
	public boolean isEmpty(Point p) {
		return maze[p.x][p.y] == 0;
	}

	// �������Ϊ������Point p �޷��ߵ��յ�ʱ���������߹��ĺۼ�Ĩȥ����ʾ���յ��߷�����p
	public void empty(Point p) {
		maze[p.x][p.y] = 0; // ����
	}

	// �ߵ�Point p
	public void step(Point p) {
		maze[p.x][p.y] = 1;
	}

	// ��ӡ��ͼ���������߹���·��
	public void print() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++)
				if (maze[i][j] == 2) {
					System.out.print(""
							+ ""
							+ "");
				} else if (maze[i][j] == 0) {
					System.out.print(" ");
				} else if (maze[i][j] == 1) {
					System.out.print("1");
				}
			System.out.println();
		}

	}

}
