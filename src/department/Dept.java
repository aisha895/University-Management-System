package department;

import java.util.*;

public class Dept {
	
	// Creating all instance variables for Dept class
	ArrayList<Academics> academics;
	ArrayList<Administrator> administrator;
	ArrayList<Faculty> faculty;
	ArrayList<UGrad> uGrad;
	List<Grad> grad;
	List<ProgramDirector> programDirector;
	ChairPerson chairperson;
	int index = 0;
	static final int maxStudents = 8;
	static final int maxTA = 5;
	

	/**
	 * Creating Dept default constructor to initialize arraylists.
	 */
	public Dept() {
		academics = new ArrayList<Academics>();
		administrator = new ArrayList<Administrator>();
		faculty = new ArrayList<Faculty>();
		uGrad = new ArrayList<UGrad>();
		grad = new ArrayList<Grad>();
		programDirector = new ArrayList<ProgramDirector>();

	}

	/**
	 * Creating Dept overloaded constructor to create a chairperson.
	 * @param chair is the ChairPerson assigned.
	 */
	public Dept(ChairPerson chair) {
		this();
		this.chairperson = chair; 
	}
	
	/**
	 * 
	 * @return returns the chairperson
	 */
	public ChairPerson getChairPerson() {
		return this.chairperson;
	}
	
	/**
	 *  HireFaculty() hires faculty and adds it to the faculty ArrayList if it already doesnt exist.
	 * @param f is the faculty to be added
	 * @throws NoSpaceException is the exception that checks that the max limit of faculty is not exceeded.
	 */
	public void HireFaculty(Faculty f) throws NoSpaceException{
		if(this.faculty.size() == 70) {
			throw new NoSpaceException();
		}else {
			if(!(faculty.contains(f))){
				faculty.add(f); //Adds faculty only if there is less than 70 members and it is not a duplicate.
			}
		}
	}
	
	/**
	 * 
	 * @return it returns the faculty ArrayList.
	 */
	public ArrayList<Faculty> getFaculty() {
		return faculty;
	}

	/**
	 * 
	 * @return it returns the number of faculty in the university.
	 */
	public int getNumOfFaculty() {
		return faculty.size();
	}
	
	
	/**
	 * It adds a student to the faculty which has space. It is on a first come
	 * first serve basis.
	 * @param student is the undergrad student that gets assigned to a faculty.
	 */
	public void AdmitStudent(UGrad student) {
		int n = index;
		if(this.faculty.get(n).getNumOfAdvisingUGrads() < 8) {
			addStudent(student, n); //Adds student only if there is less than 8 advisees for the faculty.
		}
		else {
			n += 1;
			index = n;
			addStudent(student, n); //Adds student to the next faculty available.
		}
	}
	
	/**
	 * addStudent() assigns a student a faculty and a faculty the student.
	 * The function also sorts based on alphabetical order.
	 * @param ugrad is the student needed to be assigned
	 * @param n is the location in the arrayList that designates which faculty to add to.
	 */
	public void addStudent(UGrad ugrad, int n) {
		if(this.uGrad.size() <= 500) {
			if(!(this.uGrad.contains(ugrad))){
				this.uGrad.add(ugrad); // Adds uGrad student if its not a duplicate.
				Collections.sort(uGrad); //Sorts based on name alphabetically
				ugrad.setFaculty(this.faculty.get(n)); //Adds student objects faculty in Student class.
				faculty.get(n).setAdvising(ugrad);//Adds student to faculty arrayList in Faculty class.
			}
		}
	}

	/**
	 * 
	 * @return it returns the number of undergrad students;
	 */
	public int getNumOfUGradStudents() {
		return uGrad.size();
	}
	
	/**
	 * 
	 * @return it returns the number of graduate students;
	 */
	public int getNumOfGradStudents() {
		return grad.size();
	}
	
	/**
	 * HireTA hires the added student as a TA if there is space in the faculty.
	 * @param s is the graduate student to be assigned as a TA.
	 * @throws NoSpaceException is the exception thrown if all faculties are full.
	 */
	public void HireTA(Grad s) throws NoSpaceException {
		if(this.grad.size() <= 150) {
		int n =	index;
		if(this.faculty.get(n).getTAs().size() < 5) {
			addTA(s, n); //Adds TA to faculty n if there is space.
		}
		else if(this.faculty.get(n+1).getTAs().size() < 5){
			n += 1;
			index = n;
			addTA(s, n); // adds TA to next location.
		}
		}
		else {
			throw new NoSpaceException();
		}
	}
	
	/**
	 * addTA adds the TA to the faculty arrayList and assigns the graduate student a faculty.
	 * @param s is the graduate student to be assigned as a TA.
	 * @param n is the location in the arrayList to designate which faculty should the student 
	 * be assigned a TA to.
	 */
	public void addTA(Grad s, int n) {
		if(!(this.grad.contains(s))){
			this.grad.add(s); // Adds student to grad array only if its not a duplicate.
			Collections.sort(grad);
			s.setFaculty(this.faculty.get(n)); //Set student's faculty in Student class
			faculty.get(n).setTA(s); //Add student to TA array in Faculty class.
		}
		if(!(this.faculty.get(n).TA.isEmpty())) {
			this.faculty.get(n).populated = true; // If there exists a TA in current faculty object populated = true
		}
	}

	/**
	 * AlumnusUGrad is a function that removes all links between an undergraduate
	 * student and a faculty after they have graduated.
	 * @param student is the undergraduate student that is graduating.
	 */
	public void AlumnusUGrad(Student student) {
		this.faculty.get(index).advising.remove(student); //Remove student from advising array in Faculty class.
		this.uGrad.remove(student);//Remove student from uGrad array.
	}

	/**
	 * AlumnusGrad is the function that removed all links between a graduate and their
	 * faculty after graduating.
	 * @param student is the student that is graduating
	 * @throws NoTAException is thrown when a faculty's last TA graduate leaving it empty.
	 */
	public void AlumnusGrad(Grad student) throws NoTAException {
		this.faculty.get(index).TA.remove(student);
		this.grad.remove(student); // Removed connections between grad and faculty.
		if(this.faculty.get(index).TA.isEmpty()){
			this.faculty.get(index).populated = false; // Populated becomes false if the last TA is removed from faculty.
		}
		if(this.faculty.get(index).populated == false) {// Checks if the faculty has its last TA removed
			for(int i = 0; i < this.faculty.size(); i ++) {
				if(this.faculty.get(i).TA.isEmpty()) { 
					throw new NoTAException();
				}
			}
		}
		
		
	}

	/**
	 * 
	 * @return it returns an arrayList of all graduate students.
	 */
	public List<Grad> ExtractAllGradDetails() {
		return this.grad;
	}

	/**
	 * 
	 * @return it returns an arrayList of all undergraduate students.
	 */
	public List<UGrad> ExtractAllUGradDetails() {
		return this.uGrad;
	}

	/**
	 * 
	 * @return it returns all faculty details after sorting them alphabetically by name.
	 */
	public List<Faculty> ExtractAllFacultyDetails() {
		Collections.sort(faculty);//Sort faculty array alphabetically.
		return this.faculty;
	}

	/**
	 * Extracts all faculty details based on program.
	 * @param string is the program to search for.
	 * @return it returns all the faculty details of the required program in alphabetical oder by name.
	 */
	public List<Faculty> ExtractFacultyDetails(String string) {
		List<Faculty> fcopy = new ArrayList<Faculty>();
		for(int  i = 0; i < this.faculty.size(); i++){
			if(this.faculty.get(i).program.equals(string)) {
				fcopy.add(faculty.get(i)); // Add all faculty that are in the required program
			}
		}
		Collections.sort(fcopy); //sort array alphabetically
		return fcopy;
	}

	/**
	 * 
	 * @param f is the faculty who's advisees we wish to extract
	 * @return it returns all undergraduate students advised by faculty f in alphabetical order by name.
	 */
	public ArrayList<Student> ExtractAdviseesDetails(Faculty f) {
		Collections.sort(f.advising); //Sort advising array based on name;
		return f.advising;
	}

	/**
	 * 
	 * @param f is the faculty who's TA's we wish to extract.
	 * @return it returns all graduate students who are TA's in faculty f, sorted by alphabetical.
	 */
	public ArrayList<Student> ExtractTAsDetails(Faculty f) {
		Collections.sort(f.TA); //Sort TA array based on name
		return f.TA;
	}

	/**
	 * 
	 * @param p1 p1 adds a program director.
	 * @throws NoSpaceException is thrown if more than 3 programDirectors are added. 
	 */
	public void addProgramDirector(ProgramDirector p1) throws NoSpaceException{
		if(programDirector.size() <= 3) {
			this.programDirector.add(p1); 
		}
		else {
			throw new NoSpaceException();
		}
	}

	/**
	 * Retires the faculty and then assigns the remaining advisees and TA's to the next available 
	 * faculty.
	 * @param f is the faculty that is retiring.
	 * @throws NoSpecialtyException is thrown if there is no other faculty with the required skills.
	 * @throws NoSpaceException is thrown if there is no space to reassign students.
	 */
	public void RetireFaculty(Faculty f) throws NoSpecialtyException, NoSpaceException {
		boolean a = false;
		ArrayList<Student> Grad = new ArrayList<Student>();
		
		for(int i = 0; i < f.TA.size(); i++) {//Adding all TA into local arrayList
					Grad.add(f.TA.get(i));
		}
		this.faculty.remove(f); //Deleting faculty
		
		for(int i = 0; i < this.faculty.size(); i++) {
			
			if(this.faculty.get(i).TA.size() == 5) {
				a = true; // If all faculty have max number of TA's
			}
		}
		
		if(a == true) {
			throw new NoSpecialtyException();
		}
		else{
			for(int i = 0; i < grad.size(); i++) {
				this.HireTA(grad.get(i)); //Add TA's to remaining Faculties.
			}
		}
	}
}