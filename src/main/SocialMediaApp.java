package main;

import java.util.Scanner;
import com.socialmedia.dao.*;  
import com.socialmedia.service.*;  
import com.socialmedia.model.*;

public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UserDAO userDAO = new UserDAO();
        FriendDAO friendDAO = new FriendDAO();
        PostDAO postDAO = new PostDAO();

        UserService userService = new UserService(userDAO);
        FriendService friendService = new FriendService(friendDAO);
        PostService postService = new PostService(postDAO);

        System.out.println("Welcome to Console Social Media App!");

        while(true) {
            System.out.println("\nMenu:\n1.Sign Up\n2.Send Friend Request\n3.View Requests\n4.View Friends\n5.Create Post\n6.View Feed\n7.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("DOB (dd-mm-yyyy): "); String dob = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Location: "); String loc = sc.nextLine();
                    System.out.print("Occupation: "); String occ = sc.nextLine();
                    userService.signUp(name, dob, age, loc, occ);
                    break;

                case 2:
                    System.out.print("Your Name: "); String senderName = sc.nextLine();
                    User sender = userService.findUser(senderName);
                    friendService.suggestFriends(sender, userService.getAllUsers());
                    System.out.print("Send request to: "); String receiverName = sc.nextLine();
                    User receiver = userService.findUser(receiverName);
                    if(receiver != null) friendService.sendRequest(sender, receiver);
                    break;

                case 3:
                    System.out.print("Your Name: "); String userName = sc.nextLine();
                    User user = userService.findUser(userName);
                    friendService.viewRequests(user);
                    System.out.print("Accept or Reject (A/R): "); String ar = sc.nextLine();
                    if(ar.equalsIgnoreCase("A")) {
                        System.out.print("Request from: "); String reqName = sc.nextLine();
                        User reqUser = userService.findUser(reqName);
                        friendService.acceptRequest(user, reqUser);
                    } else if(ar.equalsIgnoreCase("R")) {
                        System.out.print("Request from: "); String reqName = sc.nextLine();
                        User reqUser = userService.findUser(reqName);
                        friendService.rejectRequest(user, reqUser);
                    }
                    break;

                case 4:
                    System.out.print("Your Name: "); userName = sc.nextLine();
                    user = userService.findUser(userName);
                    friendService.viewFriends(user);
                    break;

                case 5:
                    System.out.print("Your Name: "); userName = sc.nextLine();
                    user = userService.findUser(userName);
                    System.out.print("Enter post content: "); String content = sc.nextLine();
                    postService.createPost(user, content);
                    break;

                case 6:
                    System.out.print("Your Name: "); userName = sc.nextLine();
                    user = userService.findUser(userName);
                    postService.showNewsFeed(user);
                    break;

                case 7:
                    System.out.println("Exiting..."); System.exit(0);
            }
        }
    }
}