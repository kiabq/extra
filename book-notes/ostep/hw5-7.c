#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void) {
    pid_t ps = fork();

    if (ps == -1) {
        exit(1);
    } else if (ps == 0) {
        fprintf(stdout, "PRINTING BEFORE CLOSING FD\n");
        close(STDOUT_FILENO);
        fprintf(stdout, "PRINTING AFTER CLOSING FD\n");
        exit(0);
    } else {
        exit(1);
    }

    return 0;
}
