#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(void) {
    pid_t ps = fork();
    int ct = 0;

    if (ps == -1) {
        exit(1);
    } else if (ps == 0) {
        printf("--Goodbye, Cruel World :(\n");
        printf("--Exiting Child\n");    
        ct++;
        exit(0);
    } else {
        printf("Hello, World!\n");
        printf("Exiting Parent\n");
        exit(1);
    }
    
    return 0;
}
