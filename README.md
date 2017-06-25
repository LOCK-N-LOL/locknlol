# locknlol

## Updates 2017.06.26

### Installation in 6.26 about Front-End
* npm 계열
    * bower (없다면) ```npm install bower -g```
    * ace ```npm i -S ace-css```
    * gulp ```npm install --save-dev gulp``` 외 gulp 여러개
    * react, react-dom ```npm install --save-dev react react-dom```
    * gulp와 react는 ```npm install``` 만 해주기 (package.json에 있기 때문에)
* bower 계열
    * bootstrap ```bower install bootstrap --save```
    * jquery(bootstrap 설치 시 자동 설치) ```bower install jquery --save```
    * fontawesome ```bower install fontawesome --save```
    * lodash ```bower install lodash --save```
    * 역시 ```bower install``` 로 해결 가능
* sass ```gem install sass```

### Setting assets
* 라이브러리나 아이콘처럼 static한 것은 assets에
* 그렇지 않은 것은 resources 밑에 css, js, view 등 종류별로 구분하여 두자

---

### Updates in 6.5 about JSON DTO
* Champions
* Items
* Summoner-spells

### Updates in 5.30 about configuration
* Database test: locknlol로 변경 (create database locknlol;)
* Database password: localhost더라도 git에 올리지 말 것
* gitignore: src/generated 추가
* build.gradle 변경