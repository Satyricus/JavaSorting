package sorting;

/**
 * Node object which stores students names and scores.
 * @author Jon Erik McWilliams
 * @param <T> Generic comparable
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    
    String name;
    double score;
    
    public Node(String name, double score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public double getScore() {
        return score;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + " Score: " + score;
    }
    
    @Override
    public int compareTo(Node<T> other) {
        if (this.score < other.getScore()) return -1;
        if (this.score > other.getScore()) return 1;
        else return 0;
    }
    
}
