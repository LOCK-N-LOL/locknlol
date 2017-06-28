# locknlol

### Front 설정 총정리
* package.json => ```npm install``` 시 반영 (안되는 게 있을 수 있음)
    * 설치 시 --save-dev, --save, -g mode가 있음, -g는 package.json에 반영X
* bower.json => ```bower install``` 시 반영 (npm과 동일)
    * 대부분의 assets이 깔려있음
* gulp
    * assets, sass, babel task이 작성되어 있음
        * assets: static한 resources 보관, assets 파일 내부를 수정하는 것은 금지 (날아감)
        * sass: scss를 css로 변환, 여러 모드가 있으니 각 용도에 맞게 사용할 것 (**map**)
        * babel: requirejs를 이용하여 작성한 jsx파일 변경, 현재 /requirejs 에 존재 (**map**)
    * ```gulp (task)``` 로 실행
    * default task는 ```gulp```로만 실행됨 (현재 assets)
    * watch => 실시간 수정, 나중에 가면 버벅거림
    * 파일 경로
        * ```/src/**```는 src 하위 모든 파일
        * ```/src/*.js```는 src 바로 밑에 있는 js 형식 파일
        * ```/src/**/*.js```는 src 하위 모든 파일 중 js 형식 파일
        * ```!/src/index.js```처럼 앞에 ! 붙이면 해당 파일 제외 
* webpack
    * es6로 작성한 js를 es5로 변경 (**map**)
    * 현재 /jsx 에 존재
    * ```webpack```

<참고>
* **현재 index.js 없음**, ```gulp babel``` 또는 ```webpack```으로 생성 가능
* **map**: 실행 결과를 합쳐진 파일이 아닌 기존 파일로 보여줌, 매우 용이 ex) .css => .scss

---

### Updates 2017.06.26

#### Installation in 6.26 about Front-End
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

#### Setting assets
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
