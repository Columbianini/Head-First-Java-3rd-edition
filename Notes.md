Chapter 2
- You can 
put all of your application files  into a Java ARchive—a .jar file—that’s based on the pkzip format. In the jar file, you can include a simple text file formatted as something called a manifest, that defines which class in that jar holds the main() method that should run.

Chapter 3
- Variables come in 2 types: 8 primitives (BCBSILFD) and references
- Object Reference is like a remote control pointed to the actual object in the heap
- Null just means a remote control that isn't controlling/programmed to anything. It is a reference, not actual object

Chapter 4
- Encapsulation: 1. You could validate the setted value in the setter 2. You could easily change code around the instance variables without changing others' codes
- You do not need to initialize the instance variables, it will have DEFAULT values. In contrast, local variables will not have DEFAULT values.
- use "==" to compare if references are the same or primitive types, but always use equals if you want to compare the object values (useful at work)

Chapter 6
- Import or Type: You don’t have to worry about your code becoming bloated, or slower, from too many imports. An import is simply the way you give Java the full name of a class

Chapter 8
- private member are NOT inherited!
    - Subclass could still access base class's private member through public getter and setter. But it could not directly access to it

Chapter 9
- goodness of interface
    -  if you  use interfaces instead of concrete classes (or even abstract classes) as arguments and return types, you can pass anything that implements that interface. And with an interface, a class doesn’t have to come from just one inheritance tree

Chapter 10
- Every constructor can have a call to super() or this(), but never both!

Chapter 11
- Static variable: 
    - value is the same for ALL instances of the class
    - initialized before any object of that class can be created
    - initialized before any static method of the class runs
    - static final variables are constants
- Static methods: you could call it without instantiating the class
- A final variable means you can’t change its value.A final method means you can’t override the method.A final class means you can’t extend the class
- Using a static import removes the information about which class the static came from

Chapter 12
- If the class itself doesn’t use a type parameter, you can still  specify one for a method, by declaring it in a really unusual (but  available) space—before the return type. This method says that T  can be “any type of Animal.”
    - public <T extends Animal> void takeThing(ArrayList<T> list)
- SAM(Single Abstract Method) Interfaces (a.k.a functional interfaces): the only method that needs to be overridden could be used as lambda expression: (a, b) -> (one, two) -> one.getTitle().compareTo(two.getTitle())
- How HashSet determines that 2 elements are the same?
    - a.HashCode() == b.HashCode()
    - a.equal(b)
- How to override your customized object's HashCode?
    - By using the already implemented hashcode of "primitive" or "primitive wrapper" class
- TreeSet Vs HashSet
    - TreeSet could sort and unique the elements
        - The elements in the list  must be of a type that  implements Comparable
        - You use the TreeSet’s overloaded constructor that takes a Comparator
- Convenience Factory Methods for Collections
    - The resulting collections cannot be changed
    - The resulting collections are not the standard Collections we’ve seen
    - List.of(); Set.of(); Map.of(); Map.ofEntries()
- use polymorphic arguments and generics
    - public void takeAnimals(List<Animal> animals) VS public void takeAnimals(List<? extends Animal> animals) 
- the type of a lambda expression is this interface with a Single Abstract Method
- How to judge SAM Interfaces: With **interfaces**, any method that is not defined as **default** or **static** is an abstract method that must be overridden and there is only one such method 
    - a **default** method works a bit like a standard method in an abstract class—they have a body, and will be inherited by subclasses
    - **static** methods  don’t need to belong to an instance, and are often used as helper methods
    - Inherited methods from Object e.g. equals
- If a method is labeled as "@FunctionalInterface", then it is a SAM Interfaces and could be used with Lambda function
- method references: 
    - e.g. Function<Song, String> getGenre = Song::getGenre;
    - Similar functionality as lambda function
- Wrapper Optional 
    - e.g. Optional<Song> result = songs.stream().filter(s -> s.getYear() == 1995).findFirst();
    - result.isPresent() to check whether the wrapped object (in this case, Song) existed
    - result.get() to get the wrapped object
- Some Terminal functions in Stream
    - Collectors.joining <=> "xx".join() in Python
    - check if something exists: anyMatch()...
    - find a specific thing: findFirst() 

Chapter 13
- Risky methods that could fail at runtime declare the exceptions that might happen using “throws SomeKindOfException” on their method declaration
    - public static Sequencer getSequencer() **throws MidiUnavailableException**
- The compiler checks for everything except RuntimeExceptions
    - If you throw an exception in your method, you must declare it using the throws keyword in your method declaration
    - If you call a method that declares it throws an exception, you must acknowledge that you’re aware of the exception possibility. One way to satisfy the compiler is to wrap the call in a try/catch. 
- If the try or catch block has a return statement, finally will still run! Flow jumps to the finally, then back to the return.
- 2 Ways of dealing with risky methods:
    - Handle
    - Declare

Chapter 14
- a control is called **Event Source**
- **Event Source** creates **Event Object** and need to know **event listeners** (add{Action}Listener())
    - Accept Registration, Get Events, and Call the Listener's event-handling method
- **Event Listeners**, when event source fires an event, event listeners should react with {action}Performed() (implemented from the **listener interface**)
    - implement the interface, register with event source and provide the event-handling
- Every **event object** has a matching **listener interface**. If you want MouseEvents, implement the MouseListener interface. The interface might have several different **event methods**
    - argument to event methods
    - carry data about the event back to the listener
- **Inner class**:
    - An inner class can use all the methods and variables of the outer class, even the private ones.
    - The inner class gets to use those variables and methods just as if the methods and variables were declared within the inner class
    - Benefits:
        - Outer class could implement the same interface's method more than once
        - a way to inherit more than one class (the outer class and inner class are in different inheritance trees)
    - Alternatives: Lambda Function

Chapter 15
- A layout manager is a Java object associated with a particular component, almost always a background component.
- The layout manager controls the components contained **within** the component the layout manager is associated with
- 3 types of layout managers
    - BorderLayout
        - five regions: North, South, East, West, Center
        - e.g. frame
    - FLowLayout
        - like word processors: components added from left to right, wrapping to a new line when needed
        - e.g. panel
    - BoxLayout
        - stack components vertically or horizontally
- You could set Layout from FlowLayout to BoxLayout
    - panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
- You can ask Layout Manager to layout the inner component by:
    - <OutComponent>.add(...);





