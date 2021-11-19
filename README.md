# Assignment 4. 

####Participants
1. Martin Holmqvist
2. Nicholas Tureczek
3. Patrick Jønsson

## Mockito Powerups
#### How do you verify that a mock was called?

In mockito you can verify if a specific method has been called x numbers of times. \
This is done with the verify() method. 

    verify(mockObject).someMethodOfMockObject(someArgument);

The verify() method checks by default if the class has been called one time but 
can be set to check a specific number of times.

    verify(mockObject, times(someNumberOfTimes)).someMethodOfMockObject(someArgument);

#### How do you verify that a mock was NOT called?

To check if a method is never called. mockito has a method called never() that can be added as a 2nd parameter.

    verify(mockObject, never()).someMethodOfMockObject(someArgument);

#### How do you specify how many times a mock should have been called?

To check if a method is called a specific number of times mockito has a method called times() that can be added as a 2nd parameter and takes an int numbersOfTimes.

    verify(mockObject, times(someNumberOfTimes)).someMethodOfMockObject(someArgument);

#### How do you verify that a mock was called with specific argument?

    List<String> mockedList = mock(MyList.class);
    mockedList.addAll(Lists.<String> newArrayList("someElement"));

    ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
    verify(mockedList).addAll(argumentCaptor.capture());

    List<String> capturedArgument = argumentCaptor.<List<String>> getValue();
    assertThat(capturedArgument, hasItem("someElement"));

#### How do you use a predicate to verify the properties of the arguments given to a call to the mock?

????



## Tic-tac-toe

*https://github.com/cycloniccornet/TicTacToeTDD*