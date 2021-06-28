1. An architecture design of service(s). Documentation with visual examples encouraged.
2. A mock API service prototype. Include all source code, and it should be something that could
be run/interacted with locally by start-up engineering reps.
Your work should be delivered as a shared GitHub repo.
The service(s) will support a mobile app, which the founders assure you will go viral within a
month of its initial launch.
The service(s) will provide the following functionality:
● Storing location data from cellular transmitters attached to pet collars and collected by
units installed on cell towers.
● Returning historical location data for a given pet (basic users can see the last 24 hours
while premium users can see the last 30 days of data).
● Searching for and returning contact information for opted-in owners of other pets within a
5-mile radius. [Note: This is premium functionality.]
You will provide an architecture diagram for the service(s) and related infrastructure. The
founders are not available for consultation; list significant assumptions you make in your design
(including work to be done in different phases of development).
The service prototype will use canned location data and will be used for initial integration as the
mobile app is developed. Again, list significant assumptions made in creating the prototype


Assumption:

1) The Data Collection Units installed on the tower write data continuously to a CSV file
2) We are not capturing the GPS but we have a tower unit which does all the work GPS data capturing
3) Capacity Estimation and Constraints
#
Let’s assume that we have 500 daily active users, and on average, each unit sends 400 messages daily; this gives us 200000 messages per day.

Storage Estimation: A message is 100 bytes. So to store all the messages for one day, we would need 100GB of storage.

High level estimates:

Total messages	200000 unit messages per day
Storage for each day	100GB
Storage for 30 days days max data being stored 3000GB/3TB
Addiotinal Buffer of 3TB for buffer DB

