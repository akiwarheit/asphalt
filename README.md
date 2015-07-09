# Asphalt [![Build Status](https://travis-ci.org/akiwarheit/asphalt.svg)](https://travis-ci.org/akiwarheit/asphalt)
###### Form to object one-way-binding library for Android

## The Concept

The idea is we should objectify form handling, such that we can define a form with the ff. layout:

```xml
<com.keeboi.asphalt.view.LinearForm
    android:id="@+id/linear_form"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <EditText
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Kevin Jude Deloria" />

    <EditText
        android:id="@+id/occupation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Programmer" />

    <CheckBox
        android:id="@+id/married"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:checked="true"
        android:text="Married" />

    <Spinner
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <RadioGroup
        android:id="@+id/radio_group"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <RadioButton
            android:id="@+id/female"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Female" />

        <RadioButton
            android:id="@+id/male"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Male" />

    </RadioGroup>

</com.keeboi.asphalt.view.LinearForm>
```

And a corresponding object matching the structure of the form:

```java
@Form
public class Person {

    @Field(viewId = R.id.name)
    private String name;

    @Field(viewId = R.id.occupation)
    private String occupation;

    @Field(viewId = R.id.married)
    private Boolean married;

    @Field(viewId = R.id.spinner)
    private Status status;

    @Field(viewId = R.id.radio_group)
    private Gender gender;

    // Getters & setters

    public enum Status {
        AVAILABLE, BUSY, AWAY
    }

    public enum Gender {
        FEMALE, MALE
    }

}
```

And then bind to construct the object:

```java
LinearForm userLinearForm = (LinearForm) findViewById(R.id.linear_form);
person = userLinearForm.bind(Person.class);
```

## Supported View Widgets

I've added default matching & binding for the ff. widgets & their corresponding data type.

* `EditText` - `String`
* `CheckBox` - `Boolean`
* `Spinner` - `enum` (`ArrayAdapter`'s list of objects should match your `enum`)
* `RadioGroup` - `enum`

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
