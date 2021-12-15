# spring-boot-helm

## Build
```
mvn clean install -Ddocker_host=localhost -Drevision=0
```

## Install helm release
```
helm install postgres bitnami/postgresql --set image.tag=11 --set postgresqlDatabase=posgres --set postgresqlUsername=postgres --set postgresqlPassword=postgres
helm install spring-boot-helm --set backend.config.db.url=jdbc:postgresql://postgres-postgresql:5432/postgres --set backend.config.db.username=postgres --set backend.config.db.password=postgres target/helm/repo/spring-boot-helm-1.0.0.tgz
```

## Upgrade helm release
```
mvn clean install -Ddocker_host=localhost -Drevision=1
helm upgrade spring-boot-helm --set backend.config.db.url=jdbc:postgresql://postgres-postgresql:5432/postgres --set backend.config.db.username=postgres --set backend.config.db.password=postgres target/helm/repo/spring-boot-helm-1.0.1.tgz
```

## Rollback helm release
```
helm history spring-boot-helm
helm rollback spring-boot-helm 1
```

## App version info url
```
localhost/actuator/info
```