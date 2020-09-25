import subprocess
import os

commands = [
    'fuser -k 8085/tcp',
    'fuser -k 8079/tcp',
    'fuser -k 8080/tcp',
    'fuser -k 8091/tcp',
    'fuser -k 8082/tcp',
    'fuser -k 8078/tcp',
    'cd ~/147/CloudBase && mvn spring-boot:run -Dspring.profiles.active=native', ##-Drun.jvmArguments=-Xmx512m',
    'sleep 10 && cd ~/147/Eureka && mvn spring-boot:run -Dspring.profiles.active=local', ## -Drun.jvmArguments=-Xmx512m',
    'sleep 10 && cd ~/147/TBU && mvn spring-boot:run -Dserver.port=8010 -Dspring.profiles.active=local -Dbattle.battle-type=mutual', ## -Drun.jvmArguments=-Xmx512m',
    'sleep 10 && cd ~/147/TBU && mvn spring-boot:run -Dserver.port=8011 -Dspring.profiles.active=local -Dbattle.battle-type=incrementing', ## -Drun.jvmArguments=-Xmx512m',
    'sleep 5 && cd ~/147/Datahouse && mvn spring-boot:run -Dspring.profiles.active=local',
    'sleep 60 && cd ~/147/BattleGenerator && mvn spring-boot:run -Dspring.profiles.active=local' ## -Drun.jvmArguments=-Xmx512m'
    ]
## run in parallel
processes = [subprocess.Popen(cmd, shell=True) for cmd in commands]

##spring-boot:run -Dspring-boot.run.jvmArguments=-Dspring.profiles.active=local

