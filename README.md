# Asphalt
###### Form to object one-way-binding library for Android

The idea is that I can define a form as such

```
<!-- Sample form without all the properties because I'm lazy as f -->
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

</com.keeboi.asphalt.view.LinearForm>
```

And automatically bind it to an object

```java
@Form
public class Person {

    @Field
    private String name;

    @Field
    private String occupation;

    // Getters & setters
}
```

And it gets bound when I refer the `LinearForm` as such

```java
LinearForm<Person> linearForm = ((LinearForm<Person>) findViewById(R.id.linear_form));
linearForm.bind(Person.class);
Person user = linearForm.getObject();
```

Or something like that

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
