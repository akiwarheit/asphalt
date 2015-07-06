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
