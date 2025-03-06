This is a basic project that implements a database for hotel management. It includes five main classes: Hotel, Room, Customer, Payment, and Booking.

The purpose of the application is to manage reservations and keep track of them, 
including check-in date with the assigned room, check-out time, price, room type with its size, guest capacity, and more. 
It also manages the payment method and the details of the customer making the reservation.

To use the application, you must create objects of independent classes such as Hotel, Customer, and Payment in Postman.
Next, it is recommended to create an instance of Room, which contains a Hotel object that must already be created.
Finally, to instantiate the Booking class, it is necessary to have Room, Customer, and Payment objects, as their existence will be validated through their respective IDs when creating a booking.
