#!/bin/awk -f

# 运行前
BEGIN {
    count = 0

    printf "---------------------------------------------\n"
}

# 运行中
{
    level[count]=length($1)
    title[count]=$2
    count++
}

# 运行后
END {
    for(i=0; i<NR; i++) {
        print level[i],title[i]
        if(level[i]<level[i+1]) {
            system("mkdir "title[i])
            system("cd "title[i])
            print "mkdir", title[i], "&& cd", title[i]
        }
        if(level[i]>level[i+1]) {
            deep = level[i] - level[i+1]
            for(j=0; j<deep ; j++) {
                cmd="cd .."
                system(cmd)
                print "cmd:", cmd
            }
        }
        cmd = "git clone https://github.com/googlesamples/android-"title[i]".git "title[i]
        print cmd
        system(cmd)
    }
    printf "---------------------------------------------\n"
}

function get_github_url(keyword){

}