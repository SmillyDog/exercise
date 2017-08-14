package classics;

/**
 * 迷宫老鼠
 * 
 */
public class Mouse {

	public static void main(String[] args) {

		// 2表示不可走，0表示可走
		int[][] maze = { { 2, 2, 2, 0, 2, 2, 2, 0, 0 }, { 2, 0, 0, 0, 0, 0, 2, 0, 0 }, { 2, 0, 2, 2, 2, 2, 2, 2, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 2 }, { 2, 0, 2, 2, 2, 2, 0, 2, 2 }, { 2, 0, 2, 2, 0, 0, 0, 2, 2 },
				{ 2, 0, 2, 2, 0, 2, 2, 0, 2 }, { 2, 0, 2, 0, 0, 0, 0, 0, 0 }, { 2, 0, 2, 2, 2, 2, 2, 2, 2 } };
		Map map = new Map(maze, new Point(7, 8)); // 迷宫地图
		Mouse.go(map, new Point(0, 3));
		map.print(); // 打印走迷宫的路径
/*	
		System.out.println(map.getClass().getSimpleName()); // Map
		System.out.println(map.getClass().getName()); // classics.Map
		System.out.println(maze.getClass().getName()); // [[I
		System.out.println(maze.getClass().getSimpleName()); // int[][]
*/		

	}

	public static void go(Map map, Point p) {
		map.step(p);
		if (p.y < map.maze[0].length - 1) { // 列，能向下走
			test(map, new Point(p.x, p.y + 1));
		}
		if (p.x < map.maze.length - 1) { // 行，能向右走
			test(map, new Point(p.x + 1, p.y));
		}
		if (p.y >= 1) { // 列，能向上走
			test(map, new Point(p.x, p.y - 1));
		}
		if (p.x >= 1) { // 行，能向左走
			test(map, new Point(p.x - 1, p.y));
		}
		if (!map.isArrived()) // 四个方向都不能走，还没有到达终点，则回溯
			map.empty(p);
	}

	public static void test(Map map, Point p) { // 是否可走
		if (!map.isArrived() && map.isEmpty(p)) { // 当前格可行且尚未到达终点
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

// 迷宫地图
class Map {
	int[][] maze;
	Point end; // 终点

	public Map(int[][] maze, Point end) {
		this.maze = maze;
		this.end = end;
	}

	// 是否到达终点
	public boolean isArrived() {
		return maze[end.x][end.y] == 1;
	}

	// 当前这一格是否可行
	public boolean isEmpty(Point p) {
		return maze[p.x][p.y] == 0;
	}

	// 可以理解为当经过Point p 无法走到终点时，把老鼠走过的痕迹抹去，表示最终的走法不含p
	public void empty(Point p) {
		maze[p.x][p.y] = 0; // 回溯
	}

	// 走到Point p
	public void step(Point p) {
		maze[p.x][p.y] = 1;
	}

	// 打印地图，含老鼠走过的路径
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
