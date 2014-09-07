#Views

* [ Freemarker ]( http://freemarker.org/ )
* [ Mustache ]( https://github.com/spullara/mustache.java )


```bash
git checkout step06
git merge step07 --no-commit --no-ff
```

###Demo

```bash
./gradlew run

curl -s http://localhost:9000/api/todo/matt@veryrealemail.com/ | python -m json.tool
open http://localhost:9000/api/todo/matt@veryrealemail.com/view
```
