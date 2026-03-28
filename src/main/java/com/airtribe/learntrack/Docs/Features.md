## Key Features

* **Student Administration**: Create and manage student profiles, including automated ID generation and status tracking.
* **Course Management**: Maintain a catalog of courses with details on duration and active/inactive status.
* **Dynamic Enrollment System**: Seamlessly link students to courses with a dedicated Enrollment Service that tracks the date and current status (Active, Completed, or Cancelled).
* **Custom Exception Handling**: Uses a specialized `EntityNotFoundException` to gracefully handle errors when searching for IDs that don't exist.
* **Inheritance Hierarchy**: Utilizes a `Person` base class to allow for future expansion (e.g., adding Instructors or Admins).
* **Status Tracking**: Real-time status updates for enrollments to monitor student progress.