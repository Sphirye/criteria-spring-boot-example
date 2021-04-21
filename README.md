# criteria-spring-boot-example

A simple criteria example in Spring Boot for search pagination filter.

**How to run**

1-Clone this repo.

2-Run ```./gradlew :bootRun```

3-Make a GET request to ```localhost:8080/public/post``` having a three fields body, **title (optional), page (with a value *0*), size (with a value *5*)** (Assuming you are using a request program like Postman).

This will return a 5 lasts posts array as a page, change the page value to 1 to see the next 5 posts (there are 10 default posts so you dont really need to create yours).
