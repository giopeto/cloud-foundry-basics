# cloud-foundry-basics

## Setup
- clone & install demo app
```
git clone https://github.com/giopeto/cloud-foundry-basics.git

mvn clean install
```

- login to Pivotal Cloud Foundry

`cf login -a api.run.pivotal.io`

## 01 Push simple spring boot app (branch: 01-deploy-boot-app-to-cf)
`git checkout 01-deploy-boot-app-to-cf`
###
- build the application

`mvn package`

- push app to cloud foundry

`cf push`

## 02 Connect to MySQL DB (branch: 02-connect-to-mysql-db)

`git checkout 02-connect-to-mysql-db`

- create mysql service 

```
cf marketplace
cf marketplace -s cleardb
cf create-service cleardb spark app-db
```

- build and push app

`mvn package && cf push`
