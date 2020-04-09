import java.util.Stack;

public class fertilizer {
    treeNode root;
    int totalEntries = 0;
    int totalDuplicates = 0;
    int totalTreeBuildingComparisons = 0;
    int totalTreeWritingComparisons = 0;
    int tabsLeft = 0;
    int treeArrayIndex = 0;
    fileIn fIn = new fileIn();
    fileOut fOut = new fileOut();

    void setLeft(treeNode t, int n) {
        if (t.left != null) {
            System.out.println("Error: Node already exists.");
        } else {
            t.left = makeTreeNode(n);
        }
    }

    void setRight(treeNode t, int n) {
        if (t.right != null) {
            System.out.println("Error: Node already exists.");
        } else {
            t.right = makeTreeNode(n);
        }
    }

    treeNode makeTreeNode(int n) {
        treeNode t;
        t = new treeNode();
        t.data = n;
        t.left = null;
        t.right = null;
        t.printed = false;

        return t;
    }

    treeNode buildThatTreeOhYes(int num) {
        treeNode curr;
        boolean searching = true;
        totalEntries += 1;

        if (root == null) {
            root = makeTreeNode(num);
        } else {
            curr = root;
            while (searching) {
                totalTreeBuildingComparisons++;
                if (num == curr.data) {
                    totalDuplicates++;
                    curr.duplicate++;
                    searching = false;
                } else if (num < curr.data) {
                    if (curr.left == null) { /* If no left node set left */
                        setLeft(curr, num);
                        searching = false;
                    } else {
                        curr = curr.left; /* Else increment to next left node */
                    }
                } else if (num > curr.data) {
                    if (curr.right == null) { /* If no right node set left */
                        setRight(curr, num);
                        searching = false;
                    } else {
                        curr = curr.right; /* Else increment to next right node */
                    }
                }
            } /* End While */
        }

        return root;
    }

    void inOrderR(treeNode t) {
        if (t.left != null) {
            totalTreeWritingComparisons++;
            tabsLeft++;
            inOrderR(t.left);
        }
        if (!t.printed) {
            // Formating output
            String output = "";

            if (t.data >= 10) {
                output += "|\t\t\t" + t.data + "\t\t\t|\t\t\t";
            } else {
                output += "|\t\t\t" + t.data + "\t\t\t\t|\t\t\t";
            }

            if (t.duplicate >= 10) {
                output += t.duplicate + "\t\t\t|\n";
            } else {
                output += t.duplicate + "\t\t\t\t|\n";
            }

            fOut.writeToFile(output, fileIn.append);
            t.printed = true;
        }
        if (t.right != null) {
            totalTreeWritingComparisons++;
            inOrderR(t.right);
        }
    }
}
