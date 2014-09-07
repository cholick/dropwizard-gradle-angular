#Validation

### javax.validation
* @NotEmpty, @NotNull
* @Email
* @Max, @Min
* @Past, @Future

```bash
git checkout step04
git merge step05 --no-commit --no-ff
```

###Demo

```bash
./gradlew run

curl -svX POST -d '{}' localhost:9000/todo/asdf@asdf.com \
     --header 'Content-Type:application/json'
```
