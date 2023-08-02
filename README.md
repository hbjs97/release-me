# release-me
```
server:
port: 7000

# 전적으로 spring.application.name을 참조한다.

# name 설명보면 spring.application.name를 override 한다고 되어있는데, override 하지 않는다.

# defaultContext 역시 영향일 끼치지 못한다.

aws:
paramstore:
enabled: true
region: ap-northeast-2
prefix: /config

# name: application # 의미없음

profileSeparator: _

# defaultContext: application # 의미없음
```
