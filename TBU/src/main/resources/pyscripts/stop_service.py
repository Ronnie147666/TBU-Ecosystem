import subprocess
import os

commands = [
    'fuser -k 8010/tcp',
    'fuser -k 8011/tcp',
    'fuser -k 8085/tcp',
    'fuser -k 8079/tcp',
    'fuser -k 8080/tcp',
    'fuser -k 8091/tcp',
    'fuser -k 8082/tcp',
    'fuser -k 8078/tcp'
    ]
## run in parallel
processes = [subprocess.Popen(cmd, shell=True) for cmd in commands]


