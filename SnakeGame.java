/**
 * A console-based Snake Game.
 * The snake is controlled using WASD keys and grows when it eats food.
 * The game ends when the snake collides with itself.
 *
 * Uses a custom ArrayList implementation to store the snake body.
 *
 * @author Siyamthanda Xenza
 */ 
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private static final int GRID_SIZE = 10;
    private MyArrayListHM<Point> snake;
    private Point food;
    private Direction currentDirection;
    private boolean gameOver;
    private int score;
    private Random random;
    private Scanner scanner;

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }
    }

    public SnakeGame() {
        snake = new MyArrayListHM<>();
        random = new Random();
        scanner = new Scanner(System.in);
        initializeGame();
    }

    private void initializeGame() {
        snake.clear();
        // Start snake with length 1 in center 
        snake.add(0, new Point(GRID_SIZE / 2, GRID_SIZE / 2));
        currentDirection = Direction.RIGHT;
        gameOver = false;
        score = 0;
        placeFood();
    }

    private void placeFood() {
        while (true) {
            int x = random.nextInt(GRID_SIZE);
            int y = random.nextInt(GRID_SIZE);
            food = new Point(x, y);
            
            // Ensure food doesn't spawn on snake 
            boolean validPosition = true;
            for (int i = 0; i < snake.getSize(); i++) {
                if (food.equals(snake.get(i))) {
                    validPosition = false;
                    break;
                }
            }
            
            if (validPosition) break;
        }
    }

    private void printGrid() {
        // Display grid with H, b, *, .
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                Point current = new Point(x, y);
                if (snake.get(0).equals(current)) {
                    System.out.print("H ");
                } else if (containsPoint(snake, current)) {
                    System.out.print("b ");
                } else if (food.equals(current)) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("Score: " + score); 
    }

    private boolean containsPoint(MyArrayListHM<Point> list, Point point) {
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).equals(point)) {
                return true;
            }
        }
        return false;
    }

    private void processInput() {
        System.out.print("Enter direction (WASD): ");
        String input = scanner.nextLine().toUpperCase();
        
        
        switch (input) {
            case "W":
                if (currentDirection != Direction.DOWN) currentDirection = Direction.UP;
                break;
            case "S":
                if (currentDirection != Direction.UP) currentDirection = Direction.DOWN;
                break;
            case "A":
                if (currentDirection != Direction.RIGHT) currentDirection = Direction.LEFT;
                break;
            case "D":
                if (currentDirection != Direction.LEFT) currentDirection = Direction.RIGHT;
                break;
        }
    }

    private void moveSnake() {
        Point head = snake.get(0);
        Point newHead = new Point(head.x, head.y);
        
        
        switch (currentDirection) {
            case UP:
                newHead.y--;
                break;
            case DOWN:
                newHead.y++;
                break;
            case LEFT:
                newHead.x--;
                break;
            case RIGHT:
                newHead.x++;
                break;
        }
        
        
        if (newHead.x < 0) newHead.x = GRID_SIZE - 1;
        if (newHead.x >= GRID_SIZE) newHead.x = 0;
        if (newHead.y < 0) newHead.y = GRID_SIZE - 1;
        if (newHead.y >= GRID_SIZE) newHead.y = 0;
        
        
        for (int i = 1; i < snake.getSize(); i++) {
            if (newHead.equals(snake.get(i))) {
                gameOver = true;
                return;
            }
        }
        
        
        snake.add(0, newHead);
        
        
        if (newHead.equals(food)) {
            score++; 
            placeFood(); 
        } else {
            
            snake.remove(snake.getSize() - 1);
        }
    }

    public void play() {
        while (true) {
            initializeGame();
            
            while (!gameOver) {
                printGrid(); 
                processInput(); 
                moveSnake(); 
            }
            
            printGrid();
        
            System.out.println("Game Over! Final Length: " + snake.getSize() + ", Score: " + score);
            
            System.out.print("Play again? (Y/N): ");
            String choice = scanner.nextLine().toUpperCase();
            
            if (!choice.equals("Y")) {
                break;
            }
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.play();
    }
}