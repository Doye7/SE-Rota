# SE-Rota
Software Engineering Coursework

Creating a rota system for automatically allocating work hours.

# Instructions for use
Open the project INSEBase in netbeans (version 8.2 used to build).

Click the green Triangle on the toolbar to run the program.

On the very first run you will be presented with a notification saying there are no employees in the system.

Dissmissing the message you will see the main menu of the program.

If there are no previous employees you cannot view the timetable until at least one is added.

# Add new employees
To add a new employee fill in the form provided and click add.

To close the form without adding any new employee click discard.

There are several validation rules in place to prevent incorrect data being added. Name should be a first and a last name. Shorthand should be 3 letters that can be easily recognised as that employee. Maximum hours should be any integer defaulted to 20. ID should be that employees personal number.

# View Employees
View employees shows the entire list of employees. The buttons Next and Prev can be used to navigate through.

The window shows infomation about each employee and underneath that, what hours they would prefer not to work.

These hours can be changed by picking the coresponding timeslot on the right and clicking toggle. The window should update automatically.

# View Timetable
Clicking view timetable will show the systems generated timetable. If null shows then a manager must fairly allocate that timeslot as no employee has volenteered to work it.

#Save changes
Clicking this button will save all changes made to the employee database to disk. The system creates a single file named employee.ser that will be located at C://data/ (replace C with which ever drive you have java installed to). This file is loaded when the system runs and if deleted will remove all employee data.
