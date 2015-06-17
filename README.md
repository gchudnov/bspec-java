# bspec-java
[![Build Status](https://travis-ci.org/gchudnov/bspec-java.svg)](https://travis-ci.org/gchudnov/bspec-java)

A Java library for structuring business rules.

## Requirements

`bspec-java` can be included in any Java or Android application.


## Installation

Add the following line to the `dependencies` section of your `build.gradle` file:

```groovy
compile 'com.github.gchudnov.bspec:bspec:0.9.0'
```

## Usage
The essential part of the library is a *specification* -- an object with the following properties:
* it can be combined with other *specification*-objects using `.and()`, `.or()` and `.not()` methods to form a composite specification and express more complex rules.
* it implements `isSatisfiedBy` method -- a predicate that determines whether a *candidate* object does or does not satisfy some criteria.

To create a composable *specification*, extend `CompositeSpecification` and define the `isSatisfiedBy` method to check for some condition.

## API

### .and(otherSpec): Specification&lt;T&gt;
the _and_ of a set of specifications is *true* if and only if all of its operands are *true*. 
```java
spec = spec1.and(spec2);
```

### .or(otherSpec): Specification&lt;T&gt;
the _or_ of a set of specifications is *true* if and only if one or more of its operands is *true*
```java
spec = spec1.or(spec2);
```

### .not(): Specification&lt;T&gt;
_not_ negates the specification
```java
spec = spec1.not();
```

### .isSatisfiedBy(final T candidate): boolean
checks whether some _candidate_ object satisfies the specification.

```java
  boolean result = spec.isSatisfiedBy(obj);
  
  // `result` true|false value
```


For the details of usage, take a look at the [examples](/samples) section in the project.

## Contact

[Grigoriy Chudnov] (mailto:g.chudnov@gmail.com)


## License

Distributed under the [The MIT License (MIT)](https://github.com/gchudnov/bspec-java/blob/master/LICENSE).
