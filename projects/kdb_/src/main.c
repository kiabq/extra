#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node {
    int* root;
} tree;

struct obj {
    char* key;
    char* value;
};

int main(void) {
    struct obj db;

    db.key = "1";
    db.value = "Puppy";

    printf("Key: %s | Value: %s\n", db.key, db.value);

    return 0;
}
