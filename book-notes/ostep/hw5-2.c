#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

int main(void) {
    // File Description
    /*
        O_WRONLY - Opens file with write access only.
        O_CREAT - Will create the file if it does not exist.
        O_TRUNC - If the file already exists, it will be truncated to a length of 0. The file will be reset.
    */ 
    char* filepath = "/tmp/hw.txt";
    int fd = open(filepath, O_WRONLY | O_CREAT | O_TRUNC); 

    if (fd == -1) {
        fprintf(stderr, "OPENING FILE FOR OPENING FAILED\n");
        exit(1);
    }
    
    fprintf(stdout, "--PARENT ACCESSING FILE DESCRIPTOR (FD %d)\n", fd);

    // Start Child Process
    pid_t ps = fork();    

    if (ps == -1) {
        fprintf(stderr, "FORKING FAILED\n");
        exit(1);
    } else if (ps == 0) {
        fprintf(stdout, "CHILD PROCESS EXITING (PID %d)\n", (int) getpid());
        fprintf(stdout, "--CHILD ACCESSING FILE DESCRIPTOR (FD %d)\n", fd);
        exit(0);    
    } else {
        fprintf(stdout, "CHILD PROCESS IS (PID %d)\n", ps);
        exit(0);
    }

    return 0;
}
