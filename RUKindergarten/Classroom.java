package kindergarten;
/**
 * This class represents a Classroom, with:
 * - an SNode instance variable for students in line,
 * - an SNode instance variable for musical chairs, pointing to the last student in the list,
 * - a boolean array for seating availability (eg. can a student sit in a given seat), and
 * - a Student array parallel to seatingAvailability to show students filed into seats 
 * --- (more formally, seatingAvailability[i][j] also refers to the same seat in studentsSitting[i][j])
 * teju//
 * @author Ethan Chou
 * @author Kal Pandit
 * @author Maksims Kurjanovics Kravcenko
 */
public class Classroom {
    private SNode studentsInLine;             // when students are in line: references the FIRST student in the LL
    private SNode musicalChairs;              // when students are in musical chairs: references the LAST student in the CLL
    private boolean[][] seatingAvailability;  // represents the classroom seats that are available to students
    private Student[][] studentsSitting;      // when students are sitting in the classroom: contains the students

    /**
     * Constructor for classrooms. Do not edit.
     * @param l passes in students in line
     * @param m passes in musical chairs
     * @param a passes in availability
     * @param s passes in students sitting
     */
    public Classroom ( SNode l, SNode m, boolean[][] a, Student[][] s ) {
		studentsInLine      = l;
        musicalChairs       = m;
		seatingAvailability = a;
        studentsSitting     = s;
	}
    /**
     * Default constructor starts an empty classroom. Do not edit.
     */
    public Classroom() {
        this(null, null, null, null);
    }

    /**
     * This method simulates students coming into the classroom and standing in line.
     * 
     * Reads students from input file and inserts these students in alphabetical 
     * order to studentsInLine singly linked list.
     * 
     * Input file has:
     * 1) one line containing an integer representing the number of students in the file, say x
     * 2) x lines containing one student per line. Each line has the following student 
     * information separated by spaces: FirstName LastName Height
     * 
     * @param filename the student information input file
     */
    public void makeClassroom ( String filename ) {

        // WRITE YOUR CODE HERE
        StdIn.setFile(filename);
        int noOfStudents = StdIn.readInt();
        while (StdIn.hasNextLine()) {

            String fName = StdIn.readString();
            String lName = StdIn.readString();
            int height = StdIn.readInt();
            Student student = new Student(fName, lName, height);
            SNode node = new SNode(student, null);
            SNode currNode;


            if (studentsInLine == null ||
                    studentsInLine.getStudent().compareNameTo(node.getStudent()) > 0) {
                node.setNext(studentsInLine);
                studentsInLine = node;
            } else {


                currNode = studentsInLine;

                while (currNode.getNext() != null
                        && currNode.getNext().getStudent().compareNameTo(node.getStudent()) <= 0)

                    currNode = currNode.getNext();

                node.setNext(currNode.getNext());
                currNode.setNext(node);
            }

        }





    }

    /**
     * 
     * This method creates and initializes the seatingAvailability (2D array) of 
     * available seats inside the classroom. Imagine that unavailable seats are broken and cannot be used.
     * 
     * Reads seating chart input file with the format:
     * An integer representing the number of rows in the classroom, say r
     * An integer representing the number of columns in the classroom, say c
     * Number of r lines, each containing c true or false values (true denotes an available seat)
     *  
     * This method also creates the studentsSitting array with the same number of
     * rows and columns as the seatingAvailability array
     * 
     * This method does not seat students on the seats.
     * 
     * @param seatingChart the seating chart input file
     */
    public void setupSeats(String seatingChart) {

    // WRITE YOUR CODE HERE
    
    StdIn.setFile(seatingChart);

    int noOfRows = StdIn.readInt();
    int noOfCols = StdIn.readInt();
    seatingAvailability = new boolean[noOfRows][noOfCols];
    studentsSitting = new Student[noOfRows][noOfCols];

    for (int r = 0; r < noOfRows; r++) {
        for (int c = 0; c < noOfCols; c++) {
            seatingAvailability[r][c] = StdIn.readBoolean();
        }
    }

    }

    /**
     * 
     * This method simulates students taking their seats in the classroom.
     * 
     * 1. seats any remaining students from the musicalChairs starting from the front of the list
     * 2. starting from the front of the studentsInLine singly linked list
     * 3. removes one student at a time from the list and inserts them into studentsSitting according to
     *    seatingAvailability
     * 
     * studentsInLine will then be empty
     */
    public void seatStudents () {

	// WRITE YOUR CODE HERE
    SNode currNode = studentsInLine;
    boolean isWinnerSeated = false;

    OUTER_LOOP:
    for (int r = 0; r < studentsSitting.length; r++) {
        for (int c = 0; c < studentsSitting[r].length; c++) {
            if (seatingAvailability[r][c]) {
                if (!isWinnerSeated && musicalChairs != null) {
                    studentsSitting[r][c] = musicalChairs.getStudent();
                    isWinnerSeated = true;
                    musicalChairs = null;
                } else {
                    studentsSitting[r][c] = currNode.getStudent();

                    if (currNode.getNext() != null) {
                        currNode = currNode.getNext();
                    } else break OUTER_LOOP;

                }


            }
        }
    }
    studentsInLine = null;

    }

    /**
     * Traverses studentsSitting row-wise (starting at row 0) removing a seated
     * student and adding that student to the end of the musicalChairs list.
     * 
     * row-wise: starts at index [0][0] traverses the entire first row and then moves
     * into second row.
     */
    public void insertMusicalChairs () {
        
        // WRITE YOUR CODE HERE
        studentsInLine = null;

        for (int r = 0; r < studentsSitting.length; r++) {
            for (int c = 0; c < studentsSitting[r].length; c++) {

                if (studentsSitting[r][c] != null) {
                    SNode node = new SNode(studentsSitting[r][c], null);

                    if (musicalChairs == null) {
                        node.setNext(node);
                        musicalChairs = node;

                    } else {
                        node.setNext(musicalChairs.getNext());
                        musicalChairs.setNext(node);
                        musicalChairs = node;
                    }

                }
            }
        }


     }

    /**
     * 
     * This method repeatedly removes students from the musicalChairs until there is only one
     * student (the winner).
     * 
     * Choose a student to be elimnated from the musicalChairs using StdRandom.uniform(int b),
     * where b is the number of students in the musicalChairs. 0 is the first student in the 
     * list, b-1 is the last.
     * 
     * Removes eliminated student from the list and inserts students back in studentsInLine 
     * in ascending height order (shortest to tallest).
     * 
     * The last line of this method calls the seatStudents() method so that students can be seated.
     */
    public void playMusicalChairs() {

        // WRITE YOUR CODE HERE
        //studentsInLine = null;

        int lengthOfMusicalChair = getCountInMusicalChair();


        while (lengthOfMusicalChair > 1) {
            //System.out.println("lengthOfMusicalChair at the beginning :" + lengthOfMusicalChair);
            printMusicalChairs();
            int pos = StdRandom.uniform(lengthOfMusicalChair);
            // System.out.println("deleting pos :" + pos);
            SNode eliminatedNode = getNodeToBeDeleted(pos);
            // System.out.println("eliminated node: " + eliminatedNode.getStudent());
            musicalChairs = deleteAtPosition(pos, lengthOfMusicalChair);
            //System.out.println("after deleting musical chair now");
            printMusicalChairs();
            //  studentsInLine.setNext(eliminatedNode);
            // System.out.println("calling addEliminantedNodeToStudentInLine");
            addDeletedNodeToStudentInLine(eliminatedNode.getStudent());
            printStudentsInLine();
            lengthOfMusicalChair--;
        }
        seatStudents();

    } 
    private void addDeletedNodeToStudentInLine(Student deletedStudent) {
        printStudentsInLine();

        SNode currNode;

        if (studentsInLine == null ||
                studentsInLine.getStudent().getHeight() > deletedStudent.getHeight()) {
            SNode deletedNode = new SNode(deletedStudent, studentsInLine);

            studentsInLine = deletedNode;
        } else {

            currNode = studentsInLine;
            while (currNode.getNext() != null) {
                //System.out.println("student :" + currNode.getNext().getStudent().print());
                // System.out.println("student :" + currNode.getNext().getStudent().getHeight());
                if (currNode.getNext().getStudent().getHeight() < deletedStudent.getHeight())
                    currNode = currNode.getNext();
                else {
                    SNode deletedNode = new SNode(deletedStudent, currNode.getNext());
                    currNode.setNext(deletedNode);
                    break;
                }

            }

        }

    }

    private SNode deleteAtPosition(int index, int len) {


        int count = 0;
        SNode previous = musicalChairs, next = musicalChairs, head = musicalChairs;
        // check list have any node
        // if not then return
        if (head == null) {
            // System.out.printf("\nDelete Last List is empty\n");
            return null;
        }
        // given index is in list or not
        if (index >= len || index < 0) {
            //  System.out.printf("\nIndex is not Found\n");
            return null;
        }
        while (len > 0) {
            // if index found delete that node
            if (index == count) {

                if (index == 0) {
                    return deleteFirstNode();
                } else if (index == (getCountInMusicalChair() - 1)) {
                    previous.setNext(musicalChairs.getNext());
                    head = previous;
                } else previous.setNext(next.getNext());
                return head;
            }
            previous = previous.getNext();
            next = previous.getNext();
            len--;
            count++;
        }
        return head;
    }

    private SNode deleteFirstNode() {
        SNode head = musicalChairs.getNext();
        SNode prev = head, firstNode = head;

        if (head == null) {
            return null;
        }

        if (prev.getNext() == prev) {
            head = null;
            musicalChairs = null;
            return null;
        }


        while (prev.getNext() != head) {
            prev = prev.getNext();
        }

        prev.setNext(firstNode.getNext());
        head = prev.getNext();
        musicalChairs = prev;

        return musicalChairs;
    }

    private int getCountInMusicalChair() {
        SNode head = musicalChairs;
        int count = 0;
        if (musicalChairs != null) {
            do {
                head = head.getNext();
                count++;
            } while (head != musicalChairs);
        }

        return count;
    }

    private SNode getNodeToBeDeleted(int pos) {

        if (pos == 0)
            return musicalChairs.getNext();


        SNode curr = musicalChairs.getNext();

        for (int i = 1; i <= pos; i++)
            curr = curr.getNext();


        return curr;
    }


    /**
     * Insert a student to wherever the students are at (ie. whatever activity is not empty)
     * Note: adds to the end of either linked list or the next available empty seat
     * @param firstName the first name
     * @param lastName the last name
     * @param height the height of the student
     */
    public void addLateStudent ( String firstName, String lastName, int height ) {
        
        // WRITE YOUR CODE HERE
        Student lateStudent = new Student(firstName, lastName, height);
        SNode lateStudentNode = new SNode(lateStudent, null);
        SNode head = studentsInLine.getNext();
        if (studentsInLine != null) {

            SNode temp = head;
            while (temp.getNext() != null)
                temp = temp.getNext();

            temp.setNext(lateStudentNode);


        } else if (musicalChairs != null) {
            lateStudentNode.setNext(musicalChairs.getNext());
            musicalChairs.setNext(lateStudentNode);
            musicalChairs = lateStudentNode;
        }

        OUTER_LOOP:
        for (int r = 0; r < seatingAvailability.length; r++) {
            for (int c = 0; c < seatingAvailability[r].length; c++) {
                if (seatingAvailability[r][c]) {
                    studentsSitting[r][c] = lateStudent;
                    break OUTER_LOOP;
                }
            }
        }
        
    }

    /**
     * A student decides to leave early
     * This method deletes an early-leaving student from wherever the students 
     * are at (ie. whatever activity is not empty)
     * 
     * Assume the student's name is unique
     * 
     * @param firstName the student's first name
     * @param lastName the student's last name
     */
    public void deleteLeavingStudent ( String firstName, String lastName ) {
        if (studentsInLine != null)
        deleteFromStudentInLine(firstName, lastName);

    else if (musicalChairs != null)
        deleteFromMusicalChairs(firstName, lastName);

    if (studentsSitting != null) {

        OUTER_LOOP:
        for (int r = 0; r < studentsSitting.length; r++) {
            for (int c = 0; c < studentsSitting[r].length; c++) {

                if (studentsSitting[r][c] != null && studentsSitting[r][c].getFirstName().equals(firstName) && studentsSitting[r][c].getLastName().equals(lastName)) {
                    studentsSitting[r][c] = null;
                    break OUTER_LOOP;
                }
            }
        }

    }
    }

    private void deleteFromMusicalChairs(String fName, String lName) {
        SNode head = musicalChairs.getNext();

        if (head == null)
            return;


        SNode currNode = head, prev = new SNode();
        while (!(currNode.getStudent().getFirstName().toLowerCase().equals(fName.toLowerCase())
                && currNode.getStudent().getLastName().toLowerCase().equals(lName.toLowerCase())
        )) {
            if (currNode.getNext() == head) {

                break;
            }

            prev = currNode;
            currNode = currNode.getNext();
        }


        if (currNode == head && currNode.getNext() == head) {
            head = null;
            musicalChairs = null;
            // return head;
        }

        if (currNode == head) {
            prev = head;
            while (prev.getNext() != head)
                prev = prev.getNext();
            head = currNode.getNext();
            prev.setNext(head);
        } else if (currNode.getNext() == head) {
            prev.setNext(head);
        } else {
            prev.setNext(currNode.getNext());
        }

        musicalChairs = prev;

    }

    private void deleteFromStudentInLine(String fName, String lName) {
        SNode curr = studentsInLine, prev = null;

        if (curr != null &&
                (curr.getStudent().getFirstName().toLowerCase().equals(fName.toLowerCase())
                        && curr.getStudent().getLastName().toLowerCase().equals(lName.toLowerCase())
                )) {
            studentsInLine = curr.getNext();
            return;
        }


        while (curr != null && !(curr.getStudent().getFirstName().toLowerCase().equals(fName.toLowerCase())
                && curr.getStudent().getLastName().toLowerCase().equals(lName.toLowerCase())
        )) {
            prev = curr;
            curr = curr.getNext();
        }

        // If key was not present in linked list
        if (curr == null)
            return;

        // Unlink the node from linked list
        prev.setNext(curr.getNext());
    }


    /**
     * Used by driver to display students in line
     * DO NOT edit.
     */
    public void printStudentsInLine () {

        //Print studentsInLine
        StdOut.println ( "Students in Line:" );
        if ( studentsInLine == null ) { StdOut.println("EMPTY"); }

        for ( SNode ptr = studentsInLine; ptr != null; ptr = ptr.getNext() ) {
            StdOut.print ( ptr.getStudent().print() );
            if ( ptr.getNext() != null ) { StdOut.print ( " -> " ); }
        }
        StdOut.println();
        StdOut.println();
    }

    /**
     * Prints the seated students; can use this method to debug.
     * DO NOT edit.
     */
    public void printSeatedStudents () {

        StdOut.println("Sitting Students:");

        if ( studentsSitting != null ) {
        
            for ( int i = 0; i < studentsSitting.length; i++ ) {
                for ( int j = 0; j < studentsSitting[i].length; j++ ) {

                    String stringToPrint = "";
                    if ( studentsSitting[i][j] == null ) {

                        if (seatingAvailability[i][j] == false) {stringToPrint = "X";}
                        else { stringToPrint = "EMPTY"; }

                    } else { stringToPrint = studentsSitting[i][j].print();}

                    StdOut.print ( stringToPrint );
                    
                    for ( int o = 0; o < (10 - stringToPrint.length()); o++ ) {
                        StdOut.print (" ");
                    }
                }
                StdOut.println();
            }
        } else {
            StdOut.println("EMPTY");
        }
        StdOut.println();
    }

    /**
     * Prints the musical chairs; can use this method to debug.
     * DO NOT edit.
     */
    public void printMusicalChairs () {
        StdOut.println ( "Students in Musical Chairs:" );

        if ( musicalChairs == null ) {
            StdOut.println("EMPTY");
            StdOut.println();
            return;
        }
        SNode ptr;
        for ( ptr = musicalChairs.getNext(); ptr != musicalChairs; ptr = ptr.getNext() ) {
            StdOut.print(ptr.getStudent().print() + " -> ");
        }
        if ( ptr == musicalChairs) {
            StdOut.print(musicalChairs.getStudent().print() + " - POINTS TO FRONT");
        }
        StdOut.println();
    }

    /**
     * Prints the state of the classroom; can use this method to debug.
     * DO NOT edit.
     */
    public void printClassroom() {
        printStudentsInLine();
        printSeatedStudents();
        printMusicalChairs();
    }

    /**
     * Used to get and set objects.
     * DO NOT edit.
     */

    public SNode getStudentsInLine() { return studentsInLine; }
    public void setStudentsInLine(SNode l) { studentsInLine = l; }

    public SNode getMusicalChairs() { return musicalChairs; }
    public void setMusicalChairs(SNode m) { musicalChairs = m; }

    public boolean[][] getSeatingAvailability() { return seatingAvailability; }
    public void setSeatingAvailability(boolean[][] a) { seatingAvailability = a; }

    public Student[][] getStudentsSitting() { return studentsSitting; }
    public void setStudentsSitting(Student[][] s) { studentsSitting = s; }

}
