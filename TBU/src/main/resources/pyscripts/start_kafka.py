import subprocess
import os

commands = [
    'cd ~/Logicea/kafka* && ./bin/zookeeper-server-start.sh config/zookeeper.properties',
    'sleep 10 && cd ~/Logicea/kafka* && ./bin/kafka-server-start.sh config/server.properties',
    'sleep 10 && service mongod start'
    ]
## run in parallel
processes = [subprocess.Popen(cmd, shell=True) for cmd in commands]


