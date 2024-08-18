#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
    int x = 100;
    fprintf(stdout, "--PARENT PROCESS VALUE OF X IS (%d)\n", x);
    x = 50;
    fprintf(stdout, "--PARENT PROCESS VALUE OF X IS (%d)\n", x);
    
    pid_t ps = fork();
    
    if (ps == -1) {
        fprintf(stderr, "FORK FAILED");
        exit(1);
    } else if (ps == 0) {
        fprintf(stdout, "CHILD PROCESS EXITING (PID: %d)\n", (int) getpid());
        exit(0);
    } else {
        fprintf(stdout, "CHILD PROCESS IS (PID: %d)\n", (int) ps);
        fprintf(stdout, "--CHILD PROCESS VALUE OF X IS (%d)\n", x);
        x = 25;
        fprintf(stdout, "--CHILD PROCESS VALUE OF X IS (%d)\n", x);
        exit(0);
    }

    return 0;
}
