import subprocess
import os

commands = [
    'cd ~/147/DomainCentral && mvn clean install -DskipTests',
    'cd ~/147/BattleGenerator && mvn clean install -DskipTests',
    'cd ~/147/CloudBase && mvn clean install -DskipTests',
    'cd ~/147/Datahouse && mvn clean install -DskipTests',
    'cd ~/147/Eureka && mvn clean install -DskipTests',
    'cd ~/147/TBU && mvn clean install -DskipTests'
 ##   'cd ~/147/ZuulGatekeeper && mvn clean install -DskipTests'
    ]
## run in parallel
processes = [subprocess.Popen(cmd, shell=True) for cmd in commands]


