# spring-boot-helm

## Build
```
mvn clean install -Ddocker_host=localhost
```

## Install helm
```
helm install postgres bitnami/postgresql --set image.tag=11 --set postgresqlDatabase=posgres --set postgresqlUsername=postgres --set postgresqlPassword=postgres
helm install spring-boot-helm --set backend.config.db.url=jdbc:postgresql://postgres-postgresql:5432/postgres --set backend.config.db.username=postgres --set backend.config.db.password=postgres target/helm/repo/spring-boot-helm-1.0.0.tgz
```