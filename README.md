#DI & Data

* [ Guice ]( https://github.com/google/guice )
* For demo no db, but framework supports
  * JDBI
  * Hibernate
  * Migrations (Liquibase)
* [ Managed interface ]( http://dropwizard.readthedocs.org/en/latest/manual/core.html#managed-objects )

```bash
git checkout step02
git merge step03 --no-commit --no-ff
```

###Demo

```bash
./gradlew run

curl -s localhost:9000/todo/matt@veryrealemail.com | python -m json.tool
curl -s localhost:9000/todo/asdf@asdf.com | python -m json.tool
```
