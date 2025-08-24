import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Blog Post
class BlogPost {
    private String title;
    private String content;
    private String author;

    public BlogPost(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void displayPost() {
        System.out.println("\n===============================");
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Content : " + content);
        System.out.println("===============================\n");
    }
}

// Main Blog Platform
public class BlogPlatform {
    private static ArrayList<BlogPost> posts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== BLOG PLATFORM =====");
            System.out.println("1. Create Post");
            System.out.println("2. View All Posts");
            System.out.println("3. Delete Post");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createPost();
                case 2 -> viewPosts();
                case 3 -> deletePost();
                case 4 -> System.out.println("Exiting Blog Platform. Goodbye!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
    }

    // Create new blog post
    private static void createPost() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        BlogPost newPost = new BlogPost(title, content, author);
        posts.add(newPost);
        System.out.println(" Post created successfully!");
    }

    // View all blog posts
    private static void viewPosts() {
        if (posts.isEmpty()) {
            System.out.println("No posts available.");
            return;
        }

        System.out.println("\n----- All Blog Posts -----");
        for (int i = 0; i < posts.size(); i++) {
            System.out.println((i + 1) + ". " + posts.get(i).getTitle());
        }

        System.out.print("Enter post number to view details (0 to go back): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= posts.size()) {
            posts.get(choice - 1).displayPost();
        }
    }

    // Delete a blog post
    private static void deletePost() {
        if (posts.isEmpty()) {
            System.out.println("No posts to delete.");
            return;
        }

        System.out.println("Select post number to delete: ");
        for (int i = 0; i < posts.size(); i++) {
            System.out.println((i + 1) + ". " + posts.get(i).getTitle());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= posts.size()) {
            posts.remove(choice - 1);
            System.out.println("🗑 Post deleted successfully!");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
