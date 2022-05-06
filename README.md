# Flight Booking System


## 1. Building the project and steps to execute the same


mvn compile
mvn clean install
mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="<arg1> <arg2 > <arg3> <arg4>"

<arg1> = Sample.csv which has booking details.

<img width="468" alt="image" src="https://user-images.githubusercontent.com/89234498/167052430-b679ab47-d635-4e07-aa74-8aae74bd4719.png">
Image of the columns should be as shown above

<arg2> = flight.csv which has booking details.

<img width="601" alt="image" src="https://user-images.githubusercontent.com/89234498/167052446-1328c88a-1a4b-4963-810f-3bd1f0686299.png">
Image of the columns should be as shown above

Note:- Seat Categories are as follows 
Economy
Premium Economy
Business

<img width="468" alt="image" src="https://user-images.githubusercontent.com/89234498/167052483-4302f535-dfe9-4fa8-8c36-a155d57d3d11.png">
Image of the seat category is shown above

<arg3> = Output.csv which has all valid booking details.

<img width="472" alt="image" src="https://user-images.githubusercontent.com/89234498/167052499-42b04506-e92d-469d-a994-8aa1f4d7211e.png">
Image of the valid booking details is shown above

<arg4> = Output.txt which has all invalid booking details.

<img width="468" alt="image" src="https://user-images.githubusercontent.com/89234498/167052509-5085f17e-5102-4321-b35c-35cef4e32ecb.png">
Image of the invalid booking details is shown above


## 2. Answers for the question


Describe what is the primary problem you try to solve

The primary problem I tried to solve was that every flight has 3 different types of categories i.e. Economy, Premium Economy and Business so storing each type of seat count and price was a challenging task and there are multiple ways to approach this problem and decided to create a class so that accessing the type of seat for each flight would be easier.

Describe what are the secondary problems you try to solve

The secondary problem which I tried to solve was accessing the flight information from the flight inventory and to do so I needed the same flight inventory object so I used a singleton design pattern. Along with this problem, validating users credit card information was also an issue. To solve this issue I used a chain of responsibility.

Describe what design pattern(s) you use how (use plain text and diagrams)

Singleton Design Pattern
The purpose of the Singleton pattern is to ensure that there is only one instance of a class, and that there is a global access point to that object. The pattern ensures that the class is instantiated only once and that all requests are directed to that one and only object.

For the project I have created a Singleton class named FlightInventory. This class has a private constructor which is called only once when a public function getInstance is called. If the getInstance is called for the first time then this constructor is called and the object is created. I used this pattern as the in different classes I need this FlightInverntory object as it contains all the data of each and every flight. So the same object is called everywhere in the code to ensure that I have used the Singleton design pattern.

Chain of Responsibility
Chain of Responsibility as a design pattern consisting of “a source of command objects and a series of processing objects”. Each processing object in the chain is responsible for a certain type of command, and the processing is done, it forwards the command to the next processor in the chain.

For the project I have created a Chain of Responsibility for validating credit cards. The purpose of this is that if the credit card does not belong to one of the categories the credit card information is passed to the next chain to validate the credit card.

Builder Design Pattern
Builder is a creational design pattern, which allows constructing of complex objects step by step. Unlike other creational patterns, Builder doesn't require products to have a common interface. That makes it possible to produce different products using the same construction process.

For the project I have used builder interface to create the flight inventory and then defined a builder interface object which is basically a singleton class object.


Describe the consequences of using this/these pattern(s).
Singleton Design Pattern
Singletons don't scale. No matter what you think should be a singleton, when your system gets bigger, it turns out you need more than one. If you never need more than one, a singleton is fine. However, as systems scale, you typically need more than one of anything within its own context. Singletons are merely another way to say "global". It's not bad, but generally, it's not a good idea for systems that evolve and grow in complexity.
 
Chain of Responsibility
The request must be received not guarantee. The performance of the system will be affected, but also in the code debugging is not easy and may cause cycle calls. It may not be easy to observe the characteristics of the operation, due to debugging.
Builder
The number of lines of code increases at least to double in builder pattern, but the effort pays off in terms of design flexibility and much more readable code. Requires creating a separate ConcreteBuilder for each different type of Product.


Class Diagram


 <img width="522" alt="image" src="https://user-images.githubusercontent.com/89234498/167052599-e4e00cc2-5fef-486f-8416-583aa6b14ee5.png">

Drive Link to class Diagram:- https://drive.google.com/file/d/19491ABReSORjYG8nGOaRLSdeaeIuPPyo/view?usp=sharing
## 3. Screenshot

Test cases run

<img width="468" alt="image" src="https://user-images.githubusercontent.com/89234498/167052631-d1a0ad04-774a-4326-a421-61737dced8eb.png">
