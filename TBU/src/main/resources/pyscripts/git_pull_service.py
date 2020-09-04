##import subprocess
##import os
##
##commands = [
##    'cd ~/147/DomainCentral && git pull origin && git reset --hard origin/master',
##    'cd ~/147/BattleGenerator && git pull origin && git reset --hard origin/master',
##    'cd ~/147/CloudBase && git pull origin && git reset --hard origin/master',
##    'cd ~/147/Datahouse && git pull origin && git reset --hard origin/master',
##    'cd ~/147/Eureka && git pull origin && git reset --hard origin/master',
##    'cd ~/147/TBU && git pull origin && git reset --hard origin/master'
## ##   'cd ~/147/ZuulGatekeeper && git reset --hard origin/master'
##    ]
#### run in parallel
##processes = [subprocess.Popen(cmd, shell=True) for cmd in commands]


import os
import git

def git_pull(local_repo_path):
    repo = git.Repo(local_repo_path)
    repo.git.reset('--hard','origin/master')
    repo.remotes.origin.pull()
    


DomainCentral = "/home/nick/147/DomainCentral"
BattleGenerator = "/home/nick/147/BattleGenerator"
CloudBase = "/home/nick/147/CloudBase"
Datahouse = "/home/nick/147/Datahouse"
Eureka = "/home/nick/147/Eureka"
TBU = "/home/nick/147/TBU"

git_pull(DomainCentral)
git_pull(BattleGenerator)
git_pull(CloudBase)
git_pull(Datahouse)
git_pull(Eureka)
git_pull(TBU)

