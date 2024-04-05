public class CircularList {

    private Node current;

    // Insert a node with the given key
	public void insert(int key) {
        Node insertNode = new Node();
        insertNode.key = key; 
        if (current == null) {
            current = insertNode;
            current.next = current;
        } else {
            insertNode.next = current.next;
            current.next = insertNode;
        }
    }

    // Delete the current node
    public void delete() {
        if (current == null) {
            return;
        }
        if (current.next == current) {
            current = null;
        } else {
            current.next = current.next.next;
        }
    }

    // Find a node with the given key
    public Node find(int key) {
        if (current == null) {
            return null;
        }
        Node temp = current;
        do {
            temp = temp.next;
            if (temp.key == key) {
                return temp;
            }
        } while (temp != current);
        return null;
    }

    // Delete the first occurrence of a node with the given key
    public void deleteKey(int key) {
        if (current == null) {
            return;
        }
        Node temp = current;
        while (temp.next != current) {
            if (temp.next.key == key) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        if (current.key == key) {
            delete();
        }
    }

    // Move to the next node
    public void step() {
        if (current != null) {
            current = current.next;
        }
    }

    // Peek at the current node
    public Node peek() {
        return current;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return current == null;
    }

    // Provide a string representation of the list
    @Override
	public String toString() {
		
		StringBuilder ret = new StringBuilder();
		
		if (current == null)
			return "null";
		
		Node currentNode = current;
		
		do
		{
			ret.append(currentNode.key + " -> ");
			currentNode = currentNode.next;
		}while(currentNode != current);
		
		return ret.toString();
	}
}

