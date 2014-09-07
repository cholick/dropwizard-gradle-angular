#Additional Gradle

Runtime class reloading
Using [ Spring-Loaded ]( https://github.com/spring-projects/spring-loaded ) javaagent
* Same library powers Grails reloading
* A Recent [ blog post ]( http://www.cholick.com/entry/show/280 ) explaining in detail

```bash
git checkout step07
git merge step08 --no-commit --no-ff
```

###Demo

```bash
./gradlew dev

curl -s http://localhost:9000/api/todo/matt@veryrealemail.com/ | python -m json.tool
```
