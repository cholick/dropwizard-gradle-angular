#Remaining Endpoints

* PUT, DELETE, & POST
* Framework [recently added](https://dropwizard.github.io/dropwizard/about/release-notes.html#v0-7-1) PATCH


```bash
git checkout step03
git merge step04 --no-commit --no-ff
```

###Demo

```bash
./gradlew run

curl -s localhost:9000/todo/asdf@asdf.com | python -m json.tool
curl -sX POST -d '{"item": "Buy milk"}' localhost:9000/todo/asdf@asdf.com \
     --header 'Content-Type:application/json'
curl -s localhost:9000/todo/asdf@asdf.com | python -m json.tool
```
