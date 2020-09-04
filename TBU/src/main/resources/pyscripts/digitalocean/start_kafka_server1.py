import subprocess
import os

commands = [
    'cd /home/kafka* && ./bin/zookeeper-server-start.sh config/zookeeper.properties',
    'sleep 10 && cd /home/kafka* && ./bin/kafka-server-start.sh config/server.properties'
    ]
## run in parallel
processes = [subprocess.Popen(cmd, shell=True) for cmd in commands]


