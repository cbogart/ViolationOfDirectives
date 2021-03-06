**Branches for different tasks:**

There are commit for both the faulty code and a sample fix in these branches.
You can look though the branch commit messages to find the version of 
interest. (note: last parentheses in each line are quick personal reminders 
about the different tasks and are not consistent)

- Android Task 1 (TA1): FAULT_031_SO_11495527 (meeting time issue)
- Android Task 2 (TA2): FAULT_029_SO_27375363 (serious warning - parameter in constructor)
- Android Task 3 (TA3): FAULT_017_SO_29115050 (setHasOptionsMenu(true) missing)
- Android Task 4 (TA4): FAULT_013_SO_6215239 (others tab crashes)
- Android Task 5 (TA5): FAULT_63_SO_19999172 (setArguments issue - change color of button)
- Android Task 6 (TA6): FAULT_050_SO_25652512 (context menu when meant options menu)
- Android Task 7 (TA7): FAULT_012_SO_19597901 (missing false parameter)


**Steps to create ROS tasks**

Task 1 (TR1): 
Install code to have one turtlesim mimic another turtlesim as per: [http://wiki.ros.org/ROS/Tutorials/UsingRqtconsoleRoslaunch]
In the mimic.cpp file (shown here: [http://docs.ros.org/diamondback/api/turtlesim/html/mimic_8cpp_source.html]) change line 38 to “ros::spinOnce();”, making the callback (defined on line 25) execute only once instead of continuously. 

Task 2 (TR2):
Install the mp3controller ros_service_examples as hosted here: [https://github.com/fairlight1337/ros_service_examples]
In the mp3_controller.cpp file (shown here: [https://github.com/fairlight1337/ros_service_examples/blob/master/src/mp3_controller.cpp]), modify it to reflect the
mp3_controller_modified.cpp file in the main folder of the master branch, and give it a launch file as shown in attached media.launch in the same location, such that it instead retrieves the strDirectory parameter from the parameter server, but looks in the global namespace instead of in the local namespace, where it is (as shown in launch file).

Task 3 (TR3):
Install code to have one turtlesim mimic another turtlesim as per: [http://wiki.ros.org/ROS/Tutorials/UsingRqtconsoleRoslaunch]
In the turtle.cpp file (shown here: [http://docs.ros.org/hydro/api/turtlesim/html/turtle_8cpp_source.html]) modify the callback parameter on line 66 to read “const turtlesim::Velocity_::ConstPtr& vel”, thus using the old Velocity type instead of Twist


----------------------------------------------------------------------------------
Original README from forked repo

Android LNotifications Sample Sample
===================================

This sample demonstrates new features for notifications introduced in Android L.
These features include heads-up notifications, visibility, people, category and priority
metadata.

Introduction
------------

Android 5.0 (Lollipop, API level 21) introduced additional features to the Notification API.
Specifically, it allows developers to specify the priority and visibility level for
notifications. This metadata allows the system to provide enhanced security for notifications
while the lock screen is active, allows high-priority notifications to appear even when
the notification bar is closed, and provides users to silence low-priority notifications
when they're busy.

This metadata is provided via additional arguments to the `Notification.Builder` class.

Specifically, this sample demonstrates how to generate a heads-up notification
(`HeadsUpNotificationFragment`), how to control visibility on the lock screen
(`VisibilityMetadataFragment`), and how to set the category, priority, and associated contact
for a notification (`OtherMetadataFragment`).

Pre-requisites
--------------

- Android SDK v21
- Android Build Tools v21.1.1
- Android Support Repository

Screenshots
-------------

<img src="screenshots/1-headsup.png" height="400" alt="Screenshot"/> <img src="screenshots/2-visibility.png" height="400" alt="Screenshot"/> <img src="screenshots/3-others.png" height="400" alt="Screenshot"/> 

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

Support
-------

- Google+ Community: https://plus.google.com/communities/105153134372062985968
- Stack Overflow: http://stackoverflow.com/questions/tagged/android

If you've found an error in this sample, please file an issue:
https://github.com/googlesamples/android-LNotifications Sample

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request through GitHub. Please see CONTRIBUTING.md for more details.

License
-------

Copyright 2014 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
