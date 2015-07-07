# Asphalt [![Build Status](https://travis-ci.org/akiwarheit/asphalt.svg)](https://travis-ci.org/akiwarheit/asphalt)
###### Form to object one-way-binding library for Android

## The Concept

The idea is we should objectify form handling, such that we can define a form with the ff. layout:

```xml
<com.keeboi.asphalt.view.LinearForm
    android:id="@+id/linear_form"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Kevin Jude Deloria" />

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Programmer" />

    <CheckBox
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:checked="true"
        android:text="Married" />

    <Spinner
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</com.keeboi.asphalt.view.LinearForm>
```

And a corresponding object matching the structure of the form:

```java
@Form
public class Person {

    @Field
    private String name;

    @Field
    private String occupation;

    @Field
    private Boolean married;

    @Field
    private Status status;

    // Getters & setters

    public enum Status {
        AVAILABLE, BUSY, AWAY
    }
}
```

And then bind to construct the object:

```java
LinearForm<Person> linearForm = ((LinearForm<Person>) findViewById(R.id.linear_form));
linearForm.bind(Person.class);
Person user = linearForm.getObject();
```

## Supported View Widgets

I've added default matching & binding for the ff. widgets & their corresponding data type.

* `EditText` - `String`
* `CheckBox` - `Boolean`
* `Spinner` - `enum` (`ArrayAdapter`'s list of objects should match your `enum`)

## Sample Usage

@TODO I'll update this once I have more bindings :)

<pre>
Copyright 2015 Kevin Jude A. Deloria

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
