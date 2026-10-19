/**
 * Represents the doubly linked list for the music playlist.
 * Your Name:        Bora AVCU
 * Your Student ID:  250444902
 * Your Date:        19.10.2026
 */

public class MusicPlaylist {

    // create private instants of the doubly linked list:
    // -  head, tail and current
    private SongNode head;
    private SongNode tail;
    private SongNode current;

    // constructor: The head,tail and current should be initialized to null in the beginning
    public MusicPlaylist() {
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    // Add a song to the end of the playlist
    public void addSong(String title) {

        // 1. Create a new SongNode
        SongNode newNode = new SongNode(title);

        // 2. If the playlist is empty, make the new node
        //    head, tail and current
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            // 3. Otherwise, add the new node after tail
            // 4. Update both next and prev pointer
            newNode.prev = tail;
            tail.next = newNode;

            // 5. Update tail
            tail = newNode;
        }
    }


    // Remove a song from the playlist
    public void removeSong(String title) {

        // 1. Search for the song
        SongNode temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        // 2. If the song does not exist, display a message as: "The song isn't in the playlist"
        if (temp == null) {
            System.out.println("The song isn't in the playlist");
            return;
        }

        // 7. Handle removing the current song
        if (temp == current) {
            if (current.next != null) {
                current = current.next;
            } else {
                current = current.prev;
            }
        }

        // 5. Handle removing head
        if (temp == head && temp == tail) {
            head = null;
            tail = null;
        } else if (temp == head) {
            head = head.next;
            head.prev = null;
        }
        // 6. Handle removing tail
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // 3. Update the previous node's next pointer
        // 4. Update the next node's prev pointer
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Removed: " + title);
    }


    // Move to the next song
    public void nextSong() {

        // If current is not null and current.next exists,
        // move current to current.next.
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title);
        }
        // Otherwise, display:
        // "Already at the last song of the playlist."
        else {
            System.out.println("Already at the last song of the playlist.");
        }
    }


    // Move to the previous song
    public void previousSong() {

        // If current is not null and current.prev exists,
        // move current to current.prev.
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        }
        // Otherwise, display:
        // "Already at the first song of the playlist."
        else {
            System.out.println("Already at the first song of the playlist.");
        }
    }


    // Display the current song
    public void displayCurrentSong() {

        // Display the title of the current song.
        if (current != null) {
            System.out.println("Current Song: " + current.title);
        } else {
            System.out.println("The playlist is empty.");
        }
    }


    // Display all songs
    public void displayPlaylist() {

        // Start from head and follow next pointer.
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp.title + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}