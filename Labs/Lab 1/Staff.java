//a simple class to contain and manage Staff details
//(id, name, hours)
public class Staff implements Comparable<Staff>
{
	private final String id;
    private final String name;
    private final int hoursWorked;

    /**
     * Set up the contact details. All details are trimmed to remove
     * trailing white space.
     * @param name The name.
     * @param hoursWorked The hours worked
     */
    public Staff(String id, String name, int hoursWorked)
    {   
    	if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or blank");
        }
        if (!id.matches("[A-Z]\\d+")) {
            throw new IllegalArgumentException("Invalid ID format: " + id);
        }
        if (id.length() > 10) { // Example length check
            throw new IllegalArgumentException("ID too long: " + id);
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (!name.matches("[A-Za-z-\\s]+")) {
            throw new IllegalArgumentException("Invalid name format: " + name);
        }
        if (name.length() > 50) { // Example length check
            throw new IllegalArgumentException("Name too long: " + name);
        }

        if (hoursWorked < 0 || hoursWorked > 80) { // Assuming 80 hours as a realistic maximum
            throw new IllegalArgumentException("Invalid number of hours: " + hoursWorked);
        }

        this.id = id.trim();
        this.name = name.trim();
        this.hoursWorked = hoursWorked;
    }
    
    /**
     * @return The id.
     */    
    public String getId() {
    	return id;
    }
    
    /**
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The hours Worked
     */
    public int getHoursWorked()
    {
        return hoursWorked;
    }

    
    /**
     * Test for content equality between two objects.
     * @param other The object to compare to this one.
     * @return true if the argument object has same id
     */
    public boolean equals(Object other)
    {
        if(other instanceof Staff) {
            Staff otherStaff = (Staff) other;
            return id.equals(otherStaff.getId());
        }
        else {
            return false;
        }
    }

    /**
     * Compare this Staff object against another, for the purpose
     * of sorting. The fields are compared by id.
     * @param otherDetails The details to be compared against.
     * @return a negative integer if this id comes before the parameter's id,
     *         zero if they are equal and a positive integer if this
     *         comes after the other.
     */

    public int compareTo(Staff otherDetails)
    {
        return id.compareTo(otherDetails.getId());
    }    

    /**
     * @return A  string containing all details.
     */
    public String toString()
    {
        return String.format("%-5s", id ) + String.format("%-20s", name) +
                 String.format("%5d", hoursWorked );
    }

}
