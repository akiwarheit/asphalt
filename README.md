# Asphalt
###### Form to object binding in Android

The idea is that I can define a form as such

```
<!-- Sample form without all the properties because I'm lazy as f -->
<LinearForm>
    <EditText />
    <EditText />
    <EditText />
</LinearForm>
```

And automatically bind it to an object

```java
@Form
public class User {
    @Field
    private String name;
    
    @Field
    private String surname;
    
    @Field
    private String title;
    
    // Getters & setters
}
```

And it gets bound when I refer the `LinearForm` as such

```java
    User user = ((LinearForm<User>) findViewById(R.id.linear_form)).getObject();
```

Or something like that

<pre>
Copyright [2015] [Kevin Jude A. Deloria]

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
