//maintains a list of Staff objects as an ArrayList

import java.util.ArrayList;
import java.util.Collections;

public class StaffList
{
    // Storage for an arbitrary number of details.
    private final ArrayList <Staff> staffList;

    /**
     * Perform any initialization for the address book.
     */
    public StaffList()
    {
        staffList = new ArrayList<Staff>() ;
    }
    
    /**
     * Look up an id and return the
     * corresponding staff details.
     * @param id The id  to be looked up.
     * @return The details corresponding to the id, null if none
     */
    public Staff findById(String id)
    {
    	for (Staff s : staffList)
    	{
    		if (s.getId().equals(id))
    		{
    			return s;
    		}
    	}
    	return null;
    }

    /**
     * Add a new set of details to the list
     * @param details The details of the staff
     */
    public void addDetails(Staff details) throws DuplicateIDException
    {
        // Checking for null in addDetails method is necessary
        // to ensure that a null Staff object is not added to the staffList.
        // Yes, it is a good idea. It prevents the addition of null entries
        // in the staffList, avoiding NullPointerException in future operations.
        // Yes, it's a good practice to check for null parameters in the Staff
        // constructor to ensure the object is properly initialized with valid data.
        // In the Staff constructor, it is appropriate to check for null or empty values for 'id' and 'name'.
        // 'hoursWorked' is an int and cannot be null.

    	if (details == null )
    		throw new IllegalArgumentException();
    	else {
    		String id = details.getId();
    		if (findById(id) != null)
    			throw new DuplicateIDException(id);
    		else
				staffList.add(details);
    	}
    }
    
    /**
     * remove Staff object identified by this ID
     * @param id the ID identifying the person to be removed
     */
    public void removeDetails(String id) throws NoMatchingIDException {
    	int index = findIndex(id);
    	if (index != -1) {
    		staffList.remove(index);
    	} else {
            throw new NoMatchingIDException(id);
        }
    }
    /**
     * Look up an id and return index
     * @param id The id  to be looked up.
     * @return The index, -1 if none
     */
    private int findIndex(String id)
    {
    	int size =staffList.size();
    	for (int i = 0; i < size; i++)
    	{
    		Staff s = staffList.get(i);
    		if (s.getId().equals(id))
    		{
    			return i;
    		}
    	}
    	return -1;
    }

    /**
     * @return The number of entries currently in the
     *         address book.
     */
    public int getNumberOfEntries()
    {
        return staffList.size();
    }

 
    /**
     * @return All the staff details
     */
    public String listDetails()
    {
    	StringBuffer allEntries = new StringBuffer();
        for(Staff details : staffList) {
            allEntries.append(details);
            allEntries.append('\n');
        }
        return allEntries.toString();
    }
    
    /**
     * @return All the staff details in name order
     */
    public String listByName()
    {
    	staffList.sort(new StaffNameComparator());
    	return listDetails();
    }
    
    /**
     * @return All the staff details in id order
     */
    public String listByID()
    {
    	Collections.sort(staffList);
    	return listDetails();
    }
}
