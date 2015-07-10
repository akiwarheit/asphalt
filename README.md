# Asphalt ![Circle CI](https://circleci.com/gh/akiwarheit/asphalt.png?circle-token=3cf0ff70e075bd184c30f4576237f3916f370d95) [![Download](https://api.bintray.com/packages/akiwarheit/maven/asphalt/images/download.svg) ](https://bintray.com/akiwarheit/maven/asphalt/_latestVersion)[![License](https://img.shields.io/badge/license-Apache%202.0-green.svg)](http://www.apache.org/licenses/LICENSE-2.0)




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

## Custom Binding

If you have a custom view (for example, `MyCustomView`) you want to bind to your field, you can create a custom `Binder` implementation, here is an example:

```java
public class MyCustomBinder<K> implements Binder<K> {

    @Override
    public void handle(K instance, View view, Field field) throws IllegalAccessException {
        String value = ((MyCustomView) view).getStringFromThisCustomView(); // cast this view object to your custom object
        field.setAccessible(true); // accessibility
        field.set(instance, value); // setting the value for this instance's field
    }
}
```

And pass the implementation of this custom binder as your strategy

```java
    @Field(viewId = R.id.my_custom_view, strategy = MyCustomBinder.class)
    String field;
```

The only constraint is **it should have a default public constructor.**


## Gradle

It's not yet linked to JCenter yet, so add my maven repo:

```gradle
repositories {
    maven {
        url "http://dl.bintray.com/akiwarheit/maven"
    }
}
```
And the dependency to your `build.gradle`

```gradle
compile 'com.keeboi.asphalt:asphalt:0.0.1-BETA@aar'
```

**Refer to my badge above for latest version**

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
