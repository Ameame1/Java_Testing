School Mail: 22910358@student.uwa.edu.au
Personal Mail: liuyu.ame@gmail.com

Phone_number:+61-0422985577 

Address: Stirling St. 89, WA 6000, Perth

Question 1
(a)
T1 is a unit test.
The focus of T1 lies in the addCmeara method, T1 this code involves only one unit of work, and all operations are done in this one unit of work.  
Integration tests often test data streams like time, databases, threads, etc., and the test objects do not depend on their single unit of work.  
In summary, T1 is a unit test.

(b)
T1 and T2 are appropriate. T3 is inappropriate. 
JavaDoc elaborates on all parameters in T1 and T2. Such as “If camera cannot be reached at the URL specified, then a java.net.ConnectException exception is thrown”, “Once a camera has been added, its ID will be in the list returned by the listCameraIds” etc. 
T1's "Expected output" is the ID in listCameraIDs, which conforms to JavaDoc's description, so String as the "Expected output” is no problem. T2's "Expected output" also fits the description described in JavaDoc, throwing a ConnectionException exception.
T3 has the problem of undefined parameters for negative numbers. The JavaDoc states that "If the secondsBetweenCptures parameter or the areaChangeThreshold parameter are negative, the behaviour of the method is undefined", the above content is undefined and does not need to be tested.

(c)
The sys object’s behaviour in this case is a Failure.
Failure represents a series of problems caused by software design flaws, some module functions cannot be realized but the program has run. For example, there is always no response to some specific operations of the user.
Fault indicates that the software was unable to execute the selected code, which is usually caused by not improving the fault tolerance of the code. Such as Lack of resources, An invalid step, Inappropriate data definition, etc.
An erroneous state generally refers to human error, and the program cannot run due to an error in the programmer's code. For example, spelling mistakes, one less '{', etc.
It is mentioned in the text that the method ConnectException exception should throw an exception, but the test has been run and no exception is thrown, so this is a defect of a function and belongs to failure.

(d)
Ellen’s approach is inappropriate.
Ellen wants to test all T1, T2, T3 sequentially using a parameterized test method.
We can find that T1, T2's "Setup" and "Values" are the same, when T1 is executed using the parameterized test method, T2’s parameters are the same as the T1, which will cause T1 to be tested twice when testing T2.
In addition, the output of T1 is that CameraID belongs to a string. The output of T2 is that ConnectionException. T3 outputs exception information. It is not possible to test T1, T2, and T3 at the same time using a single test because their outlet types are different.
We should choose a test specifically for stringing, and then choose a test to check whether it successfully threw an exception. A single parameterized test obviously cannot test for the above.
Therefore, Ellen’s approach is inappropriate.

Question 2

(a)
Precondition:
A precondition is a condition, in which it must be true to work before other methods can be run. The method we're calling needs to have something before it can be called. If the precondition is not sufficiently met before the operation is executed, there is no guarantee that the operation will perform as expected.
Eg: 
1. The URL address is valid.
2. CameraIDlist is not full and can continue to be added.
3. Continuous power supply during the add camera phase.

(b)
Postcondition:
Po­stcondition refers to events that are guaranteed to occur after an operation is complete. This indicates that if the operation is performed correctly and the conditioning is true, then the postcondition must be true. 
Eg:
1. After the program runs successfully, the camera of the URL address you applied for will be generated a new CameraID.
2. If the URL address is invalid, an exception will be thrown.
(c)
Side effect:
After performing an operation, expression, or function, the value of some variable outside the local environment is modified, it is called side effect. This includes variables that may be for non-local variables, static local variables, etc. This shows that in a program side effect exists, you need to consider its historical calls and usage.
Eg:
1. After each program run, the total number of ListCameraIDs will change, and the number of IDs depends on the running history.
2. After you add a CameraID, the next camera you add will use a different ID. This also depends on the running history.

Question 3

The article describes the existence of functions are addCamera and listCameraIDs.

addCamera parameters:

1. cameraStreamingUrl
2. secondsBetwweenCaptures
3. areaChangeThreshold
4. The 'this' pointer.

listCameraIDs parameters:

1. cameraID 
2. The 'this' pointer.

All java non-statistic methods need to have a pointer to themselves, otherwise, they cannot be run.

Question 4

(a)
For requirement i:

Inappropriate. 

This statement is too broad, how to define highly security? What is the standard of security? 

I suggest that if you want to ensure highly security, you should define it:

1. The system can withstand 50 DDOS attacks or CC attacks in 10s.
2. The system can statically handle the URL without using the dynamic URL parameter.

For requirement ii:

That's appropriate, and it ensures good interaction between humans and machines.

For requirement iii:

Inappropriate.

1. Since serious injuries rarely occur in home occupants (0.1%), this in itself is very difficult to test, and the time cost is too high.
2. This requirement should not be tested experimentally with customers.
3. The total duration of the test is uncertain.

(b)
ISP technical will not be useful with these tests.
ISP is primarily used to help test function domains. We often test domains with different ranges of parameters. Typically includes equalization partitioning, boundary value analysis, and domain testing.
But none of the three tests involved specific values. We need to select certain values from a particular partition in our ISP tests.
Requirement i is testing for security, which obviously requires multiple modules to run together, should be non-functionally tested and is no need to test for certain values.
Requirement ii involves interactions that necessarily involve multiple modules, non-functional testing should be done and is no need to test for certain values.
Requirement iii involves a long period of time, non-functional testing should be performed, and it is unreasonable to use ISP testing.
In summary, ISP technical will not be useful with these tests.

Question 5

(a)
If it is a prime path, then it cannot be used as a simple path for any other prime path.
But in this question BCDEFG is a sub-path of BCDEFGB, so he is not the prime path.

(b)

BCDEFGHIJKB

BCDEFGHIJKLMB

ABCDEFGHIJKLMN

(c)
Logic-based tests can apply this diagram.

As shown in the flowing, the diagram contains several conditional statements.

The program can only succeed if all three conditions of the above diagram are true.

We can use a logic-based approach to define clauses the following:

G: isApproved(name)

K: isCorrect(CAPTCHA)

M: isMatch(face)

Based on the above clauses we can choose logic tests and control variables when we use logic tests.

Eg:

If we want to test M, we need to make sure that G and K are true. 

Usecase1: G is true; K is true; M is false.

Usecase2: G is true; K is true; M is true.

Therefore, logic-based tests can apply this diagram.

Question 6
(a)
Logic-based testing can be used to assess the coverage level of tests of the drone. 
The text contains many conditional statements such as "is identified as human.", "match a home occupant", etc.  
Following converge levels:
1. Predicate converge
However, the test of the entire preparatory test is too wide and too simple, and the test result is only 0/1, which is not suitable for our in-depth study.  
2. Combinatorial converge  
Each case can be listed in detail, but the time cost is too high.  
3. Clause converge
Therefore, it is appropriate to choose active clause coverage (ACC) to test.  
Using ACC can help us identify the key clause, which is able to decide the yes or no of the entire category.  
Take the Rule ID 0901 phrase as an example.  
Eg: 
A: isHuman(object) 
B: isFaceMatch(face) 
C: isNotEncountered 

If the final Action is offering a greeting, we can conclude that the predicate is A ∧ B ∧ C.

Based on the above clauses we can perform logic tests (A, B, C) 

Two test cases are used as examples: 

We make clause A active.

Usecase1:

A is true; B is true; C is true.
After identifying as a human, it is confirmed that it is a home occupant and has not been met earlier, and a greeting is offered.  

Usecase2:

A is false; B is true; C is true.
If it is not recognized as a human, will not offer a greeting.
Therefore, logic-based testing can be used to assess the coverage level of tests of the drone. 

(b)
The advantage of Graph-based tests can be quickly passed between different nodes, no matter how complex the interior, which obviously saves testing time.
But for the control-flow graph described in the text, the number of Rule ID is very large (0010,0902), which is obviously not a quick test, and the use of edge coverage test volume is huge Most of the control-flow graphs are no problems, which obviously wastes a lot of resources.
Logic-based tests can test some special conditional statements, increase the value of the test, and find key test points. Logic-based tests can perform detailed tests on the internal structure.
In summary, the logic-based test is more suitable for the drone's source code than graph-based tests

Question 7

(a) 
In an instance of the model, EyrieSystem can only have 0 or 1. 
The constraints in the text are "lone", so there are only 0 or 1.
We should tighten constraints.  
Common constraints include:
lone: 0 or 1
one: There is only one  
some: At least one  
set: Greater than or equal to 0 
no: 0 
The security system must exist, so we exclude 'no' and 'set'. If the cost allows, we can choose 'some', but based on the above model, the number of EyrieSystems can only be 0 or 1, so we should choose 'one'.
Therefore, change String 'lone' to 'one'.

(b)
A PeripheralComponent cannot be a Drone and a Camera at the same time.
Java classes only support single inheritance, not multiple inheritances. That is to say, there can only be one parent class. From the text, there is only one parent class, that is, PeripheralComponent. If a PeripheralComponent to be both a Drone and a Camera, a subclass has to inherit two parent classes. 
Therefore, it is impossible for a PeripheralComponent to be both a Drone and a Camera.

(c)
EyrieSystem can have zero or any number of attachedComponents, which is the 'set' in what we call constraints above.
Eg:
We can install multiple Cameras at the same time and the CoffeeMakers, Drones as well. We can also choose not to install any Cameras, CoffeeMakers, or Drones.

(d)

<code>

fact everyPeripheralComponentsInEyrieSystem{

every PC: PeripheralComponent, ES: EyrieSystem | PC in ES.attachedComponents

}

</code>

The content in fact must be true, which means that every PeripheralComponent entity is contained in the EyrieSystem and there is no remaining PeripheralComonent that has not been contained in the EyrieSystem.
Therefore, we write the above fact everyPeripheralComponentsInEyrieSystem {}.
