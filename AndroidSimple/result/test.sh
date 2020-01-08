#!/usr/bin/env bash

# git clone https://github.com/googlesamples/android-AppRestrictionEnforcer.git AppRestrictionEnforcer
# awk '{project_name=$2; cmd="git clone https://github.com/googlesamples/android-"project_name".git "project_name;system(cmd)}' answer.txt
awk '/#/' answer.txt | awk -f test.awk