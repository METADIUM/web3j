Web3j: Web3 Java Ethereum Ðapp API
==================================

[![Documentation Status](https://img.shields.io/travis/web3j/web3j-docs?label=docs)](https://docs.web3j.io/)
[![Build Status](https://travis-ci.org/web3j/web3j.svg?branch=master)](https://travis-ci.org/web3j/web3j)
[![codecov](https://codecov.io/gh/web3j/web3j/branch/master/graph/badge.svg)](https://codecov.io/gh/web3j/web3j)
[![Join the chat at https://gitter.im/web3j/web3j](https://img.shields.io/discourse/users?server=https%3A%2F%2Fcommunity.web3labs.com)](https://community.web3labs.com)

This is a project forked from [Web3j](https://github.com/web3j/web3j).

In web3j, Android API 23 is supported up to 4.6.0, and in 4.8.8 and 11, it is supported.

Accordingly, this is a project to support version 4.8.8 up to Android API 23.


## Usage 
Jit

Maven
-----

Set Java 8

```
<properties>
	<maven.compiler.target>1.8</maven.compiler.target>
	<maven.compiler.source>1.8</maven.compiler.source>
</properties>
```

Add Repository

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Add Web3j

```
<dependency>
  <groupId>com.github.METADIUM.web3j</groupId>
  <artifactId>core</artifactId>
  <version>4.8.8-android-6</version>
</dependency>
```

Gradle
------

Set Java 8
```
compileOptions {
sourceCompatibility JavaVersion.VERSION_1_8
targetCompatibility JavaVersion.VERSION_1_8
}
```

Add Repository

```
repositories {
    google()
    jcenter()
    maven { url "https://jitpack.io" }  // JitPack repository 사용
}
```

Add Web3j

```
implementation ('com.github.METADIUM.web3j:core:4.8.8-android-6')
```

License
------
Apache 2.0
