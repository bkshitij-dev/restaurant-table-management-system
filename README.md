## Assignment: Design a Table Management System for a Restaurant

You are required to design and implement a Table Management/Planning System for
restaurants. The system should be built using Spring Boot and should focus on optimising
table turnover while ensuring reservations are handled efficiently. Your solution should
include the core features listed below, and you will need to make appropriate design
decisions to meet the requirements.

### Core Features

1. #### Table Management:
    <ul>
        <li>
        The system should allow for the creation of tables, where each table has a
   unique identifier, name, and a defined seating capacity.
        </li>
   <li>
        Tables should be stored persistently, and their status should be easily
   retrievable at any point in time.
        </li>
    </ul>
   
2. #### Reservation Handling:
    <ul>
        <li>
        Implement functionality to handle incoming table reservations.
        </li>
   <li>
        The system should assign the most appropriate available table(s) based on
   the reservation request, aiming to maximise table turnover.
        </li>
   <li>
        If a new reservation comes in that could potentially optimise the turnover, the
   system should intelligently reshuffle table assignments(i.e deallocate
   previously assigned table) to accommodate the new reservation if this results
   in higher utilisation.The system should prioritise table allocations that allow for
   the highest number of seatings during operating hours.
        </li>
   <li>
        You can assume the table can be turned in 2 hours time. Example, if you
   reserve the table for 5PM, you can expect the table to be free at 7PM i.e
   table is only reserved for two hours.
        </li>
    </ul>