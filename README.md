#Misc

### Healthcheck
### Asset bundle

```bash
git checkout step05
git merge step06 --no-commit --no-ff
```
###Demo

```bash
./gradlew run

curl -s localhost:9001/healthcheck | python -m json.tool
open http://localhost:9000/
```
