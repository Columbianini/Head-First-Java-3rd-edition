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

Chapter 16
- Streams
    - **Connection Stream**: represent connections to destinations and sources such as files or network sockets, used to represent connection, e.g. FileOutputStream
    - **Chain Stream**: work only if chained to other streams; used to call methods on, e.g. ObjectOutputStream
- Serialization saves the entire object graph—all objects referenced by instance variables, starting with the object being serialized
- If you want your class to be serializable, implement Serializable
    - if the upper class already implemented Serializable, the subclass will automatically implemented Serializable
- If you want an instance variable to be skipped by the serialization process, mark the variable with the **transient** keyword
    - when you inflate the object, the variable with transient will be null
- You could serialize/deserialize several objects into the same file "xxx.ser"
- **static** variable is not serialized
- if current project could not find the class from which the serialized object is made, deserialization process would generate exception
- Tips: 
    - JFrame.set(JMenuBar); JMenuBar.add(JMenu); JMenu.add(MenuItem)
    - JFileChooser: Brings up a file dialog box and waits on this line until the user chooses ‘Save’ from the dialog box. All the file dialog navigation and selecting a file, etc., is done for you by the JFileChooser! It really is this easy.
    - A File object represents the name and path of a file or directory on disk, But it does NOT represent, or give you access to, the data in the file!
        - make a file
        - make a directory
        - list the contents of a directory
        - delete a file or directory
- Buffers give you a temporary holding place to group things until the buffer (like the cart) is full. You get to make far fewer trips when you use a buffer.   
    - Only when the buffer is full will the FileWriter actually be told to write to the file on disk. 
    - If you want to send data to the disk before the buffer is full, you should call **flush**
- Tips:
    - write text files: BufferedReader and BufferedWriter (chained to FileReader and FileWriter)
    - write serialized objects: ObjectOutputStream and 
    ObjectInputStream (chained to FileInputStream and 
    FileOutputStream)
- Java NIO2 package (java.nio.file + java.nio.file.attribute (manipulate the metadata associated with the files and directories, e.g. change permissions))
    - Path: use Path object to locate the directories or files you want to work with
    - Paths: use Paths.get(...) to create Path object
    - Files: use the static methods to do things like
        - make new Readers and Writers
        - create, modify and search through directories and files on file systems
- conventions in Java IO: use try-with-resource
    - e.g.
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)); BufferedReader reader = new BufferedReader(new FileReader(file))) {...}
    catch{}
    - the newly created objects in the try block need to implement Autocloseable
    - you can write more than one object in the try block. They will be deleted in the reverse order
    
Chapter17
- a chat program: connect, send and receive
    - client side:
        - connect: connect server **channel** with client **channel** using IP Addresss(Shopping mall) and TCP port (store)
            - way 1: InetSocketAddress serverAddress = new InetSocketAddress(<IP Address>, <TCP Port>); SocketChannel socketChannel = SocketChannel.open(serverAddress)
            - way 2: Socket chatSocket = new Socket(<IP Address>, <TCP port>);
        - send: use chainstream + connection stream, and write msg using chainstream method
            - way 1: Reader reader = socketChannel.newReader(socketChannel, StandardCharsets.UTF_8); BufferedReader bufferedReader = new BufferedReader(reader); String msg = bufferedReader.readLine();
            - way 2: Reader reader = new InputStreamReader(chatSocket.getInputStream()); BufferedReader bufferedReader = new BufferedReader(reader); String msg = bufferedReader.readLine();
        - write: 
            - way 1: Writer writer = socketChannel.newWriter(socketChannel, StandardCharsets.UTF_8); PrintWriter printWriter = new PrintWriter(writer);
            writer.println(....);
            - way 2: PrintWriter writer = new PrintWriter(chatSocket.getOutputStream()); writer.println(....);
    - server side:
        - connect：create a serversocketchannel and wait for client request
            - ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); serverSocketChannel.bind(InetSocketAddress); while(serverSocketChannel.isopen()){SocketChannel clientChannel = serverSocketChannel.accept(); ......}
        - reader/writer: similar to client side
- *TODO* Channels can support **nonblocking I/O**, reading and writing via **ByteBuffers**, and **asynchronous I/O**.
- Server and client are just individual PCs, they write or receive message on SocketChannel
    - client get the SocketChannel (with server) through: SocketChannel.open(serverAddress);
    - server get the SocketChannel (with client) through: serverSocketChannel.accept();
        - when the read/write request from client comes for the first time, accept() will create a socket channel for it. When the read/write request from client comes for the second time, it will communicate through the previous channel
- DEBUG EXPERIENCES:
    - DO NOT PUT CONNECTION in try-with-resource syntax, as it will close the connection right after first-time connection!!! Check line 33 at Chapter17/SimpleChatClientA.java
- use Executors class (to create ExecutorServices) to create multithreaded applications in Java
- a thread = a seperate call stack with run() at the bottom
- a thread needs an instance that implements **Runable**
- 4 states of thread:
    - NEW: not started
    - RUNNABLE： started and waiting to be chosen to run.
    - RUNNING: selected by thread scheduler to run
    - NON-RUNNABLE: blocked because
        - wait data from stream
        - sleep
            - you could put a thread to sleep and give the other threads to run. But **you have to use try...catch... syntax as it will generate Exception: try{Thread.sleep(2000);}catch(Exception ex){ex.printStackTrace();}** 
                - you can use Thread.sleep(2000) or TimeUnit.SECONDS.sleep(2);
            - CountDownLatch: create CountDownLatch in mainthread, pass the latch to runnable, call latch.countDown() to let other threads run; in the subthread, try{latch.await()}catch(Exception ex){...}...
        - wait for an object's lock
- Barrier Synchronizer: mechanisms to allow threads to coordinate with each other, e.g. **CountDownLatch,CyclicBarrier,Phaser**
- ExecutorServices should be shut down correctly so the jobs are finished andthreads terminated. Use shutdown() for graceful shutdown, and shutdownNow() to kill everything
    - shutdown(): reject new jobs but will finish running and waiting jobs
    - try{boolean finished = awaitTermination(5, TimeUnit.SECONDS)}catch(Exception ex){ex.printStackTrace();}
        - Wait up to 5 seconds for the ExecutorService to finish everything. 
        - If this method hits the timeout before everything has finished, it returns “false.
        - If everything has finished, it returned "true"
    - shutdownNow(): kill every job
    
Chapter 18
- Race condition: When 2 or more threads(i.e. **Runnable objects**) have access to a single **same** object's data
    - access: read / write
    - e.g. if one thread, for example, leaves the running state (e.g. finish check balance but before spend) while still in the middle of manipulating an object’s critical state
- lock the object: when a thread (i.e. Runnable object) want to access an object. It will lock the object for certain transactions and take the key. And then when another thread (i.e. Runnable object) want to access the same object in the same transactions. It could not access to the certain transactions since there is no key to the object lock
-  synchronization: make a specific section of code work **atomically (i.e. must finish the synchronized method or block at one thread before another thread enter the same block/method on the same object)**
- every object has a lock. The lock comes to play when there is a **synchronized block**(i.e. use the synchronized keyword with a specified object, e.g. lock(account)) for an object or the object  has **synchronized methods** (i.e. there is a keyword synchronized in the method declaration).
    - synchronized block: tell you to lock and check which object when you try to run the block。 For example, lock(account){...}: when program run here, it tells Java to first check whether account object is locked, if not, lock the account object and continue
    - when an object has synchronized methods, a thread can only enter a synchronized method only if the thread can get the key to the **object's lock (no lock for the method)**
    -**The locks are per object, not per method!!!** If an object has 2 synchronized methods, it means when one thread is using (i.e. lock) the object, another thread could not use any of the synchronized methods. 
- The goal of synchronization is to protect critical data. But remember, you don’t lock the data itself; **you synchronize the methods/blocks that access that data.**
- what happens when a thread is running its call stack and suddenly hits an object's synchronized method?
    - the thread recognize that it needs a key for that object before it can enter the method
    - It looks for the key and if the key is available, the thread grab the key and enter the method
    - the thread will continue to run until it completes the synchronized method or block
    - So while the thread is holding the object's key, no other threads can enter any of the object's synchronized methods, because one key for that object will not be available
- each loaded **class** has a lock
    - e.g. if you have three Dog objects on your heap, you have a total of four Dog-related locks; three belonging to the three Dog instances, and one belonging to the Dog class itself. 
    - When you synchronize a static method, Java uses the lock of the class itself. 
    - So if you synchronize two static methods in a single class, a thread will need the class lock to enter either of the methods
- even "i++" need synchronize, since it will read the variable "i" first and then i++
- bad synchronization outcomes:
    - slow performance
    - deadlock: 2 objects and 2 threads
        - both threads hold the key that the other thread needs
- Alternatives to synchronize (e.g. check java.util.concurrent)
    - Atomic Varaibles: all the methods are synchronized (i.e. atomic)
        - when to use? : its just one value that is being changed by multiple threads
        -  AtomicInteger, AtomicLong, AtomicBoolean, AtomicReference
            - compareAndSet (CAS: compare-and-swap): similar to np.where(condition, other value), return a boolean variable if the operation is successful or not
                - when you use CAS operations, you have to deal with times when the operation does not succeed
            - incrementAndSet 
    - Immutable objects: make class as final and all its instance variables as final
        - It’s writing data from multiple threads that causes the most problems, not reading, so consider if your data needs to be changed at all or if it can be immutable.
- concurrentModificationException: If a collection is changed by one thread while another thread is reading that collection
    - thread-safe data structure: e.g. java.utils.concurrent.CopyOnWriteArrayList
        - create a copy and write to it everytime there is a write operation
        - potential issue: some threads are reading from the old data
        - usage: lots of reading threads and not many writing










