Assumption:-

1:-Visitor can buy only one membership at a time by particular name.
2:- In visitAnimal function, which i implemented in the visitor class , i just assume 3 kinds of animals are present in the zoo , that is lion,frog snake. Basically there is one animal of each particular type, and so i hardocde them, and then what the visitor wants to do in the visitAnimal function that is feed the animal or read about the description of that animal, visitor can do that only of these 3 animals. And other animal which admin add, they are added in the zoo but visitor can visit hese animals only , one of each particular type.
3:- In view discount also i just assumme that these are the discount which user can applied and the time of buying the tickets these discounts are getting availed automatically that time.

Also i uses 2 interface which i implemented in later class.
Readme File

This Java program, titled "ZOOtopia", simulates a zoo management system where administrators can manage attractions, animals, events, discounts, and special deals. Visitors can register, log in, explore the zoo, buy memberships, tickets, view discounts, special deals, visit animals and attractions, and leave feedback.

Key Features:

Admin Features:

Manage attractions: Add, view, modify, or remove attractions.
Manage animals: Add, update, or remove animals.
Schedule events: Set opening and closing times, ticket prices, and initial visitor counts.
Set discounts: Add, modify, or remove discounts based on age groups.
Set special deals.
View visitor statistics and feedback.
Visitor Features:

Register and log in.
Explore the zoo: View attractions and animals.
Buy memberships: Basic or premium, with optional discount codes.
Buy tickets for attractions.
View available discounts and special deals.
Visit animals and attractions.
Leave feedback.
command use :-
1) mvn clean
2) mvn compile
3) mvn package
4) java -jar target\_2022157_dhairya-1.0-SNAPSHOT.jar